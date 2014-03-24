/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package intel;

import chkrs.Board;

/**
 *
 * @author bensmac
 */
public class Intel2 {
    
    
    int r = 0;
    int c = 0;
    int ir  = 0;
    int ic  = 0;
   
    int holder = 0;
    public void run(int a, int b, int ia, int ib){
	r = a;
	c = b;
	ir = ia;
	ic = ib;
	holdValues[0][0] = 0;
	holdValues[0][1] = 0;
	for(int ii = 0; ii < 16; ii++){
	    holdValues[1][ii] = 0;
	}
	count = 0;
	this.checkAPiece();
	this.printMoves();
	this.compareValues();
	System.out.println("holder: " + holder);
	this.checkMoveOk();
		
    }
    int[][] holdValues = {
	{0,0},
	{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    };
    int count = 0;
    
    public void checkMoveOk(){
	for(int i = 0; i < 16; i++){
	    if(holdValues[1][i] == holder){
		
		this.movePiece();
	    }
	}
    }
    
    public void printMoves(){
	System.out.print(holdValues[0][0] +","+holdValues[0][1]+ ": " );
	for(int i = 0; i < 16; i++){
	    System.out.print(holdValues[1][i] + ", " );
	}
    }
    
    
    public void compareValues(){
	holder = 0;
	if((ir == r - 1)&&(ic == c + 1)){
	    holder = 1;
	}
	if((ir == r - 1)&&(ic == c - 1)){
	    holder = 2;
	}
	if((ir == r - 2)&&(ic == c + 2)){
	    holder = 3;
	}
	if((ir == r - 2)&&(ic == c - 2)){
	    holder = 4;
	}
	if((ir == r - 4)&&(ic == c)){
	   if(Board.brd[r - 1][c+1] != " "){
		if(Board.brd[r - 2][c+2] == " "){
		    if(Board.brd[r - 3][c +1] != " "){
			if(Board.brd[r - 4][c] == " "){
	    holder = 5;
			}
		    }
		}
	    }
	}
	if((ir == r - 4)&&(ic == c)){
	    if(Board.brd[r -1][c-1] != " "){
		if(Board.brd[r - 1][c-2] == " "){
		    if(Board.brd[r - 1][c-1] != " "){
			if(Board.brd[r -1][c] == " "){
	    holder = 6;
			}
		    }
		}
	    }
	}
	if((ir == r - 4)&&(ic == c + 4)){
	    holder = 7;
	}
	if((ir == r - 4)&&(ic == c - 4)){
	    holder = 8;
	}
	if((ir == r + 1)&&(ic == c + 1)){
	    holder = 11;
	}
	if((ir == r + 1)&&(ic == c - 1)){
	    holder = 22;
	}
	if((ir == r + 2)&&(ic == c + 2)){
	    holder = 33;
	}
	if((ir == r + 2)&&(ic == c - 2)){
	    holder = 44;
	}
	if((ir == r + 4)&&(ic == c)){
	    if(Board.brd[r+1][c+1] != " "){
		if(Board.brd[r+2][c+2] == " "){
		    if(Board.brd[r+3][c+1] != " "){
			if(Board.brd[r+4][c] == " "){
	    holder = 55;
			}
		    }
		}
	    }
	}
	if((ir == r + 4)&&(ic == c)){
	    if(Board.brd[r+1][c-1] != " "){
		if(Board.brd[r+2][c-2] == " "){
		    if(Board.brd[r+3][c-1] != " "){
			if(Board.brd[r+4][c] == " "){
	    holder = 66;
			}
		    }
		}
	    }
	}
	if((ir == r + 4)&&(ic == c + 4)){
	    holder = 77;
	}
	if((ir == r + 4)&&(ic == c - 4)){
	    holder = 88;
	}
	System.out.println("holder: "+ holder);
    }
    
    int check = 0;
    String marker = " ";
    public int forTheHumWin = 0;
    public void movePiece(){
	
	marker = Board.brd[r][c];
	check = this.holder;
	switch(check){
	    case 1:
		Board.brd[r][c] = " ";
		if(r - 1 == 0){
		    marker = "1";
		}
		switch(marker){
		    case "X":
			Board.brd[r-1][c+1] = "X";
			break;
		    case "1":
			Board.brd[r-1][c+1] = "1";
			break;
		    case "O":
			Board.brd[r-1][c+1] = "O";
			break;
		    case "2":
			Board.brd[r-1][c+1] = "2";
			break; 
		}
		break;
	    case 2:
		Board.brd[r][c] = " ";
		if(r - 1== 0){
		    marker = "1";
		}
		switch(marker){
		    case "X":
			Board.brd[r-1][c-1] = "X";
			break;
		    case "1":
			Board.brd[r-1][c-1] = "1";
			break;
		    case "O":
			Board.brd[r-1][c-1] = "O";
			break;
		    case "2":
			Board.brd[r-1][c-1] = "2";
			break; 
		}
		break;
	    case 3:
		forTheHumWin++;
		Board.brd[r][c] = " ";
		Board.brd[r-1][c+1] = " ";
		if(r - 2 == 0){
		    marker = "1";
		}
		switch(marker){
		    case "X":
			Board.brd[r-2][c+2] = "X";
			break;
		    case "1":
			Board.brd[r-2][c+2] = "1";
			break;
		    case "O":
			Board.brd[r-2][c+2] = "O";
			break;
		    case "2":
			Board.brd[r-2][c+2] = "2";
			break; 
		}
		break;
	    case 4:
		forTheHumWin++;
		Board.brd[r][c] = " ";
		Board.brd[r-1][c-1] = " ";
		if(r - 2 == 0){
		    marker = "1";
		}
		switch(marker){
		    case "X":
			Board.brd[r-2][c-2] = "X";
			break;
		    case "1":
			Board.brd[r-2][c-2] = "1";
			break;
		    case "O":
			Board.brd[r-2][c-2] = "O";
			break;
		    case "2":
			Board.brd[r-2][c-2] = "2";
			break; 
		}
		break;
	    case 5:
		forTheHumWin++;
		forTheHumWin++;
		Board.brd[r][c] = " ";
		Board.brd[r-1][c+1] = " ";
		Board.brd[r-2][c+2] = " ";
		Board.brd[r-3][c+1] = " ";
		if(r - 4 == 0){
		    marker = "1";
		}
		switch(marker){
		    case "X":
			Board.brd[r-4][c] = "X";
			break;
		    case "1":
			Board.brd[r-4][c] = "1";
			break;
		    case "O":
			Board.brd[r-4][c] = "O";
			break;
		    case "2":
			Board.brd[r-4][c] = "2";
			break; 
		}
		break;
	    case 6:
		forTheHumWin++;
		forTheHumWin++;
		Board.brd[r][c] = " ";
		Board.brd[r-1][c-1] = " ";
		Board.brd[r-2][c-2] = " ";
		Board.brd[r-3][c-1] = " ";
		if(r - 4 == 0){
		    marker = "1";
		}
		switch(marker){
		    case "X":
			Board.brd[r-4][c] = "X";
			break;
		    case "1":
			Board.brd[r-4][c] = "1";
			break;
		    case "O":
			Board.brd[r-4][c] = "O";
			break;
		    case "2":
			Board.brd[r-4][c] = "2";
			break; 
		}
		break;
	    case 7:
		forTheHumWin++;
		forTheHumWin++;
		Board.brd[r][c] = " ";
		Board.brd[r-1][c+1] = " ";
		Board.brd[r-2][c+2] = " ";
		Board.brd[r-3][c+3] = " ";
		if(r - 4 == 0){
		    marker = "1";
		}
		switch(marker){
		    case "X":
			Board.brd[r-4][c+4] = "X";
			break;
		    case "1":
			Board.brd[r-4][c+4] = "1";
			break;
		    case "O":
			Board.brd[r-4][c+4] = "O";
			break;
		    case "2":
			Board.brd[r-4][c+4] = "2";
			break; 
		}
		break;
	    case 8:
		forTheHumWin++;
		forTheHumWin++;
		Board.brd[r][c] = " ";
		Board.brd[r-1][c-1] = " ";
		Board.brd[r-2][c-2] = " ";
		Board.brd[r-3][c-3] = " ";
		if(r - 4 == 0){
		    marker = "1";
		}
		switch(marker){
		    case "X":
			Board.brd[r-4][c-4] = "X";
			break;
		    case "1":
			Board.brd[r-4][c-4] = "1";
			break;
		    case "O":
			Board.brd[r-4][c-4] = "O";
			break;
		    case "2":
			Board.brd[r-4][c-4] = "2";
			break; 
		}
		break;
	    case 11:
		Board.brd[r][c] = " ";
		if(r + 1 == 0){
		    marker = "1";
		}
		switch(marker){
		    case "X":
			Board.brd[r+1][c+1] = "X";
			break;
		    case "1":
			Board.brd[r+1][c+1] = "1";
			break;
		    case "O":
			Board.brd[r+1][c+1] = "O";
			break;
		    case "2":
			Board.brd[r+1][c+1] = "2";
			break; 
		}
		break;
	    case 22:
		Board.brd[r][c] = " ";
		if(r + 1 == 0){
		    marker = "1";
		}
		switch(marker){
		    case "X":
			Board.brd[r+1][c-1] = "X";
			break;
		    case "1":
			Board.brd[r+1][c-1] = "1";
			break;
		    case "O":
			Board.brd[r+1][c-1] = "O";
			break;
		    case "2":
			Board.brd[r+1][c-1] = "2";
			break; 
		}
		break;
	    case 33:
		forTheHumWin++;
		Board.brd[r][c] = " ";
		Board.brd[r+1][c+1] = " ";
		if(r + 2 == 0){
		    marker = "1";
		}
		switch(marker){
		    case "X":
			Board.brd[r+2][c+2] = "X";
			break;
		    case "1":
			Board.brd[r+2][c+2] = "1";
			break;
		    case "O":
			Board.brd[r+2][c+2] = "O";
			break;
		    case "2":
			Board.brd[r+2][c+2] = "2";
			break; 
		}
		break;
	    case 44:
		forTheHumWin++;
		Board.brd[r][c] = " ";
		Board.brd[r+1][c-1] = " ";
		if(r + 2 == 0){
		    marker = "1";
		}
		switch(marker){
		    case "X":
			Board.brd[r+2][c-2] = "X";
			break;
		    case "1":
			Board.brd[r+2][c-2] = "1";
			break;
		    case "O":
			Board.brd[r+2][c-2] = "O";
			break;
		    case "2":
			Board.brd[r+2][c-2] = "2";
			break; 
		}
		break;
	    case 55:
		forTheHumWin++;
		forTheHumWin++;
		Board.brd[r][c] = " ";
		Board.brd[r+1][c+1] = " ";
		Board.brd[r+2][c+2] = " ";
		Board.brd[r+3][c+1] = " ";
		if(r + 4 == 0){
		    marker = "1";
		}
		switch(marker){
		    case "X":
			Board.brd[r+4][c] = "X";
			break;
		    case "1":
			Board.brd[r+4][c] = "1";
			break;
		    case "O":
			Board.brd[r+4][c] = "O";
			break;
		    case "2":
			Board.brd[r+4][c] = "2";
			break; 
		}
		break;
	    case 66:
		forTheHumWin++;
		forTheHumWin++;
		Board.brd[r][c] = " ";
		Board.brd[r+1][c-1] = " ";
		Board.brd[r+2][c-2] = " ";
		Board.brd[r+3][c-1] = " ";
		if(r + 4 == 0){
		    marker = "1";
		}
		switch(marker){
		    case "X":
			Board.brd[r+4][c] = "X";
			break;
		    case "1":
			Board.brd[r+4][c] = "1";
			break;
		    case "O":
			Board.brd[r+4][c] = "O";
			break;
		    case "2":
			Board.brd[r+4][c] = "2";
			break; 
		}
		break;
	    case 77:
		forTheHumWin++;
		forTheHumWin++;
		Board.brd[r][c] = " ";
		Board.brd[r+1][c+1] = " ";
		Board.brd[r+2][c+2] = " ";
		Board.brd[r+3][c+3] = " ";
		if(r + 4 == 0){
		    marker = "1";
		}
		switch(marker){
		    case "X":
			Board.brd[r+4][c+4] = "X";
			break;
		    case "1":
			Board.brd[r+4][c+4] = "1";
			break;
		    case "O":
			Board.brd[r+4][c+4] = "O";
			break;
		    case "2":
			Board.brd[r+4][c+4] = "2";
			break; 
		}
		break;
	    case 88:
		forTheHumWin++;
		forTheHumWin++;
		Board.brd[r][c] = " ";
		Board.brd[r+1][c-1] = " ";
		Board.brd[r+2][c-2] = " ";
		Board.brd[r+3][c-3] = " ";
		if(r + 4 == 0){
		    marker = "1";
		}
		switch(marker){
		    case "X":
			Board.brd[r+4][c-4] = "X";
			break;
		    case "1":
			Board.brd[r+4][c-4] = "1";
			break;
		    case "O":
			Board.brd[r+4][c-4] = "O";
			break;
		    case "2":
			Board.brd[r+4][c-4] = "2";
			break; 
		}
		break;
		    
	}
    }
    
    public void checkAPiece(){
	if((r == 7) && (c == 0)){
	    //X,1 up right
	    if(Board.brd[6][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //X,1 jump up right
	    if((Board.brd[6][1] == "2") || (Board.brd[6][1] == "O")){
		if(Board.brd[5][2] == " "){
		    holdValues[0][0] = r;
		    holdValues[0][1] = c;
		    holdValues[1][count] = 3;
		    count++;
		}
	    }
	    //X,1 angle jump up 
	    if((Board.brd[6][1] == "2") || (Board.brd[6][1] == "O")){
		if(Board.brd[5][2] == " "){
		    if((Board.brd[4][1] == "2") || (Board.brd[4][1] == "O")){
			if(Board.brd[3][0] == " "){
			    holdValues[0][0] = r;
			    holdValues[0][1] = c;
			    holdValues[1][count] = 5;
			    count++;
			}
		    }
		}
	    }
	    //X,1 double jump up right
	    if((Board.brd[6][1] == "2") || (Board.brd[6][1] == "O")){
		if(Board.brd[5][2] == " "){
		    if((Board.brd[4][3] == "2") || (Board.brd[4][3] == "O")){
			if(Board.brd[3][4] == " "){
			    holdValues[0][0] = r;
			    holdValues[0][1] = c;
			    holdValues[1][count] = 7;
			    count++;
			}
		    }
		}
	    }
	}
	if((r == 7) && (c == 2)){
	    //X,1 up left
	    if(Board.brd[6][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //X,1 up right
	    if(Board.brd[6][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //X,1 jump up left
	    if((Board.brd[6][1] == "2") || (Board.brd[6][1] == "O")){
		if(Board.brd[5][0] == " "){
		    holdValues[0][0] = r;
		    holdValues[0][1] = c;
		    holdValues[1][count] = 4;
		    count++;
		}
	    }
	    //X,1 jump up right
	    if((Board.brd[6][3] == "2") || (Board.brd[6][3] == "O")){
		if(Board.brd[5][4] == " "){
		    holdValues[0][0] = r;
		    holdValues[0][1] = c;
		    holdValues[1][count] = 3;
		    count++;
		}
	    }
	    //X,1 angle jump up left
	    if((Board.brd[6][1] == "2") || (Board.brd[6][1] == "O")){
		if(Board.brd[5][0] == " "){
		    if((Board.brd[4][1] == "2") || (Board.brd[4][1] == "O")){
			if(Board.brd[3][2] == " "){
			    holdValues[0][0] = r;
			    holdValues[0][1] = c;
			    holdValues[1][count] = 6;
			    count++;
			}
		    }
		}
	    }
	    //X,1 angle jump up right
	    if((Board.brd[6][3] == "2") || (Board.brd[6][3] == "O")){
		if(Board.brd[5][4] == " "){
		    if((Board.brd[4][3] == "2") || (Board.brd[4][3] == "O")){
			if(Board.brd[3][2] == " "){
			    holdValues[0][0] = r;
			    holdValues[0][1] = c;
			    holdValues[1][count] = 5;
			    count++;
			}
		    }
		}
	    }
	    //X,1 double jump up right
	    if((Board.brd[6][3] == "2") || (Board.brd[6][3] == "O")){
		if(Board.brd[5][4] == " "){
		    if((Board.brd[4][5] == "2") || (Board.brd[4][5] == "O")){
			if(Board.brd[3][6] == " "){
			    holdValues[0][0] = r;
			    holdValues[0][1] = c;
			    holdValues[1][count] = 7;
			    count++;
			}
		    }
		}
	    } 
	}
	if((r == 7) && (c == 4)){
	    //X,1 up left
	    if(Board.brd[6][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //X,1 up right
	    if(Board.brd[6][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //X,1 jump up left
	    if((Board.brd[6][3] == "2") || (Board.brd[6][3] == "O")){
		if(Board.brd[5][2] == " "){
		    holdValues[0][0] = r;
		    holdValues[0][1] = c;
		    holdValues[1][count] = 4;
		    count++;
		}
	    }
	    //X,1 jump up right
	    if((Board.brd[6][5] == "2") || (Board.brd[6][5] == "O")){
		if(Board.brd[5][6] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    //X,1 angle jump up left
	    if((Board.brd[6][3] == "2") || (Board.brd[6][3] == "O")){
		if(Board.brd[5][2] == " "){
		    if((Board.brd[4][3] == "2") || (Board.brd[4][3] == "O")){
			if(Board.brd[3][4] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 6;
		count++;
			}
		    }
		}
	    }
	    //X,1 angle jump up right
	    if((Board.brd[6][5] == "2") || (Board.brd[6][5] == "O")){
		if(Board.brd[5][6] == " "){
		    if((Board.brd[4][5] == "2") || (Board.brd[4][5] == "O")){
			if(Board.brd[3][4] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 5;
		count++;
			}
		    }
		}
	    }
	    //X,1 double jump up left
	    if((Board.brd[6][3] == "2") || (Board.brd[6][3] == "O")){
		if(Board.brd[5][2] == " "){
		    if((Board.brd[4][1] == "2") || (Board.brd[4][1] == "O")){
			if(Board.brd[3][0] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 8;
		count++;
			}
		    }
		}
	    } 
	    
	}
	if((r == 7) && (c == 6)){
	    //X,1 up right
	    if(Board.brd[6][7] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //X,1 up left
	    if(Board.brd[6][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //X,1 jump up left
	    if((Board.brd[6][5] == "2") || (Board.brd[6][5] == "O")){
		if(Board.brd[5][4] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //X,1 angle jump up left
	    if((Board.brd[6][5] == "2") || (Board.brd[6][5] == "O")){
		if(Board.brd[5][4] == " "){
		    if((Board.brd[4][5] == "2") || (Board.brd[4][5] == "O")){
			if(Board.brd[3][6] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 6;
		count++;
			}
		    }
		}
	    }
	    //X,1 double jump up left
	    if((Board.brd[6][5] == "2") || (Board.brd[6][5] == "O")){
		if(Board.brd[5][4] == " "){
		    if((Board.brd[4][3] == "2") || (Board.brd[4][3] == "O")){
			if(Board.brd[3][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 8;
		count++;
			}
		    }
		}
	    }
	}
	if((r == 6) && (c == 1)){
	    //X,1 up left
	    if(Board.brd[5][0] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //X,1 up right
	    if(Board.brd[5][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //X,1 jump up right
	    if((Board.brd[5][2] == "2") || (Board.brd[5][2] == "O")){
		if(Board.brd[4][3] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    //X,1 angle jump up right
	    if((Board.brd[5][2] == "2") || (Board.brd[5][2] == "O")){
		if(Board.brd[4][3] == " "){
		    if((Board.brd[3][2] == "2") || (Board.brd[3][2] == "O")){
			if(Board.brd[2][1] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 5;
		count++;
			}
		    }
		}
	    }
	    //X,1 double jump up right
	    if((Board.brd[5][2] == "2") || (Board.brd[5][2] == "O")){
		if(Board.brd[4][3] == " "){
		    if((Board.brd[3][4] == "2") || (Board.brd[3][4] == "O")){
			if(Board.brd[2][5] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 7;
		count++;
			}
		    }
		}
	    } 
	    
	}
	if((r == 6) && (c == 3)){
	    //X,1 up left
	    if(Board.brd[5][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //X,1 up right
	    if(Board.brd[5][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //X,1 jump up left
	    if((Board.brd[5][2] == "2") || (Board.brd[5][2] == "O")){
		if(Board.brd[4][1] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //X,1 jump up right
	    if((Board.brd[5][4] == "2") || (Board.brd[5][4] == "O")){
		if(Board.brd[4][5] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    //X,1 angle jump up left
	    if((Board.brd[5][2] == "2") || (Board.brd[5][2] == "O")){
		if(Board.brd[4][1] == " "){
		    if((Board.brd[3][2] == "2") || (Board.brd[3][2] == "O")){
			if(Board.brd[2][3] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 6;
		count++;
			}
		    }
		}
	    }
	    //X,1 angle jump up right
	    if((Board.brd[5][4] == "2") || (Board.brd[5][4] == "O")){
		if(Board.brd[4][5] == " "){
		    if((Board.brd[3][4] == "2") || (Board.brd[3][4] == "O")){
			if(Board.brd[2][3] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 5;
		count++;
			}
		    }
		}
	    }
	    //X,1 double jump up right
	    if((Board.brd[5][4] == "2") || (Board.brd[5][4] == "O")){
		if(Board.brd[4][5] == " "){
		    if((Board.brd[3][6] == "2") || (Board.brd[3][6] == "O")){
			if(Board.brd[2][7] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 7;
		count++;
			}
		    }
		}
	    } 
	    
	}
	if((r == 6) && (c == 5)){
	    //X,1 up left
	    if(Board.brd[5][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //X,1 up right
	    if(Board.brd[5][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //X,1 jump up left
	    if((Board.brd[5][4] == "2") || (Board.brd[5][4] == "O")){
		if(Board.brd[4][3] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //X,1 jump up right
	    if((Board.brd[5][6] == "2") || (Board.brd[5][6] == "O")){
		if(Board.brd[4][7] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    //X,1 angle jump up left
	    if((Board.brd[5][4] == "2") || (Board.brd[5][4] == "O")){
		if(Board.brd[4][3] == " "){
		    if((Board.brd[3][4] == "2") || (Board.brd[3][4] == "O")){
			if(Board.brd[2][5] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 6;
		count++;
			}
		    }
		}
	    }
	    //X,1 angle jump up right
	    if((Board.brd[5][6] == "2") || (Board.brd[5][6] == "O")){
		if(Board.brd[4][7] == " "){
		    if((Board.brd[3][6] == "2") || (Board.brd[3][6] == "O")){
			if(Board.brd[2][5] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 5;
		count++;
			}
		    }
		}
	    }
	    //X,1 double jump up left
	    if((Board.brd[5][4] == "2") || (Board.brd[5][4] == "O")){
		if(Board.brd[4][3] == " "){
		    if((Board.brd[3][2] == "2") || (Board.brd[3][2] == "O")){
			if(Board.brd[2][1] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 8;
		count++;
			}
		    }
		}
	    } 
	    
	}
	if((r == 6) && (c == 7)){
	    //X,1 up left
	    if(Board.brd[5][6] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //X,1 jump up left
	    if((Board.brd[5][6] == "2") || (Board.brd[5][6] == "O")){
		if(Board.brd[4][5] == " "){
			holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //X,1 angle jump up left
	    if((Board.brd[5][6] == "2") || (Board.brd[5][6] == "O")){
		if(Board.brd[4][5] == " "){
		    if((Board.brd[3][6] == "2") || (Board.brd[3][6] == "O")){
			if(Board.brd[2][7] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 6;
		count++;
			}
		    }
		}
	    }
	    //X,1 double jump up right
	    if((Board.brd[5][6] == "2") || (Board.brd[5][6] == "O")){
		if(Board.brd[4][5] == " "){
		    if((Board.brd[3][4] == "2") || (Board.brd[3][4] == "O")){
			if(Board.brd[2][3] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 7;
		count++;
			}
		    }
		}
	    } 
	    
	}
	if((r == 5) && (c == 0)){
	    //X,1 up right
	    if(Board.brd[4][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //X,1 jump up right
	    if((Board.brd[4][1] == "2") || (Board.brd[4][1] == "O")){
		if(Board.brd[3][2] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    //X,1 angle jump up right
	    if((Board.brd[4][1] == "2") || (Board.brd[4][1] == "O")){
		if(Board.brd[3][2] == " "){
		    if((Board.brd[2][1] == "2") || (Board.brd[2][1] == "O")){
			if(Board.brd[1][0] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 5;
		count++;
			}
		    }
		}
	    }
	    //X,1 double jump up right
	    if((Board.brd[4][1] == "2") || (Board.brd[4][1] == "O")){
		if(Board.brd[3][2] == " "){
		    if((Board.brd[2][3] == "2") || (Board.brd[2][3] == "O")){
			if(Board.brd[1][4] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 7;
		count++;
			}
		    }
		}
	    }
	    
	}
	if((r == 5) && (c == 2)){
	   //X,1 up left
	    if(Board.brd[4][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //X,1 up right
	    if(Board.brd[4][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //X,1 jump up left
	    if((Board.brd[4][1] == "2") || (Board.brd[4][1] == "O")){
		if(Board.brd[3][0] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //X,1 jump up right
	    if((Board.brd[4][3] == "2") || (Board.brd[4][3] == "O")){
		if(Board.brd[3][4] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    //X,1 angle jump up left
	    if((Board.brd[4][1] == "2") || (Board.brd[4][1] == "O")){
		if(Board.brd[3][0] == " "){
		    if((Board.brd[2][1] == "2") || (Board.brd[2][1] == "O")){
			if(Board.brd[1][2] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 6;
		count++;
			}
		    }
		}
	    }
	    //X,1 angle jump up right
	    if((Board.brd[4][3] == "2") || (Board.brd[4][3] == "O")){
		if(Board.brd[3][4] == " "){
		    if((Board.brd[2][3] == "2") || (Board.brd[2][3] == "O")){
			if(Board.brd[1][2] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 5;
		count++;
			}
		    }
		}
	    }
	    //X,1 double jump up right
	    if((Board.brd[4][3] == "2") || (Board.brd[4][3] == "O")){
		if(Board.brd[3][4] == " "){
		    if((Board.brd[2][5] == "2") || (Board.brd[2][5] == "O")){
			if(Board.brd[1][6] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 7;
		count++;
			}
		    }
		}
	    }  
	    
	}
	if((r == 5) && (c == 4)){
	    //X,1 up left
	    if(Board.brd[4][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //X,1 up right
	    if(Board.brd[4][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //X,1 jump up left
	    if((Board.brd[4][3] == "2") || (Board.brd[4][3] == "O")){
		if(Board.brd[3][2] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //X,1 jump up right
	    if((Board.brd[4][5] == "2") || (Board.brd[4][5] == "O")){
		if(Board.brd[3][6] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    //X,1 angle jump up left
	    if((Board.brd[4][3] == "2") || (Board.brd[4][3] == "O")){
		if(Board.brd[3][2] == " "){
		    if((Board.brd[2][3] == "2") || (Board.brd[2][3] == "O")){
			if(Board.brd[1][4] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 6;
		count++;
			}
		    }
		}
	    }
	    //X,1 angle jump up right
	    if((Board.brd[4][5] == "2") || (Board.brd[4][5] == "O")){
		if(Board.brd[3][6] == " "){
		    if((Board.brd[2][5] == "2") || (Board.brd[2][5] == "O")){
			if(Board.brd[1][4] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 5;
		count++;
			}
		    }
		}
	    }
	    //X,1 double jump up left
	    if((Board.brd[4][3] == "2") || (Board.brd[4][3] == "O")){
		if(Board.brd[3][2] == " "){
		    if((Board.brd[2][1] == "2") || (Board.brd[2][1] == "O")){
			if(Board.brd[1][0] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 8;
		count++;
			}
		    }
		}
	    } 
	    
	}
	if((r == 5) && (c == 6)){
	    //X,1 up right
	    if(Board.brd[4][7] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //X,1 up left
	    if(Board.brd[4][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //X,1 jump up left
	    if((Board.brd[4][5] == "2") || (Board.brd[4][5] == "O")){
		if(Board.brd[3][4] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //X,1 angle jump up left
	    if((Board.brd[4][5] == "2") || (Board.brd[4][5] == "O")){
		if(Board.brd[3][4] == " "){
		    if((Board.brd[2][5] == "2") || (Board.brd[2][5] == "O")){
			if(Board.brd[1][6] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 6;
		count++;
			}
		    }
		}
	    }
	    //X,1 double jump up left
	    if((Board.brd[4][5] == "2") || (Board.brd[4][5] == "O")){
		if(Board.brd[3][4] == " "){
		    if((Board.brd[2][3] == "2") || (Board.brd[2][3] == "O")){
			if(Board.brd[1][2] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 8;
		count++;
			}
		    }
		}
	    }
	    
	}
	if((r == 4) && (c == 1)){
	    //X,1 up left
	    if(Board.brd[3][0] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //X,1 up right
	    if(Board.brd[3][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //X,1 jump up right
	    if((Board.brd[3][2] == "2") || (Board.brd[3][2] == "O")){
		if(Board.brd[2][3] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    //X,1 angle jump up right
	    if((Board.brd[3][2] == "2") || (Board.brd[3][2] == "O")){
		if(Board.brd[2][3] == " "){
		    if((Board.brd[1][2] == "2") || (Board.brd[1][2] == "O")){
			if(Board.brd[0][1] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 5;
		count++;
			}
		    }
		}
	    }
	    //X,1 double jump up right
	    if((Board.brd[3][2] == "2") || (Board.brd[3][2] == "O")){
		if(Board.brd[2][3] == " "){
		    if((Board.brd[1][4] == "2") || (Board.brd[1][4] == "O")){
			if(Board.brd[0][5] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 7;
		count++;
			}
		    }
		}
	    } 
	    
	}
	if((r == 4) && (c == 3)){
	    //X,1 up left
	    if(Board.brd[3][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //X,1 up right
	    if(Board.brd[3][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //X,1 jump up left
	    if((Board.brd[3][2] == "2") || (Board.brd[3][2] == "O")){
		if(Board.brd[2][1] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //X,1 jump up right
	    if((Board.brd[3][4] == "2") || (Board.brd[3][4] == "O")){
		if(Board.brd[2][5] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    //X,1 angle jump up left
	    if((Board.brd[3][2] == "2") || (Board.brd[3][2] == "O")){
		if(Board.brd[2][1] == " "){
		    if((Board.brd[1][2] == "2") || (Board.brd[1][2] == "O")){
			if(Board.brd[0][3] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 6;
		count++;
			}
		    }
		}
	    }
	    //X,1 angle jump up right
	    if((Board.brd[3][4] == "2") || (Board.brd[3][4] == "O")){
		if(Board.brd[2][5] == " "){
		    if((Board.brd[1][4] == "2") || (Board.brd[1][4] == "O")){
			if(Board.brd[0][3] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 5;
		count++;
			}
		    }
		}
	    }
	    //X,1 double jump up right
	    if((Board.brd[3][4] == "2") || (Board.brd[3][4] == "O")){
		if(Board.brd[2][5] == " "){
		    if((Board.brd[1][6] == "2") || (Board.brd[1][6] == "O")){
			if(Board.brd[0][7] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 7;
		count++;
			}
		    }
		}
	    } 
	    
	}
	if((r == 4) && (c == 5)){
	    //X,1 up left
	    if(Board.brd[3][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //X,1 up right
	    if(Board.brd[3][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //X,1 jump up left
	    if((Board.brd[3][4] == "2") || (Board.brd[3][4] == "O")){
		if(Board.brd[2][3] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //X,1 jump up right
	    if((Board.brd[3][6] == "2") || (Board.brd[3][6] == "O")){
		if(Board.brd[2][7] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    //X,1 angle jump up left
	    if((Board.brd[3][4] == "2") || (Board.brd[3][4] == "O")){
		if(Board.brd[2][3] == " "){
		    if((Board.brd[1][4] == "2") || (Board.brd[1][4] == "O")){
			if(Board.brd[0][5] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 6;
		count++;
			}
		    }
		}
	    }
	    //X,1 angle jump up right
	    if((Board.brd[3][6] == "2") || (Board.brd[3][6] == "O")){
		if(Board.brd[2][7] == " "){
		    if((Board.brd[1][6] == "2") || (Board.brd[1][6] == "O")){
			if(Board.brd[0][5] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 5;
		count++;
			}
		    }
		}
	    }
	    //X,1 double jump up left
	    if((Board.brd[3][4] == "2") || (Board.brd[3][4] == "O")){
		if(Board.brd[2][3] == " "){
		    if((Board.brd[1][2] == "2") || (Board.brd[1][2] == "O")){
			if(Board.brd[0][1] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 8;
		count++;
			}
		    }
		}
	    } 
	    
	}
	if((r == 4) && (c == 7)){
	    //X,1 up left
	    if(Board.brd[3][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //X,1 jump up left
	    if((Board.brd[3][6] == "2") || (Board.brd[3][6] == "O")){
		if(Board.brd[2][5] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //X,1 angle jump up left
	    if((Board.brd[3][6] == "2") || (Board.brd[3][6] == "O")){
		if(Board.brd[2][5] == " "){
		    if((Board.brd[1][6] == "2") || (Board.brd[1][6] == "O")){
			if(Board.brd[0][7] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 6;
		count++;
			}
		    }
		}
	    }
	    //X,1 double jump up right
	    if((Board.brd[3][6] == "2") || (Board.brd[3][6] == "O")){
		if(Board.brd[2][5] == " "){
		    if((Board.brd[1][4] == "2") || (Board.brd[1][4] == "O")){
			if(Board.brd[0][3] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 7;
		count++;
			}
		    }
		}
	    } 
	    
	}
	if((r == 3) && (c == 0)){
	    //X,1 up right
	    if(Board.brd[2][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //X,1 jump up right
	    if((Board.brd[2][1] == "2") || (Board.brd[2][1] == "O")){
		if(Board.brd[1][2] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    
	    
	}
	if((r == 3) && (c == 2)){
	    //X,1 up left
	    if(Board.brd[2][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //X,1 up right
	    if(Board.brd[2][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //X,1 jump up left
	    if((Board.brd[2][1] == "2") || (Board.brd[2][1] == "O")){
		if(Board.brd[1][0] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //X,1 jump up right
	    if((Board.brd[2][3] == "2") || (Board.brd[2][3] == "O")){
		if(Board.brd[1][4] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    
	    
	}
	if((r == 3) && (c == 4)){
	    //X,1 up left
	    if(Board.brd[2][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //X,1 up right
	    if(Board.brd[2][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //X,1 jump up left
	    if((Board.brd[2][3] == "2") || (Board.brd[2][3] == "O")){
		if(Board.brd[1][2] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //X,1 jump up right
	    if((Board.brd[2][5] == "2") || (Board.brd[2][5] == "O")){
		if(Board.brd[1][6] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    
	    
	}
	if((r == 3) && (c == 6)){
	    //X,1 up right
	    if(Board.brd[2][7] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //X,1 up left
	    if(Board.brd[2][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //X,1 jump up left
	    if((Board.brd[2][5] == "2") || (Board.brd[2][5] == "O")){
		if(Board.brd[1][4] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    
	    
	} 
	if((r == 2) && (c == 1)){
	    //X,1 up left
	    if(Board.brd[1][0] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //X,1 up right
	    if(Board.brd[1][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //X,1 jump up right
	    if((Board.brd[1][2] == "2") || (Board.brd[1][2] == "O")){
		if(Board.brd[0][3] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    
	}
	if((r == 2) && (c == 3)){
	    //X,1 up left
	    if(Board.brd[1][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //X,1 up right
	    if(Board.brd[1][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //X,1 jump up left
	    if((Board.brd[1][2] == "2") || (Board.brd[1][2] == "O")){
		if(Board.brd[0][1] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //X,1 jump up right
	    if((Board.brd[1][4] == "2") || (Board.brd[1][4] == "O")){
		if(Board.brd[0][5] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    
	}
	if((r == 2) && (c == 5)){
	    //X,1 up left
	    if(Board.brd[1][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //X,1 up right
	    if(Board.brd[1][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //X,1 jump up left
	    if((Board.brd[1][4] == "2") || (Board.brd[1][4] == "O")){
		if(Board.brd[0][3] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //X,1 jump up right
	    if((Board.brd[1][6] == "2") || (Board.brd[1][6] == "O")){
		if(Board.brd[0][7] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    
	}
	if((r == 2) && (c == 7)){
	    //X,1 up left
	    if(Board.brd[1][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //X,1 jump up left king
	    if((Board.brd[1][6] == "2") || (Board.brd[1][6] == "O")){
		if(Board.brd[0][5] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    
	}   
	if((r == 1) && (c == 0)){
	    //X,1 up right
	    if(Board.brd[0][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    
	}
	if((r == 1) && (c == 2)){
	    //X,1 up right
	    if(Board.brd[0][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //X,1 up left
	    if(Board.brd[0][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	}
	if((r == 1) && (c == 4)){
	    //X,1 up right
	    if(Board.brd[0][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //X,1 up left
	    if(Board.brd[0][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	}
	if((r == 1) && (c == 6)){
	    //X,1 up right
	    if(Board.brd[0][7] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //X,1 up left
	    if(Board.brd[0][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	}
// king moves now	//
	//
	//
	//
	//
	//
	//
		//
		//
		//
		//
		//
		
if(Board.brd[r][c] == "1"){
	if((r == 0) && (c == 1)){
	    //1 down right
	    if(Board.brd[1][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //1 down left
	    if(Board.brd[1][0] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //1 jump down right
	    if((Board.brd[1][2] == "2") || (Board.brd[1][2] == "O")){
		if(Board.brd[2][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //1 angle jump down right
	    if((Board.brd[1][2] == "2") || (Board.brd[1][2] == "O")){
		if(Board.brd[2][3] == " "){
		    if((Board.brd[3][2] == "2") || (Board.brd[3][2] == "O")){
			if(Board.brd[4][1] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 55;
		count++;
			}
		    }
		}
	    }
	    //1 double jump down right
	    if((Board.brd[1][2] == "2") || (Board.brd[1][2] == "O")){
		if(Board.brd[2][3] == " "){
		    if((Board.brd[3][4] == "2") || (Board.brd[3][4] == "O")){
			if(Board.brd[4][5] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 77;
		count++;
			}
		    }
		}
	    }
	    
	}
	if((r == 0) && (c == 3)){
	    //1 down right
	    if(Board.brd[1][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //1 down left
	    if(Board.brd[1][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //1 jump down right
	    if((Board.brd[1][4] == "2") || (Board.brd[1][4] == "O")){
		if(Board.brd[2][5] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //1 jump down left
	    if((Board.brd[1][2] == "2") || (Board.brd[1][2] == "O")){
		if(Board.brd[2][1] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    //1 angle jump down left
	    if((Board.brd[1][2] == "2") || (Board.brd[1][2] == "O")){
		if(Board.brd[2][1] == " "){
		    if((Board.brd[3][2] == "2") || (Board.brd[3][2] == "O")){
			if(Board.brd[4][3] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 66;
		count++;
			}
		    }
		}
	    }
	    //1 angle jump down right
	    if((Board.brd[1][4] == "2") || (Board.brd[1][4] == "O")){
		if(Board.brd[2][5] == " "){
		    if((Board.brd[3][4] == "2") || (Board.brd[3][4] == "O")){
			if(Board.brd[4][3] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 55;
		count++;
			}
		    }
		}
	    }
	    //1 double jump down right
	    if((Board.brd[1][4] == "2") || (Board.brd[1][4] == "O")){
		if(Board.brd[2][5] == " "){
		    if((Board.brd[3][6] == "2") || (Board.brd[3][6] == "O")){
			if(Board.brd[4][7] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 77;
		count++;
			}
		    }
		}
	    }
	    
	}
	if((r == 0) && (c == 5)){
	    //1 down right
	    if(Board.brd[1][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //1 down left
	    if(Board.brd[1][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //1 jump down right
	    if((Board.brd[1][6] == "2") || (Board.brd[1][6] == "O")){
		if(Board.brd[2][7] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //1 jump down left
	    if((Board.brd[1][4] == "2") || (Board.brd[1][4] == "O")){
		if(Board.brd[2][3] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    //1 angle jump down left
	    if((Board.brd[1][4] == "2") || (Board.brd[1][4] == "O")){
		if(Board.brd[2][3] == " "){
		    if((Board.brd[3][4] == "2") || (Board.brd[3][4] == "O")){
			if(Board.brd[4][5] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 66;
		count++;
			}
		    }
		}
	    }
	    //1 angle jump down right
	    if((Board.brd[1][6] == "2") || (Board.brd[1][6] == "O")){
		if(Board.brd[2][7] == " "){
		    if((Board.brd[3][6] == "2") || (Board.brd[3][6] == "O")){
			if(Board.brd[4][5] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 55;
		count++;
			}
		    }
		}
	    }
	    //1 double jump down left
	    if((Board.brd[1][4] == "2") || (Board.brd[1][4] == "O")){
		if(Board.brd[2][3] == " "){
		    if((Board.brd[3][2] == "2") || (Board.brd[3][2] == "O")){
			if(Board.brd[4][1] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 88;
		count++;
			}
		    }
		}
	    }
	    
	}
	if((r == 0) && (c == 7)){
	    //1 down left
	    if(Board.brd[1][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //1 jump down left
	    if((Board.brd[1][6] == "2") || (Board.brd[1][6] == "O")){
		if(Board.brd[2][5] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    //1 angle jump down left
	    if((Board.brd[1][6] == "2") || (Board.brd[1][6] == "O")){
		if(Board.brd[2][5] == " "){
		    if((Board.brd[3][6] == "2") || (Board.brd[3][6] == "O")){
			if(Board.brd[4][7] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 66;
		count++;
			}
		    }
		}
	    }
	    //1 double jump down left
	    if((Board.brd[1][6] == "2") || (Board.brd[1][6] == "O")){
		if(Board.brd[2][5] == " "){
		    if((Board.brd[3][4] == "2") || (Board.brd[3][4] == "O")){
			if(Board.brd[4][3] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 88;
		count++;
			}
		    }
		}
	    }
	    
	}
	if((r == 2) && (c == 1)){
	    //1 down right
	    if(Board.brd[3][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //1 down left
	    if(Board.brd[3][0] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //1 jump down right
	    if((Board.brd[3][2] == "2") || (Board.brd[3][2] == "O")){
		if(Board.brd[4][3] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //1 angle jump down right 
	    if((Board.brd[3][2] == "2") || (Board.brd[3][2] == "O")){
		if(Board.brd[4][3] == " "){
		    if((Board.brd[5][2] == "2") || (Board.brd[5][2] == "O")){
			if(Board.brd[6][1] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 55;
		count++;
			}
		    }
		}
	    }
	    //1 double jump down right
	    if((Board.brd[3][2] == "2") || (Board.brd[3][2] == "O")){
		if(Board.brd[4][3] == " "){
		    if((Board.brd[5][4] == "2") || (Board.brd[5][4] == "O")){
			if(Board.brd[6][5] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 77;
		count++;
			}
		    }
		}
	    }
	    
	}
	if((r == 2) && (c == 3)){
	    //1 down right
	    if(Board.brd[3][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //1 down left
	    if(Board.brd[3][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //1 jump down right
	    if((Board.brd[3][4] == "2") || (Board.brd[3][4] == "O")){
		if(Board.brd[4][5] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //1 jump down left
	    if((Board.brd[3][2] == "2") || (Board.brd[3][2] == "O")){
		if(Board.brd[4][1] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    //1 angle jump down left
	    if((Board.brd[3][2] == "2") || (Board.brd[3][2] == "O")){
		if(Board.brd[4][1] == " "){
		    if((Board.brd[5][2] == "2") || (Board.brd[5][2] == "O")){
			if(Board.brd[6][3] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 66;
		count++;
			}
		    }
		}
	    }
	    //1 angle jump down right
	    if((Board.brd[3][4] == "2") || (Board.brd[3][4] == "O")){
		if(Board.brd[4][5] == " "){
		    if((Board.brd[5][4] == "2") || (Board.brd[5][4] == "O")){
			if(Board.brd[6][3] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 55;
		count++;
			}
		    }
		}
	    }
	    //1 double jump down right
	    if((Board.brd[3][4] == "2") || (Board.brd[3][4] == "O")){
		if(Board.brd[4][5] == " "){
		    if((Board.brd[5][6] == "2") || (Board.brd[5][6] == "O")){
			if(Board.brd[6][7] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 77;
		count++;
			}
		    }
		}
	    }
	    
	}
	if((r == 2) && (c == 5)){
	    //1 down right
	    if(Board.brd[3][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //1 down left
	    if(Board.brd[3][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //1 jump down right
	    if((Board.brd[3][6] == "2") || (Board.brd[3][6] == "O")){
		if(Board.brd[4][7] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //1 jump down left
	    if((Board.brd[3][4] == "2") || (Board.brd[3][4] == "O")){
		if(Board.brd[4][3] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    //1 angle jump down left
	    if((Board.brd[3][4] == "2") || (Board.brd[3][4] == "O")){
		if(Board.brd[4][3] == " "){
		    if((Board.brd[5][4] == "2") || (Board.brd[5][4] == "O")){
			if(Board.brd[6][5] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 66;
		count++;
			}
		    }
		}
	    }
	    //1 angle jump down right
	    if((Board.brd[3][6] == "2") || (Board.brd[3][6] == "O")){
		if(Board.brd[4][7] == " "){
		    if((Board.brd[5][6] == "2") || (Board.brd[5][6] == "O")){
			if(Board.brd[6][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 55;
		count++;
			}
		    }
		}
	    }
	    //1 double jump down left
	    if((Board.brd[3][4] == "2") || (Board.brd[3][4] == "O")){
		if(Board.brd[4][3] == " "){
		    if((Board.brd[5][2] == "2") || (Board.brd[5][2] == "O")){
			if(Board.brd[6][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 88;
		count++;
			}
		    }
		}
	    }
	    
	}
	if((r == 2) && (c == 7)){
	    //1 down left
	    if(Board.brd[3][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //1 jump down left
	    if((Board.brd[3][6] == "2") || (Board.brd[3][6] == "O")){
		if(Board.brd[4][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    //1 angle jump down left
	    if((Board.brd[3][6] == "2") || (Board.brd[3][6] == "O")){
		if(Board.brd[4][5] == " "){
		    if((Board.brd[5][6] == "2") || (Board.brd[5][6] == "O")){
			if(Board.brd[6][7] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 66;
		count++;
			}
		    }
		}
	    }
	    //1 double jump down left
	    if((Board.brd[3][6] == "2") || (Board.brd[3][6] == "O")){
		if(Board.brd[4][5] == " "){
		    if((Board.brd[5][4] == "2") || (Board.brd[5][4] == "O")){
			if(Board.brd[6][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 88;
		count++;
			}
		    }
		}
	    }
	    
	}
	
	if((r == 4) && (c == 1)){
	    //1 down right
	    if(Board.brd[5][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //1 down left
	    if(Board.brd[5][0] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //1 jump down right
	    if((Board.brd[5][2] == "2") || (Board.brd[5][2] == "O")){
		if(Board.brd[6][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    
	    
	}
	if((r == 4) && (c == 3)){
	    //1 down right
	    if(Board.brd[5][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //1 down left
	    if(Board.brd[5][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //1 jump down right
	    if((Board.brd[5][4] == "2") || (Board.brd[5][4] == "O")){
		if(Board.brd[6][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //1 jump down left
	    if((Board.brd[5][2] == "2") || (Board.brd[5][2] == "O")){
		if(Board.brd[6][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    
	    
	}
	if((r == 4) && (c == 5)){
	    //1 down right
	    if(Board.brd[5][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //1 down left
	    if(Board.brd[5][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //1 jump down right
	    if((Board.brd[5][6] == "2") || (Board.brd[5][6] == "O")){
		if(Board.brd[6][7] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //1 jump down left
	    if((Board.brd[5][4] == "2") || (Board.brd[5][4] == "O")){
		if(Board.brd[6][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    
	    
	}
	if((r == 4) && (c == 7)){
	    //1 down left
	    if(Board.brd[1][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //1 jump down left
	    if((Board.brd[1][6] == "2") || (Board.brd[1][6] == "O")){
		if(Board.brd[2][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    
	    
	}
	if((r == 6) && (c == 1)){
	    //1 down right
	    if(Board.brd[7][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //1 down left
	    if(Board.brd[7][0] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    
	    
	}
	if((r == 6) && (c == 3)){
	    //1 down right
	    if(Board.brd[7][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //1 down left
	    if(Board.brd[7][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    
	}
	if((r == 6) && (c == 5)){
	    //1 down right
	    if(Board.brd[7][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //1 down left
	    if(Board.brd[7][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    
	    
	}
	if((r == 6) && (c == 7)){
	    //1 down left
	    if(Board.brd[7][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    
	    
	}
	if((r == 1) && (c == 0)){
	    //1 down right
	    if(Board.brd[2][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //1 jump down right
	    if((Board.brd[2][1] == "2") || (Board.brd[2][1] == "O")){
		if(Board.brd[3][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //1 angle jump down Right
	    if((Board.brd[2][1] == "2") || (Board.brd[2][1] == "O")){
		if(Board.brd[3][2] == " "){
		    if((Board.brd[4][1] == "2") || (Board.brd[4][1] == "O")){
			if(Board.brd[5][0] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 55;
		count++;
			}
		    }
		}
	    }
	    //1 double jump down right
	    if((Board.brd[2][1] == "2") || (Board.brd[2][1] == "O")){
		if(Board.brd[3][2] == " "){
		    if((Board.brd[4][3] == "2") || (Board.brd[4][3] == "O")){
			if(Board.brd[5][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 77;
		count++;
			}
		    }
		}
	    }
	    
	}
	if((r == 1) && (c == 2)){
	    //1 down right
	    if(Board.brd[2][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //1 down left
	    if(Board.brd[2][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //1 jump down right
	    if((Board.brd[2][3] == "2") || (Board.brd[2][3] == "O")){
		if(Board.brd[3][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //1 jump down left
	    if((Board.brd[2][1] == "2") || (Board.brd[2][1] == "O")){
		if(Board.brd[3][0] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    //1 angle jump down left
	    if((Board.brd[2][1] == "2") || (Board.brd[2][1] == "O")){
		if(Board.brd[3][0] == " "){
		    if((Board.brd[4][1] == "2") || (Board.brd[4][1] == "O")){
			if(Board.brd[5][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 66;
		count++;
			}
		    }
		}
	    }
	    //1 angle jump down right
	    if((Board.brd[2][3] == "2") || (Board.brd[2][3] == "O")){
		if(Board.brd[3][4] == " "){
		    if((Board.brd[4][3] == "2") || (Board.brd[4][3] == "O")){
			if(Board.brd[5][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 55;
		count++;
			}
		    }
		}
	    }
	    //1 double jump down right
	    if((Board.brd[2][3] == "2") || (Board.brd[2][3] == "O")){
		if(Board.brd[3][4] == " "){
		    if((Board.brd[4][5] == "2") || (Board.brd[4][5] == "O")){
			if(Board.brd[5][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 77;
		count++;
			}
		    }
		}
	    }
	    
	}
	if((r == 1) && (c == 4)){
	    //1 down right
	    if(Board.brd[2][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //1 down left
	    if(Board.brd[2][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //1 jump down right
	    if((Board.brd[2][5] == "2") || (Board.brd[2][5] == "O")){
		if(Board.brd[3][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //1 jump down left
	    if((Board.brd[2][3] == "2") || (Board.brd[2][3] == "O")){
		if(Board.brd[3][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    //1 angle jump down left
	    if((Board.brd[2][3] == "2") || (Board.brd[2][3] == "O")){
		if(Board.brd[3][2] == " "){
		    if((Board.brd[4][3] == "2") || (Board.brd[4][3] == "O")){
			if(Board.brd[5][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 66;
		count++;
			}
		    }
		}
	    }
	    //1 angle jump down right
	    if((Board.brd[2][5] == "2") || (Board.brd[2][5] == "O")){
		if(Board.brd[3][6] == " "){
		    if((Board.brd[4][5] == "2") || (Board.brd[4][5] == "O")){
			if(Board.brd[5][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 55;
		count++;
			}
		    }
		}
	    }
	    //1 double jump down left
	    if((Board.brd[2][3] == "2") || (Board.brd[2][3] == "O")){
		if(Board.brd[3][2] == " "){
		    if((Board.brd[4][1] == "2") || (Board.brd[4][1] == "O")){
			if(Board.brd[5][0] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 88;
		count++;
			}
		    }
		}
	    }
	    
	}
	if((r == 1) && (c == 6)){
	    //1 down right
	    if(Board.brd[2][7] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //1 down left
	    if(Board.brd[2][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //1 jump down left
	    if((Board.brd[2][5] == "2") || (Board.brd[2][5] == "O")){
		if(Board.brd[3][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    //1 angle jump down left
	    if((Board.brd[2][5] == "2") || (Board.brd[2][5] == "O")){
		if(Board.brd[3][4] == " "){
		    if((Board.brd[4][5] == "2") || (Board.brd[4][5] == "O")){
			if(Board.brd[5][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 66;
		count++;
			}
		    }
		}
	    }
	    //1 double jump down left
	    if((Board.brd[2][5] == "2") || (Board.brd[2][5] == "O")){
		if(Board.brd[3][4] == " "){
		    if((Board.brd[4][3] == "2") || (Board.brd[4][3] == "O")){
			if(Board.brd[5][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 88;
		count++;
			}
		    }
		}
	    }
	}
	if((r == 3) && (c == 0)){
	    //1 down right
	    if(Board.brd[4][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //1 jump down right
	    if((Board.brd[4][1] == "2") || (Board.brd[4][1] == "O")){
		if(Board.brd[5][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //1 angle jump down Right
	    if((Board.brd[4][1] == "2") || (Board.brd[4][1] == "O")){
		if(Board.brd[5][2] == " "){
		    if((Board.brd[6][1] == "2") || (Board.brd[6][1] == "O")){
			if(Board.brd[7][0] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 55;
		count++;
			}
		    }
		}
	    }
	    //1 double jump down right
	    if((Board.brd[4][1] == "2") || (Board.brd[4][1] == "O")){
		if(Board.brd[5][2] == " "){
		    if((Board.brd[6][3] == "2") || (Board.brd[6][3] == "O")){
			if(Board.brd[7][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 77;
		count++;
			}
		    }
		}
	    }
	    
	}
	if((r == 3) && (c == 2)){
	    //1 down right
	    if(Board.brd[4][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //1 down left
	    if(Board.brd[4][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //1 jump down right
	    if((Board.brd[4][3] == "2") || (Board.brd[4][3] == "O")){
		if(Board.brd[5][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //1 jump down left
	    if((Board.brd[4][1] == "2") || (Board.brd[4][1] == "O")){
		if(Board.brd[5][0] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    //1 angle jump down left
	    if((Board.brd[4][1] == "2") || (Board.brd[4][1] == "O")){
		if(Board.brd[5][0] == " "){
		    if((Board.brd[6][1] == "2") || (Board.brd[6][1] == "O")){
			if(Board.brd[7][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 66;
		count++;
			}
		    }
		}
	    }
	    //1 angle jump down right
	    if((Board.brd[4][3] == "2") || (Board.brd[4][3] == "O")){
		if(Board.brd[5][4] == " "){
		    if((Board.brd[6][3] == "2") || (Board.brd[6][3] == "O")){
			if(Board.brd[7][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 55;
		count++;
			}
		    }
		}
	    }
	    //1 double jump down right
	    if((Board.brd[4][3] == "2") || (Board.brd[4][3] == "O")){
		if(Board.brd[5][4] == " "){
		    if((Board.brd[6][5] == "2") || (Board.brd[6][5] == "O")){
			if(Board.brd[7][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 77;
		count++;
			}
		    }
		}
	    }
	    
	}
	if((r == 3) && (c == 4)){
	    //1 down right
	    if(Board.brd[4][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //1 down left
	    if(Board.brd[4][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //1 jump down right
	    if((Board.brd[4][5] == "2") || (Board.brd[4][5] == "O")){
		if(Board.brd[5][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //1 jump down left
	    if((Board.brd[4][3] == "2") || (Board.brd[4][3] == "O")){
		if(Board.brd[5][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    //1 angle jump down left
	    if((Board.brd[4][3] == "2") || (Board.brd[4][3] == "O")){
		if(Board.brd[5][2] == " "){
		    if((Board.brd[6][3] == "2") || (Board.brd[6][3] == "O")){
			if(Board.brd[7][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 66;
		count++;
			}
		    }
		}
	    }
	    //1 angle jump down right
	    if((Board.brd[4][5] == "2") || (Board.brd[4][5] == "O")){
		if(Board.brd[5][6] == " "){
		    if((Board.brd[6][5] == "2") || (Board.brd[6][5] == "O")){
			if(Board.brd[7][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 55;
		count++;
			}
		    }
		}
	    }
	    //1 double jump down left
	    if((Board.brd[4][3] == "2") || (Board.brd[4][3] == "O")){
		if(Board.brd[5][2] == " "){
		    if((Board.brd[6][1] == "2") || (Board.brd[6][1] == "O")){
			if(Board.brd[7][0] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 88;
		count++;
			}
		    }
		}
	    }
	    
	}
	if((r == 3) && (c == 6)){
	    //1 down right
	    if(Board.brd[4][7] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //1 down left
	    if(Board.brd[4][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //1 jump down left
	    if((Board.brd[4][5] == "2") || (Board.brd[4][5] == "O")){
		if(Board.brd[5][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    //1 angle jump down left
	    if((Board.brd[4][5] == "2") || (Board.brd[4][5] == "O")){
		if(Board.brd[5][4] == " "){
		    if((Board.brd[6][5] == "2") || (Board.brd[6][5] == "O")){
			if(Board.brd[7][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 66;
		count++;
			}
		    }
		}
	    }
	    //1 double jump down left
	    if((Board.brd[4][5] == "2") || (Board.brd[4][5] == "O")){
		if(Board.brd[5][4] == " "){
		    if((Board.brd[6][3] == "2") || (Board.brd[6][3] == "O")){
			if(Board.brd[7][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 88;
		count++;
			}
		    }
		}
	    }
	}
	
	if((r == 5) && (c == 0)){
	    //1 down right
	    if(Board.brd[6][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //1 jump down right
	    if((Board.brd[6][1] == "2") || (Board.brd[6][1] == "O")){
		if(Board.brd[7][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	  
	    
	}
	if((r == 5) && (c == 2)){
	    //1 down right
	    if(Board.brd[6][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //1 down left
	    if(Board.brd[6][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //1 jump down right
	    if((Board.brd[6][3] == "2") || (Board.brd[6][3] == "O")){
		if(Board.brd[7][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //1 jump down left
	    if((Board.brd[6][1] == "2") || (Board.brd[6][1] == "O")){
		if(Board.brd[7][0] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }

	    
	}
	if((r == 5) && (c == 4)){
	    //1 down right
	    if(Board.brd[6][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //1 down left
	    if(Board.brd[6][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //1 jump down right
	    if((Board.brd[6][5] == "2") || (Board.brd[6][5] == "O")){
		if(Board.brd[7][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //1 jump down left
	    if((Board.brd[6][3] == "2") || (Board.brd[6][3] == "O")){
		if(Board.brd[7][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    
	  
	    
	}
	if((r == 5) && (c == 6)){
	    //1 down right
	    if(Board.brd[6][7] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //1 down left
	    if(Board.brd[6][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //1 jump down left
	    if((Board.brd[6][5] == "2") || (Board.brd[6][5] == "O")){
		if(Board.brd[7][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    
	}
	this.printMoves();
}
    }
    
}
