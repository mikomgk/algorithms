package searching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {
    @DisplayName("Binary Search")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideBinarySearchTestCases")
    void testBinarySearch(String name, int[] input, int target, int expected) {
        assertEquals(expected, BinarySearch.binarySearch(input, target));
    }

    static Stream<Arguments> provideBinarySearchTestCases() {
        return Stream.of(
                Arguments.of("Target in middle", new int[]{2, 3, 4, 10, 40}, 10, 3),
                Arguments.of("Target not found", new int[]{2, 3, 4, 10, 40}, 5, -1),
                Arguments.of("Single element (found)", new int[]{1}, 1, 0),
                Arguments.of("Single element (not found)", new int[]{1}, 5, -1),
                Arguments.of("Empty array", new int[]{}, 10, -1),
                Arguments.of("Null array", null, 10, -1)
        );
    }
}
