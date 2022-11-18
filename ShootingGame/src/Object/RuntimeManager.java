package Object;
import Framework.GameObject;
import Framework.InputManager;
import Framework.ObjectManager;
import Framework.Time;
import Utility.Vector2;

public class RuntimeManager extends GameObject{

	private float mOriginDelay;
	private float mCurrentDelay;
	
	public RuntimeManager() {
		super(new Vector2(0, 0),  "RuntimeManager", "Manager");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Start() {
		
		mOriginDelay = 0.5f;
		
	}

	@Override
	public void Update() {
		mCurrentDelay -= Time.DeltaTime();
		
		if(mCurrentDelay < 0 && InputManager.Instance().GetKey("P"))
		{
			ObjectManager.Instance().ConversionGizmoState();
			
			mCurrentDelay = mOriginDelay;
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
