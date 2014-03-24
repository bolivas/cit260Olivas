/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package select;

import chkrs.Error;
import java.util.Scanner;

/**
 *
 * @author bensmac
 */
public class SelectRowMove {
    private static Scanner input = new Scanner(System.in);
    private static String instructions = "Please Select the row where you want to move the piece.";
    private static  boolean valid = false;
    private final static String[] validInputs = {"0","1","2","3","4","5","6","7"};
    private static String selection;
    private static int converted;
    
    public SelectRowMove(){
	
    }

    public static Scanner getInput() {
	return input;
    }

    public static void setInput(Scanner input) {
	SelectRowMove.input = input;
    }

    public static String getInstructions() {
	return instructions;
    }

    public static void setInstructions(String instructions) {
	SelectRowMove.instructions = instructions;
    }

    public static boolean isValid() {
	return valid;
    }

    public static void setValid(boolean valid) {
	SelectRowMove.valid = valid;
    }

    public static String getSelection() {
	return selection;
    }

    public static void setSelection(String selection) {
	SelectRowMove.selection = selection;
    }

    public static int getConverted() {
	return converted;
    }

    public static void setConverted(int converted) {
	SelectRowMove.converted = converted;
    }
    
    
    
    public int getStuff(){
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
