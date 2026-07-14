package src;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        int n = 4;
        char [][] c  = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = '.';
            }
        }
        c[0][0] = 'Q';
        c[1][2] = 'Q';
        c[2][1] = 'Q';

        System.out.println(array2List(c));


    }
    private static List<String> array2List(char [][] c){
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
