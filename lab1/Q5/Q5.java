// Student name: Kian Zahrai
// Student number: 300098986
// Course code: ITI1121
// Lab section: B-01


public class Q5{

	public static void main(String[] args){
		boolean[] test = new boolean[8];

		//test for isPrime
		test[0]  = (isPrime(0) == false);
		test[1] = (isPrime(2) == true);
		test[2] = (isPrime(7) == true);
		test[3] = (isPrime(15) == false);

		test[4]  = (getFibonacci(1) == 1);
		test[5]  = (getFibonacci(3) == 2);
		test[6]  = (getFibonacci(5) == 5);
		test[7]  = (getFibonacci(8) == 21);


		boolean testFlag=true;
		for (int i = 0; i < test.length; i++){
			if(test[i]){
				System.out.println("test " + i + " passed");
			}

			else{
				System.out.println("test " + i + " failed");
				testFlag = false;
			}
		}

		if(testFlag ){
				System.out.println("All tests are successful");
			}

		else{
			System.out.println("Not all tests are successful");
		}

	}

	//method that determines if the number x is prime
	public static boolean isPrime(int x){
		if(x < 2){
			return false; // since 1 and 0 are not prime numbers, the condition forces them out
		}
		if(x == 2){
			return true; // lowest prime number (base test in a sense to be compared to)
		}
		boolean prime = true;
		int i = 2;
		while(x > i){
			if(x % i == 0){ // if remainder is 0, means the number is divisible by another numbe rpother than 1 or itself (here is 2)
				prime = false; // thus not a prime number
			}
		i++;
		}
	return prime;
	}

	//returns the fibonacci number at the position in parameter
	public static int getFibonacci(int position){
		int num = 0; // starting number
		int num2 = 1; // the number after the starting number
		int fibonacci = 0; // starting value of the sum of the 2 numbers (above)
		for (int i = 0; i < position; i++)
		{
   		 	fibonacci = num2 + num; // variable "fibonacci" is assinged to the sum of the 2 numbers
   		 	num = num2; // starting number becomes the next number
   			num2 = fibonacci; // incremented to next number
		}
		return num;

	}



}