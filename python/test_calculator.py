import unittest

from calculator import Calculator


class TestCalculator(unittest.TestCase):

    # setUp runs before EVERY test, so each test gets a brand new Calculator.
    # One test can never mess up another test this way.
    def setUp(self):
        self.calc = Calculator()

    # ---------- assertEqual: is the result exactly what we expect? ----------
    def test_add_two_positive_numbers(self):
        self.assertEqual(self.calc.add(2, 3), 5)

    def test_add_negative_numbers(self):
        self.assertEqual(self.calc.add(-2, -3), -5)

    def test_subtract(self):
        self.assertEqual(self.calc.subtract(10, 4), 6)

    def test_multiply_by_zero(self):
        self.assertEqual(self.calc.multiply(7, 0), 0)

    def test_power(self):
        self.assertEqual(self.calc.power(2, 3), 8)

    # ---------- assertNotEqual: the result must NOT be this value ----------
    def test_subtract_order_matters(self):
        self.assertNotEqual(self.calc.subtract(10, 4), self.calc.subtract(4, 10))

    # ---------- assertAlmostEqual: for decimals (floating point) ----------
    def test_divide_gives_decimal(self):
        # 1 / 3 = 0.3333333...  Exact comparison of decimals is risky.
        self.assertAlmostEqual(self.calc.divide(1, 3), 0.3333333, places=6)

    def test_square_root(self):
        self.assertAlmostEqual(self.calc.square_root(2), 1.41421356, places=6)

    # ---------- assertRaises: the code MUST raise an error ----------
    def test_divide_by_zero_raises_error(self):
        with self.assertRaises(ValueError):
            self.calc.divide(5, 0)

    def test_square_root_of_negative_raises_error(self):
        with self.assertRaises(ValueError):
            self.calc.square_root(-9)

    # ---------- assertTrue / assertFalse: yes-or-no answers ----------
    def test_four_is_even(self):
        self.assertTrue(self.calc.is_even(4))

    def test_seven_is_not_even(self):
        self.assertFalse(self.calc.is_even(7))

    # ---------- assertIn / assertNotIn: is the item inside the list? ----------
    def test_factors_of_twelve_contain_four(self):
        self.assertIn(4, self.calc.factors(12))

    def test_factors_of_twelve_do_not_contain_five(self):
        self.assertNotIn(5, self.calc.factors(12))

    # ---------- assertEqual also works on whole lists ----------
    def test_factors_of_six(self):
        self.assertEqual(self.calc.factors(6), [1, 2, 3, 6])

    # ---------- assertIsNone / assertIsNotNone ----------
    def test_largest_of_empty_list_is_none(self):
        self.assertIsNone(self.calc.largest([]))

    def test_largest_of_list(self):
        result = self.calc.largest([3, 9, 2])
        self.assertIsNotNone(result)
        self.assertEqual(result, 9)

    # ---------- assertGreater / assertLess ----------
    def test_square_is_bigger_than_number(self):
        self.assertGreater(self.calc.power(5, 2), 5)

    def test_root_is_smaller_than_number(self):
        self.assertLess(self.calc.square_root(16), 16)

    # ---------- assertIsInstance: check the type of the result ----------
    def test_divide_returns_float(self):
        self.assertIsInstance(self.calc.divide(10, 2), float)


if __name__ == "__main__":
    unittest.main()
