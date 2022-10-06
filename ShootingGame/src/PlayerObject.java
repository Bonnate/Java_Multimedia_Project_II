import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerObject extends GameObject implements KeyListener {
	
	/** 총알 발사 딜레이*/
	private float mOriginBulletDelay = 1;
	private float mCurrentBulletDelay = 0; 
	
	public PlayerObject(int posX, int posY) {
		super(posX, posY, ">-O-<");
	}

	@Override
	public void Start() {
		// TODO Auto-generated method stub

		// debug
		System.out.print("게임 오브젝트 생성됨");

		// runtime
		GameManager.Instance().AttachKeyListener(this);
		
		mCurrentBulletDelay = mOriginBulletDelay;
	}

	@Override
	public void Update() {
		
		Move();
		ShootBullet();
	}

	@Override
	public void OnDestroy() {
		// TODO Auto-generated method stub

	}
	
	private void Move()
	{
		if(InputManager.Instance().GetKey("W"))
		{
			--mPosY;
			
			if(mPosY == -1) { ++mPosY; }
		}
		if(InputManager.Instance().GetKey("A"))
		{
			--mPosX;
			
			if(mPosX == GameManager.LEFT_PADDING) { ++mPosX; }
		}
		if(InputManager.Instance().GetKey("S"))
		{
			++mPosY;
			
			if(mPosY == GameManager.SCREEN_HEIGHT) { --mPosY; }
		}
		if(InputManager.Instance().GetKey("D"))
		{
			++mPosX;
			
			if(mPosX == GameManager.SCREEN_WIDTH - GameManager.RIGHT_PADDING - mImage.length() + 2) { --mPosX; }
		}
	}
	
	private void ShootBullet()
	{
		//총알 딜레이
		--mCurrentBulletDelay;
		
		
		if(mCurrentBulletDelay < 0 && InputManager.Instance().GetKey("SPACEBAR"))
		{
			if(mPosY == 0) { return; }
			
			ObjectManager.Instance().Instantiate(new PlayerBullet(mPosX + 2, mPosY));
			mCurrentBulletDelay = mOriginBulletDelay;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//None
	}


    @Override
    public void keyPressed(KeyEvent e) {
    	InputManager.Instance().ModifyKey(e, true);
    }

	@Override
	public void keyReleased(KeyEvent e) {
		InputManager.Instance().ModifyKey(e, false);

	}

}
