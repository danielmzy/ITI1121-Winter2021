import java.util.Scanner;

public class BasicMethods{
	/* 
	- all the method definitions go inside this class
	- main goes inside the class
	- unlike Python, the main can come before the function definitions
	*/

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter base: ");
		double b = keyboard.nextDouble();
		System.out.print("Enter height: ");
		double h = keyboard.nextDouble();

		double area = AreaOfTriangle(b, h); //method Invokation --> function call in Python
		System.out.println(area);
		AreaOfTrianglePrints(b, h);

		DrawRec();

		System.out.print("Enter number of seconds: ");
		int sec = keyboard.nextInt();

		int[] time;
		time = S_to_hms(sec); // reference variable, where address of the method is stored
		// System.out.println(time); --> prints the address of array
		for (int item: time) {
			System.out.print(item);
			System.out.print("\n");

		}
		System.out.println(sec + " seconds is " + time[0] + " hour(s), " 
			+ time[1] + " minutes and " + time[2] + " seconds.\n");
	}

	public static double AreaOfTriangle(double base, double height){
		// body of method:
		double area = base * height * 0.5;
		return area;
	}

	public static void AreaOfTrianglePrints(double base, double height){
		double area = base * height * 0.5;
		System.out.println(area);
	}

	public static void DrawRec(){
		System.out.println();
		System.out.println("----------------");
		System.out.println("|               |");
		System.out.println("|               |");
		System.out.println("----------------");
		System.out.println();
	}

	public static int[] S_to_hms(int s){
		
		int hour = s / 3600; // both operands are of type integer, thus hour is of type int
		s = s % 3600;
		int minute = s / 60;
		s = s % 60;

		// Shortcut --> int[] hms = {hour, minute, s};

		int[] hms = new int[3]; // default value is 0 for each index/element
		hms[0] = hour;
		hms[1] = minute;
		hms[2] = s;

		return hms;
		


	}

}