package src;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK_560 {
    public static void main(String[] args) {

    }

    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int sum = 0;
        map.put(0,1);
        for(int i = 0; i < n;i++){
            sum += nums[i];
            map.put(sum,map.getOrDefault(sum,0) + 1);
            ans += map.getOrDefault(sum - k,0);
        }
        return ans;


    }
}
