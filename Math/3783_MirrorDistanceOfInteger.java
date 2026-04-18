/**
 * 3783. Mirror Distance of an Integer
 *
 * Approach:
 * - Reverse the digits of the number
 * - Compute absolute difference between original and reversed number
 *
 * Key Insight:
 * - Each iteration removes one digit → total iterations = number of digits
 * - Number of digits in n = log10(n)
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }

    private int reverse(int n) {
        int rev = 0;

        while (n > 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        }

        return rev;
    }
}

// Pattern: Digit Manipulation
// Similar Problems:
// - Reverse Integer
// - Palindrome Number
