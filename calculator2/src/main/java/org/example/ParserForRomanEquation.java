package org.example;

class ParserForRomanEquation implements Parser {
    /**
     * Преобразовывает строку с римскими числами
     * в Equation
     */
    @Override
    public Equation parse(String equationString) throws Exception {
        String[] parts = equationString.split(" ");
        if(parts.length!=3)
            throw new Exception();

       int left = ConverterRomanToArabic.convertNumber(parts[0]);
       int right = ConverterRomanToArabic.convertNumber(parts[2]);
        char sign = parts[1].charAt(0);
        if(left>10 || right>10)
            throw new Exception();
        if(sign!='+' && sign!='-' && sign!='*' && sign!='/')
            throw new Exception();

        return new Equation(left, right,sign);
    }
}
