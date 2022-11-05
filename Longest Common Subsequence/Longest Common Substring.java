// Longest Common Substring
// Input: S1 = "ABCDGH", S2 = "ACDGHR", n = 6, m = 6
// Output: 4
// Explanation: The longest common substring
// is "CDGH" which has length 4.

// This is problem is similar to the LCS Problem just change is need to find the substring so if letters are not equal then insetad of max initiliaze to the zero
// Code 
// Top Down

class Solution{
    int longestCommonSubstr(String s1, String s2, int n, int m){
        // code here
        int ans=0;
        int dp[][]= new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j]=0;
                ans = Math.max(dp[i][j],ans);
            }
        }
        return ans;
    }
}