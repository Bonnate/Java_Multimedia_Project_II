package Framework;
import java.util.Vector;

import Utility.*;

//런타임 도중 생성될 수 있는 게임 오브젝트 하나
abstract public class GameObject {
	protected Vector2 mPosition;
	protected String mName;
	protected String mTag;
	protected Sprite mSprite;
	
	private Vector<BoxCollider2D> mBoxCollider;

	/** 삭제 예약인 상태인가를 나타내는 불리언 변수 Destroy가 호출되면 프레임이 끝나는 순간에 제거된다. */
	protected boolean mIsDestroy = false;

	/** 게임 오브젝트 생성*/
	public GameObject(Vector2 position, String name, String tag) {
		mBoxCollider = new Vector<BoxCollider2D>();
		
		mPosition = position;
		this.mName = name;
		this.mTag = tag;
	}

	/** 오브젝트 매니저에 의해 인스턴스 될 경우 한번 호출되는 함수 */
	abstract public void Start();

	/** 매 프레임마다 호출되는 함수 */
	abstract public void Update();

	/** mIsDestroy가 true인경우 프레임이 끝나는 시점에 호출되는 함수 */
	abstract public void OnDestroy();
	
	/** 콜리전 발생시 호출되는 함수*/
	abstract public void OnTriggerStay(GameObject other);

	/** mImage를 버퍼에 쓰는 함수 */
	public void Draw() {
//		GameManager.Instance().DrawToBuffer((int)mPosition.x, (int)mPosition.y, mImage);
	}

	/** 자기자신 혹은 외부에서 호출될 수 있으며, 프레임이 끝나는 시점에 파괴하도록 예약한다. */
	public void Destroy() {
		mIsDestroy = true;
	}

	/** 파괴 대기중인 상태인지를 리턴 */
	public boolean IsDestroy() {
		return mIsDestroy;
	}
	
	public void Translate(double x, double y)
	{
		this.mPosition.x += x;
		this.mPosition.y += y;
		
		//박스 콜라이더 이동
		for(BoxCollider2D boxcollider : mBoxCollider)
		{
			boxcollider.Translate(x, y);
		}
	}
	
	public void SetPosition(double x, double y)
	{
		this.mPosition.x = (float) x;
		this.mPosition.y = (float) y;
		
		//박스 콜라이더 위치 지정
		for(BoxCollider2D boxcollider : mBoxCollider)
		{
			boxcollider.SetPosition(this.mPosition.x, this.mPosition.y);
		}
	}
	
	/** BoxCollider2D 추가 */
	public void AddBoxCollider2D(float x, float y, float width, float height)
	{
		mBoxCollider.add(new BoxCollider2D(mPosition.x + x, mPosition.y + y, width, height));
	}
	
	//** BoxCollider2D 얻기 */
	public Vector<BoxCollider2D> GetBoxCollider2D()
	{
		return mBoxCollider;
	}
	
	public String GetName()
	{
		return mName;
	}
	
	public String GetTag()
	{
		return mTag;
	}
}
