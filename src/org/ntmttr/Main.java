package org.ntmttr;

import org.ntmttr.exeption.SecondArgumentNotValid;
import org.ntmttr.exeption.ValueOutOfRange;
import org.ntmttr.service.InputAnalyzer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Введите число от 1 до 10 арабскими или римскими числами");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        InputAnalyzer ia = new InputAnalyzer(s);
        try {
            System.out.println(ia.solve());
        } catch (SecondArgumentNotValid e) {
            System.out.println("Типы аргументов не совпадают между собой");
        } catch (ValueOutOfRange e){
            System.out.println("Вводимое значение выходит за рамки допустимых");
        }
    }

}
