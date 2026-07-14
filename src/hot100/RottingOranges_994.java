package src.hot100;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges_994 {
    static int ans = Integer.MAX_VALUE;
    static int[][] dir = new int[][] { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
    static int bed = 0;
    static int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
    public static void main(String[] args) {

        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int good = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    good++;
                } else if (grid[i][j] == 2) {
                    bed++;
                    q.add(new int[] { i, j });
                }
            }
        }
        if (bed == 0)
            return -1;
        if (good == 0)
            return 0;
        int sum = bed + good;
        int[][] visited = new int[m][n];

        bfs(grid, visited, bed, q);

        if (bed == sum)
            return ans;
        return -1;

    }

    private static void bfs(int[][] grid,int[][] visited, int bed, Queue<int[]> q) {

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int[] cur = q.poll();
            if (size > 0) {
                for (int i = 0; i < 4; i++) {
                    int nextX = dir[i][0] + cur[0];
                    int nextY = dir[i][1] + cur[1];
                    if (nextX >= 0 && nextY >= 0 && nextX < grid.length && nextY < grid[0].length &&
                            visited[nextX][nextY] == 0 && grid[nextX][nextY] == 1) {
                        visited[nextX][nextY] = 1;
                        bed++;
                        q.add(new int[] { nextX, nextY });
                    }
                }
                size--;
            }
            time++;


        }
        ans = Math.min(ans, time);
    }
}
