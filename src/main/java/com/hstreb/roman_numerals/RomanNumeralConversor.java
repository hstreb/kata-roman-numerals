package com.hstreb.roman_numerals;

import java.util.Arrays;
import java.util.List;

public class RomanNumeralConversor {

    private static List<String> ones = Arrays.asList("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX");
    private static List<String> tens = Arrays.asList("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC");
    private static List<String> hundreds = Arrays.asList("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM");
    private static List<String> thousands = Arrays.asList("", "M", "MM", "MMM");

    public String convert(int number) throws NotSupportedRomanNumeralException {
        if (number <= 0)
            throw new NotSupportedRomanNumeralException(number + " is not supported by roman numerals!");
        return thousands.get(part(number, 1000)) +
                hundreds.get(part(number, 100)) +
                tens.get(part(number, 10)) +
                ones.get((part(number, 1)));
    }

    private int part(int number, int digit) {
        return  number % (digit * 10) / digit;
    }
}
