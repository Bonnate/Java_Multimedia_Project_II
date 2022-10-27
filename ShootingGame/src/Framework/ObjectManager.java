package Framework;

import java.util.ArrayList;
import java.util.Vector;

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

	private boolean mIsDrawGizmos;

	/** 게임 오브젝트를 담는 리스트 */
	private ArrayList<GameObject> mObjects;

	/** 생성자 (1회만 호출됨) */
	private ObjectManager() {
		mObjects = new ArrayList<GameObject>();

		mIsDrawGizmos = false;
	}

	/** GameObject를 매 프레임마다 업데이트한다. */
	public void ManageObject() {
		for (int i = 0; i < mObjects.size(); ++i) {
			mObjects.get(i).Update();

			if (mIsDrawGizmos) {
				Vector<BoxCollider2D> colliders = mObjects.get(i).GetBoxCollider2D();

				for (BoxCollider2D collider : colliders) {
					collider.DrawGizmo();
				}
			} else {
				mObjects.get(i).Draw();
			}
		}

		CheckCollision();
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

	public GameObject[] GetAllObjects() {
		GameObject[] array = new GameObject[mObjects.size()];

		int size = 0;

		for (GameObject obj : mObjects) {
			array[size++] = obj;
		}

		return array;
	}

	public GameObject FindGameObjectFromName(String name) {
		for (GameObject obj : mObjects) {
			if (obj.mName.equals(name)) {
				if (!obj.mIsDestroy) {
					return obj;
				}
			}
		}

		return null;
	}

	public void CheckCollision() {
		for (int i = 0; i < mObjects.size(); ++i) {
			for (int j = 0; j < mObjects.size(); ++j) {
				if (i < j) {
					CheckObjectCollision(mObjects.get(i), mObjects.get(j));
				}
			}
		}
	}

	private void CheckObjectCollision(GameObject objI, GameObject objJ) {
		if (!objI.IsDestroy() && !objJ.IsDestroy()) {
			Vector<BoxCollider2D> boxI = objI.GetBoxCollider2D();
			Vector<BoxCollider2D> boxJ = objJ.GetBoxCollider2D();

			for (int ii = 0; ii < boxI.size(); ii++) {
				for (int jj = 0; jj < boxJ.size(); jj++) {
					// 박스좌표 구하기
					float[] x0I = { 0 }, y0I = { 0 }, x1I = { 0 }, y1I = { 0 }; // boxI 충돌체의 사각형 꼭지점 좌표
					float[] x0J = { 0 }, y0J = { 0 }, x1J = { 0 }, y1J = { 0 }; // boxJ 충돌체의 사각형 꼭지점 좌표

					boxI.get(ii).GetVertexBox(x0I, y0I, x1I, y1I);
					boxJ.get(jj).GetVertexBox(x0J, y0J, x1J, y1J);

					// System.out.println("I: " + x0I[0] + ", " + y0I[0] + ", " + x1I[0] + ", " +
					// y1I[0]);
					// System.out.println("J: " + x0J[0] + ", " + y0J[0] + ", " + x1J[0] + ", " +
					// y1J[0]);

					if (!(x1J[0] < x0I[0] || x1I[0] < x0J[0] || y1I[0] < y0J[0] || y1J[0] < y0I[0])) // if (x1J >= x0I
																										// && x1I >= x0J
																										// && y1I >= y0J
																										// && y1J >=
																										// y0I)
					{
						// 충돌 이벤트 콜백//
						objI.OnTriggerStay(objJ); // objI에게 objJ하고 충돌중임을 알림
						objJ.OnTriggerStay(objI); // objJ에게 objI하고 충돌줌임을 알림

						// 충돌 발생 시 같은 오브젝트에서는 더 이상 체크를 하지 않
						return;
					}
				}
			}
		}
	}

	public void ConversionGizmoState() {
		mIsDrawGizmos = !mIsDrawGizmos;
	}
}