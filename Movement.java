/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chkrs;

/**
 *
 * @author bensmac
 */
public class Movement {
    public void move(){
	short rowBeforeMove = 3;
	short colBeforeMove = 3;
	int rowAfterMove = 0;
	int colAfterMove = 0;
	String error = "";
	//types ul, ur, dl, dr, jul, jur, jdl, jdr
	String moveType = "dl";
	
	switch(moveType){
	    case "ul":  rowAfterMove = rowBeforeMove + 1;
			colAfterMove = colBeforeMove - 1;
			break;
	    case "ur":  rowAfterMove = rowBeforeMove + 1;
			colAfterMove = colBeforeMove + 1;
			break;
            case "dl":  rowAfterMove = rowBeforeMove - 1;
			colAfterMove = colBeforeMove - 1;
			break;
	    case "dr":  rowAfterMove = rowBeforeMove - 1;
			colAfterMove = colBeforeMove + 1;
			break;
	    case "jul": rowAfterMove = rowBeforeMove + 1 ;
			colAfterMove = colBeforeMove - 1;
			break;
	    case "jur": rowAfterMove = rowBeforeMove + 1;
			colAfterMove = colBeforeMove + 1;
			break;
            case "jdl": rowAfterMove = rowBeforeMove - 1;
			colAfterMove = colBeforeMove - 1;
			break;
	    case "jdr": rowAfterMove = rowBeforeMove - 1;
			colAfterMove = colBeforeMove + 1;
			break;
	    default: error = "\tError, Invalid Move Type\n";
			break;
		
	}
	System.out.println(error);
	System.out.println("The piece in position "+ rowBeforeMove + ","+ colBeforeMove+ " has moved "+ moveType+ " to position "+rowAfterMove+","+colAfterMove+".");
	
	
	
	
    }
    
    
    
    public void alphaNum(){
	String colBefore = "A";
	int colAfter = -1;
	String error = "";
	
	switch (colBefore){
	    case "A": colAfter = 0;
		break;
	    case "B": colAfter = 1;
		break;
	    case "C": colAfter = 2;
		break;
            case "D": colAfter = 3;
		break;
	    case "E": colAfter = 4;
		break;
	    case "F": colAfter = 5;
		break;
	    case "G": colAfter = 6;
		break;
	    case "H": colAfter = 7;
		break;
	    default: error = "Error, PLease make another selection.";
		break;
	  
	}
	
}
    
}
