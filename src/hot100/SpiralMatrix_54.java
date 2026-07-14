package src.hot100;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4 },
                {5,6,7,8},
                {9,10,11,12}
        };

        List<Integer> ans = new ArrayList();
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;

        while(top <= bottom && left <= right){

            for(int j = left; j <= right;j++){
                ans.add(matrix[top][j]);
            }
            top++;

            if(bottom < top) break;
            for(int i = top; i <= bottom;i++){
                ans.add(matrix[i][right]);
            }
            right--;

            if(right < left) break;
            for(int j = right; j >= left;j--){
                ans.add(matrix[bottom][j]);
            }
            bottom--;

            if(bottom < top) break;
            for(int i = bottom; i >= top;i--){
                ans.add(matrix[i][left]);
            }
            left++;
        }
    }
}
