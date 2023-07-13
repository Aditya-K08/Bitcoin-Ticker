package assignment4;
import java.util.Scanner;
public class Employee {
	String Name,address,MailID;
	long num;
	int ID;
	double Basic_Pay,DA,HRA,PF;
	Employee(){
		Name="";
		address="";
		MailID="";
		ID=0;
	}
	void GetData() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Name: ");
		Name = in.next();
		System.out.println("Enter address : " );
		address = in.next();
		System.out.println("Enter MailID : ");
		MailID = in.next();
		System.out.println("Enter ID: ");
		ID = in.nextInt();
		System.out.println("Enter Number");
		num = in.nextLong();
		System.out.println("Enter Basic Pay: ");
		Basic_Pay = in.nextDouble();
		DA=0.1*Basic_Pay;
		HRA=0.12*Basic_Pay;
		PF=0.001*Basic_Pay;
	}
	void displayData() {
		double Gross=Basic_Pay+DA+HRA;
		double Net=Gross-PF;
		System.out.println("PAYSLIP");
		System.out.println("Name : "+ Name);
		System.out.println(" Address : "+ address);
		System.out.println("MAIl id"+MailID);
		System.out.println("ID "+ID);
		System.out.println("NUMBER "+num);
		System.out.println("basic pay : "+Basic_Pay);
		System.out.println("DA : "+DA);
		System.out.println("HRA : "+HRA);
		System.out.println("gross salaray : "+Gross);
		System.out.println("NEt salary : "+Net);
	}
}
class Programmer extends Employee{
	public void displayData() {
		super.displayData();
	}
}
class AssociateProfessor extends Employee{
	public void displayData() {
		super.displayData();
	}
}
class AssitantProcessor extends Employee{
	public void displayData() {
		super.displayData();
	}
}
class Professor extends Employee{
	public void displayData() {
		super.displayData();
	}
}