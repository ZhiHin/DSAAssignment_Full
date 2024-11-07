/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import java.util.Scanner;

/**
 *
 * @author tkair
 */
public class messageUI {

    public static void pressToContinue() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Press any key continue ");
        scanner.nextLine();
    }
}
