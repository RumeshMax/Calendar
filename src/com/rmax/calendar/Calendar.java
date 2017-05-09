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
public class Calendar {

    private final static String WEEK_HEADER_1 = "Su Mo Tu We Th Fr Sa ";
    private final static String WEEK_HEADER_2 = "Sun Mon Tue Wed Thu Fri Sat ";
    private final static String SPACE_BETWEEN_DATES_1 = "   ";
    private final static String SPACE_BETWEEN_DATES_2 = "    ";
    private final static String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "Augest", "September", "October", "November", "December"};

    private final static int[] DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private final static int WEEK_HEADER_LENGTH_1 = WEEK_HEADER_1.length();
    private final static int WEEK_HEADER_LENGTH_2 = WEEK_HEADER_2.length();
    private final static int NUM_OF_MONTHS = 12;
    private final static int NUM_OF_DAYS_IN_WEEK = 7;
    private final static int DAYS_IN_LEAP_YEAR = 29;
    private final static int DEFAULT_NUM_OF_MONTHS_PER_ROW = 4;

    public final static int CALENDAR_TYPE_1 = 1;
    public final static int CALENDAR_TYPE_2 = 2;
    public final static int HEADER_ALIGNMENT_LEFT = 3;
    public final static int HEADER_ALIGNMENT_MIDDLE = 2;
    public final static int HEADER_ALIGNMENT_RIGHT = 1;
    
    public final static int HOLIDAY_TYPE_PUBLIC = 1; // public holiday
    public final static int HOLIDAY_TYPE_MERCANTILE = 2; // mercantile holiday
    public final static int HOLIDAY_TYPE_POYA_DAY = 3; // poya day
    public final static int HOLIDAY_TYPE_OTHER = 4; // other
    
    private final static int DEFAULT_COLOR_FOR_DAY = 0; // black
    private final static int DEFAULT_COLOR_FOR_HOLIDAY_TYPE_PUBLIC = 1; // blue
    private final static int DEFAULT_COLOR_FOR_HOLIDAY_TYPE_MERCANTILE = 2; // pink
    private final static int DEFAULT_COLOR_FOR_HOLIDAY_TYPE_POYA_DAY = 3; // red
    private final static int DEFAULT_COLOR_FOR_HOLIDAY_TYPE_OTHER = 4; // green

    public static void printYear(int year) {
        printYear(year, DEFAULT_NUM_OF_MONTHS_PER_ROW, CALENDAR_TYPE_1, HEADER_ALIGNMENT_RIGHT, true, false, false, null);
    }
    
    public static void printYear(int year, Holiday holidays) {
        printYear(year, DEFAULT_NUM_OF_MONTHS_PER_ROW, CALENDAR_TYPE_1, HEADER_ALIGNMENT_RIGHT, true, false, false, holidays);
    }

    public static void printYear(int year, boolean printHeaderAndFooter) {
        printYear(year, DEFAULT_NUM_OF_MONTHS_PER_ROW, CALENDAR_TYPE_1, HEADER_ALIGNMENT_RIGHT, false, printHeaderAndFooter, printHeaderAndFooter, null);
    }
    
    public static void printYear(int year, boolean printHeaderAndFooter, Holiday holidays) {
        printYear(year, DEFAULT_NUM_OF_MONTHS_PER_ROW, CALENDAR_TYPE_1, HEADER_ALIGNMENT_RIGHT, false, printHeaderAndFooter, printHeaderAndFooter, holidays);
    }

    public static void printYear(int year, boolean printHeader, boolean printFooter) {
        printYear(year, DEFAULT_NUM_OF_MONTHS_PER_ROW, CALENDAR_TYPE_1, HEADER_ALIGNMENT_RIGHT, true, printHeader, printFooter, null);
    }
    
    public static void printYear(int year, boolean printHeader, boolean printFooter, Holiday holidays) {
        printYear(year, DEFAULT_NUM_OF_MONTHS_PER_ROW, CALENDAR_TYPE_1, HEADER_ALIGNMENT_RIGHT, true, printHeader, printFooter, holidays);
    }

    public static void printYear(int year, int numOfMonthsPerRow) {
        printYear(year, numOfMonthsPerRow, CALENDAR_TYPE_1, HEADER_ALIGNMENT_RIGHT, true, false, false, null);
    }
    
    public static void printYear(int year, int numOfMonthsPerRow, Holiday holidays) {
        printYear(year, numOfMonthsPerRow, CALENDAR_TYPE_1, HEADER_ALIGNMENT_RIGHT, true, false, false, holidays);
    }

    public static void printYear(int year, int numOfMonthsPerRow, boolean printHeader, boolean printFooter) {
        printYear(year, numOfMonthsPerRow, CALENDAR_TYPE_1, HEADER_ALIGNMENT_RIGHT, true, printHeader, printFooter, null);
    }

    public static void printYear(int year, int numOfMonthsPerRow, int calendarType) {
        printYear(year, numOfMonthsPerRow, calendarType, HEADER_ALIGNMENT_RIGHT, true, false, false, null);
    }
    
    public static void printYear(int year, int numOfMonthsPerRow, int calendarType, Holiday holidays) {
        printYear(year, numOfMonthsPerRow, calendarType, HEADER_ALIGNMENT_RIGHT, true, false, false, holidays);
    }

    public static void printYear(int year, int numOfMonthsPerRow, int calendarType, boolean printHeader, boolean printFooter) {
        printYear(year, numOfMonthsPerRow, calendarType, HEADER_ALIGNMENT_RIGHT, true, printHeader, printFooter, null);
    }
    
    public static void printYear(int year, int numOfMonthsPerRow, int calendarType, boolean printHeader, boolean printFooter, Holiday holidays) {
        printYear(year, numOfMonthsPerRow, calendarType, HEADER_ALIGNMENT_RIGHT, true, printHeader, printFooter, holidays);
    }

    public static void printYear(int year, int numOfMonthsPerRow, int calendarType, int headerAlignment) {
        printYear(year, numOfMonthsPerRow, calendarType, headerAlignment, true, false, false, null);
    }
    
    public static void printYear(int year, int numOfMonthsPerRow, int calendarType, int headerAlignment, boolean printHeader, boolean printFooter, Holiday holidays) {
        printYear(year, numOfMonthsPerRow, calendarType, headerAlignment, false, printHeader, printFooter, holidays);
    }

    public static void printYear(int year, int numOfMonthsPerRow, int calendarType, int headerAlignment, boolean printYear, boolean printHeader, boolean printFooter, Holiday holidays) {
        ArrayList<ArrayList<String>> months = new ArrayList<ArrayList<String>>();
        ArrayList<String> calendarHeaders = new ArrayList<String>();

        // Print header
        if (printHeader) {
            printCalendarHeader(year, numOfMonthsPerRow, calendarType);
        }

        // Get calendar bodies
        for (int month = 1; month <= NUM_OF_MONTHS; month++) {
            int numOfDays = DAYS[month - 1];

            // Check if it is a leap year
            if ((month == 2) && isLeapYear(year)) {
                numOfDays = DAYS_IN_LEAP_YEAR;
            }

            int startDay = getMonthStartingDay(1, month, year);

            months.add(getCalendar(numOfDays, startDay, calendarType));

            // Get calendar headers
            String[] calHeader = null;
            if (printYear) {
                calHeader = getMonthHeader(month, year, calendarType, headerAlignment);
            } else {
                calHeader = getMonthHeader(month, calendarType, headerAlignment);
            }
            for (int j = 0; j < calHeader.length; j++) {
                calendarHeaders.add(calHeader[j]);
            }
        }

        for (int i = 0; i < NUM_OF_MONTHS; i++) {
            int tempIValue = i;

            // Print month e.g.: January 2016
            for (int j = 0; j < numOfMonthsPerRow; j++) {
                if (i < NUM_OF_MONTHS) {
                    System.out.print(calendarHeaders.get(2 * i));
                    System.out.print(getSpacesBetweenDates(calendarType));
                    i++;
                }
            }
            System.out.println();
            i = tempIValue;

            // Print week header e.g.: Su Mo Tu We Th Fr Sa
            for (int j = 0; j < numOfMonthsPerRow; j++) {
                if (i < NUM_OF_MONTHS) {
                    System.out.print(calendarHeaders.get((2 * i) + 1));
                    System.out.print(getSpacesBetweenDates(calendarType));
                    i++;
                }
            }
            System.out.println();

            // Print calendar
            for (int l = 0; l < 6; l++) {
                for (int m = 0; m < numOfMonthsPerRow; m++) {
                    for (int n = 0; n < NUM_OF_DAYS_IN_WEEK; n++) {
                        if ((m + tempIValue) < NUM_OF_MONTHS) {
                            if (months.get(m + tempIValue).size() > (n + (l * NUM_OF_DAYS_IN_WEEK))) {
                                int monthIndex = (m + tempIValue);
                                int dayIndex = (n + (l * NUM_OF_DAYS_IN_WEEK));
                                String dayToPrint = months.get(monthIndex).get(dayIndex);
                                
                                boolean isHoliday = false;
                                if (holidays != null) {
                                    for (int k = 0; k < holidays.getList().size(); k++) {
                                        int dd = holidays.getList().get(k).getDay();
                                        int mm = holidays.getList().get(k).getMonth();
                                        if ((String.valueOf(dd).trim().equalsIgnoreCase(months.get(monthIndex).get(dayIndex).trim())) && (mm == (monthIndex + 1))) {
                                            System.out.print(Holiday.getDayColorText(dayToPrint, holidays.getList().get(k).getType()));
                                            isHoliday = true;
                                            break;
                                        } else {
                                            isHoliday = false;
                                        }
                                    }
                                }
                                
                                if (!isHoliday) {
                                    if ((n == 0) || (n == 6)) {
                                        System.out.print(Holiday.getDayColorText(dayToPrint, DayType.WEEKEND));
                                    } else {
                                        System.out.print(dayToPrint);
                                    }
                                }
                            }
                        }
                    }
                    System.out.print(getSpacesBetweenDates(calendarType));
                }
                System.out.println();
            }

            System.out.println();
            i--;
        }

        // Print footer
        if (printFooter) {
            printCalendarFooter(year, numOfMonthsPerRow, calendarType);
        }
    }

    public static void printMonth(int month, int year) {
        printMonth(month, year, CALENDAR_TYPE_1, HEADER_ALIGNMENT_RIGHT, false, null);
    }

    public static void printMonth(int month, int year, int calendarType) {
        printMonth(month, year, calendarType, HEADER_ALIGNMENT_RIGHT, false, null);
    }

    public static void printMonth(int month, int year, int calendarType, int headerAlignment) {
        printMonth(month, year, calendarType, headerAlignment, false, null);
    }
    
    public static void printMonth(int month, int year, int calendarType, int headerAlignment, Holiday holidays) {
        printMonth(month, year, calendarType, headerAlignment, false, holidays);
    }

    public static void printMonth(int month, int year, int calendarType, int headerAlignment, boolean printYear, Holiday holidays) {
        int numOfDays = DAYS[month - 1];

        // Check if it is a leap year
        if ((month == 2) && isLeapYear(year)) {
            numOfDays = DAYS_IN_LEAP_YEAR;
        }

        int startDay = getMonthStartingDay(1, month, year);

        String[] tempHeader = null;
        if (printYear) {
            tempHeader = getMonthHeader(month, year, calendarType, headerAlignment);
        } else {
            tempHeader = getMonthHeader(month, calendarType, headerAlignment);
        }
        if (tempHeader != null) {
            System.out.println(tempHeader[0]);
            System.out.println(tempHeader[1]);
        }
        printCalendarBody(month, getCalendar(numOfDays, startDay, calendarType), holidays);
    }

    private static void printCalendarBody(ArrayList<String> days) {
        for (int i = 0; i < days.size(); i++) {
            for (int j = 0; j < NUM_OF_DAYS_IN_WEEK; j++) {
                if (i < days.size()) {
                    System.out.print(days.get(i));
                }
                i++;
            }
            System.out.println();
            i--;
        }
    }
    
    /**
     * holidays
     * int[month][day][holidayType]
     * 
     * @param month
     * @param holidays 
     */
    private static void printCalendarBody(int month, ArrayList<String> days, Holiday holidays) {
        for (int i = 0; i < days.size(); i++) {
            for (int j = 0; j < NUM_OF_DAYS_IN_WEEK; j++) {
                if (i < days.size()) {
                    boolean isHoliday = false;
                    if (holidays != null) {
                        for (int k = 0; k < holidays.getList().size(); k++) {
                            int d = holidays.getList().get(k).getDay();
                            int m = holidays.getList().get(k).getMonth();
                            if ((String.valueOf(d).trim().equalsIgnoreCase(days.get(i).trim())) && (m == month)) {
                                System.out.print(Holiday.getDayColorText(days.get(i), holidays.getList().get(k).getType()));
                                isHoliday = true;
                                break;
                            } else {
                                isHoliday = false;
                            }
                        }
                    }
                    if (!isHoliday) {
                        if ((j == 0) || (j == 6)) {
                            System.out.print(Holiday.getDayColorText(days.get(i), DayType.WEEKEND));
                        } else {
                            System.out.print(days.get(i));
                        }
                    }
                    i++;
                }
            }
            System.out.println();
            i--;
        }
    }
    
    private static int decideHolidayColor(int holidayType) {
        switch (holidayType) {
            case HOLIDAY_TYPE_PUBLIC:
                return DEFAULT_COLOR_FOR_HOLIDAY_TYPE_PUBLIC;
            case HOLIDAY_TYPE_MERCANTILE:
                return DEFAULT_COLOR_FOR_HOLIDAY_TYPE_MERCANTILE;
            case HOLIDAY_TYPE_POYA_DAY:
                return DEFAULT_COLOR_FOR_HOLIDAY_TYPE_POYA_DAY;
            case HOLIDAY_TYPE_OTHER:
                return DEFAULT_COLOR_FOR_HOLIDAY_TYPE_OTHER;
            default:
                return DEFAULT_COLOR_FOR_DAY;
        }
    }

    private static ArrayList<String> getCalendar(int numOfDays, int startDay, int calendarType) {
        boolean isCalendarStartDatePrinted = false;
        ArrayList<String> arr = new ArrayList<String>();

        for (int i = 1; i <= numOfDays; i++) {
            for (int j = 0; j < NUM_OF_DAYS_IN_WEEK; j++) {
                if (!isCalendarStartDatePrinted) {
                    for (int k = 1; k < startDay; k++) {
                        arr.add(getSpacesBetweenDates(calendarType));
                        j++;
                    }
                    j--;
                    isCalendarStartDatePrinted = true;
                } else if (i <= numOfDays) {
                    arr.add(getCalendarDate(i, calendarType));
                    if (i == numOfDays) {
                        int t = (arr.size() % NUM_OF_DAYS_IN_WEEK);
                        int emptySpaces = (NUM_OF_DAYS_IN_WEEK - t);
                        if (emptySpaces != NUM_OF_DAYS_IN_WEEK) {
                            for (int m = 0; m < emptySpaces; m++) {
                                arr.add(getSpacesBetweenDates(calendarType));
                            }
                        }
                    }
                    i++;
                }
            }
            i--;
        }
        int spaceCount = (42 % arr.size());
        for (int i = 0; i < spaceCount; i++) {
            arr.add(getSpacesBetweenDates(calendarType));
        }
        return arr;
    }

    /**
     * Given the month (M), day (D), and year (Y), return which day
     * of the week it falls on according to the Gregorian calendar.
     * For M use 1 for January, 2 for February, and so forth. Outputs
     * 0 for Sunday, 1 for Monday, and so forth.
     * Start Day
     * Su Mo Tu We Th Fr Sa
     *  1  2  3  4  5  6  7
     * 
     * @param day
     * @param month
     * @param year
     * @return 
     */
    public static int getMonthStartingDay(int day, int month, int year) {
        int y = (year - ((14 - month) / 12));
        int x = (y + (y / 4) - (y / 100) + (y / 400));
        int m = (month + (12 * ((14 - month) / 12)) - 2);
        int d = ((day + x + (31 * m) / 12) % 7) + 1;
        return d;
    }

    // return true if the given year is a leap year
    public static boolean isLeapYear(int year) {
        return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
    }

    private static String[] getMonthHeader(int month, int calendarType, int headerAlignment) {
        String[] s = new String[2];
        String tempMonthHeader = (MONTHS[month - 1]);
        s[0] = getMonthHeaderText(tempMonthHeader, calendarType, headerAlignment);
        s[1] = getWeekHeader(calendarType);
        return s;
    }

    private static String[] getMonthHeader(int month, int year, int calendarType, int headerAlignment) {
        String[] s = new String[2];
        String tempMonthHeader = (MONTHS[month - 1] + " " + year);
        s[0] = getMonthHeaderText(tempMonthHeader, calendarType, headerAlignment);
        s[1] = getWeekHeader(calendarType);
        return s;
    }

    private static String getMonthHeaderText(String monthHeader, int calendarType, int headerAlignment) {
        switch (headerAlignment) {
            case HEADER_ALIGNMENT_LEFT:
                return leftPad((monthHeader + " "), ' ', getWeekHeaderLength(calendarType));
            case HEADER_ALIGNMENT_MIDDLE:
                return leftRightPad(monthHeader, ' ', getWeekHeaderLength(calendarType));
            case HEADER_ALIGNMENT_RIGHT:
                return rightPad(monthHeader, ' ', getWeekHeaderLength(calendarType));
            default:
                return rightPad(monthHeader, ' ', getWeekHeaderLength(calendarType));
        }
    }

    private static int getWeekHeaderLength(int calendarType) {
        switch (calendarType) {
            case CALENDAR_TYPE_1:
                return WEEK_HEADER_LENGTH_1;
            case CALENDAR_TYPE_2:
                return WEEK_HEADER_LENGTH_2;
            default:
                return WEEK_HEADER_LENGTH_1;
        }
    }

    private static String getWeekHeader(int calendarType) {
        switch (calendarType) {
            case CALENDAR_TYPE_1:
                return WEEK_HEADER_1;
            case CALENDAR_TYPE_2:
                return WEEK_HEADER_2;
            default:
                return WEEK_HEADER_1;
        }
    }

    private static String getSpacesBetweenDates(int calendarType) {
        switch (calendarType) {
            case CALENDAR_TYPE_1:
                return SPACE_BETWEEN_DATES_1;
            case CALENDAR_TYPE_2:
                return SPACE_BETWEEN_DATES_2;
            default:
                return SPACE_BETWEEN_DATES_1;
        }
    }

    private static String getCalendarDate(int day, int calendarType) {
        switch (calendarType) {
            case CALENDAR_TYPE_1:
                return (leftPad(String.valueOf(day), ' ', (SPACE_BETWEEN_DATES_1.length() - 1)) + " ");
            case CALENDAR_TYPE_2:
                return (leftPad(String.valueOf(day), ' ', (SPACE_BETWEEN_DATES_2.length() - 1)) + " ");
            default:
                return (leftPad(String.valueOf(day), ' ', (SPACE_BETWEEN_DATES_1.length() - 1)) + " ");
        }
    }

    private static String getCalendarDate(String day, int calendarType) {
        switch (calendarType) {
            case CALENDAR_TYPE_1:
                return (leftPad(day, ' ', (SPACE_BETWEEN_DATES_1.length() - 1)) + " ");
            case CALENDAR_TYPE_2:
                return (leftPad(day, ' ', (SPACE_BETWEEN_DATES_2.length() - 1)) + " ");
            default:
                return (leftPad(day, ' ', (SPACE_BETWEEN_DATES_1.length() - 1)) + " ");
        }
    }

    /* Utility Methods - START */
    private static String leftPad(String text, char c, int length) {
        return (String.format("%" + String.valueOf(length) + "s", text).replace(' ', c));
    }

    private static String rightPad(String text, char c, int length) {
        return (String.format("%-" + String.valueOf(length) + "s", text).replace(' ', c));
    }

    private static String leftRightPad(String text, char c, int totalLength) {
        int textLength = text.length();
        double paddingLength = (totalLength - textLength);
        int lPadLength = ((int) Math.floor((paddingLength / 2)) + textLength);
        String lPaddedText = leftPad(text, c, lPadLength);
        int rPadLength = (int) ((Math.ceil((paddingLength / 2))) + lPaddedText.length());
        return rightPad(lPaddedText, c, rPadLength);
    }
    /* Utility Methods - FINISH */
    
    /* Header and Footer print - START */
    private static void printCalendarHeader(int year, int numOfMonthsPerRow, int calendarType) {
        int spacesBetweenDates = getSpacesBetweenDates(calendarType).length();
        int numberOfDates = (numOfMonthsPerRow * NUM_OF_DAYS_IN_WEEK);
        int numberOfSpacesBetweenMonths = (numOfMonthsPerRow - 1);
        int headerStyleLength = ((numberOfDates * getCalendarDate("", calendarType).length()) + (numberOfSpacesBetweenMonths * spacesBetweenDates) - 1);

        for (int i = 0; i < headerStyleLength; i++) {
            System.out.print("-");
        }
        System.out.println("");

        for (int i = 0; i < headerStyleLength; i++) {
            System.out.print("˄");
        }
        System.out.println("");

        System.out.println(leftRightPad(("~~~ " + year + " ~~~"), ' ', headerStyleLength));

        for (int i = 0; i < headerStyleLength; i++) {
            System.out.print("˅");
        }
        System.out.println("");

        for (int i = 0; i < headerStyleLength; i++) {
            System.out.print("-");
        }
        System.out.println("\n");
    }

    private static void printCalendarFooter(int year, int numOfMonthsPerRow, int calendarType) {
        int spacesBetweenDates = getSpacesBetweenDates(calendarType).length();
        int numberOfDates = (numOfMonthsPerRow * NUM_OF_DAYS_IN_WEEK);
        int numberOfSpacesBetweenMonths = (numOfMonthsPerRow - 1);
        int headerStyleLength = ((numberOfDates * getCalendarDate("", calendarType).length()) + (numberOfSpacesBetweenMonths * spacesBetweenDates) - 1);

        for (int i = 0; i < headerStyleLength; i++) {
            System.out.print("-");
        }
        System.out.println("");

        for (int i = 0; i < headerStyleLength; i++) {
            System.out.print("˄");
        }
        System.out.println("");

        System.out.println(leftRightPad(("~~~ " + year + " ~~~"), ' ', headerStyleLength));
//        System.out.println(leftRightPad(("~~~ " + Holiday.getDayColorText("• Public Holiday", DayType.PUBLIC) + " " +
//                                         Holiday.getDayColorText("• Mercantile Holiday", DayType.MERCANTILE) + " " +
//                                         Holiday.getDayColorText("• Poya Day", DayType.POYA_DAY) + " " +
//                                         Holiday.getDayColorText("• Other Holiday", DayType.OTHER) + " ~~~"), ' ', headerStyleLength));

        for (int i = 0; i < headerStyleLength; i++) {
            System.out.print("˅");
        }
        System.out.println("");

        for (int i = 0; i < headerStyleLength; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }
    /* Header and Footer print - FINISH */
    
    public static void main(String[] args) {
        //printMonth(2, 2016, 1);
        //printMonth(2, 2016, 1, 3);
        //printMonth(2, 2016, 1, 1, true);
        //printYear(2015, 6, 1, 3, true);
        //printYear(2015, true);
        
        //printYear(year, numOfMonthsPerRow, calendarType, HEADER_ALIGNMENT_RIGHT, true, printHeader, printFooter);
        //printYear(2016, 3, 1, 1);
        
        
//        HOLIDAY_TYPE_PUBLIC
//        HOLIDAY_TYPE_MERCANTILE
//        HOLIDAY_TYPE_POYA_DAY
//        HOLIDAY_TYPE_OTHER
        
        
        Holiday h = new Holiday();
        h.addDay(4, 2, 2016, "", DayType.PUBLIC);
        h.addDay(5, 2, 2016, "", DayType.MERCANTILE);
        h.addDay(6, 2, 2016, "", DayType.POYA_DAY);
        h.addDay(7, 2, 2016, "", DayType.OTHER);
        h.addDay(19, 2, 2016, "", DayType.MERCANTILE);
        
        //printMonth(month, year, calendarType, headerAlignment, false, holidays);
        //printMonth(2, 2016, 1, 1);
        
        printYear(2017, 6, 1, 1, true, true, h);
    }
}
