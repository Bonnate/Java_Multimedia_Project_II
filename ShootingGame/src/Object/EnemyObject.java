package Object;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Framework.GameManager;
import Framework.GameObject;
import Framework.ObjectManager;
import Framework.SoundManager;
import Framework.Time;
import Utility.Layer;
import Utility.Vector2;

public class EnemyObject extends GameObject {
	
	public static int EnemyCount = 0;

	// 이동속도 (점점 증가하도록)
	private float mSpeed;

	// 총알 공격 타이머
	private float mShootOriginTimer, mShootCurrentTimer;

	// 방향 전환 타이머
	private float mDirectionOriginTimer, mDirectionCurrentTimer;
	private boolean mIsLeftDirection;

	public EnemyObject(Vector2 pos) {
		super(pos, "Enemy1", "Enemy", Layer.OBJECT);
		AddBoxCollider2D(0, 0, 40, 60);
		
		mSpeed = 30.0f;
		mDirectionOriginTimer = 1.0f;
		mShootOriginTimer = 2.0f;
		
		mIsLeftDirection = Math.random() > 0.5f ? true : false;
		
		AddSpriteImage("./Assets/Enemy/Enemy_1.png");
	}

	@Override
	public void Start() {
		++EnemyCount;
	}

	@Override
	public void Update() {
		
		// 총알 공격 타이머
		mShootCurrentTimer -= Time.DeltaTime();
		if (mShootCurrentTimer < 0) {
			mShootCurrentTimer = mShootOriginTimer;
			
			if (Math.random() < 0.8f) {
				ObjectManager.Instance().Instantiate(new EnemyBulletObject(new Vector2(mPosition.x + 23, mPosition.y + 50)));
			}
		}
		
		if(mPosition.y < 50)
		{
			Translate(0, mSpeed * Time.DeltaTime());
			return;
		}

		// 방향 전환 타이머
		mShootCurrentTimer -= Time.DeltaTime();
		if (mDirectionCurrentTimer < 0) {
			mDirectionCurrentTimer = mDirectionOriginTimer;

			// 1초마다 30% 확률로 방향을 전환한다.
			if (Math.random() < 0.3f) {
				mIsLeftDirection = !mIsLeftDirection;
			}
		}

		// 가속도 추가 (조건: 점점 빠르게 내려온다)
		mSpeed += Time.DeltaTime() * 2;

		// 이동
		Translate(mSpeed * Time.DeltaTime() * (mIsLeftDirection ? -1 : +1), mSpeed * Time.DeltaTime());

		// 맨 아래에 도착하는경우 파괴한다
		if (super.mPosition.y > GameManager.SCREEN_HEIGHT - 1) {
			GameManager.Instance().DisplayEndingMenu(false);
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
		
		if(other.GetTag().equals("PlayerBullet"))
		{
			ObjectManager.Instance().Instantiate(new Explosion(new Vector2(mPosition.x, mPosition.y)));
			--EnemyCount;
			GameManager.Instance().ModifyScore(10);
			
			try {
				SoundManager.Instance().PlayClip("./Assets/Sounds/Explosion.wav");
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			other.Destroy();
			Destroy();
		}
	}

	/** 겹침을 방지하기 위해 방향을 돌린다 */
	private void ChangeDirection() {
		mDirectionCurrentTimer = mDirectionOriginTimer;
		mIsLeftDirection = !mIsLeftDirection;
	}
}
