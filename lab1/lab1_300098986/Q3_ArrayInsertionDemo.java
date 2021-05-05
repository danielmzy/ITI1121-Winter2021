// Student name: Kian Zahrai
// Student number: 300098986
// Course code: ITI1121
// Lab section: B-01

// Exercise 3.3: ArrayInsertionDemo
public class Q3_ArrayInsertionDemo{

	public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert)
	{
		int newArray[] = new int[beforeArray.length + 1]; 
		// initialization and declaration of array newArray of type int 
		int index = 0; // declaring a variable + assignment 
		for(int i = 0; i < beforeArray.length; i++, index++) // for loop to traverse through the array
		{
			if(i == indexToInsert)
			{
				index++;
			}
			newArray[index] = beforeArray[i];
		}
		newArray[indexToInsert] = valueToInsert;
		System.out.println("Array after insertion of "+ valueToInsert +" at position " + indexToInsert + ": ");
		// to show the edited array (after insertion)
		return newArray;
	}

	public static void main(String[] args)
	{
		int bArray[] = {1,5,4,7,9,6}; // manual declaration of the array values
		System.out.println("Array before insertion:"); // to show the original array values
		for(int i = 0; i < bArray.length; i++) // for loop used to traverse through the array to print each value
		{
			System.out.println(bArray[i]);
		}

		int ab[] = new int[bArray.length + 1]; // new array created to insert original array values + the new one
	
		ab = insertIntoArray(bArray, 3, 15); 
		// calling insertIntoArray method with given parameters (original array, which index to update, value to insert)

		for(int j = 0; j < ab.length; j++) // for loop used to traverse through the edited array to print each value
		{
			System.out.println(ab[j]);
		}
	}
}