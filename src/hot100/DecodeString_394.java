package src.hot100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DecodeString_394 {
    public static void main(String[] args) {
        System.out.println(decodeString("100[leetcode]"));

    }

    public static String decodeString(String s) {
        int n = s.length();
        char [] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < n;i++){
            if(c[i] != ']'){
                stack.push(c[i]);
            }else{
                List<Character> list = new ArrayList<>();
                while(!stack.isEmpty() && stack.peek() != '['){
                    list.add(stack.pop());
                }
                Collections.reverse(list);

                stack.pop();

                StringBuilder num = new StringBuilder();
                while(!stack.isEmpty() && stack.peek() < '9' && stack.peek() >= '0'){
                    num.append(stack.pop());
                }

                int val = Integer.valueOf(num.toString());


                List<Character> path = new ArrayList<>();
                while(val > 0){
                    for(Character x : list){
                        path.add(x);
                    }
                    val--;
                }

                for(Character x : path){
                    stack.push(x);
                }
            }

        }

        List<Character> ans = new ArrayList<>();
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        StringBuilder result = new StringBuilder();
        Collections.reverse(ans);
        for(Character x : ans){
            result.append(x);
        }
        return result.toString();
    }
}
