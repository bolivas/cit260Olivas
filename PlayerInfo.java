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
public class PlayerInfo {
    Scanner input = new Scanner(System.in);
    String name = "bbbbbbb";
    public void getName(){
	
	System.out.println("Please enter your name.");
	this.name = input.next().trim();
    }
}
