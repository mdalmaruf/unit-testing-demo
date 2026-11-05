import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calc;

    // @Before runs before EVERY test, so each test gets a brand new Calculator.
    // One test can never mess up another test this way.
    @Before
    public void setUp() {
        calc = new Calculator();
    }

    // ---------- assertEquals: is the result exactly what we expect? ----------
    // Order matters: assertEquals(EXPECTED, ACTUAL)
    @Test
    public void addTwoPositiveNumbers() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    public void addNegativeNumbers() {
        assertEquals(-5, calc.add(-2, -3));
    }

    @Test
    public void subtract() {
        assertEquals(6, calc.subtract(10, 4));
    }

    @Test
    public void multiplyByZero() {
        assertEquals(0, calc.multiply(7, 0));
    }

    // ---------- assertNotEquals: the result must NOT be this value ----------
    @Test
    public void subtractOrderMatters() {
        assertNotEquals(calc.subtract(10, 4), calc.subtract(4, 10));
    }

    // ---------- assertEquals with a delta: for decimals (double) ----------
    // The third number is how close is "close enough".
    @Test
    public void divideGivesDecimal() {
        assertEquals(0.333333, calc.divide(1, 3), 0.000001);
    }

    @Test
    public void power() {
        assertEquals(8.0, calc.power(2, 3), 0.000001);
    }

    @Test
    public void squareRoot() {
        assertEquals(1.414213, calc.squareRoot(2), 0.000001);
    }

    // ---------- assertThrows: the code MUST throw an exception ----------
    @Test
    public void divideByZeroThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> calc.divide(5, 0));
    }

    @Test
    public void squareRootOfNegativeThrowsException() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> calc.squareRoot(-9));
        // We can also check the error message
        assertEquals("Cannot take the square root of a negative number", e.getMessage());
    }

    // ---------- assertTrue / assertFalse: yes-or-no answers ----------
    @Test
    public void fourIsEven() {
        assertTrue(calc.isEven(4));
    }

    @Test
    public void sevenIsNotEven() {
        assertFalse(calc.isEven(7));
    }

    // ---------- assertArrayEquals: compare two arrays item by item ----------
    @Test
    public void factorsOfSix() {
        int[] expected = {1, 2, 3, 6};
        assertArrayEquals(expected, calc.factors(6));
    }

    // ---------- assertNull / assertNotNull ----------
    @Test
    public void largestOfEmptyArrayIsNull() {
        assertNull(calc.largest(new int[] {}));
    }

    @Test
    public void largestOfArray() {
        Integer result = calc.largest(new int[] {3, 9, 2});
        assertNotNull(result);
        assertEquals(Integer.valueOf(9), result);
    }

    // ---------- assertSame / assertNotSame: the exact same object? ----------
    @Test
    public void factorsReturnsANewArrayEachTime() {
        assertNotSame(calc.factors(6), calc.factors(6));
    }

    // ---------- A message helps you understand a failure quickly ----------
    @Test
    public void addWithMessage() {
        assertEquals("2 + 2 should be 4", 4, calc.add(2, 2));
    }
}
