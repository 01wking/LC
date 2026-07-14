package src.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queens_51 {
    List<List<String>> ans = new ArrayList<>();
    public static void main(String[] args) {
        N_Queens_51 n = new N_Queens_51();
        System.out.println(n.solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        char [][] c = new char [n][n];
        for(int i = 0; i < n;i++){
            Arrays.fill(c[i],'.');
        }
        backtrack(0,0,c);
        return ans;

    }

    private void backtrack(int row,int col,char [][] c){
        if(row == c.length){
            ans.add(array2List(c));
            return;
        }

        for(int i = 0; i < c.length;i++){
            if(is(row,i,c)){
                c[row][i] = 'Q';
                backtrack(row + 1, 0,c);
                c[row][i] = '.';
            }
        }
    }

    private boolean is(int row,int col,char [][] c){

        //
        for(int j = 0; j < col;j++){
            if(c[row][j] == 'Q') return false;
        }
        //45
        for(int i = row - 1,j = col - 1;i >= 0 && j >= 0;i--,j--){
            if(c[row][col] == 'Q') return false;
        }

        //135
        for(int i = row - 1,j = 0;i >= 0 && j < col;i--,j++){
            if(c[row][col] == 'Q') return false;
        }
        return true;
    }

    private List<String> array2List(char [][] c){
        List<String> path = new ArrayList<>();

        int n = c.length;
        for(int i = 0; i < n;i++){
            StringBuilder s = new StringBuilder();
            for(int j = 0; j < n;j++){
                s.append(c[i][j]);
            }
            path.add(s.toString());
        }
        return path;
    }
}
