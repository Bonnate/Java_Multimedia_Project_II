package _0922_A;

 class Person{
 	protected String name;
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
 	public void printStudentMessage() {
 		System.out.println(name+"는 Student으로 캐스팅할 수 있다." );
 	}
 }

 class Researcher extends Person {
 	public Researcher(String name) {
 		super(name);
 	}
 	public void printResearcherMessage() {
 		System.out.println(name+"는 Resercher으로 캐스팅할 수 있다." );
 	}
 }

 class Professor extends Researcher {
 	public Professor(String name) {
 		super(name);
 	}
 	public void printProfessorMessage() {
 		System.out.println(name+"는 Professor으로 캐스팅할 수 있다." );
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
 			((Student)jee).printStudentMessage();
 		}
 		if(kim instanceof Student){
 			((Student)kim).printStudentMessage();
 		}
 		if(kim instanceof Professor){
 			((Professor)kim).printProfessorMessage();
 		}
 		if(kim instanceof Researcher){
 			((Researcher)kim).printResearcherMessage();
 		}
 		if(lee instanceof Professor){
 			((Professor)lee).printProfessorMessage();
 		}

 	}

 }