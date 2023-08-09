package usecase.operation;

import entity.ComplexNumber;
import usecase.operation.ComplexNumberOperation;

public class LogarithmOperation implements ComplexNumberOperation {
    @Override
    public ComplexNumber perform(ComplexNumber num1, ComplexNumber num2) {
        double real = Math.log(num1.getNorm());
        double argument = num1.getArgument();
        return new ComplexNumber(real, argument);
    }
}