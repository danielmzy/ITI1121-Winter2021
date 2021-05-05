  
import java.util.Scanner;

public class VotingRight{

	public static void main(String[] args){
		Scanner myScan = new Scanner(System.in); //initializes myScan
		System.out.print("How old are you? "); // Question for user

		int usersAge = myScan.nextInt(); // input for age
		int yearsLeft = 18 - usersAge; // difference of age to age restriction (if needed)
		String years; // initialization for later importance

		if(usersAge < 18){ // condition that if age is lower than the restriction
			
		  if(yearsLeft == 1){ // grammar accordance with word "year" if difference is larger than 1 or not

			years = "year";
		  }
		  else{
			years = "years";
		  }
			System.out.println("You will be allowed to vote in " + yearsLeft + " " + years + "."); // message for advice
		} 
		else{ //if the user is older than or is 18 years old
			System.out.println("You have the right to vote!");
		}
	}
	

}