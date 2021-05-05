class Pikachu {
	
	// static members can be accessed without an instance
	// (instances and objects are the same thing)
	public static int attackCount;
	
	public int health;
	public String type;
	
	public void attack() {
		System.out.println("Pikachu used thunderbolt!");
		
		// update statistics each time we attack
		attackCount++;
	}
}
