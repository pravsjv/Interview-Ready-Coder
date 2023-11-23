package algods.random;

import java.util.Stack;

/**
 * This class provides a method to evaluate a basic mathematical expression involving addition, subtraction, multiplication, and division.
 *
 * @author Praveen Kumar JV
 */
public class BasicCalculatorII {
    /**
     * Evaluates a basic mathematical expression given as a string.
     *
     * @param s The string representation of the mathematical expression.
     * @return The evaluated result of the expression.
     */
    public int calculate(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Input cannot be null.");
        }

        Stack<Integer> stack = new Stack<>(); // A stack to store operands and intermediate results
        int currentNumber = 0; // A variable to accumulate the current operand
        char operator = '+'; // The current operation to be performed

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) { // Extract digits from the input string
                currentNumber = currentNumber * 10 + (c - '0');
            }

            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == s.length() - 1) { // Process encountered operators or the end of the string
                switch (operator) {
                    case '-':
                        stack.push(-currentNumber);
                        break;
                    case '+':
                        stack.push(currentNumber);
                        break;
                    case '*':
                        stack.push(stack.pop() * currentNumber);
                        break;
                    case '/':
                        if (currentNumber != 0) {
                            stack.push(stack.pop() / currentNumber);
                        }
                        break;
                }

                operator = c; // Update the current operator
                currentNumber = 0; // Reset the current operand accumulator
            }
        }

        int result = 0; // Initialize the result variable

        while (!stack.isEmpty()) { // Pop operands from the stack and accumulate the result
            result += stack.pop();
        }

        return result; // Return the evaluated result
    }
}
