/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chkrs;

import java.util.Scanner;


 
public class GetPoints {
    int won = 0;
    int lost = 0;
    int kings = 0;
    int total = 0;
    
    Scanner input = new Scanner(System.in);

    public int getpoints(){
	if (won < 0){
	    System.out.println("Invalid point calculation");
	    return -1;
	}
	if (lost < 0){
	    System.out.println("Invalid point calculation");
	    return -1;
	}
	if (kings < 0){
	    System.out.println("Invalid point calculation");
	    return -1;
	}
   
   
	total = ((won * 100) + (lost * 50) + (kings * 50));

         return total; 
    }
    
    
    
}
