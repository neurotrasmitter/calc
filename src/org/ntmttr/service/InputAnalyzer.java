package org.ntmttr.service;

import org.ntmttr.exeption.SecondArgumentNotValid;
import org.ntmttr.exeption.ValueOutOfRange;
import org.ntmttr.model.Converter;

public class InputAnalyzer {

    private String[] expression;
    private Double first;
    private Double second;
    private Boolean isRome;

    public InputAnalyzer(String expression) {
        this.expression = expression.trim().split("\s+");
        this.isRome = isRomeNumber(0);
    }

    public String solve() throws SecondArgumentNotValid, ValueOutOfRange {
        Double result;
        if (!isEquals()) {
            throw new SecondArgumentNotValid("InputAnalyzer:solve");
        }
        toInteger();
        if (first < 1 || first > 10 || second < 1 || second > 10){
            throw new ValueOutOfRange("InputAnalyzer:solve");
        } else {
            switch (expression[1]){
                case ("+"):
                    result = first + second;
                    break;
                case ("-"):
                    result = first - second;
                    break;
                case ("*"):
                    result = first * second;
                    break;
                case ("/"):
                    result = first / second;
                    break;
                default:
                    return "некорректный символ математической операции";
            }
        }
        if (isRome){
            return Converter.arabicToRoman((int)Math.floor(result));
        } else {
            return "" + (int)Math.floor(result);
        }
    }

    private Boolean isRomeNumber(Integer num){
        try {
            Integer.parseInt(expression[num]);
            return false;
        }catch (NumberFormatException e){
            return true;
        }
    }

    private Boolean isEquals(){
        if (isRomeNumber(0) == isRomeNumber(2)){
            return true;
        } else {
            return false;
        }
    }

    private void toInteger(){
        if (isRome){
            first = new Double(Converter.romanToArabic(expression[0]));
            second = new Double(Converter.romanToArabic(expression[2]));
        } else {
            first = new Double(Integer.parseInt(expression[0]));
            second = new Double(Integer.parseInt(expression[2]));
        }
    }

}
