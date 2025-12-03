package org.demchuko.day1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class TaskTest {

    @InjectMocks
    Task underTest;

    @Test
    void test() {
        assertThat(true).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"0, L1, 0", "0, L100, 1", "0, L101, 1", "0, L200, 2", "0, R1, 0", "50, L50, 1", "50, L150, 2", "85, R805, 8"})
    void testFoo2(int startPosition, String rotation, int touchedTimes) {

        underTest.rotate2(startPosition, rotation);

        assertThat(underTest.touched0).isEqualTo(touchedTimes);
    }

}



