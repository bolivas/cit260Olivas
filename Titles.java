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
public enum Titles {
    BOARD ("Checker Board"),
    MAIN_MENU ("Main Menu"),
    PLAYING_MENU ("Playing Menu");
    
    String value;
    
    Titles(String value){
	this.value = value;
    }
    
    public String getValue(){
	return value;
    }
    
}
