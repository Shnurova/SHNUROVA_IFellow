import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class RunTest {
    // its RunTest origin

    public static double clockDegree(int hours, int minutes) {
        if (hours > 12 || hours < 1) {
            throw new IllegalArgumentException("Часы не могут быть меньше 1 и больше 12");
        }

        if (minutes > 59 || minutes < 0) {
            throw new IllegalArgumentException("Минуты не могут быть меньше 0 и больше 59");
        }
        double degree = (Math.abs((minutes * 6) - (hours * 30 + minutes * 0.5)));
        if (degree <= 180) {
            return degree;
        }
        return 360 - degree;
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("develop Начало тестирования");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("develop Окончание тестирования");
    }

    @BeforeEach
    public void initEach(TestInfo testInfo) {
        System.out.println("Запуск теста \"" + testInfo.getDisplayName() + "\"");
    }


    @Test
    @DisplayName("Определение угла между стрелками для эквивалентных значений")
    public void timeTestUsualNumbers() {
        Assertions.assertEquals(82.5, clockDegree(12, 15));
    }


    @Test
    @DisplayName("Ошибка определения угла между стрелками для отрицательных значений")
    public void negativeValuesTimeTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            clockDegree(-15, -35);
        });
    }

    @Test
    @DisplayName("Ошибка определения угла между стрелками для нулевых значений")
    public void zeroValuesTimeTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            clockDegree(0, 0);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0, 12, 0",
            "65.5, 1, 59"
    }, ignoreLeadingAndTrailingWhitespace = true)
    @DisplayName("Определение угла между стрелками для граничных значений")
    public void boundaryValuesTimeTest(double expectedResult, int hours, int minutes) {
        Assertions.assertEquals(expectedResult, clockDegree(hours, minutes));
    }
}
