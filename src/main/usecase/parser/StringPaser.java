package usecase.parser;

public class StringPaser {
    public static String[] parse(String expression) {
        return expression.split(" ");
    }
}
