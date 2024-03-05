public class Week6ArrayMethods_soln {

    /*

    Create the following methods and a set of tests in the main method to test your methods:

    initOddArray - this method should generate an array of arbitrary size (we can call this size n).  The array should
    have incrementing odd numbers up to n (but maybe not including n), then decrementing odd numbers back down to 1.
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

    public static int[] initOddArray(int n) {
        // if zero elements, just return an empty array
        if (n == 0) {
            return new int[0];
        }

        // initialize an integer array of size n
        int[] oAry = new int[n];

        int num = -1; // initialize the number to -1 (will add 2 at the beginning of the loop to start the array at 1)
        if (n % 2 == 0) { // if even, do the following
            for (int i = 0; i < n; i++) { // iterate through the array
                if (i < n/2) { // if i is less than halfway through the array
                    num += 2; // add 2 to num to increment before inserting the number into the array
                    oAry[i] = num; // insert num into the array
                } else { // if i is past the halfway point in the array
                    oAry[i] = num; // insert num into the array (doing this first allows the number to repeat)
                    num -= 2; // subtract 2 from num so that the numbers decrement
                }
            }
        } else { // if n is odd, do the following
            for (int i = 0; i < n; i++) { // iterate through the array
                if (i <= n/2) { // if i is less than or equal to the halfway point through the array
                    num += 2; // add 2 to num to increment before inserting the number into the array
                    oAry[i] = num; // insert num into the array
                } else { // if i is past the halfway point in the array
                    num -= 2;
                    oAry[i] = num; // insert num into the array
                                   // (doing this after decrement prevents the number from repeating)
                }
            }
        }

        return oAry;
    }

    // Overloaded printAry method for integers
    public static void printAry(int[] ary) {
        for (int i = 0; i < ary.length; i++) {
            System.out.print(ary[i] + " ");;
        };
    }

    // Overloaded printAry method for Strings
    public static void printAry(String[] ary) {
        for (int i = 0; i < ary.length; i++) {
            System.out.print(ary[i]);;
        }
    }

    public static String[][] initCardDeck() {
        String[][] deck = new String[DECK_SIZE][2]; // initialize a 2d array of length DECK_SIZE,
                                                    // with each card consisting of 2 elements

        // Solution 1
        for (int i = 0; i < DECK_SIZE; i++) { // iterate through the deck

            // the following inserts a new String array into each element in the deck
            // By using i % 13 for the ranks, it will provide incrementing numbers from 0 - 12 (the indices for the
            // ranks elements)
            // The suits array needs to be handled a little differently.  Since there are 13 cards in Ranks, we need
            // to ensure that the suits match with the ranks.  The way we do this is divide i by 13.  This now leaves us
            // with 4 sets of i.  This is integer division, so i/13 = 0, 1, 2, 3 (remember that integer division always
            // truncates everything after the decimal point).
            deck[i] = new String[]{ RANKS[ i % 13 ], SUITS[ i / 13 ] };

            // the above (line 88) is equivalent to:
            // deck[i][0] = RANKS[ i % 13 ];
            // deck[i][1] = SUITS[ i / 13 ];
        }

        // Solution 2
        // This solution uses nested for loops.  i represents the suits, and j represents the ranks so we can use i,j
        // directly for the RANKS and SUITS arrays.  For the deck, however, we need to ensure that the element numbers
        // range from 0 to 51, inclusive.  We first multiply i * 13, since there are 13 cards of each suit.  Then we add
        // j to each.
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 13; j++) {
//                deck[j + (i * 13)] = new String[]{ RANKS[j], SUITS[i] };
//            }
//        }

        return deck;

    }

    public static void printCardDeck(String[][] deck) {
        for (int i = 0; i < deck.length; i++ ) {
            if ( ( i + 1 ) % 13 == 0) {
                printAry(deck[i]);
                System.out.println();
            } else {
                printAry(deck[i]);
                System.out.print("  ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] oAry = {initOddArray(0),initOddArray(1),initOddArray(2),initOddArray(5),initOddArray(10)};
        String[][] deck = initCardDeck();

        System.out.println("oddArrays (0, 1, 2, 5, 10)");
        for (int[] e : oAry) {  // remember how to use enhanced for-loops?
            printAry(e);
            System.out.println();
        }

        System.out.println("\nDeck");
        printCardDeck(deck);
    }
}
