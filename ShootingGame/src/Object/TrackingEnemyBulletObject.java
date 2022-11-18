package Object;
import Framework.GameManager;
import Framework.GameObject;
import Framework.ObjectManager;
import Framework.Time;
import Utility.Layer;
import Utility.Vector2;

public class TrackingEnemyBulletObject extends GameObject 
{
	private float mSpeed;
	private Vector2 mDirection;
	
	public TrackingEnemyBulletObject(Vector2 pos)
	{
		super(pos, "TrackingEnemyBullet", "EnemyBullet", Layer.BULLET);
		
		mSpeed = 200.0f;
		
		super.AddBoxCollider2D(0, 0, 17, 17);
		
		AddSpriteImage("./Assets/Enemy/Bullet2.png");
	}

	@Override
	public void Start() {
		
		Vector2 playerPos = ObjectManager.Instance().FindGameObjectFromName("Player1").GetPosition();
		float xMag = mPosition.x - playerPos.x;
		float yMag = mPosition.y - playerPos.y;
		
		mDirection = Vector2.Normalize(new Vector2(xMag, yMag));
	}

	@Override
	public void Update() {
		
		super.Translate(-mDirection.x * mSpeed * Time.DeltaTime(), -mDirection.y * mSpeed * Time.DeltaTime());
		
		if(mPosition.y > GameManager.AREA_HEIGHT)
		{
			Destroy();
		}
		
		// 우측에 도착하는경우 파괴한다
		if (super.mPosition.x > GameManager.AREA_WIDTH - 17) {
			Destroy();
		}
	}

	@Override
	public void OnDestroy() {
		
	}

	@Override
	public void OnTriggerStay(GameObject other) {
		if(other.GetTag().equals("Player"))
		{
			GameManager.Instance().DisplayEndingMenu(false);
			
			other.Destroy();
			Destroy();
		}
	}
}
