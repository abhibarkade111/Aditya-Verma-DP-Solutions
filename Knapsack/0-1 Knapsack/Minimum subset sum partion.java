// Minimum subset sum Partion
// Input: N = 4, arr[] = {1, 6, 11, 5} 
// Output: 1
// Explanation: 
// Subset1 = {1, 5, 6}, sum of Subset1 = 12 
// Subset2 = {11}, sum of Subset2 = 11 

// Code :
// Top Down DP

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes 
	    int sum = 0;
	    for(int i : arr) sum+=i;
	    int range = sum/2;
	    int ans = sum;
	    boolean dp[][] = new boolean[n+1][range+1];
	    for(int j=0;j<=range;j++) dp[0][j] = false;
	    for(int i=0;i<=n;i++) dp[i][0] = true;
	    for(int i=1;i<=n;i++){
	        for(int j=1;j<=range;j++){
	            if(arr[i-1]<=j){
	                dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
	            }
	            else{
	                dp[i][j] = dp[i-1][j];
	            }
	            if(dp[i][j]){
	                ans = sum - 2*j;
	            }
	        }
	    }
	    return ans;
	} 
}
