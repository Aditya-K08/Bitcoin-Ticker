package assignment7;
import java.util.*;
public class Main {
	public static void main(String args[]) {
		int size;
		System.out.println("Please Enter The Stack Size: ");
		Scanner in = new Scanner(System.in);
		size=in.nextInt();
		Stack stack= new Stack(size);
		int Choice;
		int eLe;
		do {
			System.out.println("Please Choose 1.PUSH   2.POP   3.Exit");
			Choice=in.nextInt();
			if(Choice==1) {
				System.out.println("Enter the Element: ");
				eLe=in.nextInt();
				stack.push(eLe);
			}
			else if(Choice == 2) {
				stack.pop();
			}
			else {
				Choice =3;
			}
		}while(Choice!=3);
	}
}
