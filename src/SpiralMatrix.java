package src;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1,2,3 },
                {4,5,6,},
                { 7,8,9 }
        };

        List<Integer> ans = new ArrayList();
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;

        while(left <= right && top <= bottom){


            for(int i = left; i <= right;i++){
                ans.add(matrix[top][i]);
            }

            top++;

            if (top > bottom) break;
            for(int j = top; j <= bottom;j++){
                ans.add(matrix[j][right]);
            }

            right--;
            if(top > bottom) break;
            for(int j = right;j >= left;j--){
                ans.add(matrix[bottom][j]);
            }

            bottom--;

            if (left > right) break;
            for(int i = bottom; i <= top;i++){
                ans.add(matrix[i][left]);
            }

            left++;

        }
    }
}
