/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chkrs;

import java.util.Scanner;

/**
 *
 * @author bensmac
 */
public class MenuPlayingHelp extends Menu{
    private static String instructions = "What can we help you with?";
    private static int menuItems = 4;
    private final static String[][] menus = {
        {"I", "Game play instructions"}, 
        {"N", "Menu Navigation"},
	{"G", "General"},
	{"R", "Return to previous menu"},
	};
    
    public MenuPlayingHelp(){
	super(instructions,menuItems,menus);
    }
   
    @Override
     public void executeCommands(boolean valid){
	if(valid){
	    switch(selection){
		case "I": System.out.println("NNNNN1");//this.menuPlayingHelpControl.instructions();
		    break;
		case "N": System.out.println("NNNNN2");//this.menuPlayingHelpControl.navigation();
		    break;
		case "G": System.out.println("NNNNN3");//this.menuPlayingHelpControl.general();
		    break;
		case "R": System.out.println("NNNNN4");//this.menuPlayingHelpControl.general();
		    break;
		}
	}
    }
}
