import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class InputManager implements KeyListener
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
	
	private InputManager()
	{
		GameManager.Instance().AttachKeyListener(this);
	}
	
	static boolean[] state = {false, false, false, false, false, false ,false, false, false, false};

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
			
		case KeyEvent.VK_G:
			state[4] = flag;
			break;
		case KeyEvent.VK_UP:
			state[5] = flag;
			break;
			
		case KeyEvent.VK_LEFT:
			state[6] = flag;
			break;

		case KeyEvent.VK_DOWN:
			state[7] = flag;
			break;
			
		case KeyEvent.VK_RIGHT:
			state[8] = flag;
			break;
			
		case KeyEvent.VK_M:
			state[9] = flag;
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
			
		case "G":
			return state[4];
			
		case "UP":
			return state[5];
			
		case "LEFT":
			return state[6];
			
		case "DOWN":
			return state[7];
			
		case "RIGHT":
			return state[8];
			
		case "M":
			return state[9];
			
		default:
			System.out.println("Null Key Reference Error");
			return false;
		}
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		//None
	}


    @Override
    public void keyPressed(KeyEvent e) {
    	InputManager.Instance().ModifyKey(e, true);
    }

	@Override
	public void keyReleased(KeyEvent e) {
		InputManager.Instance().ModifyKey(e, false);

	}
}