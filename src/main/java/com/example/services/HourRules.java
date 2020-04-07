package com.example.services;

public enum HourRules {

    MORNING_START(7,0), MORNING_END(9,30), EVENING_START(16,0), EVENING_END(19,30);

    HourRules(int hour, int minute ){
        this.hour=hour;
        this.minute=minute;
    }
    private int hour;
    private int minute;
    
    public int getHour() {
         return hour;
     }

     public int getMinute() {
        return minute;
    } 

}