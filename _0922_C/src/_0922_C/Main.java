package _0922_C;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		FriendInfoHandler handler = new FriendInfoHandler();
		
		while (true) {
			System.out.println("*** 메뉴 선택 ***");
			System.out.println("1. 고교 친구 저장");
			System.out.println("2. 대학 친구 저장");
			System.out.println("3. 전체 정보 출력");
			System.out.println("4. 기본 정보 출력");
			System.out.println("5. 프로그램 종료");
			System.out.print("선택>> ");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
			case 2:
				handler.AddFriend(choice);
				break;
			case 3:
				handler.ShowAllData();
				break;
			case 4:
				handler.ShowAllSimpleData();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			
			System.out.println("");
		}

	}

}
