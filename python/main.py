from calculator import Calculator


def read_number(prompt):
    return float(input(prompt))


def main():
    calc = Calculator()

    while True:
        print()
        print("===== Simple Calculator =====")
        print("1. Add")
        print("2. Subtract")
        print("3. Multiply")
        print("4. Divide")
        print("5. Power")
        print("6. Square root")
        print("7. Is it even?")
        print("8. Factors of a number")
        print("9. Largest of a list")
        print("0. Exit")
        choice = input("Choose an option: ").strip()

        try:
            if choice == "1":
                a = read_number("First number: ")
                b = read_number("Second number: ")
                print("Result:", calc.add(a, b))
            elif choice == "2":
                a = read_number("First number: ")
                b = read_number("Second number: ")
                print("Result:", calc.subtract(a, b))
            elif choice == "3":
                a = read_number("First number: ")
                b = read_number("Second number: ")
                print("Result:", calc.multiply(a, b))
            elif choice == "4":
                a = read_number("First number: ")
                b = read_number("Second number: ")
                print("Result:", calc.divide(a, b))
            elif choice == "5":
                a = read_number("Base: ")
                b = read_number("Exponent: ")
                print("Result:", calc.power(a, b))
            elif choice == "6":
                n = read_number("Number: ")
                print("Result:", calc.square_root(n))
            elif choice == "7":
                n = int(input("Whole number: "))
                print("Result:", calc.is_even(n))
            elif choice == "8":
                n = int(input("Whole number: "))
                print("Result:", calc.factors(n))
            elif choice == "9":
                text = input("Numbers separated by spaces: ")
                numbers = [float(x) for x in text.split()]
                print("Result:", calc.largest(numbers))
            elif choice == "0":
                print("Goodbye!")
                break
            else:
                print("Unknown option, try again.")
        except ValueError as error:
            print("Error:", error)


if __name__ == "__main__":
    main()
