package dal;

import java.sql.SQLException;
import java.util.ArrayList;

import blogic.Person;

public interface  PersonDAO
{
	ArrayList<Person> read() throws SQLException, ClassNotFoundException;
	void create(Person p)    throws SQLException, ClassNotFoundException;
	void update(Person p)    throws SQLException, ClassNotFoundException;
	void delete(Person p)    throws SQLException, ClassNotFoundException;
}
