import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManager implements KeyListener {
	// Singleton - pattern
	private static InputManager Instance = null;

	public static InputManager Instance() {
		if (Instance == null) {
			Instance = new InputManager();
		}

		return Instance;
	}

	/** 생성되는 시점에 게임 매니저의 JFrame에 키 리스너를 등록시킨다 */
	private InputManager() {
		GameManager.Instance().AttachKeyListener(this);
	}

	/** 예약되어 있는 키들이 눌린 상태인지에 대한 불리언 변수들 */
	private boolean[] mIsPressed = { false, false, false, false, false, false, false, false, false, false };

	/** 키가 입력되면 flag 값대로 해당 키의 상태를 갱신시키는 함수 */
	public void ModifyKey(KeyEvent key, boolean flag) {
		switch (key.getKeyCode()) {
		case KeyEvent.VK_W:
			mIsPressed[0] = flag;
			break;

		case KeyEvent.VK_A:
			mIsPressed[1] = flag;
			break;

		case KeyEvent.VK_S:
			mIsPressed[2] = flag;
			break;

		case KeyEvent.VK_D:
			mIsPressed[3] = flag;
			break;

		case KeyEvent.VK_G:
			mIsPressed[4] = flag;
			break;
		case KeyEvent.VK_UP:
			mIsPressed[5] = flag;
			break;

		case KeyEvent.VK_LEFT:
			mIsPressed[6] = flag;
			break;

		case KeyEvent.VK_DOWN:
			mIsPressed[7] = flag;
			break;

		case KeyEvent.VK_RIGHT:
			mIsPressed[8] = flag;
			break;

		case KeyEvent.VK_M:
			mIsPressed[9] = flag;
			break;
		}
	}

	/** 키 이름을 통해 해당 키의 상태를 리턴 */
	public boolean GetKey(String name) {
		switch (name) {
		case "W":
			return mIsPressed[0];

		case "A":
			return mIsPressed[1];

		case "S":
			return mIsPressed[2];

		case "D":
			return mIsPressed[3];

		case "G":
			return mIsPressed[4];

		case "UP":
			return mIsPressed[5];

		case "LEFT":
			return mIsPressed[6];

		case "DOWN":
			return mIsPressed[7];

		case "RIGHT":
			return mIsPressed[8];

		case "M":
			return mIsPressed[9];

		default:
			System.out.println("Null Key Reference Error");
			return false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// None
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