class Runner {
	
	public static void main(String[] args) {
		
		Pikachu pikachu = new Pikachu(20, "Electric");
		
		System.out.print("Pikachu is an " + pikachu.type + " pokemon, ");
		System.out.println("and it has " + pikachu.health + " health.");
		
		pikachu.attack();
	}
}
