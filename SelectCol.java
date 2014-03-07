/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chkrs;

import java.io.Serializable;
import java.util.Scanner;
/**
 *
 * @author bensmac
 */
public class SelectCol implements Serializable{
    Scanner input = new Scanner(System.in);
    private String instructions = "Please Select the column of the piece you would like to move";
    private boolean valid = false;
    private final static String[] validInputs = {"A","B","C","D","E","F","G","H","a","b","c","d","e","f","g","h"};
    private String selection;
    private int converted;
    
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
    
    
    
    public int getStuff(){
	while(!this.valid){
	System.out.println(this.instructions);
	this.selection = input.next();
	this.valid = validateCommand(this.selection);
	    if(this.valid){
		this.converted = convertAlpha(this.selection);
	    }
	}
	return this.converted;
    }
    private boolean validateCommand(String selection){
	for(int i = 0;i < 16;i++){
	    if(this.validInputs[i].equals(selection)){
		this.valid = true;
	    }
	}
	if(!this.valid){
	    new Error().displayError("Invalid command. Please enter a valid command");
	}
	return this.valid;
    }
    private int convertAlpha(String selection){
	switch(selection){
	    case "A": this.converted = 0;
		break;
	    case "B": this.converted = 1;
		break;
	    case "C": this.converted = 2;
		break;
	    case "D": this.converted = 3;
		break;
	    case "E": this.converted = 4;
		break;
	    case "F": this.converted = 5;
		break;
	    case "G": this.converted = 6;
		break;
	    case "H": this.converted = 7;
		break;
	    case "a": this.converted = 0;
		break;
	    case "b": this.converted = 1;
		break;
	    case "c": this.converted = 2;
		break;
	    case "d": this.converted = 3;
		break;
	    case "e": this.converted = 4;
		break;
	    case "f": this.converted = 5;
		break;
	    case "g": this.converted = 6;
		break;
	    case "h": this.converted = 7;
		break;
	}
	
	return this.converted;
    }
    
}
