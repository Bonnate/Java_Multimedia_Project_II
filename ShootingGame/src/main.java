public class main {
	private GameManager mManager;
	private ObjectManager mInstanceManager;

	public static void main(String[] args) {
		new main();
	}

	public main() {
		//매니저 초기
		mManager = new GameManager();
		mInstanceManager = ObjectManager.Instance();

		//Time 초기화
		Time.InitDeltaTime();
		
		PlayerObject p1 = (PlayerObject) mInstanceManager.Instantiate(new PlayerObject(24, 20));
		p1.ModifyCtrlPanel(true);

		PlayerObject p2 = (PlayerObject) mInstanceManager.Instantiate(new PlayerObject(32, 20));
		p2.ModifyCtrlPanel(false);

		mInstanceManager.Instantiate(new EnemyObject(20, 1));
		mInstanceManager.Instantiate(new EnemyObject(36, 1));
		mInstanceManager.Instantiate(new EnemyObject(28, 3));

		while (true) {
			//델타타임 업데이트
			Time.UpdateDeltaTime();
			
			//오브젝트 관리(업데이트 및 버퍼에 쓰)
			mInstanceManager.ManageObject();
			
			//오브젝트 모두 그리기
			mManager.DrawAll();
			
			//오브젝트 제거
			mInstanceManager.Destroy();
		}
	}

}
