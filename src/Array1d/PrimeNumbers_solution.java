package Array1d;

public class PrimeNumbers_solution {

    public static boolean isPrime(int num, int[] sortedPrimes) {
        int largestPrime = (int) Math.sqrt(num);

        if (num == 2) {
            return true;
        }

        for (int i = 0; sortedPrimes[i] <= largestPrime; i++) {
            if (num % sortedPrimes[i] == 0) {
                return false;
            }
        }

        return true;
    }

    public static int[] generateSortedPrimes(int num_of_primes) {
        int count = 0; // Count the number of prime numbers
        int num = 2; // Number to check is prime
        int[] sortedPrimes = new int[num_of_primes];

        // Repeatedly find prime numbers
        while (count < num_of_primes) {
            if (isPrime(num, sortedPrimes)) {
                sortedPrimes[count] = num; // add new prime number to sortedPrimes
                count++; // Increase the count
            }
            num++;
        }
        System.out.println(sortedPrimes[0]);

        return sortedPrimes;
    }

    public static void printArray(int[] intArray, int lineLength) {
        for (int i = 0; i < intArray.length; i++) {
            if ((i + 1) % lineLength == 0) {
                System.out.printf("%4d\n", intArray[i]);
            } else {
                System.out.printf("%4d ", intArray[i]);
            }
        }
    }

    public static void run() {
        final int NUMBER_OF_PRIMES = 50; // Number of primes to display
        final int NUMBER_OF_PRIMES_PER_LINE = 10; // Display 10 per line

        int[] sortedPrimes = generateSortedPrimes(NUMBER_OF_PRIMES);

        System.out.printf("The first %d prime numbers are \n\n", NUMBER_OF_PRIMES);

        printArray(sortedPrimes, NUMBER_OF_PRIMES_PER_LINE);
    }

    public static void main(String[] args) {
        run();
    }
}
