package trees;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LowestCommonAncestorTest {
    @DisplayName("Lowest Common Ancestor")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideLCATestCases")
    void testFindLCA(String name, TreeNode root, int value1, int value2, Integer expected) {
        TreeNode result = LowestCommonAncestor.findLCA_NotExist(root, value1, value2);
        assertEquals(expected, result != null ? result.value : null);
    }

    static Stream<Arguments> provideLCATestCases() {
        return Stream.of(
                Arguments.of("LCA of balanced tree", createTree(new int[]{50, 30, 70, 20, 40, 60, 80}), 20, 40, 30),
                Arguments.of("LCA of root", createTree(new int[]{50, 30, 70, 20, 40}), 30, 70, 50),
                Arguments.of("LCA of null tree", null, 20, 40, null),
                Arguments.of("LCA with one node not in tree", createTree(new int[]{50, 30, 70, 20, 40}), 20, 100, null)
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
