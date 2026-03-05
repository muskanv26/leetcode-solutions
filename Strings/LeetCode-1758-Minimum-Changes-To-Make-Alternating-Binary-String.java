/*
LeetCode 1758
Minimum Changes to Make Alternating Binary String

Problem:
Given a binary string s, return the minimum number of character changes required
to make the string alternating.

An alternating string is one where no two adjacent characters are the same.

Approach:
We check two possible patterns:
1. Start with '0' -> 010101...
2. Start with '1' -> 101010...

We count mismatches for both patterns and return the minimum.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution 
{
    public int minOperations(String s) 
  {
        int start0 = 0;
        int start1 = 0;
        for(int i = 0; i < s.length(); i++) 
        {
            if(i % 2 == 0) 
            {
                if(s.charAt(i) != '0') 
                  start0++;
                if(s.charAt(i) != '1') 
                  start1++;
            } 
            else 
            {
                if(s.charAt(i) != '1') 
                  start0++;
                if(s.charAt(i) != '0') 
                  start1++;
            }
        }
        return Math.min(start0, start1);
    }
}
