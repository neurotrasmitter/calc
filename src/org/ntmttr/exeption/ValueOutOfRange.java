package org.ntmttr.exeption;

public class ValueOutOfRange extends Exception{

    public ValueOutOfRange(String method){
        super(method + " вводимое значение выходит за рамки допустимых");
    }
}
