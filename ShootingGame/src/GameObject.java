//런타임 도중 생성될 수 있는 게임 오브젝트 하나
abstract public class GameObject 
{
	protected int mPosX, mPosY;
	protected String mImage;
	
	/** 삭제 예약인 상태인가? */
	protected boolean mIsDestroy = false;
	
	public GameObject(int posX, int posY, String image)
	{
		this.mPosX = posX;
		this.mPosY = posY;
		this.mImage = image;
	}
	
	//인스턴스가 생성되면 호출되는 함수
	abstract public void Start();
	
	//매 프레임마다 호출되는 함수
	abstract public void Update();
	
	//인스턴스가 삭제되기 직전에 호출되는 함수
	abstract public void OnDestroy();
	
	//현재 인스턴스를 버퍼에 쓴다
	public void Draw()
	{
		GameManager.Instance().drawToBuffer(mPosX, mPosY, mImage);
	}
	
	public void Destory()
	{
		mIsDestroy = true;
	}
	
	public boolean IsDestroy()
	{
		return mIsDestroy;
	}
}
