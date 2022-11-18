package Object;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Framework.GameManager;
import Framework.GameObject;
import Framework.InputManager;
import Framework.ObjectManager;
import Framework.SoundManager;
import Framework.Time;
import Utility.Layer;
import Utility.Vector2;

public class PlayerObject extends GameObject {

	/** 총알 발사 딜레이 */
	private float mOriginBulletDelay = 0.1f;
	private float mCurrentBulletDelay;
	private boolean mShootReady = false;

	/** 좌측 컨트롤 패널을 이용하는가? */
	private boolean mIsLeftCtrl;

	/** 이동속도 */
	private float mSpeed;
	
	/** 보너스 오브젝트 딜레이 */
	private float mBonusSpawnDelay;
	private boolean mIsBonusSpawned = false;

	public PlayerObject(Vector2 pos, String name) {
		super(pos, name, "Player", Layer.OBJECT);

		mSpeed = 500.0f;
	}

	@Override
	public void Start() {
		// TODO Auto-generated method stub

		// runtime
		mCurrentBulletDelay = mOriginBulletDelay;

		AddBoxCollider2D(10, 10, 42, 60);

		AddSpriteImage("./Assets/Player/Player_anim1.png");
		AddSpriteImage("./Assets/Player/Player_anim2.png");
		AddSpriteImage("./Assets/Player/Player_anim3.png");
		AddSpriteImage("./Assets/Player/Player_anim4.png");

		mSprite.SetAnimDelay(0.25f);
		
		mBonusSpawnDelay = (float) (Math.random() * 10);
	}

	@Override
	public void Update() {
		Move();
		ShootBullet();
		
		mBonusSpawnDelay -= Time.DeltaTime();
		if(!mIsBonusSpawned && mBonusSpawnDelay < 0f)
		{
			ObjectManager.Instance().Instantiate(new BonusObject(new Vector2(0, 0)));
			
			mIsBonusSpawned = true;
		}
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
			if (mPosition.y > 0) {
				Translate(0, -mSpeed * Time.DeltaTime());
			}
		}

		if (InputManager.Instance().GetKey((mIsLeftCtrl ? "A" : "LEFT"))) {
			if (mPosition.x > 0) {
				Translate(-mSpeed * Time.DeltaTime(), 0);
			}
		}

		if (InputManager.Instance().GetKey((mIsLeftCtrl ? "S" : "DOWN"))) {
			if (mPosition.y < GameManager.AREA_HEIGHT - 120) {
				Translate(0, mSpeed * Time.DeltaTime());
			}
		}

		if (InputManager.Instance().GetKey((mIsLeftCtrl ? "D" : "RIGHT"))) {
			if (mPosition.x < GameManager.AREA_WIDTH - 62) {
				Translate(mSpeed * Time.DeltaTime(), 0);
			}
		}
	}

	private void ShootBullet() {
		// 총알 딜레이
		mCurrentBulletDelay -= Time.DeltaTime();

		if (mShootReady && mCurrentBulletDelay < 0 && InputManager.Instance().GetKey((mIsLeftCtrl ? "G" : "M"))) {

			ObjectManager.Instance().Instantiate(new BulletObject(new Vector2(mPosition.x + 23, mPosition.y)));
			
			try {
				SoundManager.Instance().PlayClip("./Assets/Sounds/Gunfire.wav");
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			mCurrentBulletDelay = mOriginBulletDelay;

			mShootReady = false;
		}

		if (!InputManager.Instance().GetKey((mIsLeftCtrl ? "G" : "M"))) {
			mShootReady = true;	
		}
	}

	@Override
	public void OnTriggerStay(GameObject other) {
		if (other.GetTag().equals("Enemy")) {
			Destroy();

			GameManager.Instance().DisplayEndingMenu(false);
		}
	}
}
