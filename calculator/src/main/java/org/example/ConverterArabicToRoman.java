package org.example;

import java.util.List;

class ConverterArabicToRoman {
    /**
     * Переводит арабское число в римское
     */
    public static String convertNumber(int number) throws Exception {
       if (number <= 0)  {
            throw new Exception();
        }

        List<RomanNumber> romanNumbers = RomanNumber.getValuesBackwards();

        int i = 0;
        StringBuilder builder = new StringBuilder();

        while ((number > 0) && (i < romanNumbers.size())) {
            RomanNumber currentSymbol = romanNumbers.get(i);
            if (currentSymbol.getValue() <= number) {
                builder.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return builder.toString();
    }
}
