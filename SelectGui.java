/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package select;

import Exception.IntelException;
import intel.Intel2;

/**
 *
 * @author bensmac
 */
public class SelectGui {
    private int selRow = 0;
    private int selCol = 0;
    private int movRow = 0;
    private int movCol = 0;
    
    Intel2 intel2 = new Intel2();
    
    public int getMovRow() {
	return movRow;
    }

    public void setMovRow(int movRow) {
	this.movRow = movRow;
    }

    public int getMovCol() {
	return movCol;
    }

    public void setMovCol(int movCol) {
	this.movCol = movCol;
    }

    public int getSelRow() {
	return selRow;
    }

    public void setSelRow(int selRow) {
	this.selRow = selRow;
    }

    public int getSelCol() {
	return selCol;
    }

    public void setSelCol(int selCol) {
	this.selCol = selCol;
    }

    public SelectGui() {
	 
    }
    
    public void display() {
	System.out.println("Coordinates: (" + selRow + "," + selCol + ")");
    }
    public void display2() {
	System.out.println("Coordinates: (" + movRow + "," + movCol + ")");
    }
	SelectVars set = new SelectVars();
    public void run(int r, int c, int ir, int ic) throws IntelException{
	
	try{
	    intel2.run(r, c, ir, ic);
	}
	catch(IndexOutOfBoundsException e){
	    throw new IntelException("An error has occured.");
	} 
    }
    public void switchEm(){
	
    }
    
}   

