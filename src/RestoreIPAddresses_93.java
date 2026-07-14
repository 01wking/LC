package src;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses_93 {
    static List<String> ans = new ArrayList<>();
    static List<String> path = new ArrayList<>();
    public static void main(String[] args) {
        backtrack(0, "25525511135");
        System.out.println(ans);
    }

    private static void backtrack(int index,String s){
        if(path.size() == 4 && index == s.length()){
            ans.add(String.join(".", path));
            return;
        }

        for(int i = index; i < s.length() && i - index < 3;i++){
            String c = s.substring(index,i + 1);
            if(voletid(c)){
                path.add(c);
                backtrack(i + 1,s);
                path.remove(path.size() - 1);
            }
        }
    }

    private static boolean voletid(String s){
        if((s.charAt(0) == '0' && s.length() > 1) || Integer.valueOf(s) > 255){
            return false;
        }
        return true;
    }

}
