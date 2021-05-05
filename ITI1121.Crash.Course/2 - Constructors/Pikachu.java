class Pikachu {
	
	public static int attackCount;
	
	public int health;
	public String type;
	
	// constructors are called to create objects from classes
	
	public Pikachu(int health, String type) {
		this.health = health;
		this.type = type;
	}
	
	public void attack() {
		System.out.println("Pikachu used thunderbolt!");
		attackCount++;
	}
}
