package Object;
import Framework.GameManager;
import Framework.GameObject;
import Framework.Time;
import Utility.Vector2;

public class BulletObject extends GameObject 
{
	private float mSpeed;
	
	public BulletObject(Vector2 pos)
	{
		super(pos, "↑", "PlayerBullet", "PlayerBullet");
		
		mSpeed = 45.0f;
		
		super.AddBoxCollider2D(0, 0, 1, 1);
	}

	@Override
	public void Start() {
				
	}

	@Override
	public void Update() {
		
		super.Translate(0, -mSpeed * Time.DeltaTime());
		
		//높이가 0이면.. Destory
		if(mPosition.y < .5f)
		{
			Destroy();
		}
	}

	@Override
	public void OnDestroy() {
		
	}

	@Override
	public void OnTriggerStay(GameObject other) {
		if(other.GetTag().equals("Enemy"))
		{
			GameManager.Instance().ModifyScore(10);
			
			other.Destroy();
			Destroy();
		}
	}
}
