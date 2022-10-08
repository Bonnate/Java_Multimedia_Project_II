import java.time.Duration;
import java.time.Instant;

public class Time {
	private Time() {}
	
	private static Duration mFPSmDeltaTime = Duration.ZERO;
	private static Duration mLastTime = Duration.ZERO;
	public static Instant mBeginTime = Instant.now();
	private static double mDeltaTime = mFPSmDeltaTime.toMillis() - mLastTime.toMillis();
	
	public static void InitDeltaTime()
	{
		mBeginTime = Instant.now();
		mFPSmDeltaTime= Duration.ZERO;
	}
	
	public static void UpdateDeltaTime()
	{
		mFPSmDeltaTime = Duration.between(mBeginTime, Instant.now());
		mDeltaTime = (double)mFPSmDeltaTime.toMillis() - mLastTime.toMillis();
		mLastTime = mFPSmDeltaTime;
	}
	
	public static double DeltaTime()
	{
		return mDeltaTime / 1000.0;
	}
}
