import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("===== Simple Calculator =====");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Power");
            System.out.println("6. Square root");
            System.out.println("7. Is it even?");
            System.out.println("8. Factors of a number");
            System.out.println("9. Largest of a list");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            String choice = in.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        System.out.println("Result: " + calc.add(readInt(in, "First number: "), readInt(in, "Second number: ")));
                        break;
                    case "2":
                        System.out.println("Result: " + calc.subtract(readInt(in, "First number: "), readInt(in, "Second number: ")));
                        break;
                    case "3":
                        System.out.println("Result: " + calc.multiply(readInt(in, "First number: "), readInt(in, "Second number: ")));
                        break;
                    case "4":
                        System.out.println("Result: " + calc.divide(readDouble(in, "First number: "), readDouble(in, "Second number: ")));
                        break;
                    case "5":
                        System.out.println("Result: " + calc.power(readDouble(in, "Base: "), readDouble(in, "Exponent: ")));
                        break;
                    case "6":
                        System.out.println("Result: " + calc.squareRoot(readDouble(in, "Number: ")));
                        break;
                    case "7":
                        System.out.println("Result: " + calc.isEven(readInt(in, "Whole number: ")));
                        break;
                    case "8":
                        System.out.println("Result: " + Arrays.toString(calc.factors(readInt(in, "Whole number: "))));
                        break;
                    case "9":
                        System.out.print("Numbers separated by spaces: ");
                        String line = in.nextLine().trim();
                        int[] numbers = line.isEmpty() ? new int[0]
                                : Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
                        System.out.println("Result: " + calc.largest(numbers));
                        break;
                    case "0":
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Unknown option, try again.");
                }
            } catch (IllegalArgumentException e) {
                // NumberFormatException is also an IllegalArgumentException
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static int readInt(Scanner in, String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(in.nextLine().trim());
    }

    private static double readDouble(Scanner in, String prompt) {
        System.out.print(prompt);
        return Double.parseDouble(in.nextLine().trim());
    }
}
