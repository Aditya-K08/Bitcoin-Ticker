package assignment3;

public class Book extends Publication{
	
	protected String author;
	
	
	
	public Book()
	{
		this.pd_order=0;
		this.sell=0;
	}
	public void  order_Copies()
	{
		System.out.println("order copies ");
	}
}
