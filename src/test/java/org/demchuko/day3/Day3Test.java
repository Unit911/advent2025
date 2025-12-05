package org.demchuko.day3;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class Day3Test {

    @InjectMocks
    Day3 day3;

    @ParameterizedTest
    @CsvSource({
            "987654321111111,98",
            "811111111111119,89",
            "234234234234278,78",
            "818181911112111,92"
    })
    void verifyGetMaxJoltagex(String s, int expectedResult) {
        double result = day3.getMaxJoltage(s, 2);
        assertThat(result).isEqualTo(expectedResult);

    }

    @ParameterizedTest
    @CsvSource({
            "987654321111111,987654321111",
            "811111111111119,811111111119",
            "234234234234278,434234234278",
            "818181911112111,888911112111"
    })
    void verifyGetMaxJoltagex2(String s, double expectedResult) {
        double result = day3.getMaxJoltage(s, 12);
        assertThat(result).isEqualTo(expectedResult);

    }

}