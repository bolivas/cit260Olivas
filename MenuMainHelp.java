package chkrs;

import java.util.Scanner;

public class MenuMainHelp {
    Scanner input;
    
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
    
    MenuMainHelpControl menuMainHelpControl = new MenuMainHelpControl();
    
    public MenuMainHelp(){
	this.input = new Scanner(System.in);
	
    }
   
    public void displayMenu(){
	System.out.println(this.instructions+"\n");
	
	for(int i = 0; i < this.menuItems; i++){
	    System.out.println(MenuMainHelp.menus[i][0]+ "   " +MenuMainHelp.menus[i][1]);
	}
    }
    public void getInput(){
	do{
	displayMenu();
	System.out.println("\nPlease make your selection now.");
	valid = getCommand(selection);
	
	if(valid){
	    switch(selection){
		case "I": menuMainHelpControl.instructions();
		    break;
		case "N": menuMainHelpControl.navigation();
		    break;
		case "G": menuMainHelpControl.general();
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
	
	for(String[] row : MenuMainHelp.menus){
	    if(row[0].equals(selection)){
		return true;
	    }
	}
	return false;
    }
}
