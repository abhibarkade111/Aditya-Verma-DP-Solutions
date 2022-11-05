// Longest Common Subsequence 
// Input:
// A = 6, B = 6
// str1 = ABCDGH
// str2 = AEDFHR
// Output: 3
// Explanation: LCS for input Sequences
// “ABCDGH” and “AEDFHR” is “ADH” of
// length 3.

// Here as in Knapsack Probblem we see the first the recursive code then memoization and at then Top Down

// 1) Recursive 

class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        if(x==0 || y==0) return 0;
        if(s1.charAt(x-1)==s2.charAt(y-1)) return 1+lcs(x-1, y-1, s1,s2);
        else return Math.max(lcs(x-1,y,s1,s2), lcs(x,y-1,s1,s2));
    }
    
}

// 2) Memoization(Bottom UP Approach)

class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int dp[][] = new int[1002][1002];
    static int findLcs(int x, int y, String s1, String s2){
        if(x==0 || y==0) return 0;
        if(dp[x][y]!=-1) return dp[x][y];
        if(s1.charAt(x-1)==s2.charAt(y-1)) return dp[x][y]=1+findLcs(x-1, y-1, s1,s2);
        else return dp[x][y]=Math.max(findLcs(x-1,y,s1,s2), findLcs(x,y-1,s1,s2));
    }
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        for(int i=0;i<1002;i++) Arrays.fill(dp[i],-1);
        return findLcs(x,y,s1,s2);
   
    }
    
}

// Top Down DP

class Solution
{
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        // Now Top Down Approach
        
        int dp[][] = new int[x+1][y+1];
        for(int i=1;i<=x;i++){
            for(int j=1;j<=y;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[x][y];
   
    }
    
}