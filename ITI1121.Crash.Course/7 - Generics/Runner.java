import java.util.LinkedList;

class Runner {
	
	public static void main(String[] args) {
		
		// generics let classes work with different types that
		// may otherwise have nothing in common!
		
		Pikachu<Berry> pikachu = new Pikachu<Berry>();
		pikachu.heldItem = new Berry();
		
		Ivysaur<ExpShare> ivysaur = new Ivysaur<ExpShare>();
		ivysaur.heldItem = new ExpShare();
		
		LinkedList<Pokemon> party = new LinkedList<Pokemon>();
		party.add(pikachu);
		party.add(ivysaur);
		for (int i = 0; i < party.size(); i++) {
			System.out.println(party.get(i) + " is holding a " + party.get(i).heldItem);
		}
	}
}
