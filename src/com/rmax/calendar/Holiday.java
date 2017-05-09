/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmax.calendar;

import java.util.ArrayList;

/**
 *
 * @author ruaplk
 */
public class Holiday {
    private String id;
    private String description;
    private ArrayList<Day> list;

    public Holiday() {
        this("0", "Default", new ArrayList<Day>());
    }
    
    public Holiday(String id, String description, ArrayList<Day> list) {
        this.id = id;
        this.description = description;
        this.list = list;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Day> getList() {
        return list;
    }

    public void setList(ArrayList<Day> list) {
        this.list = list;
    }
    
    public void addDay(int day, int month, int year, String description, DayType type) {
        Day d = new Day(day, month, year, description, type);
        this.list.add(d);
    }
    
    public void removeDay(int day, int month, int year) {
        for (int i = 0; i < this.list.size(); i++) {
            int d = this.list.get(i).getDay();
            int m = this.list.get(i).getMonth();
            int y = this.list.get(i).getYear();
            if ((d == day) && (m == month) && (y == year)) {
                this.list.remove(i);
                break;
            }
        }
    }
    
    public void removeDay(int day, int month) {
        for (int i = 0; i < this.list.size(); i++) {
            int d = this.list.get(i).getDay();
            int m = this.list.get(i).getMonth();
            if ((d == day) && (m == month)) {
                this.list.remove(i);
                break;
            }
        }
    }
    
    public static String getDayColorText(String day, DayType type) {
        String tempColoredDay = "";
        switch (type) {
            case PUBLIC:
                tempColoredDay = ("\033[34;1m" + day + "\033[0m");
                break;
            case MERCANTILE:
                tempColoredDay = ("\033[35;1m" + day + "\033[0m");
                break;
            case POYA_DAY:
                tempColoredDay = ("\033[31;1m" + day + "\033[0m");
                break;
            case WEEKEND:
                tempColoredDay = ("\033[30;1m" + day + "\033[0m");
                break;
            case OTHER:
                tempColoredDay = ("\033[32;2m" + day + "\033[0m");
                break;
            default:
                tempColoredDay = day;
                break;
        }
        return tempColoredDay;
    }
}
