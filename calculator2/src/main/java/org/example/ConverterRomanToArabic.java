package org.example;

import java.util.List;
class ConverterRomanToArabic {
    /**
     * Переводит римское число в арабское
     */
    public static int convertNumber(String input) throws Exception {

        String romanNumber = input;
        int result = 0;

        List<RomanNumber> romanNumbers = RomanNumber.getValuesBackwards();

        int i = 0;

        while ((romanNumber.length() > 0) && (i < romanNumbers.size())) {
            RomanNumber symbol = romanNumbers.get(i);
            if (romanNumber.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumber = romanNumber.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumber.length() > 0) {
            throw new Exception();
        }

        return result;
    }
}
