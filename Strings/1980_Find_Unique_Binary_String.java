/*
Problem: 1980. Find Unique Binary String
Platform: LeetCode
Topic: Strings

Approach:
We use Cantor's Diagonal Trick to construct a unique binary string.
For each index i, we check the i-th character of nums[i] and flip it.

If nums[i][i] = '0' → we add '1'
If nums[i][i] = '1' → we add '0'

This guarantees that the generated string differs from every
string in the array at least at one position.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < nums.length; i++) 
        {
            if(nums[i].charAt(i) == '0')
                ans.append('1');
            else
                ans.append('0');
        }
        return ans.toString();
    }
}
