package src;

public class LongestPalindromicSubstring_5 {
    public static void main(String[] args) {

    }
    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean [][] dp = new boolean [n][n];
        int start = 0;
        int end = 0;
        int ans = 0;
        for(int i = n - 1; i >= 0;i--){
            for(int j = i; j < n;j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i <= 1){
                        dp[i][j] = true;
                        if(j - i  > ans){
                            start = i;
                            end = j;
                            ans = end - start;

                        }
                    }else if(dp[i + 1][j - 1]){
                        dp[i][j] = true;
                        if(j - i  > ans){
                            start = i;
                            end = j;
                            ans = end - start;

                        }
                    }
                }
            }
        }
        return s.substring(start,start + ans + 1);
    }
}
