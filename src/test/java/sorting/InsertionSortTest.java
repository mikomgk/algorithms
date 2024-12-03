package sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class InsertionSortTest {
    @DisplayName("Insertion Sort")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideInsertionSortTestCases")
    void testInsertionSort(String name, int[] input, int[] expected) {
        InsertionSort.insertionSort(input);
        assertArrayEquals(expected, input);
    }

    static Stream<Arguments> provideInsertionSortTestCases() {
        return Stream.of(
                Arguments.of("Random order", new int[]{12, 11, 13, 5, 6}, new int[]{5, 6, 11, 12, 13}),
                Arguments.of("Reverse order", new int[]{5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5}),
                Arguments.of("Already sorted", new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}),
                Arguments.of("Single element", new int[]{1}, new int[]{1}),
                Arguments.of("Empty array", new int[]{}, new int[]{}),
                Arguments.of("Null array", null, null)
        );
    }
}
