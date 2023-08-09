package usecase.operation;

import entity.ComplexNumber;

public class AdditionOperation implements ComplexNumberOperation {
    @Override
    public ComplexNumber perform(ComplexNumber num1, ComplexNumber num2) {
        double real = num1.getReal() + num2.getReal();
        double imaginary = num1.getImaginary() + num2.getImaginary();
        return new ComplexNumber(real, imaginary);
    }
}
