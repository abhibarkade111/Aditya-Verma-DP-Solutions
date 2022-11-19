// Longest Palindromic Subsequence 
// Input:
// S = "bbabcbcab"
// Output: 7
// Explanation: Subsequence "babcbab" is the
// longest subsequence which is also a palindrome.

// Code 

// class Solution
// {
//     public int longestPalinSubseq(String S)
//     {
//         //code here
//         int n = S.length();
//         String Rev = new StringBuilder(S).reverse().toString();
//         int dp[][] = new int[n+1][n+1];
//         for(int i=1;i<=n;i++){
//             for(int j=1;j<=n;j++){
//                 if(S.charAt(i-1)==Rev.charAt(j-1)){
//                     dp[i][j] = 1+dp[i-1][j-1];
//                 }
//                 else{
//                     dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
//                 }
//             }
//         }
//         return dp[n][n];
//     }
// }