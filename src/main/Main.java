import controller.ComplexCalculatorApp;
import entity.ComplexNumber;
import entity.TreeNode;
import usecase.parser.StringPaser;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Complex Calculator App!");
        System.out.println("Supported operations: +, -, *, /");
        System.out.print("Enter a mathematical expression (e.g., '3 + 4i * 2 - 1i / 2'), \n" +
                "you must separate all your operations with a space, \n" +
                "e.g., '( 1 + 1 )': ");
        String expression = scanner.nextLine();

        String[] tokens = StringPaser.parse(expression);

        TreeNode expressionTree = ComplexCalculatorApp.buildExpressionTree(tokens, 0, tokens.length - 1);

        ComplexNumber result = ComplexCalculatorApp.evaluateExpressionTree(expressionTree);

        System.out.println("Result: " + result);
    }
}