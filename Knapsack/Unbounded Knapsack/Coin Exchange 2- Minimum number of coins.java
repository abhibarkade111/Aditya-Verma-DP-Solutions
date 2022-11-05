// Coin Exchange 2- Minimum number of coins
// Input: V = 30, M = 3, coins[] = {25, 10, 5}
// Output: 2
// Explanation: Use one 25 cent coin
// and one 5 cent coin

// Code
// Top Down DP

class Solution{

	public int minCoins(int coins[], int m, int v) 
	{ 
	    // Your code goes here
	    int dp[][] = new int[m+1][v+1];
	    for(int j=0;j<=v;j++) dp[0][j]=Integer.MAX_VALUE;
	    for(int i=0;i<=m;i++) dp[i][0] = 0;
	    for(int j=1;j<=v;j++){
	        if(j%coins[0]==0) dp[1][j] = j/coins[0];
	        else dp[1][j] = Integer.MAX_VALUE-1;
	    }
	    for(int i=2;i<=m;i++){
	        for(int j=1;j<=v;j++){
	            if(coins[i-1]<=j){
	                dp[i][j] = Math.min(dp[i][j-coins[i-1]]+1, dp[i-1][j]);
	            }
	            else{
	                dp[i][j] = dp[i-1][j];
	            }
	        }
	    }
	    return dp[m][v]==Integer.MAX_VALUE-1?-1:dp[m][v];
	} 
}