package assignment6;
import java.util.*;
public interface Vehicle {
	public void GearChange(int gear);
	public void SpeedUp(int speed);
	public void ApplyBrakes();
}
class Bike implements Vehicle{
	public void GearChange(int gear){
		System.out.println("Gear CHanged : "+ gear);
	}
	public void SpeedUp(int speed) {
		System.out.println("speed CHanged : "+ speed);
	}
	public void ApplyBrakes() {
		System.out.println("Brakes Applied ");
	}
}
class Car implements Vehicle{
	public void GearChange(int gear){
		System.out.println("Gear CHanged : "+ gear);
	}
	public void SpeedUp(int speed) {
		System.out.println("speed CHanged : "+ speed);
	}
	public void ApplyBrakes() {
		System.out.println("Normal and handBrakes Applied ");
	}
}
class Bicycle implements Vehicle{
	public void GearChange(int gear){
		System.out.println("Gear CHanged : "+ gear);
	}
	public void SpeedUp(int speed) {
		System.out.println("speed CHanged : "+ speed);
	}
	public void ApplyBrakes() {
		System.out.println("Front and  Back Brakes Applied ");
	}
}


