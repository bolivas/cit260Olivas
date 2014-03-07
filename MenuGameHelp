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
public class MenuGameHelp {
    Scanner input = new Scanner(System.in);
    
    String instructions = "What can we help you with?";
    String selection= "Default";
    int menuItems = 4;
    boolean valid = false;
    private final static String[][] menus = {
        {"I", "Game play instructions"}, 
        {"N", "Menu Navigation"},
	{"G", "General"},
	{"R", "Return to previous menu"},
	};
    
    MenuGameHelpControl menuGameHelpControl = new MenuGameHelpControl();
    
    public MenuGameHelp(){
	
    }
   
    public void displayMenu(){
	System.out.println(this.instructions+"\n");
	
	for(int i = 0; i < this.menuItems; i++){
	    System.out.println(MenuGameHelp.menus[i][0]+ "   " +MenuGameHelp.menus[i][1]);
	}
    }
    public void getInput(){
	do{
	displayMenu();
	System.out.println("\nPlease make your selection now.");
	valid = getCommand(selection);
	
	if(valid){
	    switch(selection){
		case "I": this.menuGameHelpControl.instructions();
		    break;
		case "N": this.menuGameHelpControl.navigation();
		    break;
		case "G": this.menuGameHelpControl.general();
		    break;
		case "R": 
		    break;
		}
	}
	}while (valid != true);
    }
    
    public boolean getCommand(String string){
	
	do{
	    selection = input.next().trim().toUpperCase();
	    valid = validateCommand(selection);
	    if(!valid){
		new Error().displayError("Invalid command. Please enter a valid command");
	    }
	}while (!valid);
	return true;
    }
    
    private boolean validateCommand(String command){
	
	for(String[] row : MenuGameHelp.menus){
	    if(row[0].equals(selection)){
		return true;
	    }
	}
	return false;
    }
}
