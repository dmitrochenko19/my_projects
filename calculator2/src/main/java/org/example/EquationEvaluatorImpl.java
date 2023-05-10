package org.example;

class EquationEvaluatorImpl implements EquationEvaluator {
    /**
     * Выполняет вычисление
     */
    @Override
    public int evaluateEquation(Equation equation) {
        int equationResult = 0;
        switch (equation.getSign()) {
            case '+' -> equationResult = (equation.getLeft() + equation.getRight());
            case '-' -> equationResult = (equation.getLeft() - equation.getRight());
            case '*' -> equationResult = (equation.getLeft() * equation.getRight());
            case '/' -> equationResult = (equation.getLeft() / equation.getRight());
        }
        return equationResult;
    }
}
