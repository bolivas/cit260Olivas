
package cit260.checkers.menus;

import java.util.Scanner;

/**
 *
 * @author bensmac
 */
public class MenuMain extends Menu{
    private static final String menus[][] = {
        {"1", "New Game"}, 
	{"2", "Help Menu"},
	};
    private static final String instructions ="Welcome to Checkers! Plese select an option below to begin.";
    private static int menuItems = 2;
    
    public MenuMain(){
	super(instructions,menuItems,menus);
    }
   
        public String executeCommands(){
	if(valid){
	    switch(selection){
		case "1": System.out.println("NNNNNN");//menuPlaying.getInput();
		    break;
		case "2": System.out.println("HHHHHH");//menuMainHelp.getInput();
		    break;
                
		}
	    
	}return selection;
    }

    @Override
    public void executeCommands(boolean valid) {
	if(valid){
	    switch(selection){
		case "1": System.out.println("NNNNNN");//menuPlaying.getInput();
		    break;
		case "2": System.out.println("HHHHHH");//menuMainHelp.getInput();
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
