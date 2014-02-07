
package chkrs;

import java.util.Scanner;

public class MenuHelp {
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
    
    private MenuHelpControl helpMenuControl = new MenuHelpControl();
    private Chkrs returnTo = new Chkrs();
    public MenuHelp(){
	
    }
   
    public void displayMenu(){
	System.out.println(this.instructions+"\n");
	
	for(int i = 0; i < this.menuItems; i++){
	    System.out.println(this.menus[i][0]+ "   " +this.menus[i][1]);
	}
    }
    public void getInput(){
	do{
	displayMenu();
	System.out.println("\nPlease make your selection now.");
	valid = getCommand(selection);
	
	if(valid){
	    switch(selection){
		case "I": this.helpMenuControl.instructions();
		    break;
		case "N": this.helpMenuControl.navigation();
		    break;
		case "G": this.helpMenuControl.general();
		    break;
		case "R": this.returnTo.displayMenu();
		    break;
		}
	}
	}while (valid != true);
    }
    
    public boolean getCommand(String string){
	
	
	boolean valid = false;
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
	
	for(String[] row : MenuHelp.menus){
	    if(row[0].equals(selection)){
		return true;
	    }
	}
	return false;
    }
}
