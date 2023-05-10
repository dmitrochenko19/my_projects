package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) throws Exception {
        EquationEvaluator evaluator = new EquationEvaluatorImpl();

        if (input.contains("I") || input.contains("V") || input.contains("X")) {
            Parser parser = new ParserForRomanEquation();
            Equation equation = parser.parse(input);
            int arabicResult = evaluator.evaluateEquation(equation);
            return ConverterArabicToRoman.convertNumber(arabicResult);
        } else {
            Parser parser = new ParserForArabicEquation();
            Equation equation = parser.parse(input);
            int arabicResult = evaluator.evaluateEquation(equation);
            return Integer.toString(arabicResult);
        }
    }
}