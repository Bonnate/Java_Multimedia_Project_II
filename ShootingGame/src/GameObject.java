//런타임 도중 생성될 수 있는 게임 오브젝트 하나
abstract public class GameObject {
	protected float mPosX, mPosY;
	protected String mImage;
	
	//2차 프로젝트 업데이트 (Name, Tag 추가)
	protected String mName;
	protected String mTag;

	/**
	 * 삭제 예약인 상태인가를 나타내는 불리언 변수 Destroy가 호출되면 프레임이 끝나는 순간에 제거된다.
	 */
	protected boolean mIsDestroy = false;

	public GameObject(float posX, float posY, String image) {
		this.mPosX = posX;
		this.mPosY = posY;
		this.mImage = image;
	}

	/** 오브젝트 매니저에 의해 인스턴스 될 경우 한번 호출되는 함수 */
	abstract public void Start();

	/** 매 프레임마다 호출되는 함수 */
	abstract public void Update();

	/** mIsDestroy가 true인경우 프레임이 끝나는 시점에 호출되는 함수 */
	abstract public void OnDestroy();

	/** mImage를 버퍼에 쓰는 함수 */
	public void Draw() {
		GameManager.Instance().DrawToBuffer((int)mPosX, (int)mPosY, mImage);
	}

	/** 자기자신 혹은 외부에서 호출될 수 있으며, 프레임이 끝나는 시점에 파괴하도록 예약한다. */
	public void Destory() {
		mIsDestroy = true;
	}

	/** 파괴 대기중인 상태인지를 리턴 */
	public boolean IsDestroy() {
		return mIsDestroy;
	}
}
