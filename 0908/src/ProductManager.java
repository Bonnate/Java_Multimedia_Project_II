import java.util.ArrayList;

public class ProductManager 
{
	private ArrayList<Product> mProducts;
	
	public ProductManager()
	{
		mProducts = new ArrayList<Product>();
		
		this.Start();
	}
	
	private void Start()
	{
		System.out.println("## 상품 정보 입력 ##");
		
		//상품 데이터 입력(3회)
		for(int i = 0; i < 3; ++i) { InputProduct(); }
		SearchProduct();
		
		System.out.print("프로그램을 종료합니다.");
	}
	
	private void InputProduct()
	{
		String barcode, name, price;
		
		System.out.print("바코드: ");
		barcode = Main.Scanner.nextLine();
		
		System.out.print("상품명: ");
		name = Main.Scanner.nextLine();
		
		System.out.print("가격: ");
		price = Main.Scanner.nextLine();
		
		if(name.equals("") && price.equals(""))
		{
			mProducts.add(new Product(barcode));
		}
		else if(name.equals(""))
		{
			mProducts.add(new Product(barcode, Integer.parseInt(price)));
		}
		else if(price.equals(""))
		{
			mProducts.add(new Product(barcode, name));
		}
		else
		{
			mProducts.add(new Product(barcode, name, Integer.parseInt(price)));
		}
		
		System.out.println(mProducts.get(mProducts.size() - 1).GetProductName() + " 추가되었습니다. \n");
	}
	
	private void SearchProduct()
	{
		String input;
		
		System.out.println("## 상품 검색 ##");
		while(true)
		{
			System.out.print("바코드: ");
			
			input = Main.Scanner.nextLine();
			if(input.equals("Q")) { break; }
			
			for(int i = 0; i < mProducts.size(); ++i)
			{
				if(mProducts.get(i).GetBarcode().equals(input))
				{
					System.out.println(mProducts.get(i).GetProductName() + ", " + mProducts.get(i).GetPrice() + "원\n");
				}
			}
			
		}
	}
}