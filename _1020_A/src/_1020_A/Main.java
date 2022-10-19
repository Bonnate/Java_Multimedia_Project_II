package _1020_A;
import java.util.Scanner;

public class Main {
	
	public static Scanner keyboard=new Scanner(System.in);

	public static void main(String[] args) {
		String input;
		
		while(true)
		{
			System.out.print("입력하시오(종료:Z) ");
			input = keyboard.nextLine();
			if(input.equals("Z"))
			{
				System.out.println("프로그램을 종료합니다!!");
				return;
			}
			
			try
			{
				Integer.parseInt(input);
				System.out.println("숫자입니다!!");
			}
			catch (Exception e)
			{
				System.out.println("문자입니다!!");
			}
			
		}		
	}
}
