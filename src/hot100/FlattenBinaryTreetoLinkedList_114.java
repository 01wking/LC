package src.hot100;

public class FlattenBinaryTreetoLinkedList_114 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        new FlattenBinaryTreetoLinkedList_114().flatten(root);
    }
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode cur = root;
        while (cur.right != null){
            cur = cur.right;
        }
        cur.right = tmp;
        flatten(root.right);


    }
}
