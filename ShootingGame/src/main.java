public class main
{
	private GameManager mManager;

	//실행
	public static void main(String[] args) 
	{		
		new main();		
	}
	
	//생성자 (Init)
	public main() 
	{
		mManager = new GameManager();
		
		ObjectManager.Instance().Instantiate(new PlayerObject(28, 20));
		ObjectManager.Instance().Instantiate(new EnemyObject(20, 1));
		ObjectManager.Instance().Instantiate(new EnemyObject(36, 1));
		ObjectManager.Instance().Instantiate(new EnemyObject(28, 3));
		
		while (true) {
			ObjectManager.Instance().ManageObject();
			mManager.drawAll();
			ObjectManager.Instance().Destroy();
			
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
				ObjectManager.Instance().ManageObject();
				mManager.drawAll();
				ObjectManager.Instance().Destroy();
				
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
