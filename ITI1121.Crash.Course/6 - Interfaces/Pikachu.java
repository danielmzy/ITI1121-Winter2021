class Pikachu extends Pokemon {
	
	public Pikachu() {
		super(20, "Electric");
	}
	
	@Override
	public void attack() {
		System.out.println("Pikachu used thunderbolt!");
		attackCount++;
	}
	
	@Override
	public void interact() {
		System.out.println("Pika pika!");
	}
	
	public void flash() {
		System.out.println("Pikachu used flash!");
	}
}
