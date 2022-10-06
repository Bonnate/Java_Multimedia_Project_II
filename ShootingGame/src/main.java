public class main
{
	private GameManager mManager;
	private ObjectManager mInstanceManager;

	//실행
	public static void main(String[] args) 
	{		
		new main();		
	}
	
	//생성자 (Init)
	public main() 
	{
		mManager = new GameManager();
		mInstanceManager = ObjectManager.Instance();
		
		PlayerObject p1 = (PlayerObject) mInstanceManager.Instantiate(new PlayerObject(24, 20));
		p1.SetPlayerID(0);
		
		PlayerObject p2 = (PlayerObject) mInstanceManager.Instantiate(new PlayerObject(32, 20));
		p2.SetPlayerID(1);
		
		mInstanceManager.Instantiate(new EnemyObject(20, 1));
		mInstanceManager.Instantiate(new EnemyObject(36, 1));
		mInstanceManager.Instantiate(new EnemyObject(28, 3));
		
		while (true) {
			mInstanceManager.ManageObject();
			mManager.drawAll();
			mInstanceManager.Destroy();
			
			try {
				Thread.sleep(32);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
//		new Thread(new GameThread()).start();
	}

	//쓰레드 (Run)
	class GameThread implements Runnable {
		@Override
		public void run() {
			// game loop
			while (true) {
				mInstanceManager.ManageObject();
				mManager.drawAll();
				mInstanceManager.Destroy();
				
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//재시작
	public void restart() 
	{
	     mManager.initData();
	     new Thread(new GameThread()).start();
	}
}
