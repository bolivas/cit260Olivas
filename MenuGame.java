
package chkrs;

import java.util.Scanner;


public class MenuGame {
    Scanner input = new Scanner(System.in);
    String instructions = "What dificulty of computer would you like to play?";
    String selection = "Default";
    int menuItems = 5;
    int difficulty = 0;
    boolean valid = false;
    public String[][] menus = {
        {"3", "Hard"}, 
        {"2", "Medium"},
	{"1", "Easy"},
	{"R", "Return to previous menu"},
	{"H", "Help"},
	};
   
    MenuPlaying menuPlaying = new MenuPlaying();
    MenuGameHelp menuGameHelp = new MenuGameHelp();
    
    
    public MenuGame(){
	
    }
    private void displayMenu(){
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
		case "3": 
		    /* this sets the dificulty variable*/
		    this.difficulty = 3;
		    this.menuPlaying.getInput();
		    break;
		case "2": 
		    this.difficulty = 2;
		    this.menuPlaying.getInput();
		    break;
		case "1": 
		    this.difficulty = 1;
		    this.menuPlaying.getInput();
		    break;
		case "R": 
		    break;
		case "H": this.menuGameHelp.getInput();
		    break;
		}
	}
	}while (valid != true);
    }
    
    /**
     *
     * @param string
     * @return
     */
    private boolean getCommand(String string){
	
	do{
	    selection = input.next().trim().toUpperCase();
	    valid = validateCommand(selection);
	    if(!valid){
		new Error().displayError("Invalid command. Please enter a valid command");
	    }
	}while (valid);
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
