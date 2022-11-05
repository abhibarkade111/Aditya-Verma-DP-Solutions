// Susbset Sum Problem
// Input:
// N = 6
// arr[] = {3, 34, 4, 12, 5, 2}
// sum = 9
// Output: 1 
// Explanation: Here there exists a subset with
// sum = 9, 4+3+2 = 9.

// Code:

// Top Down DP Solution

class Solution{

    static Boolean isSubsetSum(int n, int arr[], int sum){
        // code here
        boolean dp[][] = new boolean[n+1][sum+1];
        for(int j=0;j<=sum;j++) dp[0][j]= false;
        for(int i=0;i<=n;i++) dp[i][0] = true; 
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}

// Bottom Up DP Solution

class Solution{

    static boolean dp[][] = new boolean[102][100002];
    static Boolean isSubsetSum(int n, int arr[], int sum){
        // code here
        if(sum==0) return true;
        if(n==0) return false;
        if(dp[n][sum]!=false) return true;
        if(sum-arr[n-1]>=0){
            return dp[n][sum]=isSubsetSum(n-1,arr,sum-arr[n-1]) || isSubsetSum(n-1,arr,sum);
        }
        else return dp[n][sum]=isSubsetSum(n-1,arr,sum);
       }
}