  
// Student name: Kian Zahrai
// Student number: 300098986
// Course code: ITI1121
// Lab section: B-01

public class Q3_ReverseSortDemo {
	public static void main(String[] args){
		char[] unorderedLetters; // initialization of array unorderedLetters
		unorderedLetters = new char[]{'b', 'm', 'z', 'a', 'u'}; // declaration of the array of type char
		reverseSort(unorderedLetters); // calling the method reverseSort
		for(int i = 0; i < unorderedLetters.length; i++) // for loop to traverse through to print the word
			System.out.println(unorderedLetters[i]);
	}

	//method that sorts a char array into its reverse alphabetical order
	public static void reverseSort(char[] values){

		int valuesMax; // declaring a variable for finding maximum  
		char biggestChar; // declaring a variable for finding the biggest char as in last in alphabet

		for (int i = 0; i < values.length - 1; i++) {
			//this loop is to move the max to the front of the array
			// to start at the end of array "values" and incrementing towards start of array
			valuesMax = i; // assignment of maximum
			for (int j = i + 1; j < values.length; j++) {
				// this loop is to find the max of the values from the array 
				if (values[j] > values[valuesMax]) {
					valuesMax = j;
				}
			}//sorter section
			biggestChar = values[valuesMax]; // assignment for variable
			values[valuesMax] = values[i]; // incrementation and swapping
			values[i] = biggestChar;
		}

	}

}