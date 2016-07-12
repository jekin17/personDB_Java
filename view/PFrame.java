package view;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import blogic.Person;
import blogic.PersonDM;

public class PFrame extends JFrame 
{
	ArrayList<Person> pp;
	JTable tb;

	public PFrame() throws SQLException
	{
		setLayout(null);
		setBounds(200, 10, 800, 500);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:/Users/Jeka/Desktop/Img/db_mysql.jpg"));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("My DB");
					
		PersonDM dm = new PersonDM();
		tb = new JTable(dm);	
		dm.tb = this.tb;
		JScrollPane spn = new JScrollPane(tb);
		spn.setBounds(0, 0, 400, 800);
		
		add( spn );
		add( new PBtnPanel( dm ));
						
		setVisible(true);	
	}
}




