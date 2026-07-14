package src.hot100;

public class LongestValidParentheses_32 {
    public static void main(String[] args) {
        longestValidParentheses(")()(((())))(");
    }

    public static int longestValidParentheses(String s) {
        int n = s.length();
        char [] c = s.toCharArray();
        int ans = 0;
        int left = 0;
        int right = 0;
        for(int i = 0; i < n;i++){
            if(c[i] == ')'){
                right++;
            }else{
                left++;
            }
            if(right > left){
                ans = Math.max(left * 2, ans);
                right = 0;
                left = 0;
            }
        }

        left = 0;
        right = 0;
        for(int i = n - 1; i >= 0;i--){
            if(c[i] == ')'){
                right++;
            }else{
                left++;
            }
            if(right < left){
                ans = Math.max(right * 2, ans);
                right = 0;
                left = 0;
            }
        }
        if(left == right){
            ans = Math.max(right * 2,ans);
        }

        return ans;
    }
}
