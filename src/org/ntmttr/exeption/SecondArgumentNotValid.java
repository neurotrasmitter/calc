package org.ntmttr.exeption;

public class SecondArgumentNotValid extends Exception{

    public SecondArgumentNotValid(String method){
        super(method + " типы введеных значений не совпадают между собой");
    }
}
