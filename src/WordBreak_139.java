package src;

import java.util.List;

public class WordBreak_139 {
    public static void main(String[] args) {
        wordBreak("leetcode", List.of("leet", "code"));

    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean [] dp = new boolean [n + 1];

        dp[0] = true;

        for(int i = 1; i < n + 1;i++){
            for(String x : wordDict){
                int len = x.length();
                if(i >= len && dp[i - len] && x.equals(s.substring(i - len,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
