/*
 * File: MathHandler.java
 * ---------------------
 *  This class is a helper class for a sample calculator app implementation
 *  Author: Cobalt mkc
 *  Date created: July 22, 2019
 *  Last modified: Aug 3, 2022
 */




public class MathHandler {

    public static int evaluate(int operand1, int operand2, char operator) {
        int result;
        switch (operator) {
            case '+':
                result = add(operand1, operand2);
                break;
            case '-':
                result = subtract(operand1, operand2);
                break;
            case '*':
                result = multiply(operand1, operand2);
                break;
            case '÷':
                result = divide(operand1, operand2);
                break;
            default:
                result = 0;
        }
        return result;
    }

    public static double evaluate(double operand1, double operand2, char operator) {
        double result;
        switch (operator) {
            case '+':
                result = add(operand1, operand2);
                break;
            case '-':
                result = subtract(operand1, operand2);
                break;
            case '*':
                result = multiply(operand1, operand2);
                break;
            case '÷':
                result = divide(operand1, operand2);
                break;
            default:
                result = 0;
        }
        return result;
    }


    /**
     * Returns the sum of operand1 and operand2
     * @param operand1
     * @param operand2
     * @return
     */
    public static int add(int operand1, int operand2) {
        /* YOUR CODE HERE */
        return 0;
    }

    public static double add(double operand1, double operand2) {
        /* YOUR CODE HERE */
        return 0.0;
    }


    public static int subtract(int operand1, int operand2) {
        /* YOUR CODE HERE */
        return 0;
    }

    public static double subtract(double operand1, double operand2) {
        /* YOUR CODE HERE */
        return 0.0;
    }


    public static int divide(int operand1, int operand2) {
        /* YOUR CODE HERE */
        return 0;
    }

    public static double divide(double operand1, double operand2) {
        /* YOUR CODE HERE */
        return 0.0;
    }

    // Note: '*' method already polymorphic
    public static int multiply(int operand1, int operand2) {
        /* YOUR CODE HERE */
        return 0;
    }

    public static double multiply(double operand1, double operand2) {
        return operand1 * operand2;
    }

}
