
package chkrs;

import java.util.Scanner;


public class MenuGame {
    Scanner input = new Scanner(System.in);
    
    String instructions = "What dificulty of computer would you like to play?";
    String selection = "Default";
    int menuItems = 4;
    public String[][] menus = {
        {"H", "Hard"}, 
        {"M", "Medium"},
	{"E", "Easy"},
	{"R", "Return to previous menu"},
	};
   
    public void displayMenu(){
	System.out.println(this.instructions+"\n");
	
	for(int i = 0; i < this.menuItems; i++){
	    System.out.println(this.menus[i][0]+ "   " +this.menus[i][1]);
	}
	
	System.out.println("\nPlease make your selection now.");
	this.selection = input.next().toUpperCase().trim();	
	
    }
    
}
