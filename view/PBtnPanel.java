package view;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import blogic.PersonDM;

public class PBtnPanel extends JPanel
{
	JButton btnR = null;
	JButton btnC = null;
	JButton btnU = null;
	JButton btnD = null;
	
	
	
	public PBtnPanel(PersonDM dm)
	{
		setLayout(null);
		setBounds(500, 120, 100, 500);
		
		ImageIcon icR = new ImageIcon("C:/Users/Jeka/Desktop/Img/red-button.png");
		ImageIcon icC = new ImageIcon("C:/Users/Jeka/Desktop/Img/green-button.png");
		ImageIcon icU = new ImageIcon("C:/Users/Jeka/Desktop/Img/blue-button.png");

		btnR = new JButton("Read");
		btnR.setBounds(0, 0, 80, 30);
		btnC = new JButton("Create");
		btnC.setBounds(0, 50, 80, 30);
		btnU = new JButton("Update");
		btnU.setBounds(0, 100, 80, 30);
		btnD = new JButton("Delete");
		btnD.setBounds(0, 150, 80, 30);
	

		btnR.addActionListener(dm.aRead);
		btnC.addActionListener(dm.aCreate);
		btnU.addActionListener(dm.aUpdate);
		btnD.addActionListener(dm.aDelete);

		add(btnR);
		add(btnC);
		add(btnU);
		add(btnD);
	}
}
