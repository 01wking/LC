package src.hot100;

public class PerfectSquares_279 {
    public static void main(String[] args) {
        new PerfectSquares_279().numSquares(12);
    }
    public int numSquares(int n) {
        int k = 1;
        while(k * k < n){
            k++;
        }

        int [][] dp =new int [k - 1][n + 1];

        for(int j = 0; j < n + 1;j++){
            dp[0][j] = j % 1;
        }

        for(int i = 1; i < k - 1; i ++){
            int num = (i + 1) * (i + 1);
            for(int j = 1;j < n + 1;j++){

                if(j >= num){
                    dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - num] + 1);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[k - 2][n];
    }
}
