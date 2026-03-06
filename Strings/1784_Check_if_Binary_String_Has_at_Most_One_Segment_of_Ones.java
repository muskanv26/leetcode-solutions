/*
Problem: 1784. Check if Binary String Has at Most One Segment of Ones
Platform: LeetCode
Link: https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/

Approach:
Traverse the string and check if '1' appears after a '0'.
If that happens, it means a new segment of ones started.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public boolean checkOnesSegment(String s) {
        for(int i = 1; i < s.length(); i++) 
        {
            if(s.charAt(i) == '1' && s.charAt(i-1) == '0')
                return false;
        }
        return true;
    }
}
