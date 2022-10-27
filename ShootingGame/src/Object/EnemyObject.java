package Object;

import Framework.GameManager;
import Framework.GameObject;
import Framework.ObjectManager;
import Framework.Time;
import Utility.Vector2;

public class EnemyObject extends GameObject {

	private float mSpeed;

	// 총알 공 타이머
	private float mShootOriginTimer, mShootCurrentTimer;

	// 방향 전환 타이머
	private float mDirectionOriginTimer, mDirectionCurrentTimer;
	private boolean mIsLeftDirection;

	private RuntimeManager mRuntimeManager;

	public EnemyObject(Vector2 pos) {
		super(pos, "[XUX]", "Enemy1", "Enemy");
	}

	@Override
	public void Start() {
		AddBoxCollider2D(0, 0, 5, 1);

		mSpeed = 1.0f;
		mDirectionOriginTimer = 1.0f;
		mShootOriginTimer = 2.0f;

		mIsLeftDirection = Math.random() > 0.5f ? true : false;

		mRuntimeManager = ((RuntimeManager) ObjectManager.Instance().FindGameObjectFromName("RuntimeManager"));
	}

	@Override
	public void Update() {

		// 총알 공격 타이머
		mShootCurrentTimer -= Time.DeltaTime();
		if (mDirectionCurrentTimer < 0) {
			mDirectionCurrentTimer = mDirectionOriginTimer;

			// 1초마다 30% 확률로 방향을 전환한다.
			if (Math.random() < 0.3f) {
				mIsLeftDirection = !mIsLeftDirection;
			}
		}

		// 방향 전환 타이머
		mDirectionCurrentTimer -= Time.DeltaTime();
		if (mShootCurrentTimer < 0) {
			mShootCurrentTimer = mShootOriginTimer;

			if (Math.random() < 0.8f) {
				ObjectManager.Instance().Instantiate(new EnemyBulletObject(new Vector2(mPosition.x + 2, mPosition.y)));
			}
		}

		// 가속도 추가 (조건: 점점 빠르게 내려온다)
		mSpeed += Time.DeltaTime() * 0.1;

		// 이동
		Translate(mSpeed * Time.DeltaTime() * (mIsLeftDirection ? -1 : +1), mSpeed * Time.DeltaTime());

		// 맨 아래에 도착하는경우 파괴한다
		if (super.mPosition.y > GameManager.SCREEN_HEIGHT - 1) {
			GameManager.Instance().StopGame(false);
			Destroy();
		}
	}

	@Override
	public void OnDestroy() {
	}

	@Override
	public void OnTriggerStay(GameObject other) {
		// 겹침 방지
		if (other.GetTag().equals("Enemy")) {
			((EnemyObject) other).ChangeDirection();
		}

		if (other.GetTag().equals("Wall")) {
			ChangeDirection();
		}
	}

	/** 겹침을 방지하기 위해 방향을 돌린다 */
	private void ChangeDirection() {
		mDirectionCurrentTimer = mDirectionOriginTimer;
		mIsLeftDirection = !mIsLeftDirection;
	}
}
