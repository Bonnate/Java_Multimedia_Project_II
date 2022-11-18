package Framework;

import Object.EnemyObject;
import Object.PlayerObject;
import Object.RuntimeManager;
import Object.Wall;
import Utility.Vector2;

public class main {
	private GameManager mGameManager;
	private ObjectManager mObjectManager;

	public static void main(String[] args) {
		new main();
	}

	public main() {
		// 매니저 초기
		mGameManager = new GameManager();
		mObjectManager = ObjectManager.Instance();

		// Time 초기화
		Time.InitDeltaTime();

		ResetGame();

		while (true) {
			// 델타타임 업데이트
			Time.UpdateDeltaTime();

			// 오브젝트 관리(업데이트 및 버퍼에 쓰기 )
			mObjectManager.ManageObject();

			// 오브젝트 모두 그리기
//			mGameManager.Render();

			// 오브젝트 제거
			mObjectManager.Destroy();

			if (Time.Scale == 0) {
				if (InputManager.Instance().GetKey("Y")) {
					ResetGame();
				}
				if (InputManager.Instance().GetKey("N")) {
					System.exit(0);
				}
			}
		}
	}

	private void ResetGame() {
		Time.Scale = 1.0;
		
		mGameManager.SetScore(0);

		for (GameObject obj : mObjectManager.GetAllObjects()) {
			obj.Destroy();
		}
		
		mObjectManager.Instantiate(new RuntimeManager());
		
		mObjectManager.Instantiate(new Wall(new Vector2(4, 0), new Vector2(1, 25)));
		mObjectManager.Instantiate(new Wall(new Vector2(60, 0), new Vector2(1, 25)));

		mObjectManager.Instantiate(new PlayerObject(new Vector2(24, 20), "Player1"));
		((PlayerObject) mObjectManager.FindGameObjectFromName("Player1")).ModifyCtrlPanel(true);
//		mObjectManager.Instantiate(new PlayerObject(new Vector2(24, 20), "Player2"));

		mObjectManager.Instantiate(new EnemyObject(new Vector2(14, 1)));
		mObjectManager.Instantiate(new EnemyObject(new Vector2(10, 3)));

		mObjectManager.Instantiate(new EnemyObject(new Vector2(24, 1)));
		mObjectManager.Instantiate(new EnemyObject(new Vector2(24, 3)));

		mObjectManager.Instantiate(new EnemyObject(new Vector2(34, 1)));
		mObjectManager.Instantiate(new EnemyObject(new Vector2(34, 3)));

		mObjectManager.Instantiate(new EnemyObject(new Vector2(44, 1)));
		mObjectManager.Instantiate(new EnemyObject(new Vector2(48, 3)));
	}
}
