package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import blogic.Person;

public class PersonDAO_H2 implements PersonDAO
{

	@Override
	public ArrayList<Person> read() throws SQLException, ClassNotFoundException
	{
		ArrayList<Person> pp = new ArrayList<>();
		Class.forName("org.h2.Driver");
		Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM PERSON");
		while( rs.next() )
		{
			pp.add( new Person( rs.getInt("id"), rs.getString(2), rs.getString("lname"), rs.getInt(4), rs.getString("phone")) );
		}
		return pp;
	}

	@Override
	public void create(Person p) throws SQLException, ClassNotFoundException
	{
		Class.forName("org.h2.Driver");
		Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		Statement st = con.createStatement();
		st.executeUpdate("insert into Person VALUES (" + p.id + ",'" + p.fname + "','" + p.lname + "'," + p.age + ")");
		
	}

	@Override
	public void update(Person p) throws SQLException, ClassNotFoundException
	{
		Class.forName("org.h2.Driver");
		Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		Statement st = con.createStatement();
		st.executeUpdate("update Person set fname= '" + p.fname + "' where id="+p.id);
		
	}

	@Override
	public void delete(Person p) throws SQLException, ClassNotFoundException
	{
		Class.forName("org.h2.Driver");
		Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		Statement st = con.createStatement();
		st.executeUpdate("delete from Person where id=" + p.id);
		
	}

}
