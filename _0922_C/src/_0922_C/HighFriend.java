package _0922_C;

public class HighFriend {
	
	private String mName; //이름
	private String mPhoneNum; //전화번호
	private String mAddress; //주
	private String mWork; //직업
	
	public HighFriend(String name, String phoneNum, String address, String work)
	{
		this.mName = name;
		this.mPhoneNum = phoneNum;
		this.mAddress = address;
		this.mWork = work;
	}
	
	public void ShowData()
	{
		System.out.println("이름: " + mName);
		System.out.println("전화: " + mPhoneNum);
		System.out.println("주소: " + mAddress);
		System.out.println("직업: " + mWork);
	}
	
	public void ShowBasicInfo()
	{
		System.out.println("이름: " + mName);
		System.out.println("전화: " + mPhoneNum);
	}
}
