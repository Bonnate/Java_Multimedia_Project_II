package Object;

import Framework.GameObject;
import Framework.Time;
import Utility.Layer;
import Utility.Vector2;

public class Explosion extends GameObject{

	private float mLifetime;
	
	public Explosion(Vector2 position) {
		super(position, "ExplosionParticle", "Particle", Layer.PARTICLE);
		
		mLifetime = 0.625f;
		
		// TODO Auto-generated constructor stub
		for(int i = 1; i <=25; ++i)
		{
			AddSpriteImage("./Assets/Particles/BigExplosion/bigExp" + i + ".png");			
		}
		
		mSprite.SetAnimDelay(0.025f);
	}

	@Override
	public void Start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		mLifetime -= Time.DeltaTime();
		if(mLifetime < 0)
		{
			Destroy();
		}
	}

	@Override
	public void OnDestroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OnTriggerStay(GameObject other) {
		// TODO Auto-generated method stub
		
	}

}
