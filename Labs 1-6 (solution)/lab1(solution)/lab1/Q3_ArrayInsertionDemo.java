
/*
Student name: Glen Wang
Student number: 300164126
Course: ITI 1121
Lab section: B-1
*/


/**
* The class Q3_ array insertion demo
* @author Glen Wang
*/
public class Q3_ArrayInsertionDemo {
	
	
	/**
	*
	* Insert into array
	*
	* @param beforeArray  the before array
	* @param indexToInsert  the index to insert
	* @param valueToInsert  the value to insert
	* @return int[]  the after array
	*/
	public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert){
		
		int[] afterArray = new int[beforeArray.length + 1];
		for (int i = 0; i < afterArray.length; i++) {
			if (i < indexToInsert) afterArray[i] = beforeArray[i];
			else if (i == indexToInsert) afterArray[i] = valueToInsert;
			else afterArray[i] = beforeArray[i - 1];
		}
		return afterArray;
	}
	
	// runs the program
	public static void main(String[] args) {
		
		int[] array = new int[] { 1, 5, 4, 7, 9, 6 };
		int insertIndex = 3;
		int insertValue = 15;
		System.out.println("Array before insertion:");
		for (int num : array) System.out.println(num);
		System.out.printf("Array after insertion of %d at position %d:%n", insertValue, insertIndex);
		array = insertIntoArray(array, insertIndex, insertValue);
		for (int num : array) System.out.println(num);
	}
}
