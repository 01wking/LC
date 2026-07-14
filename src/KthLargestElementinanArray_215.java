package src;

import java.util.Random;

public class KthLargestElementinanArray_215 {
    public static void main(String[] args) {
        int[] nums = { 3,2,1,5,6,4 };

        new KthLargestElementinanArray_215().findKthLargest(nums, 2);
    }
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;

        int target = n - k;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int index = qsort(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index > target) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
        return 0;

    }

    private int qsort(int[] nums, int left, int right) {
        int random = new Random().nextInt(right - left + 1);
        int privote = left + random;
        int val = nums[privote];

        int tmp = nums[left];
        nums[left] = val;
        nums[privote] = tmp;

        int l = left;
        int r = right;
        while(l < r){
            while(l < r && nums[r] > val){
                r--;
            }
            nums[l] = nums[r];
            while(l < r && nums[l] < val){
                l++;
            }
            nums[r] = nums[l];
        }

        nums[l] = val;
        return l;

    }
}
