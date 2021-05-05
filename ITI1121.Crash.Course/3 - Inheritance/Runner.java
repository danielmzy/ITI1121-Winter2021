class Runner {
	
	public static void main(String[] args) {
		
		Pikachu pikachu = new Pikachu();
		System.out.print("Pikachu is an " + pikachu.type + " pokemon, ");
		System.out.println("and it has " + pikachu.health + " health.");
		pikachu.attack();
		
		// Ivysaur ivysaur = new Ivysaur();
		// System.out.print("Ivysaur is an " + ivysaur.type + " pokemon, ");
		// System.out.println("and it has " + ivysaur.health + " health.");
		// ivysaur.attack();
		
		System.out.println("The pokemon have attacked " + Pokemon.attackCount + " times.");
	}
}
