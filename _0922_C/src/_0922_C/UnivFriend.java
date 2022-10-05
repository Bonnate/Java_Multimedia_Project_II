package _0922_C;

public class UnivFriend {
	// Friend 클래스가 있었을 땐 Friend에서 이름, 번호, 주소를 가져왔지만 없어지게 되면서 Univ, High친구 각각에서 변수들을 만들어줘야한다.
	// 그리고 ShowBasicInfo에서도 정보들을 다 적워줘야한다.
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
