// Student name: Kian Zahrai
// Student number: 300098986
// Course code: ITI1121
// Lab section: B-01

import java.util.Scanner; // import library for input from user

public class Q6{
	public static void main(String[] args){

		double[] grades = new double[10]; // array of double type values created

		Scanner scanName = new Scanner(System.in); // input for 10 numbers to be assessed

		for (int i = 0; i < 10; i++) {
			System.out.println("Enter the student's grade (#" + (i + 1) + "): "); // prompt for input (next line, the value is stored)
			grades[i] = scanName.nextDouble();
		}

		// series of method calls to evaluate the desired number, and printed
		// sort the grades
		Q6.sortDoubles(grades);

		// Average
		double studentAverage = Q6.calculateAverage(grades);
		System.out.println("The student's grade average was: " + studentAverage);

		// Median
		double studentMedian = Q6.calculateMedian(grades);
		System.out.println("The student's grade median was: " + studentMedian);

		// failed classes
		int failedClasses = Q6.calculateNumberFailed(grades);
		System.out.println("The student failed " + failedClasses + " classes");

		// passed classes
		int passedClasses = Q6.calculateNumberPassed(grades);
		System.out.println("The student passed " + passedClasses + " classes");


	}

	public static void sortDoubles(double[] values) {
		// sort method to facilitate the median method
		int valuesMin; // initialized variable 
		double smallestDouble;

		for (int i = 0; i < values.length - 1; i++) {
			//this loop is to move the max to the front of the array
			valuesMin = i; // assignment of variable for finding minimum value
			for (int j = i + 1; j < values.length; j++) {
				// this loop is to find the max of the values
				if (values[j] < values[valuesMin]) {
					valuesMin = j;
				}
			}
			smallestDouble = values[valuesMin];
			values[valuesMin] = values[i];
			values[i] = smallestDouble;
		}
	}

	public static double calculateAverage(double[] notes){

		double myTotal = 0.0;  // initialized variable to be edited via its function
		double myAverage = 0.0;

		for (int i = 0; i < notes.length; i++) { // for loop to access each value to change the double "average"
			myTotal += notes[i]; // access each value to change the double "average"
		}

		myAverage = myTotal / notes.length; // double type "average" divided by number of values given by user

		return myAverage;
	}
	public static double calculateMedian(double[] notes){
		double median; // declaration of variable
		sortDoubles(notes); // osrt method above is called
		int w = notes.length; // assignment of the array length
        if (w % 2==0) {
        	median = (notes[(w / 2) - 1] + notes[(w / 2)]) / 2; // even number of values in array
            }else {
                median = notes[w/2]; // odd number of values in array, then middle number in array is median
            }
        return median;
	}

	public static int calculateNumberFailed(double[] notes){
		int failCount = 0; // initialized variable to be incremented if value follows condition
		// for loop to implement condtion
		for (int i = 0; i < notes.length; i++) {
			if (notes[i] < 50) { // limit of passing course, thus lower value is a fail
				failCount++; // increase count if condition is true
			}
		}
		return failCount;
	}

	public static int calculateNumberPassed(double[] notes){
		int passCount = 0; // initialized variable to be incremented if value follows condition
		// for loop to implement condtion
		for (int i = 0; i < notes.length; i++) {
			if (notes[i] >= 50) { // limit of passing course, thus larger value is a pass
				passCount++; // increase count if condition is true
			}
		}
		return passCount;
	}

}