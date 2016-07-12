package blogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import dal.PersonDAO_Mock;
import dal.PersonDAO_MySQL;
import view.PDialog;

public class PersonDM extends AbstractTableModel
{
	
	ArrayList<Person> pp;
	PersonDAO_Mock pd;
	public JTable tb;
	
	public ActionDBRead 	aRead =  new ActionDBRead();
	public ActionDBCreate 	aCreate = new ActionDBCreate();
	public ActionDBUpdate 	aUpdate =  new ActionDBUpdate();
	public ActionDBDelete	aDelete = new ActionDBDelete();


	public PersonDM() throws SQLException
	{
		pd = new PersonDAO_Mock();
		pp = pd.read();
	}

	@Override
	public int getColumnCount()
	{
		return 5;
	}

	@Override
	public int getRowCount()
	{
		return pp.size();
	}

	@Override
	public String getColumnName(int column)
	{
		String[] str = {"id", "FName", "LName", "Age", "Phone"};
		return str[column];
	}
 
	
	@Override
	public Object getValueAt(int row, int column)
	{
		Person p = pp.get(row);
		Object obj = null;

		switch(column)
		{
		case	0: obj = p.id; break;
		case	1: obj = p.fname; break;
		case	2: obj = p.lname; break;
		case	3: obj = p.age; break;
		case	4: obj = p.phone;break;
		}
		return obj;
	}
	
	class ActionDBRead implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				pp = pd.read();
				fireTableDataChanged();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}
	}

	class ActionDBCreate implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			PDialog pDialog = new PDialog();
			pDialog.setModal(true);
			pDialog.setVisible(true);
			if(pDialog.res == "Ok")
			{
				try
				{
					pd.create(pDialog.getPerson());
					pp = pd.read();
					fireTableDataChanged();
				}
				catch (SQLException e2)
				{
					e2.printStackTrace();
				}
			}
		}
	}

	class ActionDBUpdate implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
						
			int ind = tb.getSelectedRow();
			PDialog pDialog = new PDialog();
			pDialog.setPerson(pp.get(ind));
			pDialog.setModal(true);
			pDialog.setVisible(true);
			
			System.out.println(ind);
			
			if(pDialog.res == "Ok")
			{
				try
				{
					pd.update(pDialog.getPerson());
					pp = pd.read();
					fireTableDataChanged();
				}
				catch (SQLException e2)
				{
					e2.printStackTrace();
				}
			}
		}
	}
	
	class ActionDBDelete implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			PDialog pDialog = new PDialog();
			pDialog.setModal(true);
			pDialog.setVisible(true);
			if(pDialog.res == "Ok")
			{
				try
				{
					pd.delete(pDialog.getPerson());
					pp = pd.read();
					fireTableDataChanged();
				}
				catch (SQLException e2)
				{
					e2.printStackTrace();
				}
			}
		}
	}
	
}
