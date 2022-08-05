/*
 * File: Calculator.java
 * ---------------------
 * This class is the main class for a sample calculator app implementation
 *  Author: Cobalt mkc
 *  Date created: July 22, 2019
 *  Last modified: Aug 3, 2022
 */


import acm.graphics.GObject;
import acm.program.*;
import java.awt.event.MouseEvent;


public class App extends GraphicsProgram {

    private static final double CANVAS_WIDTH = 540;    // Calculator width
    private static final double CANVAS_HEIGHT = 740;   // Calculator height
    private CalculatorLayout calculatorLayout;         // Instantiate the Layout Object

    private char opBuffer;                             // Stores the operator
    private double operand1;                           // Stores the operand digits
    private String result;                             // Stores the results
 
    private boolean isFirstOp;                         // Checks if first operator
    private boolean isPriorEquals;                     // Checks if  
    private boolean isFirstPoint;
    private boolean isDeletable;


    public void run() {
        setTitle("LBYCPEI Calculator");
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        calculatorLayout = new CalculatorLayout(getHeight());
        add(calculatorLayout);
        initBooleans();
        addMouseListeners();
    }


    public void mouseClicked(MouseEvent e) {
        GObject element = calculatorLayout.getElementAt(e.getX(), e.getY());
        if (element instanceof MyButton) {
            String input = ((MyButton) element).getText();

            // I. Handle special cases: Clear Element, Clear All, and  Delete
            if (input.equals("CE ")) {
                calculatorLayout.clearMainDisplay();
                calculatorLayout.clearMemoElement(opBuffer);
                System.out.println("Clear Element");
                return;
            }
            if (input.equals("C")) {
                calculatorLayout.clearMainDisplay();
                calculatorLayout.clearMemoDisplay();
                initBooleans();
                System.out.println("Clear Called");
                return;
            }
            if (input.equals("⌫") && isDeletable) {
                calculatorLayout.deleteOneCharacter();
                System.out.println("Delete Called");
                return;
            }

            // II. Handle arithmetic symbols and operations

            char symbol = input.charAt(0);

            if (symbol == '±' && isDeletable) {
                calculatorLayout.negateElement(opBuffer);
                System.out.println("Negation Called");
                return;
            }

            if ((symbol >= '0' && symbol <= '9') || symbol == '.') {
                isDeletable = true;
                if (symbol == '.') {
                    if (!isFirstPoint) {
                        return;
                    } else {
                        isFirstPoint = false;
                    }
                }
                if (isPriorEquals) {
                    calculatorLayout.clearMainDisplay();
                    isPriorEquals = false;
                    System.out.println("Digit: Prior Equals");
                }
                calculatorLayout.setMemoDisplay(symbol);
                calculatorLayout.setMainDisplay(symbol);
                System.out.println("Digit: Prior Not Equals");
                return;
            }


            double operand2;
            if (isOperator(symbol)) {
                if (isFirstOp && !isPriorEquals) {
                    operand1 = Double.parseDouble(calculatorLayout.getMainDisplay());
                    calculatorLayout.setMemoDisplay(symbol);
                    opBuffer = symbol;
                    isFirstOp = false;
                    System.out.println("Operator: First Operation and Not prior equals");
                } else if (isPriorEquals) {
                    calculatorLayout.setMemoDisplay(result + symbol);
                    opBuffer = symbol;
                    isFirstOp = false;
                    System.out.println("Operator: Prior equals!");
                } else {
                    operand2 = Double.parseDouble(calculatorLayout.getMainDisplay());
                    operand1 = MathHandler.evaluate(operand1, operand2, opBuffer);
                    result = "" + operand1;
                    result = result.contains(".") ? result.replaceAll("0*$", "").replaceAll("\\.$", "") : result;
                    calculatorLayout.setMainDisplay(result);
                    calculatorLayout.setMemoDisplay(symbol);
                    isDeletable = false;
                    System.out.println("Operator: Second operator");
                }
                calculatorLayout.clearNumBuffer();
                isFirstPoint = true;
            }
            if (symbol == '=') {
                operand2 = Double.parseDouble(calculatorLayout.getMainDisplay());
                operand1 = MathHandler.evaluate(operand1, operand2, opBuffer);
                result = "" + operand1;
                result = result.contains(".") ? result.replaceAll("0*$", "").replaceAll("\\.$", "") : result;
                calculatorLayout.setMainDisplay(result);
                calculatorLayout.clearMemoDisplay();
                initBooleans();
                System.out.println("Equals: evaluated");
                System.out.println("operand1 = " + operand1);
                System.out.println("operand2 = " + operand2);
            }
        }
    }

    private void initBooleans() {
        isFirstOp = true;
        isPriorEquals = true;
        isDeletable = false;
        isFirstPoint = true;
    }

    private boolean isOperator(char symbol) {
        return (symbol == '+' || symbol == '-' || symbol == 'x' || symbol == '÷');
    }

    // Solves java.lang.NoClassDefFoundError
    public static void main(String[] args) {
        (new App()).start(args);
    }
}
