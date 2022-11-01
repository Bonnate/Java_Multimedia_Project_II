package _1103A;

public class Person {
	private String mName;
	private int mAge;
	
	public Person(String name, int age)
	{
		this.mName = name;
		this.mAge = age;
	}
	
	public void DisplayInfo()
	{
		System.out.println("이름: " + this.mName);
		System.out.println("나이: " + this.mAge);
	}
}
