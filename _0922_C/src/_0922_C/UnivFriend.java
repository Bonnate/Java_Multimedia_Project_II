package _0922_C;

public class UnivFriend {
	
	private String mName; //이름
	private String mPhoneNum; //전화번호
	private String mAddress; //주
	private String mMajor; //전공
	
	public UnivFriend(String name, String phoneNum, String address, String major)
	{
		this.mName = name;
		this.mPhoneNum = phoneNum;
		this.mAddress = address;
		this.mMajor = major;
	}
	
	public void ShowData()
	{
		System.out.println("이름: " + mName);
		System.out.println("전화: " + mPhoneNum);
		System.out.println("주소: " + mAddress);
		System.out.println("전공: " + mMajor);
	}
	
	public void ShowBasicInfo()
	{
		System.out.println("이름: " + mName);
		System.out.println("전화: " + mPhoneNum);
		System.out.println("전공: " + mMajor);
	}
}
