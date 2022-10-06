
public class PlayerBullet extends GameObject 
{
	public PlayerBullet(int posX, int posY)
	{
		super(posX, posY, "!");
		
	}

	@Override
	public void Start() {
		// TODO Auto-generated method stub
		//debug
		System.out.println("플레이어 총알 생성");
		
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		--mPosY;
		
		//높이가 0이면.. Destory
		if(mPosY == 0)
		{
			Destory();
		}
	}

	@Override
	public void OnDestroy() {
		// TODO Auto-generated method stub
		
	}
	
	
}
