
package cit260.checkers.menus;

import java.util.Scanner;

public class MenuMainHelp extends Menu{
    
    private static final String instructions = "What can we help you with?";
    private static int menuItems = 2;
    private final static String[][] menus = {
        {"1", "Game play instructions"}, 
        {"2", "Menu Navigation"},
	};
    
    public MenuMainHelp(){
	super(instructions,menuItems,menus);
	
    }
    
   @Override
   public void executeCommands(boolean valid){
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
