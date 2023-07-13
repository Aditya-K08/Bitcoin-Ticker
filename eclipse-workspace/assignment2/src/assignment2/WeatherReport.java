package assignment2;
import java.util.Scanner;
public class WeatherReport {
	int DayMonth;
	float HighTemp;
	float LowTemp;
	float AmountRain;
	float AmountSnow;
	public WeatherReport() {
		DayMonth=0;
		HighTemp=0;
		LowTemp=0;
		AmountRain=0;
		AmountSnow=0;
	}
	public WeatherReport(int a,float b,float c,float d,float e) {
		DayMonth=a;
		HighTemp=b;
		LowTemp=c;
		AmountRain=d;
		AmountSnow=e;
	}
	public void GetData() {
		System.out.println("Enter the deatails of the day : ");
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Number of days: ");
		DayMonth=in.nextInt();
		System.out.println("Enter the Highest Temp : ");
		HighTemp=in.nextInt();
		System.out.println("Enter the Lowest Temp : ");
		LowTemp=in.nextInt();
		System.out.println("Enter the Amount of rain : ");
		AmountRain=in.nextInt();
		System.out.println("Enter the Amount of snow : ");
		AmountSnow=in.nextInt();
	}
	public static void main(String[] args) {
		int n;
		Scanner in = new Scanner(System.in);
		n=in.nextInt();
		float AvgHighTemp=0;
		float AvgLowTemp=0;
		float AmtRain=0;
		float AmtSnow=0;
		WeatherReport w1[]=new WeatherReport[n];
		for(int i=0;i<n;i++) {
			w1[i]=new WeatherReport();
			w1[i].GetData();
		}
		for(int i=0;i<n;i++) {
			AvgHighTemp= AvgHighTemp+w1[i].HighTemp;
			AvgLowTemp = AvgLowTemp+w1[i].LowTemp;
			AmtRain=AmtRain+w1[i].AmountRain;
			AmtSnow+=w1[i].AmountSnow;
		}
		System.out.println("Average High Temperature : "+AvgHighTemp/n);
		System.out.println("Average Low Temperature " + AvgLowTemp/n);
		System.out.println("Amoutn of rain "+AmtRain/n);
		System.out.println("Amoutn of snow "+AmtSnow/n);
		
	}
}
