/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chkrs;

import java.util.Scanner;

/**
 *
 * @author bensmac
 */
public class SelectRowMove {
    Scanner input = new Scanner(System.in);
    String instructions = "Please Select the row where you want to move the piece.";
    boolean valid = false;
    private final static String[] validInputs = {"0","1","2","3","4","5","6","7"};
    String selection;
    public int converted;
    public SelectRowMove(){
	
    }
    public int getInput(){
	while(!valid){
	System.out.println(instructions);
	selection = input.next();
	valid = validateCommand(selection);
	    if(valid){
		converted = Integer.parseInt(selection);
	    }
	}
	return converted;
    }
    private boolean validateCommand(String selection){
	for(int i = 0;i < 8;i++){
	    if(validInputs[i].equals(selection)){
		valid = true;
	    }
	}
	if(!valid){
	    new Error().displayError("Invalid command. Please enter a valid command");
	}
	return valid;
    }
}
