package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * <p><b>Depth-First Traversals:</b></p>
 * <ul>
 *     <li>Preorder: Visit the root, then the left subtree, and finally the right subtree.</li>
 *     <li>Inorder: Visit the left subtree, then the root, and finally the right subtree.</li>
 *     <li>Postorder: Visit the left subtree, then the right subtree, and finally the root.</li>
 * </ul>
 *
 * <b>Time Complexity:</b> O(n)  <br>
 * <b>Space Complexity:</b> O(h), where h is the height of the tree (due to recursion stack).
 */
public class DepthFirstTraversal {

    public static List<Integer> preorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private static void preorderHelper(TreeNode node, List<Integer> result) {
        if (node == null)
            return;

        result.add(node.value);
        preorderHelper(node.left, result);
        preorderHelper(node.right, result);
    }

    public static List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private static void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null)
            return;

        inorderHelper(node.left, result);
        result.add(node.value);
        inorderHelper(node.right, result);
    }

    public static List<Integer> postorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private static void postorderHelper(TreeNode node, List<Integer> result) {
        if (node == null)
            return;

        postorderHelper(node.left, result);
        postorderHelper(node.right, result);
        result.add(node.value);
    }
}