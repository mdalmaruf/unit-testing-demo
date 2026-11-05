import math


class Calculator:
    """A simple calculator. Each method does one small job,
    which makes every method easy to test on its own."""

    def add(self, a, b):
        return a + b

    def subtract(self, a, b):
        return a - b

    def multiply(self, a, b):
        return a * b

    def divide(self, a, b):
        if b == 0:
            raise ValueError("Cannot divide by zero")
        return a / b

    def power(self, base, exponent):
        return base ** exponent

    def square_root(self, n):
        if n < 0:
            raise ValueError("Cannot take the square root of a negative number")
        return math.sqrt(n)

    def is_even(self, n):
        return n % 2 == 0

    def factors(self, n):
        """Return every whole number that divides n, e.g. 6 -> [1, 2, 3, 6]."""
        result = []
        for i in range(1, n + 1):
            if n % i == 0:
                result.append(i)
        return result

    def largest(self, numbers):
        """Return the biggest number in the list, or None if the list is empty."""
        if len(numbers) == 0:
            return None
        biggest = numbers[0]
        for x in numbers:
            if x > biggest:
                biggest = x
        return biggest
