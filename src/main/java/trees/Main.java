package trees;

public class Main {
    public static void main(String[] args) {
        // Initialize the root of the tree
        TreeNode root = null;

        // Insert nodes into the Binary Search Tree (BST)
        root = BinarySearchTreeOperations.insert(root, 50);
        root = BinarySearchTreeOperations.insert(root, 30);
        root = BinarySearchTreeOperations.insert(root, 70);
        root = BinarySearchTreeOperations.insert(root, 20);
        root = BinarySearchTreeOperations.insert(root, 40);
        root = BinarySearchTreeOperations.insert(root, 60);
        root = BinarySearchTreeOperations.insert(root, 80);

        // Display the tree's traversals
        System.out.println("Preorder Traversal: " + DepthFirstTraversal.preorder(root));
        System.out.println("Inorder Traversal: " + DepthFirstTraversal.inorder(root));
        System.out.println("Postorder Traversal: " + DepthFirstTraversal.postorder(root));
        System.out.println("Level Order Traversal: " + BreadthFirstTraversal.levelOrder(root));

        // Search for a value in the BST
        int searchValue = 40;
        boolean found = BinarySearchTreeOperations.search(root, searchValue);
        System.out.println("Search for " + searchValue + ": " + (found ? "Found" : "Not Found"));

        // Delete a node from the BST
        int deleteValue = 30;
        root = BinarySearchTreeOperations.delete(root, deleteValue);
        System.out.println("Inorder Traversal after deleting " + deleteValue + ": " + DepthFirstTraversal.inorder(root));

        // Find the Lowest Common Ancestor (LCA) of two values
        int value1 = 20, value2 = 70;
        TreeNode lca = LowestCommonAncestor.findLCA(root, value1, value2);
        if (lca != null) {
            System.out.println("LCA of " + value1 + " and " + value2 + ": " + lca.value);
        } else {
            System.out.println("LCA not found (one or both nodes not present in the tree).");
        }

        // Calculate the height of the tree
        int height = TreeHeight.getHeight(root);
        System.out.println("Height of the tree: " + height);
    }
}