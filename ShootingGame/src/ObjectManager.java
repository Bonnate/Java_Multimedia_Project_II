import java.util.ArrayList;

//오브젝트 매니저
//런타임 도중 생성된 모든 게임오브젝트를 관리하는 싱글톤패턴의 클래스
public class ObjectManager {
	// Singleton - pattern
	private static ObjectManager Instance = null;

	public static ObjectManager Instance() {
		if (Instance == null) {
			Instance = new ObjectManager();
		}

		return Instance;
	}

	/** 게임 오브젝트를 담는 리스트 */
	private ArrayList<GameObject> mObjects;

	/** 생성자 (1회만 호출됨) */
	private ObjectManager() {
		mObjects = new ArrayList<GameObject>();
	}

	/** GameObject를 매 프레임마다 업데이트한다. */
	public void ManageObject() {
		for (int i = 0; i < mObjects.size(); ++i) {
			mObjects.get(i).Update();
			mObjects.get(i).Draw();
		}
	}

	/** GameObject를 생성 */
	public GameObject Instantiate(GameObject obj) {

		// runtime
		obj.Start();
		mObjects.add(obj);

		return obj;
	}

	/** GameObject를 제거 */
	public void Destroy() {
		for (int i = mObjects.size() - 1; i >= 0; --i) {
			if (mObjects.get(i).IsDestroy()) {
				// IsDestroy == 1인 오브젝트를 찾는다.
				GameObject target = mObjects.get(i);

				// 제거하기 전 OnDestroy를 실행한다.
				target.OnDestroy();

				// 제거하기
				target = null;
				mObjects.remove(i);
			}
		}
	}
}
