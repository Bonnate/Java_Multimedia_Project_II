
public class BulletObject extends GameObject 
{
	private float mSpeed;
	
	public BulletObject(float posX, float posY)
	{
		super(posX, posY, "!");
		
		mSpeed = 50.0f;
	}

	@Override
	public void Start() {
		// TODO Auto-generated method stub
		//debug
		System.out.println("플레이어 총알 생성" + mPosY);
		
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		mPosY -= mSpeed * Time.DeltaTime();
		
		//높이가 0이면.. Destory
		if(mPosY < 0)
		{
			Destory();
		}
	}

	@Override
	public void OnDestroy() {
		// TODO Auto-generated method stub
		//debug
		System.out.println("플레이어 총알 제거");
		
		GameManager.Instance().ModifyScore(1);
	}
}
