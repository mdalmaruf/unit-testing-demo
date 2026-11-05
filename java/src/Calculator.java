import java.util.ArrayList;
import java.util.List;

/**
 * A simple calculator. Each method does one small job,
 * which makes every method easy to test on its own.
 */
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public double squareRoot(double n) {
        if (n < 0) {
            throw new IllegalArgumentException("Cannot take the square root of a negative number");
        }
        return Math.sqrt(n);
    }

    public boolean isEven(int n) {
        return n % 2 == 0;
    }

    /** Return every whole number that divides n, e.g. 6 -> [1, 2, 3, 6]. */
    public int[] factors(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                result.add(i);
            }
        }
        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }
        return array;
    }

    /** Return the biggest number in the array, or null if the array is empty. */
    public Integer largest(int[] numbers) {
        if (numbers.length == 0) {
            return null;
        }
        int biggest = numbers[0];
        for (int x : numbers) {
            if (x > biggest) {
                biggest = x;
            }
        }
        return biggest;
    }
}
