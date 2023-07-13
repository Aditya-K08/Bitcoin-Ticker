package assignment1;
import java.util.Scanner;
public class Menu {
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		System.out.println("Enter your first Complex Number : ");
		double real1= in.nextDouble();	
		double imaginary1=in.nextDouble();
		Complex c1= new Complex(real1,imaginary1);
		System.out.println("Enter your second COmplex Number : ");
		double real2= in.nextDouble();	
		double imaginary2=in.nextDouble();
		Complex c2= new Complex(real2,imaginary2);
		int choice=0;
		Complex result;
		while(choice!=5) {
			System.out.println("Select an operation :");
			System.out.println("1. Addition ");
			System.out.println("2. Substracton ");
			System.out.println("3. Multiplication");
			System.out.println("4. Division");
			System.out.println("5. Exit");
			choice =in.nextInt();
			switch(choice) {
			case 1:
				result=c1.add(c2);
				System.out.println("Addition: " + result);
				break;
			case 2:
				result=c1.sub(c2);
				System.out.println("Addition: " + result);
				break;
			case 3:
				result=c1.mul(c2);
				System.out.println("Addition: " + result);
				break;
			case 4:
				result=c1.div(c2);
				System.out.println("Addition: " + result);
				break;
			case 5:
				break;
			default: 
				System.out.println("Invalid Choice");
			}
			
		}
		in.close();
	}
}
