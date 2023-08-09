package controller;

import java.util.Scanner;

import entity.ComplexNumber;
import entity.TreeNode;
import usecase.operation.*;

public class ComplexCalculatorApp {
    /**
     * Builds an expression tree from an array of tokens representing a mathematical
     * expression.
     *
     * @param tokens The array of tokens representing the mathematical expression.
     * @param start  The starting index in the array for building the expression tree.
     * @param end    The ending index in the array for building the expression tree.
     * @return The root node of the constructed expression tree.
     */
    public static TreeNode buildExpressionTree(String[] tokens, int start, int end) {
        if (start > end) {
            return null;
        }

        if (tokens[start].equals("(")) {
            int parenthesesCount = 0;
            for (int i = start; i <= end; i++) {
                if (tokens[i].equals("("))
                    parenthesesCount ++;
                if (tokens[i].equals(")"))
                    parenthesesCount --;
                if (parenthesesCount == 0) {
                    if (i == end) {
                        start++;
                        end--;
                    }
                    break;
                }
            }
        }

        int minPrecedence = Integer.MAX_VALUE;
        int minPrecedenceIndex = -1;

        int parenthesesCount = 0;

        for (int i = start; i <= end; i++) {
            if (tokens[i].equals("(")) {
                parenthesesCount++;
            } else if (tokens[i].equals(")")) {
                parenthesesCount--;
            }

            if (parenthesesCount == 0 && (tokens[i].equals("+") || tokens[i].equals("-")
                    || tokens[i].equals("*") || tokens[i].equals("/"))) {
                int precedence = (tokens[i].equals("+") || tokens[i].equals("-")) ? 1 : 2;

                if (precedence < minPrecedence) {
                    minPrecedence = precedence;
                    minPrecedenceIndex = i;
                }
            }
        }

        if (minPrecedenceIndex != -1) {
            TreeNode node = new TreeNode(tokens[minPrecedenceIndex]);
            node.left = buildExpressionTree(tokens, start, minPrecedenceIndex - 1);
            node.right = buildExpressionTree(tokens, minPrecedenceIndex + 1, end);
            return node;
        }

        return new TreeNode(tokens[start]);
    }


    /**
     * Evaluates an expression tree and returns the resulting complex number.
     *
     * @param root The root node of the expression tree to be evaluated.
     * @return The complex number resulting from the evaluation.
     * @throws IllegalArgumentException If an invalid operation is encountered.
     */
    public static ComplexNumber evaluateExpressionTree(TreeNode root) {
        if (root == null) {
            return new ComplexNumber(0, 0);
        }

        if (root.left == null && root.right == null) {
            String token = root.value;
            if (token.matches("[+-]?\\d+(\\.\\d+)?")) {
                return new ComplexNumber(Double.parseDouble(token), 0);
            } else if (token.matches("[+-]?\\d+(\\.\\d+)?i")) {
                return new ComplexNumber(0, Double.parseDouble(token.substring(0, token.length() - 1)));
            }
        }

        ComplexNumber leftValue = evaluateExpressionTree(root.left);
        ComplexNumber rightValue = evaluateExpressionTree(root.right);

        if (root.value.equals("^")) {
            if (rightValue.getImaginary() != 0) {
                throw new IllegalArgumentException("Exponent must be a real number.");
            }
            ComplexNumberOperation operation = new ExponentiationOperation(rightValue.getReal());
            return operation.perform(leftValue, rightValue);
        }

        ComplexNumberOperation operation = OperationFactory.createOperation(root);
        return operation.perform(leftValue, rightValue);
    }
}
