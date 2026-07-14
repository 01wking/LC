package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
    public static void main(String[] args) {
        int [] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int n = nums.length;

        List<List<Integer>> ans = new ArrayList();

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {

            if (nums[i] > 0)
                continue;

            while (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(new ArrayList(Arrays.asList(new Integer[] { nums[i], nums[l], nums[r] })));

                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }

        }
    }
}
