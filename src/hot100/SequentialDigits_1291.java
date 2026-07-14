package src.hot100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits_1291 {
    public static void main(String[] args) {
        System.out.println(sequentialDigits(122, 300));
    }

    public static List<Integer> sequentialDigits(int low, int high) {
//        List<Integer> ans = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();


        for(int i = 1; i <= 9;i++){
            int x = i;
            for(int d = i; x <= high && d <= 9;d++){
                if(x >= low){
                    ans.add(x);
                }
                x = x * 10 + d + 1;
            }
        }
        Collections.sort(ans);
        return ans;

//        for(int i = low + 1; i < high;i++){
//            if(check(i)){
//                ans.add(i);
//            }
//        }
//        return ans;

    }

    private static boolean check(int i){
        int val = i;
        int pre = -1;
        while(val > 0){
            if(pre != -1 && pre - 1 != val % 10){
                return false;
            }
            pre = val % 10;
            val = val / 10;

        }
        return true;
    }
}
