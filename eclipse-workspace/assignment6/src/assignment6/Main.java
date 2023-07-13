package assignment6;
import java.util.Scanner;
public class Main {
	public static void main(String []args) {
		int x=1;
		Scanner in =new Scanner(System.in);
		while(x!=0) {
			int choice;
			System.out.println("Choose your vehicle : \n 1. Bike \n 2. Car \n 3. Bicycle \n 4.Exit");
			choice=in.nextInt();
			switch (choice) {
				case 1: 
					Vehicle Bike = new Bike();
					int gear,speed;
					System.out.println("Choose Operation : \n 1. Gear \n 2. Speed \n 3. ApplyBrake");
					int choose;
					choose=in.nextInt();
					if(choose==1) {
						System.out.println("Enter the Current Gear");
						gear=in.nextInt();
						Bike.GearChange(gear);
					}
					if(choose==2) {
						System.out.println("Enter the Speed");
						speed=in.nextInt();
						Bike.SpeedUp(speed);
					}
					if(choose==3) {
						Bike.ApplyBrakes();
					}
					break;
				case 2:	
					Vehicle Car = new Car();
					System.out.println("Choose Operation : \n 1. Gear \n 2. Speed \n 3. ApplyBrake");
					choose=in.nextInt();
					if(choose==1) {
						System.out.println("Enter the Current Gear");
						gear=in.nextInt();
						Car.GearChange(gear);
					}
					if(choose==2) {
						System.out.println("Enter the Speed");
						speed=in.nextInt();
						Car.SpeedUp(speed);
					}
					if(choose==3) {
						Car.ApplyBrakes();
					}
					break;
				case 3:
					Vehicle Bicycle = new Bicycle();
					System.out.println("Choose Operation : \n 1. Gear \n 2. Speed \n 3. ApplyBrake");
					choose=in.nextInt();
					if(choose==1) {
						System.out.println("Enter the Current Gear");
						gear=in.nextInt();
						Bicycle.GearChange(gear);
					}
					if(choose==2) {
						System.out.println("Enter the Speed");
						speed=in.nextInt();
						Bicycle.SpeedUp(speed);
					}
					if(choose==3) {
						Bicycle.ApplyBrakes();
					}
					break;
				case 4:
					x=choice;
					break;
			}
		}
	}
}
