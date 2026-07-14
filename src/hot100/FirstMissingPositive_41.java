package src.hot100;

public class FirstMissingPositive_41 {
    public static void main(String[] args) {
        int[] nums = {-1,4,2,1,9,10};
        firstMissingPositive(nums);

    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n;i++){
//            int index = nums[i]; 不能拿出来，不然while循环中还是上次index
            while (nums[i] > 0 && nums[i] < n && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        int index = 0;
        while (index < n) {
            if (nums[index] != index + 1) {
                return index + 1;
            }
            index++;
        }
        return n + 1;
    }
}
