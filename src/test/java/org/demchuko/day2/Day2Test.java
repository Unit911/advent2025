package org.demchuko.day2;


import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class Day2Test {

    @InjectMocks
    Day2 day2;

    @ParameterizedTest
    @MethodSource("testDataForInvalidIds")
    public void verifyFindInvalids(double start, double end, List<Double> expected) {
        List<Double> result = day2.findInvalidsForFirstTask(start, end);

        assertThat(result).containsExactly(expected.toArray(new Double[0]));

    }

    static Stream<Arguments> testDataForInvalidIds() {
        return Stream.of(
                Arguments.of(95L, 115L, Arrays.asList(99.0)),
                Arguments.of(998L, 1012L, Arrays.asList(1010.0)),
                Arguments.of(11L, 22L, Arrays.asList(11.0, 22.0))
        );
    }


    @ParameterizedTest
    @CsvSource({"95,1", "998, 2", "100000, 3", "999000, 3"})
    void verifyFindMinOrder(double number, double expectedOrder) {
        double result = day2.findMidRank(number);
        assertThat(result).isEqualTo(expectedOrder);
    }


    @ParameterizedTest
    @CsvSource({"95,1.0", "998, 2.0", "100000, 5.0", "999000, 5.0"})
    void verifyFindMaxRank(double number, double expectedMaxRank) {
        double result = day2.findMaxRank(number);
        assertThat(result).isEqualTo(expectedMaxRank);
    }


    @ParameterizedTest
    @MethodSource("testDataForFindInvalidsForRank")
    void verifyFindInvalidsForRank(double start, double limit, int numberOfDigitsInPattern, List<Double> expectedResult) {
        List<Double> result = day2.findInvalidsForRank(start, limit, numberOfDigitsInPattern);
        assertThat(result).containsExactly(expectedResult.toArray(new Double[0]));
    }

    public static Stream<Arguments> testDataForFindInvalidsForRank() {
        return Stream.of(
//                List<Double> findInvalidsForRank(double start, double limit, int numberOfDigitsInPattern)
                Arguments.of(11, 22, 1, Arrays.asList(11.0, 22.0)),
                Arguments.of(95, 115, 1, Arrays.asList(99.0)),
                Arguments.of(1000, 1012, 1, Collections.EMPTY_LIST),
                Arguments.of(1000, 1012, 2, Arrays.asList(1010.0)),
                Arguments.of(222220, 222224, 1, Arrays.asList(222222.0))

        );
    }


    @ParameterizedTest
    @MethodSource("testDataForFindInvalidsForSecondTask")
    void verifyFindInvalidsForSecondTask(double start, double end, List<Double> expectedResult) {
        List<Double> result = day2.findInvalidsForSecondTask(start, end);
        assertThat(result).containsExactly(expectedResult.toArray(new Double[0]));
    }

    public static Stream<Arguments> testDataForFindInvalidsForSecondTask() {
        return Stream.of(
                Arguments.of(11, 22, Arrays.asList(11.0, 22.0)),
                Arguments.of(95, 115, Arrays.asList(99.0, 111.0)),
                Arguments.of(998, 1012, Arrays.asList(999.0, 1010.0)),
                Arguments.of(1188511880, 1188511890, Arrays.asList(1188511885.0)),
                Arguments.of(222220, 222224, Arrays.asList(222222.0)),
                Arguments.of(1698522, 1698528, Arrays.asList()),
                Arguments.of(446443, 446449, Arrays.asList(446446.0)),
                Arguments.of(38593856, 38593862, Arrays.asList(38593859.0)),
                Arguments.of(565653, 565659, Arrays.asList(565656.0)),
                Arguments.of(824824821, 824824827, Arrays.asList(824824824.0)),
                Arguments.of(2121212118, 2121212124, Arrays.asList(2121212121.0))
        );
    }
}