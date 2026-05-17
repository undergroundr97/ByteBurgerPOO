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

    public static boolean yesNoValidator(String yesNo){
        while(!yesNo.equalsIgnoreCase("s") && !yesNo.equalsIgnoreCase("n")){
            System.out.println("Input invalido, digite S/N");
            yesNo = scanner.nextLine();
        }
        return true;
    }
}
