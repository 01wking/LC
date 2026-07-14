package src.hot100;

public class ProductofArrayExceptSelf_238 {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        System.out.println(productExceptSelf(nums));
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] ans = new int [n];
        ans[0] = 1;
        ans[n - 1] = 1;
        int num = 1;
        for(int i = 1; i < n;i++){
            num *= nums[i - 1];
            ans[i] = num;
        }
        num = 1;
        for(int j = n - 2; j >= 0;j--){
            num *= nums[j + 1];
            ans[j] *= num;
        }

        return ans;
    }

}
