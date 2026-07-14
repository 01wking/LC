package src.hot100;

public class MedianofTwoSortedArrays_4 {
    public static void main(String[] args) {
//        int [] nums1 = {1,2};
//        int [] nums2 = {3,4};
        int [] nums1 = {1,3};
        int [] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int cnt = m + n;

        int index1 = 0;
        int index2 = 0;
        int cur = -1;
        int pre = -1;
        for (int i = 0; i < cnt / 2 + 1; i++) {
            pre = cur;
            if(index1 < n && (index2 >= m || nums1[index1] < nums2[index2])){
                cur = nums1[index1++];
            }else{
                cur = nums2[index2++];
            }
        }

        if(cnt / 2 == 0){
            return (cur + pre) / 2.0;
        }
        return (double)pre;
    }
}
