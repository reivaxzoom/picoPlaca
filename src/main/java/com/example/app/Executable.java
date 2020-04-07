package com.example.app;

import java.util.Scanner;

import com.example.services.PicoPlacaService;

public class Executable {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String RESET = "\033[0m";  
    public static final String GREEN = "\033[0;32m";   

     public static  void main(final String[] args) {
        Scanner in = new Scanner(System.in); 
        System.out.println(GREEN+ "Input date and hour: (yyyy-MM-dd)  example: 2020-01-10 14:30"+RESET); 
        String dateTime = in.nextLine(); 
        System.out.println("Datetime: "+dateTime); 
        System.out.println(GREEN+"Input plate: example: AAC0102"+RESET); 
        String plate = in.nextLine(); 
        System.out.println("Plate: "+plate); 
  
        PicoPlacaService service= new PicoPlacaService();
        String result=service.checkPermission(dateTime, plate);
        System.out.println("vehicle:" + plate + " on date: " + dateTime + " the permision is: "+result );
        in.close();
    }
}
