package Object;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import Framework.GameManager;
import Framework.GameObject;
import Framework.ObjectManager;
import Framework.Time;
import Utility.Layer;
import Utility.Vector2;

public class BulletObject extends GameObject {
	private float mSpeed;

	public BulletObject(Vector2 pos) {
		super(pos, "PlayerBullet", "PlayerBullet", Layer.BULLET);

		mSpeed = 500.0f;

		super.AddBoxCollider2D(0, 0, 1, 1);

		AddSpriteImage("./Assets/Player/Bullet1.png");
	}

	@Override
	public void Start() {
		

		
	}

	@Override
	public void Update() {

		super.Translate(0, -mSpeed * Time.DeltaTime());

		// 높이가 0이면.. Destory
		if (mPosition.y < 0f) {
			Destroy();
		}
	}

	@Override
	public void OnDestroy() {
	}

	@Override
	public void OnTriggerStay(GameObject other) {
	}
}
