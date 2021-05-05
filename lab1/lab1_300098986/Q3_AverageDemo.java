// Student name: Kian Zahrai
// Student number: 300098986
// Course code: ITI1121
// Lab section: B-01

// Exercise 3.2: AverageDemo

public class Q3_AverageDemo{
	public static void main(String[] args){
		double[] valuesArray; // initializing the array
		valuesArray = new double[]{100.0,34.0,72.0,56.0,82.0,67.0,94.0}; // manual declaration of the array values
		System.out.println("The average is: " + calculateAverage(valuesArray)); 
		// printing statement + result via calling the calculateAverage method
	}

	//method that calculates the average of the numbers in an array
	public static double calculateAverage(double[] values){
		double result; // initializing the double variable
		//your code here
		result = 0; // declaring starting value
		for(int i = 0; i < values.length; i++){ 
		// for loop to traverse through the double array of "values"
			result = result + values[i]; 
			// incrementing the result variable by adding each element of the array "values"
		}
		result = result / 7; // double divide by integer (7 is # of values) --> result is a double 
		return result; 
	}
}