package com.avanzadose.util;

import java.util.Scanner;

public class AmazonUtil {
    
    public static int validateUserResponseMenu(int min, int max){
        
        Scanner sc = new Scanner(System.in);
        
        while (!sc.hasNextInt()) {            
            sc.next();
            System.out.println("No ingresaste un opcion valida");
            System.out.println("Intenta otra vez");
        }
        
        int response = sc.nextInt();
        
        while (response < min || response > min) {            
            System.out.println("No ingresaste un opcion valida");
            System.out.println("Intenta otra vez");
            
            while (!sc.hasNextInt()) {                
                sc.next();
                System.out.println("No ingresaste una opcion valida");
                System.out.println("Intenta otra vez");
            }
            response = sc.nextInt();
        }
        System.out.println("Tu respuesta fue: " + response + "\n");
        return response;
    }
    
}
