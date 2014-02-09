

package chkrs;

import java.util.Scanner;


public class MenuGame {
    Scanner input = new Scanner(System.in);
    
    String instructions = "What dificulty of computer would you like to play?";
    String selection = "Default";
    int menuItems = 4;
    boolean valid = false;
    public String[][] menus = {
        {"H", "Hard"}, 
        {"M", "Medium"},
	{"E", "Easy"},
	{"R", "Return to previous menu"},
	};
   
    private MenuGameControl gameMenuControl = new MenuGameControl();
    private Chkrs returnTo = new Chkrs();
    public MenuGame(){
	
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
		case "H": this.gameMenuControl.hard();
		    break;
		case "M": this.gameMenuControl.medium();
		    break;
		case "E": this.gameMenuControl.easy();
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
	
	for(String[] row : this.menus){
	    if(row[0].equals(selection)){
		return true;
	    }
	}
	return false;
    }
}
