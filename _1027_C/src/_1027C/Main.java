package _1027C;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		Scanner input = new Scanner(System.in);
		
		int keyInput;
		String valueInput;
		
		while(true)
		{
			System.out.print("번호와 단어를 입력하세요(99==quit): ");
			keyInput = input.nextInt();
			valueInput = input.nextLine();
			
			if(keyInput == 99) break;
			
			map.put(keyInput, valueInput.substring(1, valueInput.length()));
		}

		System.out.print("찾을 단어의 번호를 입력하세요: ");
		keyInput = input.nextInt();
		System.out.print(map.get(keyInput) + "입니다.");
	}

}

