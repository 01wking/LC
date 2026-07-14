package src;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {
    static List<String> ans = new ArrayList<>();
    static StringBuilder path = new StringBuilder();
    public static void main(String[] args) {

        GenerateParentheses_22 g = new GenerateParentheses_22();
        System.out.println(g.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        backTrack(n,0,0);
        return ans;
    }

    private void backTrack(int n,int left,int right){
        if(n == left && n == right){
            ans.add(new String(path.toString()));
        }

        if(left > n || right > n){
            return;
        }


        for(int i = 0; i < 2;i++){
            if(i == 0){
                path.append('(');

                backTrack(n,left + 1,right);

                path.deleteCharAt(path.length() - 1);
            }else if(left > right){
                path.append(')');

                backTrack(n,left,right + 1);

                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
