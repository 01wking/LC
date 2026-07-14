package src.hot100;

public class FindtheDuplicateNumber_287 {
    public static void main(String[] args) {
        System.out.println(new FindtheDuplicateNumber_287().findDuplicate(new int[]{1,3,4,2,2}));
    }

    public int findDuplicate(int[] nums) {
        int n = nums.length;

        int slow = 0;
        int fast = 0;

        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast){
                break;
            }
        }

        int cur = 0;
        while(cur != slow){
            cur = nums[cur];
            slow = nums[slow];
        }
        return cur;
    }
}
