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
public abstract class Menu {
    Scanner input = new Scanner(System.in);
    public static String instructions;
    String selection = "Default";
    int menuItems;
    boolean valid = false;
    private static String menus[][];
    
    Menu(String i, int mi, String[][] m){
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
    public void getInput(){
	do{
	displayMenu();
	System.out.println("\nPlease make your selection now.");
	valid = getCommand(selection);
	
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
