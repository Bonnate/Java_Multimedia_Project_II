package Framework;

public class main {
	private ObjectManager mObjectManager;

	public static void main(String[] args) {
		new main();
	}

	public main() {
		
		new GameManager();
		mObjectManager = ObjectManager.Instance();

		// Time 초기화
		Time.InitDeltaTime();
		while (true) {
			// 델타타임 업데이트
			Time.UpdateDeltaTime();

			// 오브젝트 관리(업데이트 및 버퍼에 쓰기)
			mObjectManager.ManageObject();

			// 오브젝트 제거
			mObjectManager.Destroy();
		}
	}
}
