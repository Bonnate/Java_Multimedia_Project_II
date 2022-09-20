package _0922_A;

public class Animal 
{
	public void Speak()
	{
		System.out.println("Animal Speak");
	}
}

class Cat extends Animal
{
	public void Speak()
	{
		System.out.println("Meow");
	}
}

class Dog extends Animal
{
	public void Speak()
	{
		System.out.println("Woof");
	}
}
