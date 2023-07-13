package assignment3;

import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("*********** Assignment 4 ****************");
		int n=1;
		
		Publication pb=new Publication();
		while(n!=0)
		{
			System.out.println("\nEnter 1.publish Book  2.publish Magazine  3.order book  4.issue magazine  5.Display list 6.order magzine\n");
			int ch=sc.nextInt();
			
			switch(ch)
			{
				case 1:
					pb.publish_book();
					break;
				
				case 2:
					pb.publish_magazine();
					break;
					
				
				case 3:
					pb.order_book();
					pb.cheak_pend();
					break;
					
				case 4:
					pb.order_magzine();
					pb.cheak_pend();

					break;
					
				case 5:
					pb.list();
					pb.cheak_pend();
					break;
					
				
				default :
					n=0;
					break;
				
			}
		}
		
	}

}
