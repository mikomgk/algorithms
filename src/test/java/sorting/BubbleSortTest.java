package sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BubbleSortTest {
    @DisplayName("Bubble Sort")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideBubbleSortTestCases")
    void testBubbleSort(String name, int[] input, int[] expected) {
        BubbleSort.bubbleSort(input);
        assertArrayEquals(expected, input);
    }

    static Stream<Arguments> provideBubbleSortTestCases() {
        return Stream.of(
                Arguments.of("Random order", new int[]{64, 34, 25, 12, 22, 11, 90}, new int[]{11, 12, 22, 25, 34, 64, 90}),
                Arguments.of("Already sorted", new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}),
                Arguments.of("Reverse order", new int[]{5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5}),
                Arguments.of("Single element", new int[]{1}, new int[]{1}),
                Arguments.of("Empty array", new int[]{}, new int[]{}),
                Arguments.of("Null array", null, null)
        );
    }
}
