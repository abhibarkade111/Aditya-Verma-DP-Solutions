// Minimum number of deletions
// Input: n = 7, str = "aebcbda"
// Output: 2
// Explanation: We'll remove 'e' and
// 'd' and the string become "abcba".

// Code:

class Solution 
{ 
    int minDeletions(String str, int n)
    {
        // code here
        int dp[][] = new int[n+1][n+1];
        String rev = new StringBuilder(str).reverse().toString();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(str.charAt(i-1)==rev.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return n - dp[n][n];
    }
} 