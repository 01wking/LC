package src.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber_17 {

    static List<String> ans = new ArrayList<>();
    static ArrayList<Character> path = new ArrayList();
    public static void main(String[] args) {
        List<String> ans = new LetterCombinationsofaPhoneNumber_17().letterCombinations("23");

    }
    public List<String> letterCombinations(String digits) {
        Map<Integer,char []> map = new HashMap<>();
        map.put(2,new char[]{'a','b','c'});
        map.put(3,new char[]{'d','e','f'});
        map.put(4,new char[]{'g','h','i'});
        map.put(5,new char[]{'j','k','l'});
        map.put(6,new char[]{'m','n','o'});
        map.put(7,new char[]{'p','q','r','s'});
        map.put(8,new char[]{'t','u','v'});
        map.put(9,new char[]{'w','x','y','z'});

        backTrack(digits,map,0);
        return ans;
    }

    private void backTrack(String digits,Map<Integer,char [] > map,int index){
        if(digits.length() == path.size()){

            ans.add(new String(path.toString()));
            return;
        }
        int num = Integer.valueOf(digits.substring(index,index + 1));
        char [] c = map.get(num);

        for(int i = 0; i < c.length;i++){
            path.add(c[i]);
            backTrack(digits,map,index + 1);
            path.remove(path.size()  - 1);
        }
    }
}
