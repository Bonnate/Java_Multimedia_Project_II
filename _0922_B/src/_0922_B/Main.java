package _0922_B;

public class Main {

	public static void main(String[] args) {
		
		//클래스를 생성할 때, Animal > Animal로 형변환(실제로는 하지 않음)
		Animal animal = new Animal();
		
		//클래스를 생성할 때, Dog(자식 객체)를 Amimal(부모 객체)로 형변환을 하여 생성한다.
		//실제 인스턴스는 Dog이지만, Animal로 취급
		Animal dog = new Dog();
		
		//클래스를 생성할 때, Cat(자식 객체)를 Animal(부모 객체)로 형변환을 하여 생성한다.
		//실제 인스턴스는 Cat이지만, Animal로 취급 
		Animal cat = new Cat();
		
		//실제 객체의 인스턴스는 각각 Animal, Dog, Cat이지만
		//위 생성자에서는 Animal로 """취급""" 한다.
		//실제 프로그램 내에서는 바인딩으로 인해 실제 인스턴스로 작동함
		
		//이런 상속관계간 형변환을 사용하는 이유는 최상위 클래스를 이용해 하나의 타입으로 만든 배열,리스트 등 Container을 이용하여
		//하나의 for문으로 접근 및 제어 할 수 있기 때문이다.
		speak(animal);
		speak(dog);
		speak(cat);
	}
	
	private static void speak(Animal target)
	{
		//Animal 클래스 내의 함수 Speak가 실행되지만
		//각 클래스의 실제 인스턴스인 자식의 함수로 오버라이딩 되어 실행되게 된다.
		target.Speak();
	}
}