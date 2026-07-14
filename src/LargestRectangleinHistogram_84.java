package src;

import java.util.Stack;

public class LargestRectangleinHistogram_84 {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,2}));

    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int [] arr = new int [n + 2];
        for(int i = 0; i < n;i++){
            arr[i + 1] = heights[i];
        }
        arr[0] = 0;
        arr[n + 1] = 0;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n + 2;i++){

            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                int r = i;
                int h = arr[stack.pop()];
                int l = stack.peek();
                int len = r - l - 1;

                ans = Math.max(ans,len * h);
            }
            stack.push(i);
        }
        return ans;
    }
}

