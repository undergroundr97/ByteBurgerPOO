package org.InputValidor;

import java.util.Scanner;

public class InputValidator {
    static Scanner scanner = new Scanner(System.in);
    public static boolean intValidator(Scanner scanner){
       while(!scanner.hasNextInt()){
           System.out.println("Input invalido");
           scanner.next();
       }
       return true;
    }

    public static String yesNoValidator(String yesNo){
        while(!yesNo.equalsIgnoreCase("s") && !yesNo.equalsIgnoreCase("n")){
            System.out.println("Input invalido, digite S/N");
            yesNo = scanner.next();
        }
        return yesNo;
    }

    public static Integer inputInRange1to7(Integer input){
        int inp = input;
       while(inp <= 0 || inp >= 7){
           System.out.println("Input Invalido");
           InputValidator.intValidator(scanner);
           inp = scanner.nextInt();
       }
       return inp;
    }
}
