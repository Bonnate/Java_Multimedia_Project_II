package _0922_A;

class Person{
	private String name;
	public Person(String name) {
		this.name = name;
	}
	public void printPersonMessage() {
		System.out.println(name+"는 Person으로 캐스팅할 수 있다." );
	}
}

class Student extends Person {
	public Student(String name) {
		super(name);
	}
}

class Researcher extends Person {
	public Researcher(String name) {
		super(name);
	}
}

class Professor extends Researcher {
	public Professor(String name) {
		super(name);
	}
}


public class Main {

	public static void main(String[] args) {
		Person jee=new Student("jee");
		Person kim=new Professor("kim");
		Person lee=new Researcher("lee");
		if(jee instanceof Person){ 
			jee.printPersonMessage();
		}
		if(jee instanceof Student){
			System.out.println("jee는 Student로 캐스팅할 수 있다.");
		}
		if(kim instanceof Student){
			System.out.println("kim은 Student로 캐스팅할 수 있다.");
		}
		if(kim instanceof Professor){
			System.out.println("kim은 Professor로 캐스팅할 수 있다.");
		}
		if(kim instanceof Researcher){
			System.out.println("kim은 Researcher로 캐스팅할 수 있다.");
		}
		if(lee instanceof Professor){
			System.out.println("lee은 Professor로 캐스팅할 수 있다.");
		}

	}

}
