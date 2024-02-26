public class Blackjack {
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

}
