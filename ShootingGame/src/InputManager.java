import java.awt.event.KeyEvent;


public class InputManager 
{
	//Singleton - pattern
	private static InputManager Instance = null;
	public static InputManager Instance()
	{
		if(Instance == null) 
		{
			Instance = new InputManager();
		}
		
		return Instance;
	}
	
	static boolean[] state = {false, false, false, false, false};

	public void ModifyKey(KeyEvent key, boolean flag)
	{
		switch(key.getKeyCode())
		{
		case KeyEvent.VK_W:
			state[0] = flag;
			break;
			
		case KeyEvent.VK_A:
			state[1] = flag;
			break;

		case KeyEvent.VK_S:
			state[2] = flag;
			break;
			
		case KeyEvent.VK_D:
			state[3] = flag;
			break;
			
		case KeyEvent.VK_SPACE:
			state[4] = flag;
			break;
		}
	}
	
	public boolean GetKey(String name)
	{
		switch(name)
		{
		case "W":
			return state[0];
			
		case "A":
			return state[1];
			
		case "S":
			return state[2];
			
		case "D":
			return state[3];
			
		case "SPACEBAR":
			return state[4];
			
		default:
			System.out.println("Null Key Reference Error");
			return false;
		}
	}
}