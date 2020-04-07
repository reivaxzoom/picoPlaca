package com.example.services;

public enum PlateRules {

    MONDAY('1','2'), TUESDAY('3','4'), WEDNESDAY('5','6'), THURSDAY('7','8'), FRIDAY('9','0');

    PlateRules(char firstEndPLate, char secondEndPLate ){
        this.firstEndPlate=firstEndPLate;
        this.secondEndPlate=secondEndPLate;
    }
    private char firstEndPlate;
    private char secondEndPlate;
    
    public char getFirstEndPlate() {
         return firstEndPlate;
     }

     public char getSecondEndPlate() {
        return secondEndPlate;
    } 

}



// public enum Food {
//     HAMBURGER(7), FRIES(2), HOTDOG(3), ARTICHOKE(4);

//     Food(char price) {
//         this.price = price;
//     }

//     private final char price;

//     public char getPrice() {
//         return price;
//     }
// }
