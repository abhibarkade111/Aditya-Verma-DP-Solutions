// Rod Cutting 
// Input:
// N = 8
// Price[] = {1, 5, 8, 9, 10, 17, 17, 20}
// Output:
// 22
// Explanation:
// The maximum obtainable value is 22 by
// cutting in two pieces of lengths 2 and 
// 6, i.e., 5+17=22.

// Rod Cutting is the standard problem of unounded knapsack
// Same as Unbounded kanpsack

// In Unbounded knapsack we can pick one item more than once their is no restiction

// Code:
// Top Down DP

class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int dp[][] = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i<=j) dp[i][j]= Math.max(price[i-1]+dp[i][j-i], dp[i-1][j]);
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][n];
    }
}