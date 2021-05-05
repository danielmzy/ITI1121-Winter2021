class Runner {
	
	public static void main(String[] args) {
		
		Pokemon pikachu = new Pikachu();
		System.out.println("runtime entered");
		pikachu.takeDamage(-5, "Grass");
		
		// try catch is just a bougie if statement for throwables
		// that lets code continue executing even after errors are thrown
		
		// try {
		// 	System.out.println("try catch entered");
		// 	pikachu.takeDamage(5, "Grass");
		// } catch (Exception exception) {
		// 	System.out.println("ya goofed");
		// 	exception.printStackTrace();
		// }
		// System.out.println("try catch exited");
	}
}
