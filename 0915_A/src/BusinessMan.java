public class BusinessMan extends Man 
{
	//회사명, 직책
	private String mCompany, mPosition;
	
	public BusinessMan(String name, String company, String position)
	{
		super(name);
		
		this.mCompany = company;
		this.mPosition = position;
	}
	
	public String GetCompany()
	{
		return mCompany;
	}
	
	public String GetPosition()
	{
		return mPosition;
	}	
}
