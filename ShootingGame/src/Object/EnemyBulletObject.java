package Object;
import Framework.GameManager;
import Framework.GameObject;
import Framework.Time;
import Utility.Layer;
import Utility.Vector2;

public class EnemyBulletObject extends GameObject 
{
	private float mSpeed;
	
	public EnemyBulletObject(Vector2 pos)
	{
		super(pos, "EnemyBullet", "EnemyBullet", Layer.BULLET);
		
		mSpeed = 200.0f;
		
		super.AddBoxCollider2D(0, 0, 17, 17);
		
		AddSpriteImage("./Assets/Enemy/Bullet2.png");
	}

	@Override
	public void Start() {
				
	}

	@Override
	public void Update() {
		
		super.Translate(0, mSpeed * Time.DeltaTime());
		
		if(mPosition.y > GameManager.AREA_HEIGHT)
		{
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
