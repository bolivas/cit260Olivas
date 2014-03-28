/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cit260.checkers.menus;

import Exception.MenuException;
import chkrs.Error;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bensmac
 */
public abstract class Menu implements DisplayInfo, EnterInfo{
    Scanner input = new Scanner(System.in);
    public static String instructions;
    String selection = "Default";
    int menuItems;
    boolean valid = false;
    private static String menus[][];
    
    public Menu(String i, int mi, String[][] m){
	instructions = i;
	menuItems = mi;
	menus = m;
    }
    
    public void displayMenu(){
	System.out.println(this.instructions+"\n");

	for(int i = 0; i < this.menuItems; i++){
	    System.out.println(menus[i][0]+ "   " +menus[i][1]);
	}
    }
    public void getInput() throws MenuException{
	do{
	displayMenu();
	System.out.println("\nPlease make your selection now.");
	try{
	valid = getCommand(selection);
	}
	catch(NumberFormatException e){
	    throw new MenuException("You did not enter a number value. Please enter another selection");
	}
	}while (valid != true);
	executeCommands(valid);
    }
    
    public abstract void executeCommands(boolean valid);
    
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

	for(String[] row : menus){
	    if(row[0].equals(selection)){
		return true;
	    }
	}
	return false;
    }
}
