// Student name: Kian Zahrai
// Student number: 300098986
// Course code: ITI1121
// Lab section: B-01

// Exercise 3.1: SquareArray

public class Q3_SquareArray{

	public static int[] createArray(int size) {
		// Your code here
		int[] list; // initializing the array 
		list = new int[size]; // declaring the size of array
		for (int i = 0; i < list.length; i++){ // for loop for traversing through the array
			list[i] = i * i; // the square operation
		}
		return list; // edited list is returned after loop completion
	}

	public static void main(String[] args){
		// Your code here
		int[] arr; // initializing the array 
		arr = createArray(13); // calling the createArray method
		for (int i = 0; i < arr.length; i++){ // for loop for for traversing through the array
			System.out.println("The square of "+ i + " is: "+ arr[i]); 
			//result of createArray and main method
		}
		
	}
} 
