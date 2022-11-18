package Object;

import Framework.GameManager;
import Framework.GameObject;
import Framework.InputManager;
import Framework.ObjectManager;
import Framework.Time;
import Utility.Vector2;

public class PlayerObject extends GameObject {

	/** 총알 발사 딜레이 */
	private float mOriginBulletDelay = 0.1f;
	private float mCurrentBulletDelay;

	/** 좌측 컨트롤 패널을 이용하는가? */
	private boolean mIsLeftCtrl;

	/** 이동속도 */
	private float mSpeed;


	public PlayerObject(Vector2 pos, String name) {
		super(pos, name, "Player");

		mSpeed = 50.0f;
	}

	@Override
	public void Start() {
		// TODO Auto-generated method stub

		// runtime
		mCurrentBulletDelay = mOriginBulletDelay;

		super.AddBoxCollider2D(0, 0, 1, 1);
		super.AddBoxCollider2D(4, 0, 1, 1);
	}

	@Override
	public void Update() {
		Move();
		ShootBullet();
	}

	@Override
	public void OnDestroy() {
	}

	public void ModifyCtrlPanel(boolean flag) {
		mIsLeftCtrl = flag;
	}

	private void Move() {

		// 플레이어 ID가 0이면 좌측 컨트롤 패널 사용(WASD G)
		if (InputManager.Instance().GetKey(mIsLeftCtrl ? "W" : "UP")) {
			Translate(0, -mSpeed * Time.DeltaTime());

			if (mPosition.y < 0) {
				Translate(0, 1);
			}
		}
		if (InputManager.Instance().GetKey((mIsLeftCtrl ? "A" : "LEFT"))) {
			Translate(-mSpeed * Time.DeltaTime(), 0);

			if (mPosition.x < GameManager.LEFT_PADDING + 1) {
				Translate(1, 0);
			}
		}
		if (InputManager.Instance().GetKey((mIsLeftCtrl ? "S" : "DOWN"))) {
			Translate(0, mSpeed * Time.DeltaTime());

			if (mPosition.y > GameManager.SCREEN_HEIGHT - 1) {
				Translate(0, -1);
			}
		}
		if (InputManager.Instance().GetKey((mIsLeftCtrl ? "D" : "RIGHT"))) {
			Translate(mSpeed * Time.DeltaTime(), 0);

			if (mPosition.x > GameManager.SCREEN_WIDTH - GameManager.RIGHT_PADDING - mImage.length() + 2) {
				Translate(-1, 0);
			}
		}
	}

	private void ShootBullet() {
		// 총알 딜레이
		mCurrentBulletDelay -= Time.DeltaTime();

		if (mCurrentBulletDelay < 0 && InputManager.Instance().GetKey((mIsLeftCtrl ? "G" : "M"))) {
			if (mPosition.y == 0) {
				return;
			}

			ObjectManager.Instance().Instantiate(new BulletObject(new Vector2(mPosition.x + 2, mPosition.y)));
			mCurrentBulletDelay = mOriginBulletDelay;

//			System.out.println(mPosition.x + ", " + mPosition.y);
//			System.out.println(super.GetBoxCollider2D().get(0).GetBox().x + ", " + super.GetBoxCollider2D().get(0).GetBox().y);
		}

	}

	@Override
	public void OnTriggerStay(GameObject other) {
		if (other.GetTag().equals("Enemy")) {
			Destroy();

			GameManager.Instance().StopGame(false);
		}
	}
}
