package assignment3;

import java.util.*;
public class Publication {	
	
	protected String title;
	double price;
	int copies;
	protected int sell;
	private int b,m;
	protected int pd_order;
	private int alert_lmt;
	
	Book[] bk=new Book[10];
	magazine[] mz=new magazine[10];
	 
	
	public Publication()
	{
		alert_lmt=4;
		b=0;
		m=0;
	}
	public void sell_copy()
	{
		System.out.println("Enter");	
	}
	
	
	
	public void publish_book()
	{
		Scanner sc=new Scanner(System.in);
		bk[b]=new Book();
		System.out.println("Enter the Title name :- ");
		bk[b].title=sc.nextLine();
		System.out.println("Enter the Author Name :- ");
		bk[b].author=sc.nextLine();
		
		System.out.print("Enter number of copies to Publish :- ");
		bk[b].copies=sc.nextInt();
		
		System.out.println("Enter the Price :- ");
		bk[b].price=sc.nextDouble();
		
		b++;
	}
	
	public void publish_magazine()
	{
		Scanner sc=new Scanner(System.in);
		mz[m]=new magazine();
		System.out.println("Enter the Title name :- ");
		mz[m].title=sc.nextLine();
	
		System.out.print("Enter number of copies to Publish :- ");
		mz[m].copies=sc.nextInt();
		
		System.out.println("Enter the Price :- ");
		mz[m].price=sc.nextDouble();
		
		m++;
	}

	
	public void list() {
		// TODO Auto-generated method stub
		System.out.println("*************************** Books *******************************\n");
		System.out.println("\tName\t\tAuthor\t\tprice\t\tAval. copies\t\tSells\n");
		for(int i=0;i<b;i++)
		{
			System.out.println("\t"+bk[i].title+"\t\t"+bk[i].author+"\t"+bk[i].price+"\t\t"+bk[i].copies+"\t\t\t"+bk[i].sell);
		}
		
		System.out.println("\n\n*************************** Magazine *******************************\n");
		System.out.println("\tName\t\tprice\t\tAval. copies\t\tSells\n");
		for(int i=0;i<m;i++)
		{
			System.out.println("\t"+mz[i].title+"\t\t"+mz[i].price+"\t\t"+mz[i].copies+"\t\t\t"+mz[i].sell);
		}
		
	}

	
	public void order_book() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Title of Book :- ");
		String g=sc.nextLine();
		
		for(int i=0;i<b;i++)
		{
			if(g.equals(bk[i].title))
			{
				if(bk[i].copies<=0)
				{
					System.out.println("Book Out of Stock Now ! ");
					bk[i].pd_order++;
					
				}
				else
				{
				System.out.println("order placed !");
				bk[i].copies--;
				bk[i].sell++;
				}
				
				return ;
			}
		}
		System.out.print(" No Book Found !");

	}



	public void order_magzine() {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Title of Magzine :- ");
		String g=sc.nextLine();
		
		for(int i=0;i<m;i++)
		{
			if(g.equals(mz[i].title))
			{
				if(mz[i].copies<=0)
				{
					System.out.println("Magzine Out of Stock Now ! ");
					mz[i].pd_order++;
					
				}
				else
				{
				System.out.println("order placed !");
				mz[i].copies--;
				mz[i].sell++;
				}
				
				return ;
			}
		}
		
		System.out.println("NO Magzine Found !");
		
	}



	public void cheak_pend() {
		
		// TODO Auto-generated method stub
		
		boolean t=false;
		for(int i=0;i<b;i++)
		{
			if(bk[i].pd_order>alert_lmt)
			{
				System.out.print("\t\t\t\t"+bk[i].title+"   "+bk[i].pd_order);
				t=true;
			}
		}
		
		for(int i=0;i<m;i++)
		{
			if(mz[i].pd_order>this.alert_lmt)
			{
				System.out.print("\t\t\t\t"+mz[i].title+"   "+mz[i].pd_order);
				t=true;
				
			}
		}
		if(t)
		{
			System.out.println("\n.........................!!! Pending Alert for Above !!!............................\n");
		}
		
	}
}