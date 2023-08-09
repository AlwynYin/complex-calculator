package usecase.operation;

import entity.TreeNode;

public class OperationFactory {
    /**
     * Creates and returns an instance of a class that implements the ComplexNumberOperation
     * interface based on the operation specified by the given TreeNode.
     *
     * @param node The TreeNode representing the operation.
     * @return An instance of a ComplexNumberOperation implementation corresponding to the operation.
     * @throws IllegalArgumentException If the operation specified by the TreeNode is not supported.
     */
    public static ComplexNumberOperation createOperation(TreeNode node) {
        switch (node.value) {
            case "+":
                return new AdditionOperation();
            case "-":
                return new SubtractionOperation();
            case "*":
                return new MultiplicationOperation();
            case "/":
                return new DivisionOperation();
            default:
                throw new IllegalArgumentException("Unsupported operation: " + node.value);
        }
    }
}