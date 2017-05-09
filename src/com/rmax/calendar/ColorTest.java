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
public class ColorTest {

    private static final String setPlainText = "\033[0;0masd";
    private static final String setBoldText = "\033[0;1masd";

    public static void main(String[] args) {

        // http://www.santhoshreddymandadi.com/java/coloring-java-output-on-console.html
        // Install ANSI escape plug-in - https://marketplace.eclipse.org/content/ansi-escape-console
        //                               http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=1687099
//		System.out.println("\033[31;1m Hello \033[0m, \033[32;1;2m world! \033[0m");
//	    System.out.println("\033[31m Red \033[32m, Green \033[33m, Yellow \033[34m, Blue \033[0m");
//	    
        System.out.println("\033[30;1mGREY\033[0m");
        System.out.println("\033[31;1mRED\033[0m");
        System.out.println("\033[32;2mGREEN\033[0m");
        System.out.println("\033[33;2mYELLOW\033[0m");
        System.out.println("\033[34;1mBLUE\033[0m");
        System.out.println("\033[35;1mPINK\033[0m");
        System.out.println("\033[36;2mLIGHT_BLUE\033[0m");
        //System.console().
//        System.out.println(setPlainText + "Prompt>" + setBoldText);
//        System.out.println("•");
    }
}
