public class PlayerObject extends GameObject {

	/** 총알 발사 딜레이 */
	private float mOriginBulletDelay = 0.1f;
	private float mCurrentBulletDelay;

	/** 좌측 컨트롤 패널을 이용하는가? */
	private boolean mIsLeftCtrl;
	
	/** 이동속도 */
	private float mSpeed;

	public PlayerObject(int posX, int posY) {
		super(posX, posY, ">-O-<");
		
		mSpeed = 50.0f;
	}

	@Override
	public void Start() {
		// TODO Auto-generated method stub

		// runtime
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

	public void ModifyCtrlPanel(boolean flag) {
		mIsLeftCtrl = flag;
	}

	private void Move() {

		// 플레이어 ID가 0이면 좌측 컨트롤 패널 사용(WASD G)
		if (InputManager.Instance().GetKey(mIsLeftCtrl ? "W" : "UP")) {
			mPosY -= mSpeed * Time.DeltaTime();

			if (mPosY < 0) {
				mPosY = 0;
			}
		}
		if (InputManager.Instance().GetKey((mIsLeftCtrl ? "A" : "LEFT"))) {
			mPosX -= mSpeed * Time.DeltaTime();

			if (mPosX < GameManager.LEFT_PADDING + 1) {
				mPosX = GameManager.LEFT_PADDING + 1;
			}
		}
		if (InputManager.Instance().GetKey((mIsLeftCtrl ? "S" : "DOWN"))) {
			mPosY += mSpeed * Time.DeltaTime();

			if (mPosY > GameManager.SCREEN_HEIGHT - 1) {
				mPosY = GameManager.SCREEN_HEIGHT - 1;
			}
		}
		if (InputManager.Instance().GetKey((mIsLeftCtrl ? "D" : "RIGHT"))) {
			mPosX += mSpeed * Time.DeltaTime();

			if (mPosX > GameManager.SCREEN_WIDTH - GameManager.RIGHT_PADDING - mImage.length() + 2) {
				mPosX = GameManager.SCREEN_WIDTH - GameManager.RIGHT_PADDING - mImage.length() + 1;
			}
		}
	}

	private void ShootBullet() {
		// 총알 딜레이
		mCurrentBulletDelay -= Time.DeltaTime();

		if (mCurrentBulletDelay < 0 && InputManager.Instance().GetKey((mIsLeftCtrl ? "G" : "M"))) {
			if (mPosY == 0) {
				return;
			}

			ObjectManager.Instance().Instantiate(new BulletObject(mPosX + 2, mPosY));
			mCurrentBulletDelay = mOriginBulletDelay;
		}

	}

}
