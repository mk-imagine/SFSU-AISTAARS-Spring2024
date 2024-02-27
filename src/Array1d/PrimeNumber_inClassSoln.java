package Array1d;

public class PrimeNumber_inClassSoln {
    public static final int NUMBER_OF_PRIMES = 50; // Number of primes to display
    public static final int NUMBER_OF_PRIMES_PER_LINE = 10; // Display 10 per line

    public static void main(String[] args) {

        int[] primes = generatePrimes(NUMBER_OF_PRIMES);
        printArray(primes);
    }

    public static int[] generatePrimes(int numberOfPrimes) {
        int numToCheck = 2;
        int[] primeAry = new int[numberOfPrimes];
        primeAry[0] = 2;

        for (int i = 0; i < numberOfPrimes; ) {
            if(isPrime(numToCheck, primeAry)) {
                primeAry[i] = numToCheck;
                i++;
            }
            numToCheck++;
        }

        return primeAry;
    }

    public static boolean isPrime(int num, int[] primeAry) {
        for ( int i = 0; i < primeAry.length ; i++ ) {
            if (primeAry[i] == 0) {
                break;
            }

            if ( num % primeAry[i] == 0 ) {
                return false;
            }
        }
        return true;
    }

    public static void printArray( int[] array ) {
        System.out.println("Prime Array:");
        for (int i = 0; i < array.length ; i++) {
            if ( (i + 1) % NUMBER_OF_PRIMES_PER_LINE == 0 ) {
                System.out.print(array[i] + "\n");
            } else {
                System.out.print(array[i] + " ");
            }
        }
    }
}