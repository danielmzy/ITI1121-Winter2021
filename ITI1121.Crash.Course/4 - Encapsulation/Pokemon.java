
// abstract makes this class unable to constructed directly — the generic
// pokemon shouldn't exist!
abstract class Pokemon {
	
	// protected is only accessible to inheritors
	protected static int attackCount;
	
	// private is only accessible within this class
	private int health;
	
	// public is accessible to everything
	public final String TYPE;
	
	protected Pokemon(int health, String type) {
		this.health = health;
		TYPE = type;
	}
	
	// health getter
	public int getHealth() {
		return health;
	}
	
	public void takeDamage(int damage, String type) {
		if (type.equals(TYPE)) damage *= 0.5;
		health -= damage;
	}
	
	// abstract on a method forces non-abstract inheritors to override it
	public abstract void attack();
}
