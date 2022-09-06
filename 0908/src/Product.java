
public class Product 
{
	private String 	mBarcode;
	private String 	mProductName;
	private int 	mPrice;
	
	public Product(String barcode, String productName, int price)
	{
		this.mBarcode = barcode;
		this.mProductName = productName;
		this.mPrice = price;
	}
	
	public Product(String barcode, int price)
	{
		this(barcode, "No name", price);		
	}
	
	public Product(String barcode, String productName)
	{
		this(barcode, productName, 0);	
	}
		
	public Product(String barcode)
	{
		this(barcode, "No name", 0);	
	}	
	
	public String GetBarcode() { return mBarcode; }
	public String GetProductName() { return mProductName; }
	public int GetPrice() { return mPrice; }
}
