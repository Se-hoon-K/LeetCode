import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q2523 {
    // Given two positive integers left and right, find the two integers num1 and num2 such that:
    // left <= num1 < num2 <= right .
    // Both num1 and num2 are prime numbers.
    // num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.
    // Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions, return the one with the smallest num1 value. If no such numbers exist, return [-1, -1].


    /* In order to find the prime numbers, studied the Sieve of Eratoshtenes.
     * Time complexity of this algorithm is O(N*log(log(N)))
     * Although implemented to find the answer, further study on algoritm is required.
     */
    
    public int[] closestPrimes(int left, int right) {
        boolean[] prime = new boolean[right + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int p = 2; p * p <= right; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= right; i += p)
                    prime[i] = false;
            }
        }

        List<Integer> primesList = new ArrayList<>();
        for (int i = Math.max(left, 2); i <= right; i++) {
            if (prime[i]) primesList.add(i);
        }

        if (primesList.size() < 2) return new int[]{-1, -1};

        int minDiff = Integer.MAX_VALUE;
        int num1 = -1, num2 = -1;

        for (int i = 1; i < primesList.size(); i++) {
            int diff = primesList.get(i) - primesList.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                num1 = primesList.get(i - 1);
                num2 = primesList.get(i);
            }
        }
        return new int[]{num1, num2};
    }
}
