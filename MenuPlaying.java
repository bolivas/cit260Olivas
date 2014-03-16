
package chkrs;

import java.util.Scanner;

/**
 *
 * @author bensmac
 */
public class MenuPlaying extends Menu{

    private static String instructions = "Please select from the following options.";
    private static int menuItems = 2;
    private final static String[][] menus = {
        {"S", "Start Game"}, 
	{"H", "Help"},
	};
    
    MenuPlaying(){
	super(instructions,menuItems,menus);
    }
   @Override
   public void executeCommands(boolean valid){
	if(valid){
	    switch(selection){
		case "S": System.out.println("NNNNNN");//menuPlaying.getInput();
		    break;
		case "H": System.out.println("HHHHHH");//menuMainHelp.getInput();
		    break;
            }
	}
    }	
}
