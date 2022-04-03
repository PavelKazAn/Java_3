package lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTestingTest {
    static ArrayTesting arr;

    @Test
    void getNumbersArrayAfter4() {
        arr = new ArrayTesting(new int[]{1, 4, 4, 2, 3, 4, 5, 6, 7});
        Assertions.assertArrayEquals(new int[]{5, 6, 7}, arr.getNumbersArrayAfter4());
    }

    static Stream<Arguments> dataMassTestGetNumbersArrayAfter4() {
        return Stream.of(
                Arguments.arguments(new int[]{3, 3, -3, 3}, new int[]{2, 3, 1, 2, 4, 3, 14, 444, 44, 132, 4, 3, 3, -3, 3}),
                Arguments.arguments(new int[]{128, 423, 411, 324}, new int[]{1, 2, 3, 13, 4, 5, 5, 13, 4, 128, 423, 411, 324}),
                Arguments.arguments(new int[]{12, 3, 2, 5, 10, 10, 10}, new int[]{1, 2, 3, 1, 1, 1, 2, 4, 12, 3, 2, 5, 10, 10, 10}),
                Arguments.arguments(new int[]{-1}, new int[]{1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, -4, 4, 4, 4, 4, 4, 4, 0, 4+4, 6, 6, 6, 6, 4, -1}),
                Arguments.arguments(new int[]{22, 3, 3, 1, 3, -123, -900}, new int[]{0, 0, 0, 0, 0, 10, 10, 10, 10, 1, 4, 22, 3, 3, 1, 3, -123, -900})
        );
    }

    @ParameterizedTest
    @MethodSource("dataMassTestGetNumbersArrayAfter4")
    void massTestGetNumberArrayAfter4(int[] secondArray, int[] array) {
        arr = new ArrayTesting(array);
        Assertions.assertArrayEquals(secondArray, arr.getNumbersArrayAfter4());
    }

    @Test
    void testException() {
        arr = new ArrayTesting(new int[]{1, 2, 3, 5, 6, 7});
        Assertions.assertThrows(RuntimeException.class, () -> arr.getNumbersArrayAfter4());
    }

    static Stream<Arguments> dataMassTestForTestException() {
        return Stream.of(
                Arguments.arguments(new int[]{1,2,3,5,6,7,8,9,0,10,44,444,4444}),
                Arguments.arguments(new int[]{0}),
                Arguments.arguments(new int[]{444,444,14,41,44,54,442,-4,-5,-4}),
                Arguments.arguments(new int[]{-4,-4,-4,2,10+2, 4-4,4+4})
                );
    }

    @ParameterizedTest
    @MethodSource("dataMassTestForTestException")
    void massTestException(int[] array) {
        arr = new ArrayTesting(array);
        Assertions.assertThrows(RuntimeException.class, () -> arr.getNumbersArrayAfter4());
    }

    @Test
    void checkFor1And4() {
        arr = new ArrayTesting(new int[]{1, 2, 3, 4, 5, 6, 7});
        assertFalse(arr.checkFor1And4());
    }

    static Stream<Arguments> dataMassTestCheckFor1And4() {
        return Stream.of(
                Arguments.arguments(new int[]{1,1,2,3,4,5}),
                Arguments.arguments(new int[]{1,1,1,1}),
                Arguments.arguments(new int[]{4,4,4,4}),
                Arguments.arguments(new int[]{1,1,1,1,44,1,4,4,4,4})
                );
    }

    @ParameterizedTest
    @MethodSource("dataMassTestCheckFor1And4")
    void massTestCheckFor1And4(int[] array) {
        arr = new ArrayTesting(array);
        assertFalse(arr.checkFor1And4());
    }
}