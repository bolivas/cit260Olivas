

package chkrs;

import java.util.Scanner;

public class Chkrs {
    Scanner input = new Scanner(System.in);
    
    String name;
    String instructions = "This a a java version of checkers. \nI Hope you enjoy playing this game."
	    + "\nYou can use the help menu any time you want to get help. Have fun!!!";
    int menuItems = 3;
    public String[][] menus = {
        {"S", "Start a new game."}, 
        {"H", "Display the help menu."},
	{"Q", "Quit and exit."},
	};
    String selection;
    
    public static void main(String[] args) {
	Chkrs myGame = new Chkrs();
	myGame.getName();
	myGame.displayMenu();
	myGame.action();
	
    }
    public void getName(){
	
	System.out.println("Please enter your name.");
	this.name = input.next().trim();
    }
    public void displayMenu(){
	System.out.println("\nWelcome "+ this.name + "\n");
	System.out.println(this.instructions+"\n");
	
	for(int i = 0; i < this.menuItems; i++){
	    System.out.println(this.menus[i][0]+ "   " +this.menus[i][1]);
	}
	
	System.out.println("\nPlease make your selection now.");
	this.selection = input.next().toUpperCase().trim();	
	
    }
    public void action(){
	System.out.println("----"+this.selection+"----");
	if(this.selection == "S"){
	    MenuGame start = new MenuGame();
	    start.displayMenu();
	    System.out.println("sssss");
	}
	else if(this.selection == "H"){
	    MenuHelp help = new MenuHelp();
	    System.out.println("Help is on the way.");
	    
	}
	else if(this.selection == "Q"){
	    System.out.println("Good Bye");
	}
	else{
	    System.out.println("Incorrect Section");
	}
    }
    
}
