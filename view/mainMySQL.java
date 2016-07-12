package view;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;

import blogic.Person;
import blogic.PersonJSON;
import dal.PersonDAO_Mock;

public class mainMySQL
{
	public static void main(String[] args) throws SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		new PFrame();
		Person p  =  new Person(15,"Jora", "Petrov", 25, "0503200065");
		PersonDAO_Mock db = new PersonDAO_Mock();
		ArrayList<Person> pp  = db.read();
		PersonJSON json = new PersonJSON();
		String str = json.toJSON(pp);
		//System.out.println(str);
		ArrayList<Person> pp1 = json.fromJson(str);
		
		Class aClass = json.getClass();
		Field[] fields  = aClass.getFields();
		Field ff;
		
		for (Field f : fields)
		{
			Class fieldType = f.getType();
			System.out.println("Filds - " + f.getName());
			String name = f.getName();
			ff = aClass.getField(name);
			System.out.println("FildsValue - " + ff.get(json));
		}
		
		//for (Person p : pp1)
		//{
		//	System.out.println(p.id + "," + p.fname + "," + p.lname + "," + p.age);
		//}
	}
}


