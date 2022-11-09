// Print LCS 
// Input: s = abaaa, t = baabaca
// Output: aaaa abaa baaa

// Code

class Solution
{
    List<Character> temp  = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    HashSet<String> hs= new HashSet<>();
    
    public List<String> all_longest_common_subsequences(String s, String t)
    {
        // Code here
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        
        int len = dp[n][m];
        findAllSeq(s,t,0,0,n,m,len);
        Collections.sort(ans);
        return ans;
    }
    
    public void findAllSeq(String s, String t, int i, int j,int n, int m, int len){
        if(len==0){
            StringBuilder sb= new StringBuilder();
            for(int k=0;k<temp.size();k++){
                sb.append(temp.get(k));
            }
            String str = sb.toString();
            if(!hs.contains(str)){
              ans.add(str);
              hs.add(str);
            }
            return;
        }
        for(int r=i;r<n;r++){
            for(int l=j;l<m;l++){
                if(s.charAt(r)==t.charAt(l)){
                    temp.add(s.charAt(r));
                    findAllSeq(s,t,r+1,l+1,n,m,len-1);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
}