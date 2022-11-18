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

public class BonusObject extends GameObject {

	// 총알 공격 타이머
	private float mShootOriginTimer, mShootCurrentTimer;

	private float mSpeed;

	public BonusObject(Vector2 pos) {
		super(pos, "Enemy2", "None", Layer.OBJECT);
		AddBoxCollider2D(0, 0, 36, 50);

		mShootOriginTimer = 0.5f;
		mSpeed = 100.0f;

		AddSpriteImage("./Assets/Enemy/Enemy_2.png");
	}

	@Override
	public void Start() {
	}

	@Override
	public void Update() {

		// 총알 공격 타이머
		mShootCurrentTimer -= Time.DeltaTime();
		if (mShootCurrentTimer < 0) {
			mShootCurrentTimer = mShootOriginTimer;

			if (Math.random() < 0.8f) {
				ObjectManager.Instance()
						.Instantiate(new TrackingEnemyBulletObject(new Vector2(mPosition.x + 23, mPosition.y + 50)));
			}
		}

		// 이동
		Translate(mSpeed * Time.DeltaTime(), 0);

		// 우측에 도착하는경우 파괴한다
		if (super.mPosition.x > GameManager.AREA_WIDTH - 36) {
			Destroy();
		}
	}

	@Override
	public void OnDestroy() {
	}

	@Override
	public void OnTriggerStay(GameObject other) {

		if (other.GetTag().equals("PlayerBullet")) {
			ObjectManager.Instance().Instantiate(new Explosion(new Vector2(mPosition.x, mPosition.y)));
			GameManager.Instance().ModifyScore(100);

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
}
