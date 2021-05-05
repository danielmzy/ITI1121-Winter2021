public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Alex");
        Player player2 = new Player("Bob");

        Game game = new Game(player1, player2, 3);
        game.runGame();
    }
}
