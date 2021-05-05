class Pikachu extends Pokemon {
	
	public Pikachu() {
		// called with the same syntax as static classes
		super(20, Type.ELECTRIC);
	}
	
	@Override
	public void attack() {
		System.out.println("Pikachu used thunderbolt!");
		attackCount++;
	}
}
