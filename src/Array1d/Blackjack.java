package Array1d;

public class Blackjack {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String SPADES = "\u2660" + ANSI_RESET;
    private static final String HEARTS = ANSI_RED + "\u2665" + ANSI_RESET;
    private static final String DIAMONDS = ANSI_RED + "\u2666" + ANSI_RESET;
    private static final String CLUBS = "\u2663" + ANSI_RESET;

    private static final String[] SUITS = { CLUBS, DIAMONDS, HEARTS, SPADES };
    private static final String[] RANKS = { "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4"
            , "3", "2" };
    private static final int DECK_SIZE = 52;
    private static final int HAND_SIZE = 2;
    
    
}
