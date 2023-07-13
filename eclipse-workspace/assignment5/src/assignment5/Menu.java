package assignment5;
import java.util.Scanner;
public class Menu {
	public static void main(String []args) {
		int choice,ch;
		Scanner in = new Scanner(System.in);
		Shape s;
		rect r= new rect();
		tri t = new tri();
		do {
			System.out.println("1.Rectangle \n 2.triangle \n 3.exit");
			choice=in.nextInt();
			switch(choice) {
			case 1:
				s=r;
				s.area();
				break;
			case 2:
				s=t;
				s.area();
				break;
			default:
				System.out.println("invalid");
			}
			System.out.println("continue press 1 else for exit 0");
			ch=in.nextInt();
		}while(choice==1);
	}
}
