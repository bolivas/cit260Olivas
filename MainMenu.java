
package chkrs;

import java.util.Scanner;

/**
 *
 * @author bensmac
 */
public class MenuMain {
    Scanner input = new Scanner(System.in);
    String instructions = "Welcome to Checkers! Plese select an option below to begin.";
    String selection= "Default";
    int menuItems = 2;
    boolean valid = false;
    private final static String[][] menus = {
        {"N", "New Game"}, 
	{"H", "Help Menu"},
	};
    
    MenuMainHelp menuMainHelp = new MenuMainHelp();
    MenuGame menuGame = new MenuGame();
    public MenuMain(){
	

    }
   
    public void getInput(){
	do{
	displayMenu();
	System.out.println("\nPlease make your selection now.");
	valid = getCommand(selection);

	if(valid){
	    switch(selection){
		case "N": menuGame.getInput();
		    break;
		case "H": menuMainHelp.getInput();
		    break;
                
		}
	}
	}while (valid != true);
    }
    
    public void displayMenu(){
	System.out.println(this.instructions+"\n");

	for(int i = 0; i < this.menuItems; i++){
	    System.out.println(MenuMain.menus[i][0]+ "   " +MenuMain.menus[i][1]);
	}
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

	for(String[] row : MenuMain.menus){
	    if(row[0].equals(selection)){
		return true;
	    }
	}
	return false;
    }
    
}
