package entity;

/**
 * The TreeNode class represents a node in an expression tree. Each node holds a value,
 * typically representing an operator or operand, and can have left and right child nodes.
 */
public class TreeNode {
    public String value;
    public TreeNode left;
    public TreeNode right;

    /**
     * Constructs a TreeNode with the given value and initializes the left and right
     * child nodes to null.
     *
     * @param value The value to be stored in the TreeNode.
     */
    public TreeNode(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}