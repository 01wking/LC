package src.hot100;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII_437 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static Map<Integer,Integer> map = new HashMap<>();
    static int ans = 0;
    public static void main(String[] args) {
        System.out.println(pathSum(new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))), new TreeNode(-3, null, new TreeNode(11))), 8));
    }

    public static int pathSum(TreeNode root, int targetSum) {
        map.put(0,1);
        dfs(root,targetSum,0);
        return ans;
    }

    private static void dfs(TreeNode root,int targetSum,int sum){
        if(root == null) return ;

        sum += root.val;
        ans += map.getOrDefault(sum - targetSum,0);
        map.put(sum,map.getOrDefault(sum,0) + 1);


        dfs(root.left,targetSum,sum);
        dfs(root.right,targetSum,sum);

        if(map.getOrDefault(sum,0) > 0){
            map.put(sum,map.getOrDefault(sum,0) - 1);
        }else{
            map.remove(sum);
        }


    }
}
