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
public class MenuGameHelpControl {
    public void instructions(){
    	System.out.println("The goal of the game is to acquire all of the pieces from either the computer or the other player.");
	System.out.println("You are able to acquire pieces by jumping the other color. ");
    }
    
    public void navigation(){
	System.out.println("You are able to move diagonally but not directly forward or backward. ");
	System.out.println("If you need help press “H” at any point during the game or “I” to see more instructions.");
    }
    
    public void general(){
    	System.out.println("This is a game of checkers.");
    	System.out.println("Have fun and Good luck");
    }
    
}
