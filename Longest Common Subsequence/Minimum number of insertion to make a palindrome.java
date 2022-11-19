// Minimum number of insertion to make the Palindrome 
// Input: str = "abcd"
// Output: 3
// Explanation: Inserted character marked
// with bold characters in dcbabcd

// Code: 


class Solution{
    static int countMin(String str1)
    {
        // code here
        String str2 = new StringBuilder(str1).reverse().toString();
        int n = str1.length();
        int dp[][] = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return n-dp[n][n];
    }
}