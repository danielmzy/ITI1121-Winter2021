class Runner {
	
	public static void main(String[] args) {
		
		// interfaces let you work on completely different classes under the same data type!
		Interactable[] npcs = new Interactable[3];
		npcs[0] = new Trainer();
		npcs[1] = new Pikachu();
		npcs[2] = new Ivysaur();
		for (int i = 0; i < npcs.length; i++) {
			npcs[i].interact();
		}
	}
}
