package assignment5;
import java.util.Scanner;
abstract class Shape {
	double len,bre;
	abstract public void area();
}
class rect extends Shape{
	Scanner in = new Scanner(System.in);
	public void area() {
		len=in.nextDouble();
		bre=in.nextDouble();
		System.out.println("Area is : "+ (len*bre));
	}
}
class tri extends Shape{
	Scanner in = new Scanner(System.in);
	public void area() {
		len=in.nextDouble();
		bre=in.nextDouble();
		System.out.println("Area is : "+ (0.5*len*bre));
	}
}
