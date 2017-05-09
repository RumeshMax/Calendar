/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmax.calendar;

/**
 *
 * @author ruaplk
 */
public class Day {
    private int day;
    private int month;
    private int year;
    private String description;
    private DayType type;

    public Day(int day, int month) {
        this(day, month, 0, null, DayType.NORMAL);
    }
    
    public Day(int day, int month, String description) {
        this(day, month, 0, description, DayType.NORMAL);
    }
    
    public Day(int day, int month, DayType type) {
        this(day, month, 0, null, type);
    }
    
    public Day(int day, int month, String description, DayType type) {
        this(day, month, 0, description, type);
    }
    
    public Day(int day, int month, int year, String description, DayType type) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.description = description;
        this.type = type;
    }
    
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DayType getType() {
        return type;
    }

    public void setType(DayType type) {
        this.type = type;
    }
}
