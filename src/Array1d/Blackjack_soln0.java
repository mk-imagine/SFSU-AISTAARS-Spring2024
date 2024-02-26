package Array1d;

public class Blackjack_soln0 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String SPADES = "\u2660" + ANSI_RESET;
    public static final String HEARTS = ANSI_RED + "\u2665" + ANSI_RESET;
    public static final String DIAMONDS = ANSI_RED + "\u2666" + ANSI_RESET;
    public static final String CLUBS = "\u2663" + ANSI_RESET;

    public static final String[] SUITS = { CLUBS, DIAMONDS, HEARTS, SPADES };
    public static final String[] RANKS = { "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4"
            , "3", "2" };
    public static final int DECK_SIZE = 52;
    public static final int HAND_SIZE = 2;

    public static String[][] initDeck() {
        String[][] deck = new String[DECK_SIZE][2];

//        for (int i = 0; i < DECK_SIZE; i++) {
//            String[] card = {RANKS[i%13], SUITS[(i/13)%4]};
//            deck[i] = card;
//        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                String[] card = {RANKS[j], SUITS[i]};
                deck[j + (i * 13)] = card;
            }
        }

        return deck;
    }

    public static void printDeck(String[][] deck) {
        for (int i = 0; i < deck.length; i++) {
            if ((i + 1) % 13 == 0) {
                System.out.printf("%4s%s\n", deck[i][0], deck[i][1]);
            } else {
                System.out.printf("%4s%s ", deck[i][0], deck[i][1]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int handSize = 2;
        String p1 = "Player 1";
        String[][] deck = initDeck();

        System.out.println("Unshuffled Deck:");
        printDeck(deck);
    }
}
