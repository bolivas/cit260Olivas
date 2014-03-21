
package cit260.checkers.menus;

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
    
    public MenuPlaying(){
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

    @Override
    public String DisplyInfo(boolean valid) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInfo() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
