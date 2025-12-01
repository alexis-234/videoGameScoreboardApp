/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafinal_alexislajoie_v0.pkg1;

import java.util.Scanner;

/**
 *
 * @author alexi
 */
public class Utilities {
    public static int getUserChoice(String prompt){
        int choice = 0;
        System.out.print(prompt);
        Scanner myScanner = new Scanner(System.in);
        choice = myScanner.nextInt();
        return choice;
    }
    
}
