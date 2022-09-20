package _0922_A;

public class Main {

	public static void main(String[] args) {
		Animal animal = new Animal();
		Animal dog = new Dog();
		Animal cat = new Cat();
		speak(animal);
		speak(dog);
		speak(cat);
	}
	
	private static void speak(Animal target)
	{
		target.Speak();
	}
}