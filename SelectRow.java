/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package select;

import Exception.SelectException;
import chkrs.Error;
import java.util.Scanner;
/**
 *
 * @author bensmac
 */
public class SelectRow {
    private static Scanner input = new Scanner(System.in);
    private static String instructions = "Please Select the row of the piece you would like to move";
    private static boolean valid = false;
    private final static String[] validInputs = {"0","1","2","3","4","5","6","7"};
    private static String selection;
    private static int converted;
    
    public SelectRow(){
	
    }
    
    public int getStuff() throws SelectException{
	while(!valid){
	System.out.println(instructions);
	selection = input.next();
	try{
		valid = validateCommand(selection);
	}
	catch(IndexOutOfBoundsException e){
	    throw new SelectException("An error has occured.");
	}
	
	    if(valid){
		try{
		converted = Integer.parseInt(selection);
	}
	catch(IndexOutOfBoundsException e){
	    throw new SelectException("An error has occured.");
	}
		
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
