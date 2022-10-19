package _1020_B;
/*
 * 전화번호 관리 프로그램 구현 프로젝트
 * Version 0.5
 */

import java.util.Scanner;

interface INIT_MENU
{
	int INPUT=1, SEARCH=2, DELETE=3, EXIT=4;
}

interface INPUT_SELECT
{
	int NORMAL=1, UNIV=2, COMPANY=3;
}

class PhoneInfo
{
	String name;
	String phoneNumber;
	
	public PhoneInfo(String name, String num)
	{
		this.name=name;
		phoneNumber=num;
	}
	
	public void showPhoneInfo()
	{
		System.out.println("name: "+name);
		System.out.println("phone: "+phoneNumber);
	}
}

class PhoneUnivInfo extends PhoneInfo
{
	String major;
	int year;	
	
	public PhoneUnivInfo(String name, String num, String major, int year)
	{
		super(name, num);
		this.major=major;
		this.year=year;
	}
	
	public void showPhoneInfo()
	{
		super.showPhoneInfo();
		System.out.println("major: "+major);
		System.out.println("year: "+year);
	}
}

class PhoneCompanyInfo extends PhoneInfo
{
	String company;
	
	public PhoneCompanyInfo(String name, String num, String company)
	{
		super(name, num);
		this.company=company;
	}
	
	public void showPhoneInfo()
	{
		super.showPhoneInfo();
		System.out.println("company: "+company);
	}
}

class PhoneBookManager
{
	final int MAX_CNT=100;
	PhoneInfo[] infoStorage=new PhoneInfo[MAX_CNT];
	int curCnt=0;
	
	static PhoneBookManager inst=null;
	public static PhoneBookManager createManagerInst()
	{
		if(inst==null)
			inst=new PhoneBookManager();
		
		return inst;
	}
	
	private PhoneBookManager(){}
	
	private PhoneInfo readFriendInfo()
	{
		System.out.print("이름: ");
		String name=MenuViewer.keyboard.nextLine();
		System.out.print("전화번호: ");
		String phone=MenuViewer.keyboard.nextLine();
		return new PhoneInfo(name, phone);
	}
	
	private PhoneInfo readUnivFriendInfo()
	{
		System.out.print("이름: ");
		String name=MenuViewer.keyboard.nextLine();
		System.out.print("전화번호: ");
		String phone=MenuViewer.keyboard.nextLine();
		System.out.print("전공: ");
		String major=MenuViewer.keyboard.nextLine();
		System.out.print("학년: ");
		int year=MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		return new PhoneUnivInfo(name, phone, major, year);
	}
	
	private PhoneInfo readCompanyFriendInfo()
	{
		System.out.print("이름: ");
		String name=MenuViewer.keyboard.nextLine();
		System.out.print("전화번호: ");
		String phone=MenuViewer.keyboard.nextLine();
		System.out.print("회사: ");
		String company=MenuViewer.keyboard.nextLine();
		return new PhoneCompanyInfo(name, phone, company);	
	}	
	
	public void inputData() throws InputException
	{
		System.out.println("데이터 입력을 시작합니다..");
		System.out.println("1. 일반, 2. 대학, 3. 회사");
		System.out.print("선택>> ");
		int choice=MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		
		if(choice > 3) 
		{
			throw new InputException(choice);
		}
		
		PhoneInfo info=null;
		
		switch(choice)
		{
		case INPUT_SELECT.NORMAL:
			info=readFriendInfo();
			break;
		case INPUT_SELECT.UNIV:
			info=readUnivFriendInfo();
			break;
		case INPUT_SELECT.COMPANY:
			info=readCompanyFriendInfo();
			break;
		}
		
		infoStorage[curCnt++]=info;
		System.out.println("데이터 입력이 완료되었습니다. \n");		
	}
	
	public void searchData()
	{
		System.out.println("데이터 검색을 시작합니다..");
		
		System.out.print("이름: ");
		String name=MenuViewer.keyboard.nextLine();
		
		int dataIdx=search(name);
		if(dataIdx<0)
		{
			System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
		}
		else
		{
			infoStorage[dataIdx].showPhoneInfo();
			System.out.println("데이터 검색이 완료되었습니다. \n");
		}
	}
	
	public void deleteData()
	{
		System.out.println("데이터 삭제를 시작합니다..");
		
		System.out.print("이름: ");
		String name=MenuViewer.keyboard.nextLine();
		
		int dataIdx=search(name);
		if(dataIdx<0)
		{
			System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
		}
		else
		{
			for(int idx=dataIdx; idx<(curCnt-1); idx++)
				infoStorage[idx]=infoStorage[idx+1];
			
			curCnt--;
			System.out.println("데이터 삭제가 완료되었습니다. \n");
		}
	}
	
	private int search(String name)
	{
		for(int idx=0; idx<curCnt; idx++)
		{
			PhoneInfo curInfo=infoStorage[idx];
			if(name.compareTo(curInfo.name)==0)
				return idx;
		}
		return -1;
	}
}



class MenuViewer
{
	public static Scanner keyboard=new Scanner(System.in);
	
	public static void showMenu()
	{
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 프로그램 종료");
		System.out.print("선택: ");
	}
}

class Main
{	
	public static void main(String[] args)
	{
		//Untitled From Jackdclee
		//https://pastebin.com/DXgRBJG4
		
		//PhoneBookManager은 createManagerInst()함수를 통한 인스턴스 생성만 가능하게 구현(싱글톤 패턴을 이용하기 위해)
		//PhoneBookManager manager=PhoneBookManager.createManagerInst();
		
		//PhoneBookManager를 담는 변수를 3개 만들고, 변수(레퍼런스)는 3개이지만 PhoneBookManager.createManagerInst();
		//싱글톤 패턴을 적용한 클래스이기에 실제로는 하나의 인스턴스에 대한 레퍼런스는 동일하다.
		PhoneBookManager manager1=PhoneBookManager.createManagerInst();
		PhoneBookManager manager2=PhoneBookManager.createManagerInst();
		PhoneBookManager manager3=PhoneBookManager.createManagerInst();
		
		//생성자가 Private로 되어있어 생성자를 통한 인스턴스 생성이 불가
		//PhoneBookManager managerInst2 = new PhoneBookManager();
		
		int choice;
		
		while(true)
		{
			MenuViewer.showMenu();
			choice=MenuViewer.keyboard.nextInt();
			
			MenuViewer.keyboard.nextLine();
			
			try
			{
				if(choice > 4)
				{
					throw new InputException(choice);									
				}
			}
			catch (InputException e)
			{
				e.printStackTrace();
			}
			
			
			switch(choice)
			{
			case INIT_MENU.INPUT:
				try {
					manager1.inputData();
				} catch (InputException e) {
					e.printStackTrace();
				}
				break;
			case INIT_MENU.SEARCH:
				manager2.searchData();
				break;
			case INIT_MENU.DELETE:
				manager3.deleteData();
				break;				
			case INIT_MENU.EXIT:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}
