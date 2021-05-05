public class Prime {
	public static int primenumber(int n){
		int counter = 0;
		for(int i=2; i<n; i++){
			if (isPrime(i)){
				counter++;
			}
		}
		return counter;
	}

	private static boolean isPrime(int number) {
		// n=7
		// 2 3 4 5
		// 7%2 == 0 return false
		// else return true
		for (int i = 2 ; i < number; i++){
			if(number%i == 0) {
				return false;
			} 
		}
		return true;
	}

	public static void main(String[] args){
		// 2 3 4 5 6 7 8
		System.out.println(primenumber(9));
	}
}