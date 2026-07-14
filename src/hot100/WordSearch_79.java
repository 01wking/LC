package src.hot100;

public class WordSearch_79 {
    static int [][] dir = new int [][]{{0,-1},{0,1},{-1,0},{1,0}};
    static StringBuilder path = new StringBuilder();
    public static void main(String[] args) {
//        new WordSearch_79().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED");
        
        new WordSearch_79().exist(new char[][]{{'A','B'}}, "AB");
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean [][] used = new boolean [m][n];
        for(int i = 0; i < m;i++){
            for(int j = 0; j < n;j++){
                if(board[i][j] == word.charAt(0)){
                    path.append(board[i][j]);
                    if(backTrack(board,word,used,i,j,1)){
                        return true;
                    }
                }
            }
        }
        return false;

    }

    private boolean backTrack(char [][] board,String word,boolean [][] used,int x,int y,int index){
        if(path.toString().equals(word)){
            return true;
        }

        if(path.length() > word.length()){
            return false;
        }

        for(int i = 0; i < 4;i++){
            int nextX = dir[i][0] + x;
            int nextY = dir[i][1] + y;
            if(nextX >= 0 && nextY >= 0 && nextX < board.length && nextY < board[0].length
                    && !used[nextX][nextY] && board[nextX][nextY] == word.charAt(index)){
                used[nextX][nextY] = true;
                path.append(board[nextX][nextY]);
                if(backTrack(board,word,used,nextX,nextY,index + 1)){
                    return true;
                }
                used[nextX][nextY] = false;
                path.deleteCharAt(path.length() - 1);
            }

        }

        return false;

    }
}
