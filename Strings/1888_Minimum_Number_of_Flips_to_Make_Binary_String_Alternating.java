/*
LeetCode 1888
Minimum Number of Flips to Make the Binary String Alternating

Problem:
Given a binary string s, we can perform two operations:
1. Remove the first character and append it to the end (rotation).
2. Flip any character (0 -> 1 or 1 -> 0).

Return the minimum number of flips required to make the string alternating.

An alternating string is one where no two adjacent characters are equal.

Approach:
1. Double the string (s + s) to simulate all rotations.
2. Create two alternating patterns:
   - Start with '0' -> 010101...
   - Start with '1' -> 101010...
3. Use a sliding window of size n over the doubled string.
4. Count mismatches with both patterns.
5. Track the minimum flips required.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int minFlips(String s) {
        int n = s.length();
        char[] onePattern = new char[2*n];
        char[] zeroPattern = new char[2*n];
        StringBuilder sb = new StringBuilder(s+s);
        int zeroCount = 0;
        int oneCount = 0;
        int ans = Integer.MAX_VALUE;

        for(int i=0; i<2*n; i++)
        {
            if(i%2 == 0)
            {
                zeroPattern[i] = '0';
                onePattern[i] = '1';
            }
            else
            {
                zeroPattern[i] = '1';
                onePattern[i] = '0';
            }
        }

        int i = 0;
        int j = 0;

        while(i < n)
        {
            char ch = sb.charAt(i);
            if(ch != zeroPattern[i])
                zeroCount++;
            else
                oneCount++;
            i++;
        }

        ans = Math.min(oneCount, zeroCount);

        while(i < 2*n)
        {
            char currChar = sb.charAt(i);
            char prevChar = sb.charAt(j);

            if(currChar != zeroPattern[i])
                zeroCount++;
            else
                oneCount++;

            if(prevChar != zeroPattern[j])
                zeroCount--;
            else
                oneCount--;

            ans = Math.min(ans, Math.min(oneCount, zeroCount));

            i++;
            j++;
        }

        return ans;
    }
}
