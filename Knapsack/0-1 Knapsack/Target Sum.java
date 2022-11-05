// Target Sum 
// Input:
// N = 5
// A[] = {1, 1, 1, 1, 1}
// target = 3
// Output:
// 5
// Explanation:
// There are 5 ways to assign symbols to 
// make the sum of nums be target 3.
// -1 + 1 + 1 + 1 + 1 = 3
// +1 - 1 + 1 + 1 + 1 = 3
// +1 + 1 - 1 + 1 + 1 = 3
// +1 + 1 + 1 - 1 + 1 = 3
// +1 + 1 + 1 + 1 - 1 = 3

// Code
// Top Down Dp

class Solution {
    static int findTargetSumWays(int[] a , int n, int target) {
        // code here
        int sum = 0;
        for(int i : a) sum+=i;
        if((sum-target)%2!=0 || target>sum) return 0;
        int s = (sum-target)/2;
        int dp[][] = new int[n+1][s+1];
        dp[0][0]=1;
        // for(int i=0;i<=n;i++) dp[i][0]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=s;j++){
                if(a[i-1]<=j){
                    dp[i][j] = dp[i-1][j-a[i-1]]+dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][s];
    }
};