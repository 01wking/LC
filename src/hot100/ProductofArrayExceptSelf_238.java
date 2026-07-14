package src.hot100;

import java.util.Arrays;

public class ProductofArrayExceptSelf_238 {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        System.out.println(productExceptSelf(nums));
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] ans = new int [n];
        Arrays.fill(ans,1);
        int cur = nums[0];
        for(int i = 1; i < n;i++){
            ans[i] = cur;
            cur *= nums[i];
        }

        cur = nums[n - 1];
        for(int i = n - 2;i >= 0;i--){
            ans[i] *= cur;
            cur *= nums[i];
        }
        return ans;
    }

}
