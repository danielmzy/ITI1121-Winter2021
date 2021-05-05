class Pikachu extends Pokemon {
	
	public Pikachu() {
		super(20, "Electric");
	}
	
	@Override
	public void attack() {
		System.out.println("Pikachu used thunderbolt!");
		attackCount++;
	}
}
