abstract class Pokemon implements Interactable {
	
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
		if (type.equals(TYPE)) damage *= 0.5;
		health -= damage;
	}
	
	public abstract void attack();
}
