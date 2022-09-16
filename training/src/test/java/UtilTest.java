import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


class UtilTest {
    private final NumberUtil numberUtil = new NumberUtil();


    @Nested
    class TestIsSimple {

        @ParameterizedTest
        @ValueSource(ints = {2, 3, 13, 17, 19, 31})
        public void testOnSimples(int number) {
            assertTrue(numberUtil.isSimple(number));
        }

        @ParameterizedTest
        @ValueSource(ints = {15, 18, 21, 32})
        public void testOnNotSimples(int number) {
            assertFalse(numberUtil.isSimple(number));
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 1})
        public void testProblemNumbers(int number) {
            assertThrows(IncorrectException.class, () -> numberUtil.isSimple(number));
        }
    }

    @Nested
    @DisplayName("Test of method gcd")
    class TestGCD {

        @ParameterizedTest(name = "for {0}, {1}, {2}")
        @CsvSource(value = {"9, 12, 3", "16, 48, 16", "18, 12, 6", "18, 19, 1"})
        public void testGcd(int a, int b, int expected) {
            assertEquals(expected, numberUtil.gcd(a, b));
        }
    }
}