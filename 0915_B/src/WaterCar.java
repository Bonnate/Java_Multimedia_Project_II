public class WaterCar extends ElectricCar
{
	private int mWaterGauge;
	
	public WaterCar(int gasolineGauge, int electricGauge, int waterGauge)
	{
		super(gasolineGauge, electricGauge);
		
		this.mWaterGauge = waterGauge;
	}
	
	public void ShowCurrentGauge()
	{
		super.ShowCurrentGauge();
		
		System.out.println("물 양: " + mWaterGauge);
	}
}
