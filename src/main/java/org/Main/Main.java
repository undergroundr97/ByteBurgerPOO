package org.Main;

import org.InputValidor.InputValidator;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um numero");
        InputValidator.intValidator(scanner);
        int variavelTeste = scanner.nextInt();
        System.out.println(variavelTeste);
    }
}
