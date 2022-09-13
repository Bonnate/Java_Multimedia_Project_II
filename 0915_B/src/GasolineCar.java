public class GasolineCar 
{
	private int mGasolineGauge;
	
	public GasolineCar(int gasolineGauge)
	{
		this.mGasolineGauge = gasolineGauge;
	}
	
	public void ShowCurrentGauge()
	{
		System.out.println("가솔린 양: " + mGasolineGauge);
	}
}
