package org.example;

class ParserForArabicEquation implements Parser{
    /**
     * Преобразовывает строку с арабскими числами
     * в Equation
     */
    @Override
    public Equation parse(String equationString) throws Exception {
        String[] parts = equationString.split(" ");
        if (parts.length != 3)
            throw new Exception();
        int left;
        int right;

        try {
            left = Integer.parseInt(parts[0]);
            right = Integer.parseInt(parts[2]);
        }catch (NumberFormatException e){
            throw new Exception();
        }

        char sign = parts[1].charAt(0);
        if(left>10 || right>10)
            throw new Exception();
        if(sign!='+' && sign!='-' && sign!='*' && sign!='/')
            throw new Exception();

        return new Equation(left,right,sign);

    }
}
