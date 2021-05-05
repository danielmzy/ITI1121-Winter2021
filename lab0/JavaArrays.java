import java.util.Scanner;

public class JavaArrays{
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a positive integer for the size of the list: ");
		int n = keyboard.nextInt();

		// creating an array
		char[] arr;
		arr = new char[n]; // of n elements

		for (int i = 0; i < arr.length; i++){

		// arr[i] = '\u2660'; -> this is acceptable as using the unicode
		// cannot use "@", since double quotes are reserved for strings, 
		// arr is a list of characters

			arr[i] = '$'; // unicode is not \u2660, this is an example

		// cannot do this (below) because double quotes create Strings, it is reserved for that
		// reference data type.
		// arr[i] = "$"
		}

		for (int item: arr){ //notice each index is of type int
			System.out.print( (char)item ); // thus here we must type cast to char
			// it would have printed the int represntation instead
			System.out.print(" ");

		// notice for this for loop, the notation of print statement is different
		// NO ln !!!!!!!, thus the spaces after each character $

		} 

		System.out.println();

		// once created, the length of an arraya in JAVA cannot be changed,
		// DO NOT confuse this for changing the length of array!!!

		arr = new char[n+1];
		// this creates a new list of n+1 elements
		// NOT changing the original array's length

		for (int item: arr){
			System.out.print( (char)item ); 
			System.out.print(" ");

		System.out.println();
	
		}
	}
}