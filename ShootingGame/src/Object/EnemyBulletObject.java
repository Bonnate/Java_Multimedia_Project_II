package Object;
import Framework.GameManager;
import Framework.GameObject;
import Framework.Time;
import Utility.Vector2;

public class EnemyBulletObject extends GameObject 
{
	private float mSpeed;
	
	public EnemyBulletObject(Vector2 pos)
	{
		super(pos, "EnemyBullet", "EnemyBullet");
		
		mSpeed = 10.0f;
		
		super.AddBoxCollider2D(0, 0, 1, 1);
	}

	@Override
	public void Start() {
				
	}

	@Override
	public void Update() {
		
		super.Translate(0, mSpeed * Time.DeltaTime());
		
		//높이가 0이면.. Destory
		if(mPosition.y >= GameManager.SCREEN_HEIGHT - 1)
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
			GameManager.Instance().StopGame(false);
			
			other.Destroy();
			Destroy();
		}
	}
}
