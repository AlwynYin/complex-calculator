# Complex Calculator App

The Complex Calculator App is a Java program that allows users to perform arithmetic operations on complex numbers. It supports addition, subtraction, multiplication, and division operation.
## Features

- Arithmetic operations: Addition, subtraction, multiplication and division of complex numbers.

*note: I originally planned to implement exponentiation and logarithm, but then gave up due to complexity*

## UseCase

- A user wants to calculate some Complex Number arithmetics, the user inputs the mathematical expression to this app, and gets the result
- A user inputs a wrong expression, the app notifies the user that the expression is incorrect


## Design Patterns

The Complex Calculator App employs the Strategy Design Pattern for handling different mathematical operations. It separates parsing, expression tree building, and evaluation into modular components for improved maintainability and extensibility.

## Java Version and Testing Framework

- Java version: Java 11 (Amazon correcto-11)
- Testing framework: JUnit5 (Maven: org.junit.jupyter:junit.jupiter:5.9.1)

## Code Quality

The project is developed mostly complying to the SOLID and Clean Architecture. Pattern used in this project includes Strategy design pattern and Factory pattern, which complies the open/close principle.

However, the lack of framework layer avoids Clean architecture, and the two methods in `ComplexCalculatorApp` is too long, so that is a code smell in this project.

## Testing

The program has been tested using JUnit to ensure the accuracy of arithmetic calculations and operation handling. Additional test cases can be added to cover edge cases and validate the functionality.

## Authors

Aiwei Yin

