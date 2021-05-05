class Ivysaur extends Pokemon {
	
	public Ivysaur() {
		// called with the same syntax as static classes
		super(25, Type.GRASS);
	}
	
	@Override
	public void attack() {
		System.out.println("Ivysaur used razor leaf!");
		attackCount++;
	}
}
