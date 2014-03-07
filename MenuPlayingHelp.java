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
public class MenuPlayingHelp {
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
    
    MenuPlayingHelpControl menuPlayingHelpControl = new MenuPlayingHelpControl();
    
    
    public MenuPlayingHelp(){
	
    }
   
    public void displayMenu(){
	System.out.println(this.instructions+"\n");
	
	for(int i = 0; i < this.menuItems; i++){
	    System.out.println(MenuPlayingHelp.menus[i][0]+ "   " +MenuPlayingHelp.menus[i][1]);
	}
    }
    public void getInput(){
	do{
	displayMenu();
	System.out.println("\nPlease make your selection now.");
	valid = getCommand(selection);
	
	if(valid){
	    switch(selection){
		case "I": this.menuPlayingHelpControl.instructions();
		    break;
		case "N": this.menuPlayingHelpControl.navigation();
		    break;
		case "G": this.menuPlayingHelpControl.general();
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
	
	for(String[] row : MenuPlayingHelp.menus){
	    if(row[0].equals(selection)){
		return true;
	    }
	}
	return false;
    }
}
