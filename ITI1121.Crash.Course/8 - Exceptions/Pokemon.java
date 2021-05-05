abstract class Pokemon {
	
	protected static int attackCount;
	
	private int health;
	public final String TYPE;
	
	protected Pokemon(int health, String type) {
		this.health = health;
		TYPE = type;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void takeDamage(int damage, String type) {
		// exceptions let you define error messages
		// standardized way to replace print statements that highlight errors
		if (damage < 1) throw new IllegalArgumentException("damage cannot be zero or negative");
		if (type.equals(TYPE)) damage *= 0.5;
		health -= damage;
	}
	
	public abstract void attack();
}
