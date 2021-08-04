
/*
Student name: Glen Wang
Student number: 300164126
Course: ITI 1121
Lab section: B-1
*/

import java.util.Scanner;


/**
* The class Q6
* @author Glen Wang
*/
public class Q6 {
	
	
	// runs the program
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		double[] notes = new double[10];
		System.out.print("Input ten grades: ");
		for (int i = 0; i < notes.length; i++) notes[i] = input.nextDouble();
		System.out.println("Average: " + calculateAverage(notes));
		System.out.println("Median: " + calculateMedian(notes));
		System.out.println("Failed: " + calculateNumberFailed(notes));
		System.out.println("Passed: " + calculateNumberPassed(notes));
	}
	
	
	/**
	*
	* Calculates the average
	*
	* @param notes  the grades
	* @return double  the average
	*/
	public static double calculateAverage(double[] notes) {
		
		double total = 0.0;
		for (int i = 0; i < notes.length; i++) total += notes[i];
		return total / notes.length;
	}
	
	
	/**
	*
	* Calculates the median
	*
	* @param notes  the notes
	* @return double  the median
	*/
	public static double calculateMedian(double[] notes) {
		
		if (notes.length == 1) return notes[0];
		sort(notes); // assuming we're still not allowed to use arrays.sort
		if (notes.length % 2 == 0) return (notes[notes.length / 2] + notes[notes.length / 2 - 1]) / 2.0;
		else return notes[notes.length / 2];
	}
	
	
	/**
	*
	* Calculates the number failed
	*
	* @param notes  the notes
	* @return int  the number failed
	*/
	public static int calculateNumberFailed(double[] notes) {
		
		int failures = 0;
		for (int i = 0; i < notes.length; i++) if (notes[i] < 50.0) failures++;
		return failures;
	}
	
	
	/**
	*
	* Calculates the number passed
	*
	* @param notes  the notes
	* @return int  the number passed
	*/
	public static int calculateNumberPassed(double[] notes) {
		
		return notes.length - calculateNumberFailed(notes);
	}
	
	
	/**
	*
	* Bubble sorts the values
	*
	* @param values  the values
	*/
	private static void sort(double[] values) {
		
		double swap;
		int progress = 0;
		for (int i = 1; progress < values.length; i = (i + 1) % (values.length)) {
			if (i == 0) i++;
			if (values[i - 1] > values[i]) {
				swap = values[i];
				values[i] = values[i - 1];
				values[i - 1] = swap;
				progress = 0;
			} else progress++;
		}
	}
}
