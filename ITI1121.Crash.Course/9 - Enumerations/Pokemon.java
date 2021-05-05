abstract class Pokemon {
	
	protected static int attackCount;
	
	private int health;
	public final Type TYPE;
	
	protected Pokemon(int health, Type type) {
		this.health = health;
		TYPE = type;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void takeDamage(int damage, Type type) {
		if (damage < 1) throw new IllegalArgumentException("damage cannot be negative");
		if (type.equals(TYPE)) damage *= 0.5;
		health -= damage;
	}
	
	public abstract void attack();
}
