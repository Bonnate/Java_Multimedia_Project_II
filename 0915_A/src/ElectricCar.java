public class ElectricCar extends GasolineCar 
{
	private int mElectricGauge;
	
	public ElectricCar(int gasolineGauge, int electricGauge)
	{
		super(gasolineGauge);
		
		this.mElectricGauge = electricGauge;
	}
	
	public void ShowCurrentGauge()
	{
		super.ShowCurrentGauge();
		
		System.out.println("전기 양: " + mElectricGauge);	
	}
}
