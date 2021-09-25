package calcRA;

import java.util.InputMismatchException;
import java.util.Scanner;


public class RomanArabianCalc {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int result;

    public static void main (String[] args) {
        System.out.println("Enter the numbers [2+2] or two Roman numbers from I to X:[V+V] + Enter ");
        String userInput = scanner.nextLine();
        if (number1 > 10 && number2 > 10){
            System.out.println("Please enter numbers between 0 and 10");
            System.exit(0);;
        }
        char[] under_char = new char[10];
        for (int i = 0; i < userInput.length(); i++) {
            under_char[i] = userInput.charAt(i);
            if (under_char[i] == '+') {
                operation = '+';
            }
            if (under_char[i] == '-') {
                operation = '-';
            }
            if (under_char[i] == '*') {
                operation = '*';
            }
            if (under_char[i] == '/') {
                operation = '/';
            }
        }
        String under_charString = String.valueOf(under_char);
        String[] blacks = under_charString.split("[+-/*]");
        String stable00 = blacks[0];
        String stable01 = blacks[1];
        String string03 = stable01.trim();
        number1 = romanToNumber(stable00);
        number2 = romanToNumber(string03);
        if (number1 < 0 && number2 < 0) {
            result = 0;
        } else {
            result = calculated(number1, number2, operation);
            System.out.println("---Answer with Roman number----");
            String resultRoman = convertNumToRoman(result);
            System.out.println(stable00 + " " + operation + " " + string03 + " = " + resultRoman);
        }
        number1 = Integer.parseInt(stable00);
        number2 = Integer.parseInt(string03);
        result = calculated(number1, number2, operation);
        System.out.println("--Answer with Arabian number----");
        System.out.println(number1 + " " + operation + " " + number2 + " = " + result);
    }

    private static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX"
        };
        final String s = roman[numArabian];
        return s;
    }


    private static int romanToNumber (String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Invalid number");
        }
        return -1;
    }

    public static int calculated (int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Only integer non-zero parameters allowed");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
        return result;
    }
}