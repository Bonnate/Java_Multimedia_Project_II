import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
		new Cat();
		new Dog();
		new Dog();
		
		System.out.print("생성된 객체의 개수: " + Animal.AnimalCount);
	}
}
