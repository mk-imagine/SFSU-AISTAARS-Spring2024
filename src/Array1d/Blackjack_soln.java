package Array1d;

public class Blackjack_soln {
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
        String[][] deck = new String[DECK_SIZE][HAND_SIZE];

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

    public static void shiftCards(String[][] deck, int idx, int remainingDeckSize) {
        for (int i = idx; i < remainingDeckSize; i++ ) {
            deck[i] = deck[i+1];
        }
    }

    public static String[][] shuffle(String[][] deck) {
        int remainingDeckSize = DECK_SIZE;
        String[][] shuffledDeck = new String[DECK_SIZE][2];
        for (int i = 0; i < deck.length; i++) {
            int cardToRemoveIdx = (int) (Math.random() * remainingDeckSize--);
            shuffledDeck[i] = deck[cardToRemoveIdx];
            shiftCards(deck, cardToRemoveIdx, remainingDeckSize);
        }
        return shuffledDeck;
    }

    public static String[][] dealHand(String[][] deck, int handSize) {
        String[][] hand = new String[handSize][2];
        for (int i = 0; i < handSize; i++) {
            hand[i] = deck[deck.length - i - 1];
        }
        return hand;
    }

    public static int[] sumHand(String[][] hand) {
        int[] sum = {0, 0};

        for (int i = 0; i < hand.length; i++) {
            int[] value = {0, 0};
            try {
                value[0] = Integer.parseInt(hand[i][0]);
                value[1] = Integer.parseInt(hand[i][0]);
            } catch (NumberFormatException nfe) {
                switch (hand[i][0]) {
                    case "A":
                        value[0] = 1;
                        value[1] = 11;
                        break;
                    case "J": case "Q": case "K":
                        value[0] = 10;
                        value[1] = 10;
                }
            }
            sum[0] += value[0];
            sum[1] += value[1];
        }
        return sum;
    }

    public static String[][] truncDeck(String[][] deck, int numCardsToRemove) {
        String[][] truncDeck = new String[deck.length - numCardsToRemove][2];
        for (int i = 0; i < truncDeck.length; i++) {
            truncDeck[i] = deck[i];
        }
        return truncDeck;
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

    public static void printHand(String[][] hand, String player) {
        System.out.printf("%s's Hand:\n", player);
        System.out.println("   1     2       Value:");
        for (int i = 0; i < hand.length; i++) {
            if (i < hand.length - 1) {
                System.out.printf("%4s%s ", hand[i][0], hand[i][1]);
            } else {
                System.out.printf("%4s%s  ", hand[i][0], hand[i][1]);
                printHand(sumHand(hand));
            }
        }
    }

    public static void printHand(int[] sums) {
        if (sums[0] == sums[1]) {
            System.out.printf("      %d\n\n", sums[0]);
        } else {
            System.out.printf("  %2d or %d\n\n", sums[0], sums[1]);
        }
    }

    public static void printArray(int[] numAry) {
        for (int i = 0; i < numAry.length; i++) {
            if (i < numAry.length-1) {
                System.out.printf("%d ", numAry[i]);
            } else {
                System.out.printf("%d\n", numAry[i]);
            }
        }
    }

    public static void main(String[] args) {
        int handSize = 2;
        String p1 = "Player 1";
        String[][] deck = initDeck();

        System.out.println("Unshuffled Deck:");
        printDeck(deck);

        deck = shuffle(deck);
        System.out.println("Shuffled Deck:");
        printDeck(deck);

        String[][] p1hand = dealHand(deck, handSize);
        printHand(p1hand, p1);

        deck = truncDeck(deck, handSize);
        System.out.println("Shuffled Deck after Deal:");
        printDeck(deck);
    }
}
