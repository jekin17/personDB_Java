package dal;

import java.sql.SQLException;
import java.util.ArrayList;

import blogic.Person;

public class PersonDAO_Mock implements PersonDAO

{
	ArrayList<Person> pp = new ArrayList<>();

	public PersonDAO_Mock()
	{
		pp.add( new Person(1, "Vasia", "Pupkin", 23, "+380503200030") );
		pp.add( new Person(2, "Kasia", "Lupkin", 27, "+380673200030") );
		pp.add( new Person(3, "Masia", "Gupkin", 19, "+380673200030") );
		pp.add( new Person(4, "Gasia", "Hupkin", 56, "+380673200030") );
	
	}

	@Override
	public ArrayList<Person> read() throws SQLException
	{
		return pp;
	}

	@Override
	public void create(Person p) throws SQLException	
	{
		pp.add(p);
	}

	@Override
	public void update(Person p) throws SQLException	
	{
		int ind = 0;
		for (Person p1 : pp)
		{
			if(p.id == p1.id)
			{
				pp.set(ind, p);
			}
			ind++;
		}
	}

	@Override
	public void delete(Person p) throws SQLException	
	{
		pp.remove(p);
	}
}

