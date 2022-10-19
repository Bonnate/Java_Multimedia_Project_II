package _1020_B;

public class InputException extends Exception 
{
	public InputException(int num)
	{
		super(num + "은 잘못된 입력입니다.");
	}
}
