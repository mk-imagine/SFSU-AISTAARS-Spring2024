public class Week5ArrayMethods {

    /*

    Create the following methods and a set of tests in the main method to test your methods:

    initOddArray - this method should generate an array of arbitrary size (we can call this size n).  The array should
    have incrementing odd numbers up to n, then decrementing odd numbers back down to 1.
    EXAMPLE: if the array size is 10, it should return an array with the following elements: [1, 3, 5, 7, 9, 9, 7, 5, 3,
    1].  If the array size is 5, it should return an array with the following elements: [1, 3, 5, 3, 1]

    initCardDeck - this method should generate an array of pairs of strings (this should end up being a 2d array).  The
    pair of strings should be a complete 52 card deck.  For each pair, the first value should be the card rank (e.g. A,
    K, Q, J, ... , 4, 3, 2) and the second value should be the SUIT (e.g. clubs, diamonds, hearts, spades).  Some String
    constants have been provided for your convenience.  You do not need to use them.  If you want, you can just spell out
    the suits (e.g. "Clubs", "Diamonds", "Hearts", "Spades").

    How are you going to test your methods?  Perhaps some methods to print your initialized arrays would be useful.

     */

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
}
