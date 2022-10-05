package _0922_C;

import java.util.ArrayList;
import java.util.Scanner;

public class FriendInfoHandler {
	private ArrayList<HighFriend> mHighFriends;
	private ArrayList<UnivFriend> mUnivFriends;

	/// 생성자
	public FriendInfoHandler() {
		mHighFriends = new ArrayList<HighFriend>();
		mUnivFriends = new ArrayList<UnivFriend>();
	}

	/// Friend 추가
	public void AddFriend(int choice) {
		String name, phoneNum, addr, job, major;
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.print("전화 : ");
		phoneNum = sc.nextLine();
		System.out.print("주소 : ");
		addr = sc.nextLine();

		if (choice == 1) {
			System.out.print("직업 : ");
			job = sc.nextLine();
			mHighFriends.add(new HighFriend(name, phoneNum, addr, job));

		} else// if(choice==2)
		{
			System.out.print("학과 : ");
			major = sc.nextLine();
			mUnivFriends.add(new UnivFriend(name, phoneNum, addr, major));
		}
		System.out.println("입력 완료! \n");
	}

	public void ShowAllData() {	// 예제는 myFriends[i].showData()만 해주면 됐지만 각각의 리스트를 전부 출력해줘야한다.
		for (int i = 0; i < mHighFriends.size(); ++i) {
			mHighFriends.get(i).ShowData();
		}
		
		System.out.println("");
		
		for (int i = 0; i < mUnivFriends.size(); ++i) {
			mUnivFriends.get(i).ShowData();
		}
	}

	public void ShowAllSimpleData() {	// 마찬가지
		for (int i = 0; i < mHighFriends.size(); ++i) {
			mHighFriends.get(i).ShowBasicInfo();
		}
		
		System.out.println("");
		
		for (int i = 0; i < mUnivFriends.size(); ++i) {
			mUnivFriends.get(i).ShowBasicInfo();
		}
	}
}
