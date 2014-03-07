
package chkrs;


/**
 *
 * @author bensmac
 */
public class Chkrs {
   
    
    
    public static void main(String[] args) {
	int r = 0;
	int c = 0;
	int ir = 0;
	int ic = 0;
	Intel intel = new Intel();
	Intel2 intel2 = new Intel2();
	//intel2.checkAPiece();
	//intel2.compareValues();
	Board board = new Board();
	
	/**/for(int i = 0; i < 2000; i++){
	if(intel.forTheComWin == 12){
	    System.out.println("Your simply not the best. The computers are the best.");
	    break;
	}
	if(intel2.forTheHumWin == 12){
	    System.out.println("Your simply the best. The humans are the best.");
	    break;
	}
	board.displayBoard();
	
	
	intel.run();
	
	System.out.println("\nComputer moves.\n");
	board.displayBoard();	
	
	SelectRow selectRow = new SelectRow();
	r = selectRow.getInput();
	
	SelectCol selectCol = new SelectCol();
	c = selectCol.getStuff();
	
	SelectRowMove selectRowMove = new SelectRowMove();
	ir = selectRowMove.getInput();
	
	SelectColMove selectColMove = new SelectColMove();
	ic = selectColMove.getInput();
	
	
	intel2.run(r, c, ir, ic);
	}
	/*
	PlayerInfo playerinfo = new PlayerInfo();
	playerinfo.getName();
	
	MenuMain menuMain = new MenuMain();
	menuMain.getInput();
	*/
	
	
    }
   
}
