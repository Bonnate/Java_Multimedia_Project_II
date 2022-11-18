package Object;

import Framework.GameObject;
import Utility.Vector2;

public class Wall extends GameObject{

	public Wall(Vector2 position, Vector2 length) {
		super(position, "Wall", "Wall");
		
		AddBoxCollider2D(0, 0, length.x, length.y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
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
