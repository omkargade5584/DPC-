class Day28{
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;  // Empty tree
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }

    // ✅ Example Usage
    public static void main(String[] args) {
        SymmetricTree tree = new SymmetricTree();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);

        System.out.println(tree.isSymmetric(root1)); // true

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);

        System.out.println(tree.isSymmetric(root2)); // false
    }
}
