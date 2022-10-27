package _1027_A;
import java.util.*;
// 키보드로 문자열을 4개 입력 받아 ArrayList에 삽입하고 가장 긴 이름을 출력하라.
// 가장 긴 이름은 : Ashley
public class Main {
	public static void main(String[] args) {
		ArrayList<String> s = new ArrayList<String>();
		int index = 0, max = -1;
		for(int i = 0; i < 4; i++) {
			Scanner sc = new Scanner(System.in);
			System.out.print("이름을 입력하세요>>");
			s.add(new String(sc.nextLine()));
			
			if(max < s.get(i).length()) {
				max = s.get(i).length();
				index = i;
			}
		}
		for (String str : s) {
			System.out.print(str+" "); 
		}
		System.out.println("\n"+s.get(index)); 
	}
}
