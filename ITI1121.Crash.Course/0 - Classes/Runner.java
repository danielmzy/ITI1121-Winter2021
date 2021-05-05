class Runner {
	
	// `java ClassName` in a command window runs the method `public static void main` in that class
	public static void main(String[] args) {
		
		// making an object from a class
		Pikachu pikachu = new Pikachu();
		
		// the syntax `object.member` accesses variables and methods that
		// belong to that object's class
		
		pikachu.health = 20;
		pikachu.type = "Electric";
		
		System.out.print("Pikachu is an " + pikachu.type + " pokemon, ");
		System.out.println("and it has " + pikachu.health + " health.");
		
		pikachu.attack();
	}
}
