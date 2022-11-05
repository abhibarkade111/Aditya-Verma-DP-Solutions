// Equal Sum Partion 
// Input: N = 4
// arr = {1, 5, 11, 5}
// Output: YES
// Explanation: 
// The two parts are {1, 5, 5} and {11}.

// Top Down Solution

class Solution{
    static int equalPartition(int n, int arr[])
    {
        // code here
        int sum = 0;
        for(int i : arr) sum+=i;
        if(sum%2==1) return 0;
        int target = sum/2;
        boolean dp[][] = new boolean[n+1][target+1];
        for(int j=0;j<=target;j++) dp[0][j] = false;
        for(int i=0;i<=n;i++) dp[i][0] = true;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        if(dp[n][target]) return 1;
        return 0;
    }
}