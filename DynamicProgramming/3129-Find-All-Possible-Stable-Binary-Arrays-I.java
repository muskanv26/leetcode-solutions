/*
Problem: 3129. Find All Possible Stable Binary Arrays I
Link: https://leetcode.com/problems/find-all-possible-stable-binary-arrays-i/

Approach:
Dynamic Programming
Track dp[z][o][last]
*/

class Solution 
{
    static final int MOD = 1000000007;
    public int numberOfStableArrays(int zero, int one, int limit) 
  {
        long[][][] dp = new long[zero + 1][one + 1][2];
        dp[0][0][0] = dp[0][0][1] = 1;
        for (int z = 0; z <= zero; z++) 
        {
            for (int o = 0; o <= one; o++) 
            {
                for (int k = 1; k <= limit; k++) 
                {
                    if (z - k >= 0)
                        dp[z][o][0] = (dp[z][o][0] + dp[z - k][o][1]) % MOD;
                    if (o - k >= 0)
                        dp[z][o][1] = (dp[z][o][1] + dp[z][o - k][0]) % MOD;
                }
            }
        }
        return (int)((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}
