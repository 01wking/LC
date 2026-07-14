package src.hot100;

public class FirstMissingPositive_41 {
    public static void main(String[] args) {
        int[] nums = { 3,4,-1,1};
        firstMissingPositive(nums);

    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        int i = 0;
        while(i < n){
            while(nums[i] != i + 1){
                if(nums[i] < 1 || nums[i] > n - 1){
                    break;
                }
                int tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[nums[i] - 1] = tmp;
            }
            i++;
        }
        for(i = 0; i < n;i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return 0;
    }
}
