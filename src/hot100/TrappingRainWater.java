package src.hot100;

import java.util.LinkedList;
import java.util.Stack;

public class TrappingRainWater {
    public static void main(String[] args) {
//        int[] height = new int[]{4,2,0,3,2,5};
//        int ans = 0;
//        int n = height.length;
//
//        //递减
//        Stack<Integer> stack = new Stack<Integer>();
//
//        stack.push(0);
//
//        for (int i = 1; i < n; i++) {
//            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
//                int num = stack.pop();
//                if(!stack.isEmpty()){
//                    int h = Math.min(height[stack.peek()], height[i]) - num;
//                    int l = (i - stack.peek() - 1);
//                    ans += h * l;
//                }
//
//            }
//            stack.push(i);

//        }
        int[] height = new int[]{4,2,0,3,2,5};
        int ans = trap(height);
        System.out.println(ans);
    }

    public static int trap(int[] height) {
        int n = height.length;
        int[] lMax = new int[n];
        int[] rMax = new int[n];

        int max = height[0];
        for (int i = 0; i < n; i++) {
            lMax[i] = max;
            max = Math.max(max, height[i]);
        }
        max = height[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            rMax[i] = max;
            max = Math.max(max, height[i]);
        }
        int ans = 0;
        for(int i = 0; i < n;i++){
            int h = Math.min(rMax[i],lMax[i]) - height[i];

            ans += h;
        }
        return ans;

    }


}
