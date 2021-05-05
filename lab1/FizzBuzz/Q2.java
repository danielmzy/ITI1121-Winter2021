// Student name: Kian Zahrai
// Student number: 300098986
// Course code: ITI1121
// Lab section: B-01

// Exercise 2: FizzBuzz

public class Q2{
	public static void main(String[] args){
		for (int i = 1; i <= 30; i++){ // for i in range 1 to 30
			if(i % 15 == 0){ // if i is divisible by 15
				System.out.println(i + " FizzBuzz");
			}
			else if(i % 5 == 0){ // if i is divisible by 5
				System.out.println(i + " Buzz");
			}
			else if(i % 3 == 0){// if i is divisible by 3
				System.out.println(i + " Fizz");
			}
		}


	}
}