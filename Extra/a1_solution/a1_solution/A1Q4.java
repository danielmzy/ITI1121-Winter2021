import java.util.Scanner;
import java.util.Random;

public class A1Q4 {

    private static String[] deck, playerDeck, computerDeck;
    private static int sizeDeck, sizePlayerDeck, sizeComputerDeck;
    private static Scanner sc;
    private static Random generator;

    public A1Q4() {

        sc = new Scanner(System.in);
        generator = new Random();

        String[] suits = { "\u2660", "\u2661", "\u2662", "\u2663" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J",
                "Q", "K", "A" };
        sizeDeck = suits.length * ranks.length - 1;
        deck = new String[sizeDeck];
        int index = 0;
        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                if (!(ranks[i] == "Q" && suits[j] == "\u2663")) {
                    deck[index++] = ranks[i] + " of " + suits[j];
                }
            }
        }
    }

    private static void dealCards() {

        sizePlayerDeck = 0;
        sizeComputerDeck = 0;
        playerDeck = new String[sizeDeck];
        computerDeck = new String[sizeDeck];

        int i = 0, j = 0;
        while (i < sizeDeck - 1) {
            playerDeck[sizePlayerDeck++] = deck[i++];
            computerDeck[sizeComputerDeck++] = deck[i++];
        }
        if (i == sizeDeck - 1) {
            playerDeck[sizePlayerDeck++] = deck[i];
        }
    }

    private static int removePairs(String[] deckOfCards, int currentSize) {

        int i = 0;
        ArrayStringsTools.sortArray(deckOfCards, currentSize);
        while (i < currentSize - 1) {
            if (deckOfCards[i].substring(0, 2)
                    .equals(deckOfCards[i + 1].substring(0, 2))) {
                currentSize = ArrayStringsTools.removeItemByIndex(deckOfCards,
                        currentSize, i);
                currentSize = ArrayStringsTools.removeItemByIndex(deckOfCards,
                        currentSize, i);
            } else {
                i++;
            }
        }
        ArrayStringsTools.shuffleArray(deckOfCards, currentSize);
        return currentSize;

    }

    /*
     * Note: this method does not check that the input is indeed an int and will
     * crash if something else is provided
     */
    private static int getValidInput() {
        System.out.println("I have " + sizeComputerDeck
                + " cards. If 1 stands for my first card and "
                + sizeComputerDeck
                + " for my last card, which of my cards would you like?");
        System.out.print("Please enter an integer between 1 and "
                + sizeComputerDeck + ": ");
        int i = sc.nextInt();
        while (i < 1 || i > sizeComputerDeck) {
            System.out
            .print("Invalid number. Please enter an integer between 1 and "
                    + sizeComputerDeck + ": ");
            i = sc.nextInt();

        }
        // empty buffer
        sc.nextLine();
        return i;
    }

    private static void waitForUserInput() {
        sc.nextLine();
    }

    public static void playGame() {

        String[] englishOrdinalsEnd = { "st", "nd", "rd", "th" };

        ArrayStringsTools.shuffleArray(deck, sizeDeck);
        ArrayStringsTools.printArray(deck, sizeDeck);
        dealCards();
        System.out.println("Hello. My name is Robot and I am the dealer.");
        System.out.println("Welcome to my card game!");
        System.out.println("Your current deck of cards is:");
        ArrayStringsTools.printArray(playerDeck, sizePlayerDeck);
        System.out
        .println("Do not worry. I cannot see the order of your cards");

        System.out.println(
                "Now discard all the pairs from your deck. I will do the same.");

        waitForUserInput();

        sizePlayerDeck = removePairs(playerDeck, sizePlayerDeck);
        sizeComputerDeck = removePairs(computerDeck, sizeComputerDeck);

        int round = 0;
        int indexToRemove;
        String cardRemoved;
        while (sizePlayerDeck > 0 && sizeComputerDeck > 0) {
            if (round == 0) {
                System.out.println(
                        "***********************************************************");
                System.out.println("Your turn.");
                System.out.println("Your current deck of cards is:");
                ArrayStringsTools.printArray(playerDeck, sizePlayerDeck);
                if (sizeComputerDeck == 1) {
                    System.out.println(
                            "I have only one card left, you have to take it.");
                    indexToRemove = 1;
                } else {
                    indexToRemove = getValidInput();
                }
                cardRemoved = computerDeck[indexToRemove - 1];
                sizeComputerDeck = ArrayStringsTools.removeItemByIndex(
                        computerDeck, sizeComputerDeck, indexToRemove - 1);

                System.out
                .println(
                        "You asked for my " + indexToRemove
                        + englishOrdinalsEnd[(indexToRemove > 3)
                                             ? 3 : (indexToRemove - 1)]
                                                     + " card.");
                System.out.println("Here it is. It is " + cardRemoved);
                sizePlayerDeck = ArrayStringsTools.appendItem(playerDeck,
                        sizePlayerDeck, cardRemoved);
                System.out.println("With " + cardRemoved
                        + " added, your current deck of cards is:");
                ArrayStringsTools.printArray(playerDeck, sizePlayerDeck);

                System.out.println(
                        "And after discarding pairs and shuffling, your deck is:");
                sizePlayerDeck = removePairs(playerDeck, sizePlayerDeck);
                ArrayStringsTools.printArray(playerDeck, sizePlayerDeck);

                waitForUserInput();
                round = 1;
            } else {
                System.out.println(
                        "***********************************************************");
                System.out.println("My turn.");
                if (sizePlayerDeck == 1) {
                    indexToRemove = 0;
                } else {
                    indexToRemove = generator.nextInt(sizePlayerDeck - 1);
                }
                cardRemoved = playerDeck[indexToRemove];
                sizePlayerDeck = ArrayStringsTools.removeItemByIndex(playerDeck,
                        sizePlayerDeck, indexToRemove);
                sizeComputerDeck = ArrayStringsTools.appendItem(computerDeck,
                        sizeComputerDeck, cardRemoved);
                sizeComputerDeck = removePairs(computerDeck, sizeComputerDeck);
                indexToRemove++;
                System.out
                .println(
                        "I took your " + indexToRemove
                        + englishOrdinalsEnd[(indexToRemove > 3)
                                             ? 3 : (indexToRemove - 1)]
                                                     + " card.");
                waitForUserInput();
                round = 0;
            }
        }

        if (sizeComputerDeck == 0) {
            System.out.println("Oops. I do not have any more card.");
            System.out.println("You lost! I, Robot, win");
        } else {
            System.out.println(
                    "***********************************************************");
            System.out.println("Oops. You do not have any more card.");
            System.out.println("Congratulations! You, Human, win");
        }
    }

    public static void main(String[] args) {

        A1Q4 game = new A1Q4();
        game.playGame();

    }
}
