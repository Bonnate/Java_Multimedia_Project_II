public class Main 
{

	public static void main(String[] args) 
	{
		BusinessMan bMan = new BusinessMan("Jack", "ACompany", "Student");
		
		System.out.println("My name is " + 		bMan.GetName());
		System.out.println("My company is " + 	bMan.GetCompany());
		System.out.println("My position is " + 	bMan.GetPosition());
	}

}
