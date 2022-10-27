package Framework;
import java.time.Duration;
import java.time.Instant;

public class Time {

	private static Duration mFPSmDeltaTime = Duration.ZERO;
	private static Duration mLastTime = Duration.ZERO;
	public static Instant mBeginTime = Instant.now();
	public static double Scale = 1.0;
	private static double mDeltaTime = mFPSmDeltaTime.toMillis() - mLastTime.toMillis();

	/** 델타 타임 시스템 초기화 */
	public static void InitDeltaTime() {
		mBeginTime = Instant.now();
		mFPSmDeltaTime = Duration.ZERO;
	}

	/** 현 프레임기준 델타타임을 갱신 */
	public static void UpdateDeltaTime() {
		mFPSmDeltaTime = Duration.between(mBeginTime, Instant.now());
		mDeltaTime = (double) mFPSmDeltaTime.toMillis() - mLastTime.toMillis();
		mLastTime = mFPSmDeltaTime;
	}

	/** 델타 타임 값 리턴 */
	public static double DeltaTime() {
		return mDeltaTime / 1000.0 * Scale;
	}
}
