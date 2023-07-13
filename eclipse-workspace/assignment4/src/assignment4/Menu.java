package assignment4;
import java.util.Scanner;
public class Menu {
	public static void main(String []args) {
		Scanner in= new Scanner(System.in);
		int choice;
		do {
			System.out.println("Enter your choice: 1.Programmer \n 2.Professor \n 3.AssitantProfessor \n4.AssociateProfessor \n 5.exit");
			choice=in.nextInt();
			in.nextLine();
			switch(choice) {
			case 1:
				Programmer p =new Programmer();
				p.GetData();
				p.displayData();
				break;
			case 2:
				Professor pf =new Professor();
				pf.GetData();
				pf.displayData();
				break;
			case 3:
				AssitantProcessor ap = new AssitantProcessor();
				ap.GetData();
				ap.displayData();
				break;
			case 4:
				AssociateProfessor asp = new AssociateProfessor();
				asp.GetData();
				asp.displayData();
				break;
			case 5:
				System.out.println("Exit");
				break;
			default:
				System.out.println("Invalid choice");
			}
		}while(choice!=5);
	}
}
