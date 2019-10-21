package com.example.hacking.modules.javaCoreTechnologyOne.practice;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * <p>
 *
 * </p>
 *
 * @author jintingying
 * @version 1.0
 * @date 2019/10/21
 */
public class CalendarDemo {
    public static void showCalendarOfDay(LocalDate date) {
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        date = date.minusDays(today - 1);
        DayOfWeek weekday = date.getDayOfWeek();
        int week = weekday.getValue();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");

        for (int i=1; i<week;i++)
            System.out.print("    ");

        while(date.getMonthValue() == month){
            System.out.printf("%3d", date.getDayOfMonth());
            if(date.getDayOfMonth() == today)
                System.out.print("*");
            else
                System.out.print(" ");
            date = date.plusDays(1);
            if(date.getDayOfWeek().getValue() == 1) System.out.println();
        }
        if(date.getDayOfWeek().getValue() != 1) System.out.println();

    }
}
