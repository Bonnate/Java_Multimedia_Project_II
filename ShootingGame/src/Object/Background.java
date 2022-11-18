package Object;

import Framework.GameManager;
import Framework.GameObject;
import Framework.Time;
import Utility.Layer;
import Utility.Vector2;

public class Background extends GameObject{
	
	private float mSpeed;

	public Background(Vector2 position) {
		super(position, "Background", "Background", Layer.BACKGROUND);
		
		mSpeed = 100.0f;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Start() {
		// TODO Auto-generated method stub
		AddSpriteImage("./Assets/Backgrounds/background.jpg");
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
		Translate(0, mSpeed * Time.DeltaTime());
	
		if(mPosition.y > GameManager.SCREEN_HEIGHT)
		{
			SetPosition(0, -GameManager.SCREEN_HEIGHT);
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
