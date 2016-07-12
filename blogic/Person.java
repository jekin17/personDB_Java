package blogic;

import java.util.ArrayList;

public class Person
{
	public int id;
	public String fname;
	public String lname;
	public int age;
	public String phone;
	 
	public Person() {}
	
	public Person(int id, String fname, String lname, int age, String phone) 
	{
		init(id, fname, lname, age, phone);
	}
	
	public void init(int id, String fname, String lname, int age, String phone) 
	{
		this.id    = id;
		this.fname = fname;
		this.lname = lname;
		this.age   = age;
		this.phone = phone;
	}
	
	public static void print(ArrayList<Person> pp)
	{
		for (Person p : pp) 
		{
			System.out.println( p );
		}
	}
	
	@Override
	public boolean equals(Object o)
	{
		Person p = (Person) o;
		return (this.id == p.id);
	}
	
	@Override
	public String toString() 
	{
		return "Person [id=" + id + ", fname=" + fname + ", lname=" + lname + ", age=" + age +", phone =" + phone +"]";
	}
}
