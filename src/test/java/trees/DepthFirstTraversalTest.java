package trees;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepthFirstTraversalTest {
    @DisplayName("Depth-First Traversal")
    @ParameterizedTest(name = "{0} - Preorder")
    @MethodSource("providePreorderTestCases")
    void testPreorderTraversal(String name, TreeNode root, List<Integer> expected) {
        assertEquals(expected, DepthFirstTraversal.preorder(root));
    }

    @DisplayName("Depth-First Traversal")
    @ParameterizedTest(name = "{0} - Inorder")
    @MethodSource("provideInorderTestCases")
    void testInorderTraversal(String name, TreeNode root, List<Integer> expected) {
        assertEquals(expected, DepthFirstTraversal.inorder(root));
    }

    @DisplayName("Depth-First Traversal")
    @ParameterizedTest(name = "{0} - Postorder")
    @MethodSource("providePostorderTestCases")
    void testPostorderTraversal(String name, TreeNode root, List<Integer> expected) {
        assertEquals(expected, DepthFirstTraversal.postorder(root));
    }

    static Stream<Arguments> providePreorderTestCases() {
        return Stream.of(
                Arguments.of("Balanced tree", createTree(new int[]{50, 30, 70, 20, 40, 60, 80}), List.of(50, 30, 20, 40, 70, 60, 80)),
                Arguments.of("Single node tree", new TreeNode(10), List.of(10)),
                Arguments.of("Empty tree", null, List.of())
        );
    }

    static Stream<Arguments> provideInorderTestCases() {
        return Stream.of(
                Arguments.of("Balanced tree", createTree(new int[]{50, 30, 70, 20, 40, 60, 80}), List.of(20, 30, 40, 50, 60, 70, 80)),
                Arguments.of("Single node tree", new TreeNode(10), List.of(10)),
                Arguments.of("Empty tree", null, List.of())
        );
    }

    static Stream<Arguments> providePostorderTestCases() {
        return Stream.of(
                Arguments.of("Balanced tree", createTree(new int[]{50, 30, 70, 20, 40, 60, 80}), List.of(20, 40, 30, 60, 80, 70, 50)),
                Arguments.of("Single node tree", new TreeNode(10), List.of(10)),
                Arguments.of("Empty tree", null, List.of())
        );
    }

    private static TreeNode createTree(int[] input) {
        if (input == null) return null;
        TreeNode root = null;
        for (int value : input) {
            root = BinarySearchTreeOperations.insert(root, value);
        }
        return root;
    }
}
