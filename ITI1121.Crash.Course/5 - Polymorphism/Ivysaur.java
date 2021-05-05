class Ivysaur extends Pokemon {
	
	public Ivysaur() {
		super(25, "Grass");
	}
	
	@Override
	public void attack() {
		System.out.println("Ivysaur used razor leaf!");
		attackCount++;
	}
	
	public void cut() {
		System.out.println("Ivysaur used cut!");
	}
}
