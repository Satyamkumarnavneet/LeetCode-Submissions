class Solution {
public:
    int calculateMinimumHP(vector<vector<int>>& dungeon) {
        int n = dungeon.size(), m = dungeon[0].size();
        vector<int> dp(m+1, INT_MAX);
        dp[m] = 1;
        dp[m-1] = 1;

        for(int i=n-1; i>=0; i--) {
            if(i == n-2) dp[m] = INT_MAX;
            
            for(int j=m-1; j>=0; j--) {
                int need = min(dp[j], dp[j+1]) - dungeon[i][j];
                dp[j] = need <= 0 ? 1 : need;
            }
        }
        
        return dp[0];
    }
};