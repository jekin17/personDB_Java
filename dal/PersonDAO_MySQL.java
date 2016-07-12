package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import blogic.Person;

public class PersonDAO_MySQL implements PersonDAO
{
	private static String url = "jdbc:mysql://localhost:3306/person";
	private static String user = "root";
	private static String password = "Motox";

	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
	
	ArrayList<Person> pp;
	
	public PersonDAO_MySQL()
	{
		
	}

	@Override
	public ArrayList<Person> read() throws SQLException
	{
		pp = new ArrayList<>();
		con =  DriverManager.getConnection(url, user, password);
		st  = con.createStatement();
		rs = st.executeQuery("select* from persons");
		while(rs.next())
		{
			pp.add(new Person(rs.getInt("id"), rs.getString("fname"), rs.getString("lname"), rs.getInt("age"), rs.getString("phone")));
		}
		return pp;
	}

	@Override
	public void create(Person p) throws SQLException
	{
		con =  DriverManager.getConnection(url, user, password);
		st  = con.createStatement();
		st.executeUpdate("insert into Persons VALUES (" + p.id + ",'" + p.fname+ "','" + p.lname+"'," + p.age + ")");	
	}

	@Override
	public void update(Person p) throws SQLException
	{
		con =  DriverManager.getConnection(url, user, password);
		st  = con.createStatement();
		st.executeUpdate("update Persons set fname = '" + p.fname +  "',lname = '" + p.lname + "', age = '" + p.age + "' where id = '" + p.id + "'");
	}

	@Override
	public void delete(Person p) throws SQLException
	{
		con =  DriverManager.getConnection(url, user, password);
		st  = con.createStatement();
		st.executeUpdate("delete from Persons where id = "+ p.id );
	}
}
