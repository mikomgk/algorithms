package sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SelectionSortTest {
    @DisplayName("Selection Sort")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideSelectionSortTestCases")
    void testSelectionSort(String name, int[] input, int[] expected) {
        SelectionSort.selectionSort(input);
        assertArrayEquals(expected, input);
    }

    static Stream<Arguments> provideSelectionSortTestCases() {
        return Stream.of(
                Arguments.of("Random order", new int[]{29, 10, 14, 37, 14}, new int[]{10, 14, 14, 29, 37}),
                Arguments.of("Already sorted", new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}),
                Arguments.of("Reverse order", new int[]{5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5}),
                Arguments.of("Single element", new int[]{1}, new int[]{1}),
                Arguments.of("Empty array", new int[]{}, new int[]{}),
                Arguments.of("Null array", null, null)
        );
    }
}
