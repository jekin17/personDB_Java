package blogic;

import java.util.ArrayList;
import java.util.ListIterator;

public class PersonJSON
{
	public String obj = null;
	public int id;
	String fname;
	String lname;
	int age;
	String phone;

	public String toJSON(ArrayList<Person> pp)
	{	
		String tytle1 = "{\"Persons\":[";
		String tytle2 = "]}";
		obj = tytle1;
		for (Person p : pp)
		{
			obj += createObj(p);
			obj += ",";
		}
		obj = obj.substring(0, obj.length()-1);
		obj += tytle2;
		return obj;
	}

	private String createObj(Person p)
	{
		String str = "{";
		str += addKeyToObj("id");
		str += ":";
		str += addValToObj(""+p.id);
		str += ",";
		str += addKeyToObj("fname");
		str += ":";
		str += addValToObj("\"" +p.fname+ "\"");
		str += ",";
		str += addKeyToObj("lname");
		str += ":";
		str += addValToObj("\"" +p.lname+ "\"");
		str += ",";
		str += addKeyToObj("age");
		str += ":";
		str += addValToObj(""+p.age);
		str += "}";
		return str;
	}

	private String addKeyToObj(String key)
	{
		return "\"" + key+ "\"";
	}

	private String addValToObj(String val)
	{
		return val;
	}

	public ArrayList<Person>  fromJson(String json)
	{
		ArrayList<Person> pp = new ArrayList<>();
		json = json.replaceAll("(\\[|\\{|\\s|\\]|\\}|\"Person\")", "");
		json = json.replaceFirst("\\:", "");
		Person tmp = new Person(0,"","",0, "");

		String[] key = json.split(",");

		for (int i = 0, ind = 0; i < key.length; i++, ind++)
		{	
			String[] val = key[i].split(":");	
			if(ind >3)
			{
				ind = 0;
				pp.add(new Person(tmp.id, tmp.fname, tmp.lname, tmp.age, tmp.phone)); 
			}
			switch(ind)
			{
			case 0: tmp.id = Integer.parseInt(val[1]); break;
			case 1: tmp.fname = val[1]; break;
			case 2: tmp.lname = val[1]; break;
			case 3: tmp.age = Integer.parseInt(val[1]); break;
			}
		}
		pp.add(new Person(tmp.id, tmp.fname, tmp.lname, tmp.age, tmp.phone));
		return pp;
	}
}
