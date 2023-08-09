package usecase.operation;

import entity.ComplexNumber;

public interface ComplexNumberOperation {
    /**
     * Performs the specified arithmetic operation on two complex numbers and returns the result.
     *
     * @param num1 The first complex number operand.
     * @param num2 The second complex number operand.
     * @return The complex number result of the arithmetic operation.
     */
    ComplexNumber perform(ComplexNumber num1, ComplexNumber num2);
}
