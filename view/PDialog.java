package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import blogic.Person;
import dal.PersonDAO_MySQL;

public class PDialog extends JDialog
{
	JTextField id = null;
	JTextField fname = null;
	JTextField lname = null;
	JTextField age = null;
	JFormattedTextField phone = null;
	
	JLabel lbId  = null;
	JLabel lbFname  = null;
	JLabel lbLname  = null;
	JLabel lbAge  = null;
	JLabel lbPhone  = null;
	
	JButton btnOk = null;
	JButton btnCancel = null;
	
	public String res = "Cancel";
	
	public PDialog() 
	{
		setLayout(null);
		setBounds(350, 20, 400, 400);
		MaskFormatter mf;
		try
		{
			mf = new MaskFormatter("(+380)## - ### - ## - ##");
			mf.setPlaceholderCharacter('_');
			phone = new JFormattedTextField(mf);
		}
		catch (ParseException e1)
		{
			e1.printStackTrace();
		}
		id = new JTextField();
		fname = new JTextField();
		lname = new JTextField();
		age = new JTextField();
		
		
		id.setBounds(100, 30, 40, 30);
		fname.setBounds(100, 80, 120, 30);
		lname.setBounds(100, 130, 150, 30);
		age.setBounds(100, 180, 40, 30);
		phone.setBounds(100, 230, 180, 30);
		
		lbId = 		new JLabel("ID");
		lbFname = 	new JLabel("FNAME");
		lbLname =	new JLabel("LNAME");
		lbAge = 	new JLabel("AGE");
		lbPhone = 	new JLabel("PHONE");
		
		lbId.setBounds(30, 30, 30, 30);
		lbFname.setBounds(30, 80, 80, 30);
		lbLname.setBounds(30, 130, 100, 30);
		lbAge.setBounds(30, 180, 30, 30);
		lbPhone.setBounds(30, 220, 50, 30);
		
		btnOk = new JButton("OK");
		btnCancel = new JButton("Cancel");
		btnOk.setBounds(75, 280, 100, 40);
		btnCancel.setBounds(225, 280, 100, 40);
		
		add( id );
		add( fname );
		add( lname );
		add( age );
		add( phone );
		
		add( lbId );
		add( lbFname );
		add( lbLname );
		add( lbAge );
		add( lbPhone );
		
		add( btnOk );
		add(btnCancel);
		
		btnOk.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				res =  "Ok";
				setVisible(false);
			}
		});
		
		btnCancel.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				res =  "Cancel";
				setVisible(false);
			}
		});
	}
	public void setPerson(Person p)
	{
		id.setText(""+p.id);
		fname.setText(p.fname);
		lname.setText(p.lname);
		age.setText(""+p.age);
		phone.setText(p.phone);
	
	}
	public Person getPerson()
	{
		Person p = new Person();
		p.id = Integer.parseInt(id.getText());
		p.fname = fname.getText();
		p.lname = lname.getText();
		p.age =Integer.parseInt(age.getText());
		p.phone = phone.getText();
		return p;
	}
}
