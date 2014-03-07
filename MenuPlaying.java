
package chkrs;

import java.util.Scanner;

/**
 *
 * @author bensmac
 */
public class MenuPlaying {
    Master master = new Master();
    Scanner input = new Scanner(System.in);
    String instructions = "Please select from the following options.";
    String selection= "Default";
    int menuItems = 4;
    boolean valid = false;
    private final static String[][] menus = {
        {"S", "Start Game"}, 
	{"E", "Exit this game"},
	{"R", "Return to new game menu"}, 
	{"H", "Help"},
	};
    
   
    MenuPlayingHelp menuPlayingHelp = new MenuPlayingHelp();
    
    public MenuPlaying(){

    }
   
    public void displayMenu(){
	System.out.println(this.instructions+"\n");

	for(int i = 0; i < this.menuItems; i++){
	    System.out.println(MenuPlaying.menus[i][0]+ "   " +MenuPlaying.menus[i][1]);
	}
    }
    public void getInput(){
	do{
	displayMenu();
	System.out.println("\nPlease make your selection now.");
	valid = getCommand(selection);

	if(valid){
	    switch(selection){
		case "S": master.masterRun();
		    break;
		case "E": 
		    break;
		case "R":
		    break;
		case "H": this.menuPlayingHelp.getInput();
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

	for(String[] row : MenuPlaying.menus){
	    if(row[0].equals(selection)){
		return true;
	    }
	}
	return false;
    }
    
}
