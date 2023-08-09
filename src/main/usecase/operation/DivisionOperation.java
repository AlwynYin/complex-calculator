package usecase.operation;

import entity.ComplexNumber;

public class DivisionOperation implements ComplexNumberOperation {
    @Override
    public ComplexNumber perform(ComplexNumber num1, ComplexNumber num2) {
        double a = num1.getReal();
        double b = num1.getImaginary();
        double c = num2.getReal();
        double d = num2.getImaginary();
        double div = c * c + d * d;

        return new ComplexNumber((a * c + b * d) / div, (b * c - a * d) / div);
    }
}
