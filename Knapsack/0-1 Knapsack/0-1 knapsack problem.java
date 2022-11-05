// 0-1 knapsack Problem 
// We see the three solutions 1) Recursive Solution
//                            2) Recursive + Memoization (Bottom Up DP)
//                            3) Top Down DP 

// 1) Recursive Solution
// As In 0-1 kanpasack we have choice to pick or not pick the item so according we select item or not select the item and find the maximu profit

// See the Detailed Explation in Notebook

// Here is the Recursive Code

static int findKanpSackSol(int W, int wt[], int val[], int n){
    if(n==0 || W==0) return 0;
    if(wt[n-1]<=W){
        return Math.max(val[n-1]+ findKanpSackSol(W-wt[n-1],wt,val,n-1), findKanpSackSol(W,wt,val,n-1));
    }
    else{
        return findKanpSackSol(W,wt,val,n-1);
    }  
}

// 2) Recursive + Memoization (Bottom Up DP)
// As We see that the recursive solution gives us TLE Because it calculates repeted value for same subproblems so avoiding this we do the memoization
// Need some small change in the recursive solution

static int dp[][] = new int[1002][1002];
static int findKanpSackSol(int W, int wt[], int val[], int n){
     if(n==0 || W==0) return 0;
     if(dp[n][W]!=-1) return dp[n][W];
     if(wt[n-1]<=W){
         return dp[n][W]=Math.max(val[n-1]+ findKanpSackSol(W-wt[n-1],wt,val,n-1), findKanpSackSol(W,wt,val,n-1));
     }
     else{
         return dp[n][W]=findKanpSackSol(W,wt,val,n-1);
     }  
}


// 3) Top-Down Dp 
// As recursive + memoization get the same time to the run the code but recursive solution require a stack space so we use Top Down DP

static int knapSack(int W, int wt[], int val[], int n) 
{ 
    
    //Now Top Down Approach
    
    int dp[][] = new int[n+1][W+1];
    for(int i=1;i<=n;i++){
        for(int j=1;j<=W;j++){
            if(wt[i-1]<=j){
                dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
            }
            else{
                dp[i][j] = dp[i-1][j];
            }
        }
    }
    return dp[n][W];
}

    