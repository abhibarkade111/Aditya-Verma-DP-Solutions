// Minimum Number of Insertion and Deletion 

// Input: str1 = "heap", str2 = "pea"
// Output: 3
// Explanation: 2 deletions and 1 insertion
// p and h deleted from heap. Then, p is 
// inserted at the beginning One thing to 
// note, though p was required yet it was 
// removed/deleted first from its position 
// and then it is inserted to some other 
// position. Thus, p contributes one to the 
// deletion_count and one to the 
// insertion_count.

// Code

class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    int n = str1.length();
	    int m = str2.length();
	    int dp[][] = new int[n+1][m+1];
	    for(int i=1;i<=n;i++){
	        for(int j=1;j<=m;j++){
	            if(str1.charAt(i-1)==str2.charAt(j-1)){
	                dp[i][j] = 1+ dp[i-1][j-1];
	            }
	            else{
	                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
	            }
	        }
	    }
	    return m+n-2*dp[n][m];
	} 
}