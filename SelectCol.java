/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package select;

import Exception.SelectException;
import chkrs.Error;
import java.io.Serializable;
import java.util.Scanner;
/**
 *
 * @author bensmac
 */
public class SelectCol implements Serializable{
    private static Scanner input = new Scanner(System.in);
    private static String instructions = "Please Select the column of the piece you would like to move";
    private static boolean valid = false;
    private final static String[] validInputs = {"A","B","C","D","E","F","G","H","a","b","c","d","e","f","g","h"};
    private static String selection;
    private static int converted;
    
    public SelectCol(){
	
    }

    public Scanner getInput() {
	return input;
    }

    public void setInput(Scanner input) {
	this.input = input;
    }

    public String getInstructions() {
	return instructions;
    }

    public void setInstructions(String instructions) {
	this.instructions = instructions;
    }

    public boolean isValid() {
	return valid;
    }

    public void setValid(boolean valid) {
	this.valid = valid;
    }

    public String getSelection() {
	return selection;
    }

    public void setSelection(String selection) {
	this.selection = selection;
    }

    public int getConverted() {
	return converted;
    }

    public void setConverted(int converted) {
	this.converted = converted;
    }
    
    
    
    public static int getStuff() throws SelectException{
	while(!SelectCol.valid){
	System.out.println(SelectCol.instructions);
	SelectCol.selection = input.next();
	try{
	    SelectCol.valid = validateCommand(SelectCol.selection);
	}
	catch(IndexOutOfBoundsException e){
	    throw new SelectException("An error has occured.");
	}
	
	    if(SelectCol.valid){
		try{
	    SelectCol.converted = convertAlpha(SelectCol.selection);
	}
	catch(IndexOutOfBoundsException e){
	    throw new SelectException("An error has occured.");
	}
		
	    }
	}
	return SelectCol.converted;
    }
    private static boolean validateCommand(String selection){
	for(int i = 0;i < 16;i++){
	    if(SelectCol.validInputs[i].equals(selection)){
		SelectCol.valid = true;
	    }
	}
	if(!SelectCol.valid){
	    new Error().displayError("Invalid command. Please enter a valid command");
	}
	return SelectCol.valid;
    }
    private static int convertAlpha(String selection){
	switch(selection){
	    case "A": SelectCol.converted = 0;
		break;
	    case "B": SelectCol.converted = 1;
		break;
	    case "C": SelectCol.converted = 2;
		break;
	    case "D": SelectCol.converted = 3;
		break;
	    case "E": SelectCol.converted = 4;
		break;
	    case "F": SelectCol.converted = 5;
		break;
	    case "G": SelectCol.converted = 6;
		break;
	    case "H": SelectCol.converted = 7;
		break;
	    case "a": SelectCol.converted = 0;
		break;
	    case "b": SelectCol.converted = 1;
		break;
	    case "c": SelectCol.converted = 2;
		break;
	    case "d": SelectCol.converted = 3;
		break;
	    case "e": SelectCol.converted = 4;
		break;
	    case "f": SelectCol.converted = 5;
		break;
	    case "g": SelectCol.converted = 6;
		break;
	    case "h": SelectCol.converted = 7;
		break;
	}
	
	return SelectCol.converted;
    }
    
}
