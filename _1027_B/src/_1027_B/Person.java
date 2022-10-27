package _1027_B;

public class Person {
	private String mName;
	private int mAge;

	public Person(String name, int age) {
		this.mName = name;
		this.mAge = age;
	}
	
	public Person(String name) {
		this.mName = name;
	}
	
	public String GetName()
	{
		return this.mName;
	}

	public void ShowData() {
		System.out.println(this.mName + " " + this.mAge);
	}

	@Override
	public int hashCode() {
		return this.mName.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Person other = (Person) obj;
		if (this.mName.equals(other.mName))
			return true;
		
		return false;
	}
}
