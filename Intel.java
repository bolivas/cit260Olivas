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
public class Intel {
    int r = 0;
    int c = 0;
    int ir  = 0;
    int ic  = 0;
    int[][] holdValues = {
	{0,0},
	{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    };
    int count = 0;
    int[][] allMoves = {
	{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    };
    public void run(){
	// sets all the values of allMoves to zero
	for(int oo = 0; oo < 12; oo++){
	    for(int jj = 0; jj < 18; jj++){
		    allMoves[oo][jj] = 0; 
	    }
	}
	// runs the method movable pieces which checks the board for movable pieces
	this.movablePieces();
	    // filling allMoves and puts them in the 0 and 1 position of allMoves
	    for(int i = 0; i < 12; i++){
		r = allMoves[i][0];
		c = allMoves[i][1];
		count = 0;
		//clearing hold values
		holdValues[0][0] = 0;
		holdValues[0][1] = 0;
		for(int ii = 0; ii < 16; ii++){
		    holdValues[1][ii] = 0;
		}
		this.checkAPiece();
		for(int j = 0; j < 16; j++){
		    allMoves[i][j+2] = holdValues[1][j]; 
		}
	    }
	    for(int l = 0;l < 12; l++){
		System.out.print("{");
		for(int m = 0;m < 18; m++){
		System.out.print(allMoves[l][m]+",");
		} 
		System.out.println("}");
	    }
	    for(int k = 0; k < 12; k++){
		if(allMoves[k][2] != 0){
		    r= allMoves[k][0];
		    c= allMoves[k][1];
		    check = allMoves[k][2];
		    this.movePiece();
		    break;
		}
	    }
	}
    
 
    
    // populates the allMoves with movable values
    public void movablePieces(){
	int count1 = 0;
	for(int i = 0; i < 8; i++){
	    for(int j = 0; j < 8; j++){
		if((Board.brd[i][j] == "O")||(Board.brd[i][j] == "2")){
		    allMoves[count1][0] = i;
	            allMoves[count1][1] = j;
	            count1++;
		}
	    }
	}
    }

    
    int check = 0;
    String marker = " ";
    public int forTheComWin = 0;
    public void movePiece(){
	
	marker = Board.brd[r][c];
	switch(check){
	    case 1:
		Board.brd[r][c] = " ";
		if(r - 1 == 7){
		    marker = "2";
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
		if(r - 1== 7){
		    marker = "2";
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
		forTheComWin++;
		Board.brd[r][c] = " ";
		Board.brd[r-1][c+1] = " ";
		if(r - 2 == 7){
		    marker = "2";
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
		forTheComWin++;
		Board.brd[r][c] = " ";
		Board.brd[r-1][c-1] = " ";
		if(r - 2 == 7){
		    marker = "2";
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
		forTheComWin++;
		forTheComWin++;
		Board.brd[r][c] = " ";
		Board.brd[r-1][c+1] = " ";
		Board.brd[r-2][c+2] = " ";
		Board.brd[r-3][c+1] = " ";
		if(r - 4 == 7){
		    marker = "2";
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
		forTheComWin++;
		forTheComWin++;
		Board.brd[r][c] = " ";
		Board.brd[r-1][c-1] = " ";
		Board.brd[r-2][c-2] = " ";
		Board.brd[r-3][c-1] = " ";
		if(r - 4 == 7){
		    marker = "2";
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
		forTheComWin++;
		forTheComWin++;
		Board.brd[r][c] = " ";
		Board.brd[r-1][c+1] = " ";
		Board.brd[r-2][c+2] = " ";
		Board.brd[r-3][c+3] = " ";
		if(r - 4 == 7){
		    marker = "2";
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
		forTheComWin++;
		forTheComWin++;
		Board.brd[r][c] = " ";
		Board.brd[r-1][c-1] = " ";
		Board.brd[r-2][c-2] = " ";
		Board.brd[r-3][c-3] = " ";
		if(r - 4 == 7){
		    marker = "2";
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
		if(r + 1 == 7){
		    marker = "2";
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
		if(r + 1 == 7){
		    marker = "2";
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
		forTheComWin++;
		Board.brd[r][c] = " ";
		Board.brd[r+1][c+1] = " ";
		if(r + 2 == 7){
		    marker = "2";
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
		forTheComWin++;
		Board.brd[r][c] = " ";
		Board.brd[r+1][c-1] = " ";
		if(r + 2 == 7){
		    marker = "2";
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
		forTheComWin++;
		forTheComWin++;
		Board.brd[r][c] = " ";
		Board.brd[r+1][c+1] = " ";
		Board.brd[r+2][c+2] = " ";
		Board.brd[r+3][c+1] = " ";
		if(r + 4 == 7){
		    marker = "2";
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
		forTheComWin++;
		forTheComWin++;
		Board.brd[r][c] = " ";
		Board.brd[r+1][c-1] = " ";
		Board.brd[r+2][c-2] = " ";
		Board.brd[r+3][c-1] = " ";
		if(r + 4 == 7){
		    marker = "2";
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
		forTheComWin++;
		forTheComWin++;
		Board.brd[r][c] = " ";
		Board.brd[r+1][c+1] = " ";
		Board.brd[r+2][c+2] = " ";
		Board.brd[r+3][c+3] = " ";
		if(r + 4 == 7){
		    marker = "2";
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
		forTheComWin++;
		forTheComWin++;
		Board.brd[r][c] = " ";
		Board.brd[r+1][c-1] = " ";
		Board.brd[r+2][c-2] = " ";
		Board.brd[r+3][c-3] = " ";
		if(r + 4 == 7){
		    marker = "2";
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
	
	if(Board.brd[r][c] == "2"){
	if((r == 7) && (c == 0)){
	    //2 up right
	    if(Board.brd[6][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //2 jump up right
	    if((Board.brd[6][1] == "1") || (Board.brd[6][1] == "X")){
		if(Board.brd[5][2] == " "){
		    holdValues[0][0] = r;
		    holdValues[0][1] = c;
		    holdValues[1][count] = 3;
		    count++;
		}
	    }
	    //2 angle jump up 
	    if((Board.brd[6][1] == "1") || (Board.brd[6][1] == "X")){
		if(Board.brd[5][2] == " "){
		    if((Board.brd[4][1] == "1") || (Board.brd[4][1] == "X")){
			if(Board.brd[3][0] == " "){
			    holdValues[0][0] = r;
			    holdValues[0][1] = c;
			    holdValues[1][count] = 5;
			    count++;
			}
		    }
		}
	    }
	    //2 double jump up right
	    if((Board.brd[6][1] == "1") || (Board.brd[6][1] == "X")){
		if(Board.brd[5][2] == " "){
		    if((Board.brd[4][3] == "1") || (Board.brd[4][3] == "X")){
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
	    //2 up left
	    if(Board.brd[6][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //2 up right
	    if(Board.brd[6][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //2 jump up left
	    if((Board.brd[6][1] == "1") || (Board.brd[6][1] == "X")){
		if(Board.brd[5][0] == " "){
		    holdValues[0][0] = r;
		    holdValues[0][1] = c;
		    holdValues[1][count] = 4;
		    count++;
		}
	    }
	    //2 jump up right
	    if((Board.brd[6][3] == "1") || (Board.brd[6][3] == "X")){
		if(Board.brd[5][4] == " "){
		    holdValues[0][0] = r;
		    holdValues[0][1] = c;
		    holdValues[1][count] = 3;
		    count++;
		}
	    }
	    //2 angle jump up left
	    if((Board.brd[6][1] == "1") || (Board.brd[6][1] == "X")){
		if(Board.brd[5][0] == " "){
		    if((Board.brd[4][1] == "1") || (Board.brd[4][1] == "X")){
			if(Board.brd[3][2] == " "){
			    holdValues[0][0] = r;
			    holdValues[0][1] = c;
			    holdValues[1][count] = 6;
			    count++;
			}
		    }
		}
	    }
	    //2 angle jump up right
	    if((Board.brd[6][3] == "1") || (Board.brd[6][3] == "X")){
		if(Board.brd[5][4] == " "){
		    if((Board.brd[4][3] == "1") || (Board.brd[4][3] == "X")){
			if(Board.brd[3][2] == " "){
			    holdValues[0][0] = r;
			    holdValues[0][1] = c;
			    holdValues[1][count] = 5;
			    count++;
			}
		    }
		}
	    }
	    //2 double jump up right
	    if((Board.brd[6][3] == "1") || (Board.brd[6][3] == "X")){
		if(Board.brd[5][4] == " "){
		    if((Board.brd[4][5] == "1") || (Board.brd[4][5] == "X")){
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
	    //2 up left
	    if(Board.brd[6][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //2 up right
	    if(Board.brd[6][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //2 jump up left
	    if((Board.brd[6][3] == "1") || (Board.brd[6][3] == "X")){
		if(Board.brd[5][2] == " "){
		    holdValues[0][0] = r;
		    holdValues[0][1] = c;
		    holdValues[1][count] = 4;
		    count++;
		}
	    }
	    //2 jump up right
	    if((Board.brd[6][5] == "1") || (Board.brd[6][5] == "X")){
		if(Board.brd[5][6] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    //2 angle jump up left
	    if((Board.brd[6][3] == "1") || (Board.brd[6][3] == "X")){
		if(Board.brd[5][2] == " "){
		    if((Board.brd[4][3] == "1") || (Board.brd[4][3] == "X")){
			if(Board.brd[3][4] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 6;
		count++;
			}
		    }
		}
	    }
	    //2 angle jump up right
	    if((Board.brd[6][5] == "1") || (Board.brd[6][5] == "X")){
		if(Board.brd[5][6] == " "){
		    if((Board.brd[4][5] == "1") || (Board.brd[4][5] == "X")){
			if(Board.brd[3][4] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 5;
		count++;
			}
		    }
		}
	    }
	    //2 double jump up left
	    if((Board.brd[6][3] == "1") || (Board.brd[6][3] == "X")){
		if(Board.brd[5][2] == " "){
		    if((Board.brd[4][1] == "1") || (Board.brd[4][1] == "X")){
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
	    //2 up right
	    if(Board.brd[6][7] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //2 up left
	    if(Board.brd[6][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //2 jump up left
	    if((Board.brd[6][5] == "1") || (Board.brd[6][5] == "X")){
		if(Board.brd[5][4] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //2 angle jump up left
	    if((Board.brd[6][5] == "1") || (Board.brd[6][5] == "X")){
		if(Board.brd[5][4] == " "){
		    if((Board.brd[4][5] == "1") || (Board.brd[4][5] == "X")){
			if(Board.brd[3][6] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 6;
		count++;
			}
		    }
		}
	    }
	    //2 double jump up left
	    if((Board.brd[6][5] == "1") || (Board.brd[6][5] == "X")){
		if(Board.brd[5][4] == " "){
		    if((Board.brd[4][3] == "1") || (Board.brd[4][3] == "X")){
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
	    //2 up left
	    if(Board.brd[5][0] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //2 up right
	    if(Board.brd[5][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //2 jump up right
	    if((Board.brd[5][2] == "1") || (Board.brd[5][2] == "X")){
		if(Board.brd[4][3] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    //2 angle jump up right
	    if((Board.brd[5][2] == "1") || (Board.brd[5][2] == "X")){
		if(Board.brd[4][3] == " "){
		    if((Board.brd[3][2] == "1") || (Board.brd[3][2] == "X")){
			if(Board.brd[2][1] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 5;
		count++;
			}
		    }
		}
	    }
	    //2 double jump up right
	    if((Board.brd[5][2] == "1") || (Board.brd[5][2] == "X")){
		if(Board.brd[4][3] == " "){
		    if((Board.brd[3][4] == "1") || (Board.brd[3][4] == "X")){
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
	    //2 up left
	    if(Board.brd[5][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //2 up right
	    if(Board.brd[5][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //2 jump up left
	    if((Board.brd[5][2] == "1") || (Board.brd[5][2] == "X")){
		if(Board.brd[4][1] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //2 jump up right
	    if((Board.brd[5][4] == "1") || (Board.brd[5][4] == "X")){
		if(Board.brd[4][5] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    //2 angle jump up left
	    if((Board.brd[5][2] == "1") || (Board.brd[5][2] == "X")){
		if(Board.brd[4][1] == " "){
		    if((Board.brd[3][2] == "1") || (Board.brd[3][2] == "X")){
			if(Board.brd[2][3] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 6;
		count++;
			}
		    }
		}
	    }
	    //2 angle jump up right
	    if((Board.brd[5][4] == "1") || (Board.brd[5][4] == "X")){
		if(Board.brd[4][5] == " "){
		    if((Board.brd[3][4] == "1") || (Board.brd[3][4] == "X")){
			if(Board.brd[2][3] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 5;
		count++;
			}
		    }
		}
	    }
	    //2 double jump up right
	    if((Board.brd[5][4] == "1") || (Board.brd[5][4] == "X")){
		if(Board.brd[4][5] == " "){
		    if((Board.brd[3][6] == "1") || (Board.brd[3][6] == "X")){
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
	    //2 up left
	    if(Board.brd[5][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //2 up right
	    if(Board.brd[5][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //2 jump up left
	    if((Board.brd[5][4] == "1") || (Board.brd[5][4] == "X")){
		if(Board.brd[4][3] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //2 jump up right
	    if((Board.brd[5][6] == "1") || (Board.brd[5][6] == "X")){
		if(Board.brd[4][7] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    //2 angle jump up left
	    if((Board.brd[5][4] == "1") || (Board.brd[5][4] == "X")){
		if(Board.brd[4][3] == " "){
		    if((Board.brd[3][4] == "1") || (Board.brd[3][4] == "X")){
			if(Board.brd[2][5] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 6;
		count++;
			}
		    }
		}
	    }
	    //2 angle jump up right
	    if((Board.brd[5][6] == "1") || (Board.brd[5][6] == "X")){
		if(Board.brd[4][7] == " "){
		    if((Board.brd[3][6] == "1") || (Board.brd[3][6] == "X")){
			if(Board.brd[2][5] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 5;
		count++;
			}
		    }
		}
	    }
	    //2 double jump up left
	    if((Board.brd[5][4] == "1") || (Board.brd[5][4] == "X")){
		if(Board.brd[4][3] == " "){
		    if((Board.brd[3][2] == "1") || (Board.brd[3][2] == "X")){
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
	    //2 up left
	    if(Board.brd[5][6] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //2 jump up left
	    if((Board.brd[5][6] == "1") || (Board.brd[5][6] == "X")){
		if(Board.brd[4][5] == " "){
			holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //2 angle jump up left
	    if((Board.brd[5][6] == "1") || (Board.brd[5][6] == "X")){
		if(Board.brd[4][5] == " "){
		    if((Board.brd[3][6] == "1") || (Board.brd[3][6] == "X")){
			if(Board.brd[2][7] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 6;
		count++;
			}
		    }
		}
	    }
	    //2 double jump up right
	    if((Board.brd[5][6] == "1") || (Board.brd[5][6] == "X")){
		if(Board.brd[4][5] == " "){
		    if((Board.brd[3][4] == "1") || (Board.brd[3][4] == "X")){
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
	    //2 up right
	    if(Board.brd[4][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //2 jump up right
	    if((Board.brd[4][1] == "1") || (Board.brd[4][1] == "X")){
		if(Board.brd[3][2] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    //2 angle jump up right
	    if((Board.brd[4][1] == "1") || (Board.brd[4][1] == "X")){
		if(Board.brd[3][2] == " "){
		    if((Board.brd[2][1] == "1") || (Board.brd[2][1] == "X")){
			if(Board.brd[1][0] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 5;
		count++;
			}
		    }
		}
	    }
	    //2 double jump up right
	    if((Board.brd[4][1] == "1") || (Board.brd[4][1] == "X")){
		if(Board.brd[3][2] == " "){
		    if((Board.brd[2][3] == "1") || (Board.brd[2][3] == "X")){
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
	   //2 up left
	    if(Board.brd[4][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //2 up right
	    if(Board.brd[4][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //2 jump up left
	    if((Board.brd[4][1] == "1") || (Board.brd[4][1] == "X")){
		if(Board.brd[3][0] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //2 jump up right
	    if((Board.brd[4][3] == "1") || (Board.brd[4][3] == "X")){
		if(Board.brd[3][4] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    //2 angle jump up left
	    if((Board.brd[4][1] == "1") || (Board.brd[4][1] == "X")){
		if(Board.brd[3][0] == " "){
		    if((Board.brd[2][1] == "1") || (Board.brd[2][1] == "X")){
			if(Board.brd[1][2] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 6;
		count++;
			}
		    }
		}
	    }
	    //2 angle jump up right
	    if((Board.brd[4][3] == "1") || (Board.brd[4][3] == "X")){
		if(Board.brd[3][4] == " "){
		    if((Board.brd[2][3] == "1") || (Board.brd[2][3] == "X")){
			if(Board.brd[1][2] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 5;
		count++;
			}
		    }
		}
	    }
	    //2 double jump up right
	    if((Board.brd[4][3] == "1") || (Board.brd[4][3] == "X")){
		if(Board.brd[3][4] == " "){
		    if((Board.brd[2][5] == "1") || (Board.brd[2][5] == "X")){
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
	    //2 up left
	    if(Board.brd[4][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //2 up right
	    if(Board.brd[4][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //2 jump up left
	    if((Board.brd[4][3] == "1") || (Board.brd[4][3] == "X")){
		if(Board.brd[3][2] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //2 jump up right
	    if((Board.brd[4][5] == "1") || (Board.brd[4][5] == "X")){
		if(Board.brd[3][6] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    //2 angle jump up left
	    if((Board.brd[4][3] == "1") || (Board.brd[4][3] == "X")){
		if(Board.brd[3][2] == " "){
		    if((Board.brd[2][3] == "1") || (Board.brd[2][3] == "X")){
			if(Board.brd[1][4] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 6;
		count++;
			}
		    }
		}
	    }
	    //2 angle jump up right
	    if((Board.brd[4][5] == "1") || (Board.brd[4][5] == "X")){
		if(Board.brd[3][6] == " "){
		    if((Board.brd[2][5] == "1") || (Board.brd[2][5] == "X")){
			if(Board.brd[1][4] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 5;
		count++;
			}
		    }
		}
	    }
	    //2 double jump up left
	    if((Board.brd[4][3] == "1") || (Board.brd[4][3] == "X")){
		if(Board.brd[3][2] == " "){
		    if((Board.brd[2][1] == "1") || (Board.brd[2][1] == "X")){
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
	    //2 up right
	    if(Board.brd[4][7] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //2 up left
	    if(Board.brd[4][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //2 jump up left
	    if((Board.brd[4][5] == "1") || (Board.brd[4][5] == "X")){
		if(Board.brd[3][4] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //2 angle jump up left
	    if((Board.brd[4][5] == "1") || (Board.brd[4][5] == "X")){
		if(Board.brd[3][4] == " "){
		    if((Board.brd[2][5] == "1") || (Board.brd[2][5] == "X")){
			if(Board.brd[1][6] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 6;
		count++;
			}
		    }
		}
	    }
	    //2 double jump up left
	    if((Board.brd[4][5] == "1") || (Board.brd[4][5] == "X")){
		if(Board.brd[3][4] == " "){
		    if((Board.brd[2][3] == "1") || (Board.brd[2][3] == "X")){
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
	    //2 up left
	    if(Board.brd[3][0] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //2 up right
	    if(Board.brd[3][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //2 jump up right
	    if((Board.brd[3][2] == "1") || (Board.brd[3][2] == "X")){
		if(Board.brd[2][3] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    //2 angle jump up right
	    if((Board.brd[3][2] == "1") || (Board.brd[3][2] == "X")){
		if(Board.brd[2][3] == " "){
		    if((Board.brd[1][2] == "1") || (Board.brd[1][2] == "X")){
			if(Board.brd[0][1] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 5;
		count++;
			}
		    }
		}
	    }
	    //2 double jump up right
	    if((Board.brd[3][2] == "1") || (Board.brd[3][2] == "X")){
		if(Board.brd[2][3] == " "){
		    if((Board.brd[1][4] == "1") || (Board.brd[1][4] == "X")){
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
	    //2 up left
	    if(Board.brd[3][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //2 up right
	    if(Board.brd[3][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //2 jump up left
	    if((Board.brd[3][2] == "1") || (Board.brd[3][2] == "X")){
		if(Board.brd[2][1] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //2 jump up right
	    if((Board.brd[3][4] == "1") || (Board.brd[3][4] == "X")){
		if(Board.brd[2][5] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    //2 angle jump up left
	    if((Board.brd[3][2] == "1") || (Board.brd[3][2] == "X")){
		if(Board.brd[2][1] == " "){
		    if((Board.brd[1][2] == "1") || (Board.brd[1][2] == "X")){
			if(Board.brd[0][3] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 6;
		count++;
			}
		    }
		}
	    }
	    //2 angle jump up right
	    if((Board.brd[3][4] == "1") || (Board.brd[3][4] == "X")){
		if(Board.brd[2][5] == " "){
		    if((Board.brd[1][4] == "1") || (Board.brd[1][4] == "X")){
			if(Board.brd[0][3] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 5;
		count++;
			}
		    }
		}
	    }
	    //2 double jump up right
	    if((Board.brd[3][4] == "1") || (Board.brd[3][4] == "X")){
		if(Board.brd[2][5] == " "){
		    if((Board.brd[1][6] == "1") || (Board.brd[1][6] == "X")){
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
	    //2 up left
	    if(Board.brd[3][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //2 up right
	    if(Board.brd[3][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //2 jump up left
	    if((Board.brd[3][4] == "1") || (Board.brd[3][4] == "X")){
		if(Board.brd[2][3] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //2 jump up right
	    if((Board.brd[3][6] == "1") || (Board.brd[3][6] == "X")){
		if(Board.brd[2][7] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    //2 angle jump up left
	    if((Board.brd[3][4] == "1") || (Board.brd[3][4] == "X")){
		if(Board.brd[2][3] == " "){
		    if((Board.brd[1][4] == "1") || (Board.brd[1][4] == "X")){
			if(Board.brd[0][5] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 6;
		count++;
			}
		    }
		}
	    }
	    //2 angle jump up right
	    if((Board.brd[3][6] == "1") || (Board.brd[3][6] == "X")){
		if(Board.brd[2][7] == " "){
		    if((Board.brd[1][6] == "1") || (Board.brd[1][6] == "X")){
			if(Board.brd[0][5] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 5;
		count++;
			}
		    }
		}
	    }
	    //2 double jump up left
	    if((Board.brd[3][4] == "1") || (Board.brd[3][4] == "X")){
		if(Board.brd[2][3] == " "){
		    if((Board.brd[1][2] == "1") || (Board.brd[1][2] == "X")){
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
	    //2 up left
	    if(Board.brd[3][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //2 jump up left
	    if((Board.brd[3][6] == "1") || (Board.brd[3][6] == "X")){
		if(Board.brd[2][5] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //2 angle jump up left
	    if((Board.brd[3][6] == "1") || (Board.brd[3][6] == "X")){
		if(Board.brd[2][5] == " "){
		    if((Board.brd[1][6] == "1") || (Board.brd[1][6] == "X")){
			if(Board.brd[0][7] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 6;
		count++;
			}
		    }
		}
	    }
	    //2 double jump up right
	    if((Board.brd[3][6] == "1") || (Board.brd[3][6] == "X")){
		if(Board.brd[2][5] == " "){
		    if((Board.brd[1][4] == "1") || (Board.brd[1][4] == "X")){
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
	    //2 up right
	    if(Board.brd[2][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //2 jump up right
	    if((Board.brd[2][1] == "1") || (Board.brd[2][1] == "X")){
		if(Board.brd[1][2] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    
	    
	}
	if((r == 3) && (c == 2)){
	    //2 up left
	    if(Board.brd[2][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //2 up right
	    if(Board.brd[2][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //2 jump up left
	    if((Board.brd[2][1] == "1") || (Board.brd[2][1] == "X")){
		if(Board.brd[1][0] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //2 jump up right
	    if((Board.brd[2][3] == "1") || (Board.brd[2][3] == "X")){
		if(Board.brd[1][4] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    
	    
	}
	if((r == 3) && (c == 4)){
	    //2 up left
	    if(Board.brd[2][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //2 up right
	    if(Board.brd[2][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //2 jump up left
	    if((Board.brd[2][3] == "1") || (Board.brd[2][3] == "X")){
		if(Board.brd[1][2] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //2 jump up right
	    if((Board.brd[2][5] == "1") || (Board.brd[2][5] == "X")){
		if(Board.brd[1][6] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    
	    
	}
	if((r == 3) && (c == 6)){
	    //2 up right
	    if(Board.brd[2][7] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //2 up left
	    if(Board.brd[2][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //2 jump up left
	    if((Board.brd[2][5] == "1") || (Board.brd[2][5] == "X")){
		if(Board.brd[1][4] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    
	    
	} 
	if((r == 2) && (c == 1)){
	    //2 up left
	    if(Board.brd[1][0] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //2 up right
	    if(Board.brd[1][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //2 jump up right
	    if((Board.brd[1][2] == "1") || (Board.brd[1][2] == "X")){
		if(Board.brd[0][3] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    
	}
	if((r == 2) && (c == 3)){
	    //2 up left
	    if(Board.brd[1][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //2 up right
	    if(Board.brd[1][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //2 jump up left
	    if((Board.brd[1][2] == "1") || (Board.brd[1][2] == "X")){
		if(Board.brd[0][1] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //2 jump up right
	    if((Board.brd[1][4] == "1") || (Board.brd[1][4] == "X")){
		if(Board.brd[0][5] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 3;
		count++;
		}
	    }
	    
	}
	if((r == 2) && (c == 5)){
	    //2 up left
	    if(Board.brd[1][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //2 up right
	    if(Board.brd[1][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //2 jump up left
	    if((Board.brd[1][4] == "1") || (Board.brd[1][4] == "X")){
		if(Board.brd[0][3] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    //2 jump up right
	    if((Board.brd[1][6] == "1") || (Board.brd[1][6] == "X")){
		if(Board.brd[0][7] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    
	}
	if((r == 2) && (c == 7)){
	    //2 up left
	    if(Board.brd[1][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	    //2 jump up left king
	    if((Board.brd[1][6] == "1") || (Board.brd[1][6] == "X")){
		if(Board.brd[0][5] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 4;
		count++;
		}
	    }
	    
	}   
	if((r == 1) && (c == 0)){
	    //2 up right
	    if(Board.brd[0][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    
	}
	if((r == 1) && (c == 2)){
	    //2 up right
	    if(Board.brd[0][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //2 up left
	    if(Board.brd[0][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	}
	if((r == 1) && (c == 4)){
	    //2 up right
	    if(Board.brd[0][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //2 up left
	    if(Board.brd[0][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	}
	if((r == 1) && (c == 6)){
	    //2 up right
	    if(Board.brd[0][7] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 1;
		count++;
	    }
	    //2 up left
	    if(Board.brd[0][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 2;
		count++;
	    }
	}
    }
// End king moves now	//
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
		

	if((r == 0) && (c == 1)){
	    //O,2 down right
	    if(Board.brd[1][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //O,2 down left
	    if(Board.brd[1][0] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //O,2 jump down right
	    if((Board.brd[1][2] == "1") || (Board.brd[1][2] == "X")){
		if(Board.brd[2][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //O,2 angle jump down right
	    if((Board.brd[1][2] == "1") || (Board.brd[1][2] == "X")){
		if(Board.brd[2][3] == " "){
		    if((Board.brd[3][2] == "1") || (Board.brd[3][2] == "X")){
			if(Board.brd[4][1] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 55;
		count++;
			}
		    }
		}
	    }
	    //O,2 double jump down right
	    if((Board.brd[1][2] == "1") || (Board.brd[1][2] == "X")){
		if(Board.brd[2][3] == " "){
		    if((Board.brd[3][4] == "1") || (Board.brd[3][4] == "X")){
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
	    //O,2 down right
	    if(Board.brd[1][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //O,2 down left
	    if(Board.brd[1][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //O,2 jump down right
	    if((Board.brd[1][4] == "1") || (Board.brd[1][4] == "X")){
		if(Board.brd[2][5] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //O,2 jump down left
	    if((Board.brd[1][2] == "1") || (Board.brd[1][2] == "X")){
		if(Board.brd[2][1] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    //O,2 angle jump down left
	    if((Board.brd[1][2] == "1") || (Board.brd[1][2] == "X")){
		if(Board.brd[2][1] == " "){
		    if((Board.brd[3][2] == "1") || (Board.brd[3][2] == "X")){
			if(Board.brd[4][3] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 66;
		count++;
			}
		    }
		}
	    }
	    //O,2 angle jump down right
	    if((Board.brd[1][4] == "1") || (Board.brd[1][4] == "X")){
		if(Board.brd[2][5] == " "){
		    if((Board.brd[3][4] == "1") || (Board.brd[3][4] == "X")){
			if(Board.brd[4][3] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 55;
		count++;
			}
		    }
		}
	    }
	    //O,2 double jump down right
	    if((Board.brd[1][4] == "1") || (Board.brd[1][4] == "X")){
		if(Board.brd[2][5] == " "){
		    if((Board.brd[3][6] == "1") || (Board.brd[3][6] == "X")){
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
	    //O,2 down right
	    if(Board.brd[1][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //O,2 down left
	    if(Board.brd[1][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //O,2 jump down right
	    if((Board.brd[1][6] == "1") || (Board.brd[1][6] == "X")){
		if(Board.brd[2][7] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //O,2 jump down left
	    if((Board.brd[1][4] == "1") || (Board.brd[1][4] == "X")){
		if(Board.brd[2][3] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    //O,2 angle jump down left
	    if((Board.brd[1][4] == "1") || (Board.brd[1][4] == "X")){
		if(Board.brd[2][3] == " "){
		    if((Board.brd[3][4] == "1") || (Board.brd[3][4] == "X")){
			if(Board.brd[4][5] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 66;
		count++;
			}
		    }
		}
	    }
	    //O,2 angle jump down right
	    if((Board.brd[1][6] == "1") || (Board.brd[1][6] == "X")){
		if(Board.brd[2][7] == " "){
		    if((Board.brd[3][6] == "1") || (Board.brd[3][6] == "X")){
			if(Board.brd[4][5] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 55;
		count++;
			}
		    }
		}
	    }
	    //O,2 double jump down left
	    if((Board.brd[1][4] == "1") || (Board.brd[1][4] == "X")){
		if(Board.brd[2][3] == " "){
		    if((Board.brd[3][2] == "1") || (Board.brd[3][2] == "X")){
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
	    //O,2 down left
	    if(Board.brd[1][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //O,2 jump down left
	    if((Board.brd[1][6] == "1") || (Board.brd[1][6] == "X")){
		if(Board.brd[2][5] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    //O,2 angle jump down left
	    if((Board.brd[1][6] == "1") || (Board.brd[1][6] == "X")){
		if(Board.brd[2][5] == " "){
		    if((Board.brd[3][6] == "1") || (Board.brd[3][6] == "X")){
			if(Board.brd[4][7] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 66;
		count++;
			}
		    }
		}
	    }
	    //O,2 double jump down left
	    if((Board.brd[1][6] == "1") || (Board.brd[1][6] == "X")){
		if(Board.brd[2][5] == " "){
		    if((Board.brd[3][4] == "1") || (Board.brd[3][4] == "X")){
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
	    //O,2 down right
	    if(Board.brd[3][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //O,2 down left
	    if(Board.brd[3][0] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //O,2 jump down right
	    if((Board.brd[3][2] == "1") || (Board.brd[3][2] == "X")){
		if(Board.brd[4][3] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //O,2 angle jump down right 
	    if((Board.brd[3][2] == "1") || (Board.brd[3][2] == "X")){
		if(Board.brd[4][3] == " "){
		    if((Board.brd[5][2] == "1") || (Board.brd[5][2] == "X")){
			if(Board.brd[6][1] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 55;
		count++;
			}
		    }
		}
	    }
	    //O,2 double jump down right
	    if((Board.brd[3][2] == "1") || (Board.brd[3][2] == "X")){
		if(Board.brd[4][3] == " "){
		    if((Board.brd[5][4] == "1") || (Board.brd[5][4] == "X")){
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
	    //O,2 down right
	    if(Board.brd[3][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //O,2 down left
	    if(Board.brd[3][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //O,2 jump down right
	    if((Board.brd[3][4] == "1") || (Board.brd[3][4] == "X")){
		if(Board.brd[4][5] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //O,2 jump down left
	    if((Board.brd[3][2] == "1") || (Board.brd[3][2] == "X")){
		if(Board.brd[4][1] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    //O,2 angle jump down left
	    if((Board.brd[3][2] == "1") || (Board.brd[3][2] == "X")){
		if(Board.brd[4][1] == " "){
		    if((Board.brd[5][2] == "1") || (Board.brd[5][2] == "X")){
			if(Board.brd[6][3] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 66;
		count++;
			}
		    }
		}
	    }
	    //O,2 angle jump down right
	    if((Board.brd[3][4] == "1") || (Board.brd[3][4] == "X")){
		if(Board.brd[4][5] == " "){
		    if((Board.brd[5][4] == "1") || (Board.brd[5][4] == "X")){
			if(Board.brd[6][3] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 55;
		count++;
			}
		    }
		}
	    }
	    //O,2 double jump down right
	    if((Board.brd[3][4] == "1") || (Board.brd[3][4] == "X")){
		if(Board.brd[4][5] == " "){
		    if((Board.brd[5][6] == "1") || (Board.brd[5][6] == "X")){
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
	    //O,2 down right
	    if(Board.brd[3][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //O,2 down left
	    if(Board.brd[3][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //O,2 jump down right
	    if((Board.brd[3][6] == "1") || (Board.brd[3][6] == "X")){
		if(Board.brd[4][7] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //O,2 jump down left
	    if((Board.brd[3][4] == "1") || (Board.brd[3][4] == "X")){
		if(Board.brd[4][3] == " "){
		    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    //O,2 angle jump down left
	    if((Board.brd[3][4] == "1") || (Board.brd[3][4] == "X")){
		if(Board.brd[4][3] == " "){
		    if((Board.brd[5][4] == "1") || (Board.brd[5][4] == "X")){
			if(Board.brd[6][5] == " "){
			    holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 66;
		count++;
			}
		    }
		}
	    }
	    //O,2 angle jump down right
	    if((Board.brd[3][6] == "1") || (Board.brd[3][6] == "X")){
		if(Board.brd[4][7] == " "){
		    if((Board.brd[5][6] == "1") || (Board.brd[5][6] == "X")){
			if(Board.brd[6][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 55;
		count++;
			}
		    }
		}
	    }
	    //O,2 double jump down left
	    if((Board.brd[3][4] == "1") || (Board.brd[3][4] == "X")){
		if(Board.brd[4][3] == " "){
		    if((Board.brd[5][2] == "1") || (Board.brd[5][2] == "X")){
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
	    //O,2 down left
	    if(Board.brd[3][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //O,2 jump down left
	    if((Board.brd[3][6] == "1") || (Board.brd[3][6] == "X")){
		if(Board.brd[4][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    //O,2 angle jump down left
	    if((Board.brd[3][6] == "1") || (Board.brd[3][6] == "X")){
		if(Board.brd[4][5] == " "){
		    if((Board.brd[5][6] == "1") || (Board.brd[5][6] == "X")){
			if(Board.brd[6][7] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 66;
		count++;
			}
		    }
		}
	    }
	    //O,2 double jump down left
	    if((Board.brd[3][6] == "1") || (Board.brd[3][6] == "X")){
		if(Board.brd[4][5] == " "){
		    if((Board.brd[5][4] == "1") || (Board.brd[5][4] == "X")){
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
	    //O,2 down right
	    if(Board.brd[5][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //O,2 down left
	    if(Board.brd[5][0] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //O,2 jump down right
	    if((Board.brd[5][2] == "1") || (Board.brd[5][2] == "X")){
		if(Board.brd[6][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    
	    
	}
	if((r == 4) && (c == 3)){
	    //O,2 down right
	    if(Board.brd[5][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //O,2 down left
	    if(Board.brd[5][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //O,2 jump down right
	    if((Board.brd[5][4] == "1") || (Board.brd[5][4] == "X")){
		if(Board.brd[6][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //O,2 jump down left
	    if((Board.brd[5][2] == "1") || (Board.brd[5][2] == "X")){
		if(Board.brd[6][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    
	    
	}
	if((r == 4) && (c == 5)){
	    //O,2 down right
	    if(Board.brd[5][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //O,2 down left
	    if(Board.brd[5][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //O,2 jump down right
	    if((Board.brd[5][6] == "1") || (Board.brd[5][6] == "X")){
		if(Board.brd[6][7] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //O,2 jump down left
	    if((Board.brd[5][4] == "1") || (Board.brd[5][4] == "X")){
		if(Board.brd[6][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    
	    
	}
	if((r == 4) && (c == 7)){
	    //O,2 down left
	    if(Board.brd[1][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //O,2 jump down left
	    if((Board.brd[1][6] == "1") || (Board.brd[1][6] == "X")){
		if(Board.brd[2][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    
	    
	}
	if((r == 6) && (c == 1)){
	    //O,2 down right
	    if(Board.brd[7][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //O,2 down left
	    if(Board.brd[7][0] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    
	    
	}
	if((r == 6) && (c == 3)){
	    //O,2 down right
	    if(Board.brd[7][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //O,2 down left
	    if(Board.brd[7][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    
	}
	if((r == 6) && (c == 5)){
	    //O,2 down right
	    if(Board.brd[7][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //O,2 down left
	    if(Board.brd[7][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    
	    
	}
	if((r == 6) && (c == 7)){
	    //O,2 down left
	    if(Board.brd[7][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    
	    
	}
	if((r == 1) && (c == 0)){
	    //O,2 down right
	    if(Board.brd[2][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //O,2 jump down right
	    if((Board.brd[2][1] == "1") || (Board.brd[2][1] == "X")){
		if(Board.brd[3][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //O,2 angle jump down Right
	    if((Board.brd[2][1] == "1") || (Board.brd[2][1] == "X")){
		if(Board.brd[3][2] == " "){
		    if((Board.brd[4][1] == "1") || (Board.brd[4][1] == "X")){
			if(Board.brd[5][0] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 55;
		count++;
			}
		    }
		}
	    }
	    //O,2 double jump down right
	    if((Board.brd[2][1] == "1") || (Board.brd[2][1] == "X")){
		if(Board.brd[3][2] == " "){
		    if((Board.brd[4][3] == "1") || (Board.brd[4][3] == "X")){
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
	    //O,2 down right
	    if(Board.brd[2][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //O,2 down left
	    if(Board.brd[2][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //O,2 jump down right
	    if((Board.brd[2][3] == "1") || (Board.brd[2][3] == "X")){
		if(Board.brd[3][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //O,2 jump down left
	    if((Board.brd[2][1] == "1") || (Board.brd[2][1] == "X")){
		if(Board.brd[3][0] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    //O,2 angle jump down left
	    if((Board.brd[2][1] == "1") || (Board.brd[2][1] == "X")){
		if(Board.brd[3][0] == " "){
		    if((Board.brd[4][1] == "1") || (Board.brd[4][1] == "X")){
			if(Board.brd[5][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 66;
		count++;
			}
		    }
		}
	    }
	    //O,2 angle jump down right
	    if((Board.brd[2][3] == "1") || (Board.brd[2][3] == "X")){
		if(Board.brd[3][4] == " "){
		    if((Board.brd[4][3] == "1") || (Board.brd[4][3] == "X")){
			if(Board.brd[5][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 55;
		count++;
			}
		    }
		}
	    }
	    //O,2 double jump down right
	    if((Board.brd[2][3] == "1") || (Board.brd[2][3] == "X")){
		if(Board.brd[3][4] == " "){
		    if((Board.brd[4][5] == "1") || (Board.brd[4][5] == "X")){
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
	    //O,2 down right
	    if(Board.brd[2][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //O,2 down left
	    if(Board.brd[2][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //O,2 jump down right
	    if((Board.brd[2][5] == "1") || (Board.brd[2][5] == "X")){
		if(Board.brd[3][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //O,2 jump down left
	    if((Board.brd[2][3] == "1") || (Board.brd[2][3] == "X")){
		if(Board.brd[3][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    //O,2 angle jump down left
	    if((Board.brd[2][3] == "1") || (Board.brd[2][3] == "X")){
		if(Board.brd[3][2] == " "){
		    if((Board.brd[4][3] == "1") || (Board.brd[4][3] == "X")){
			if(Board.brd[5][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 66;
		count++;
			}
		    }
		}
	    }
	    //O,2 angle jump down right
	    if((Board.brd[2][5] == "1") || (Board.brd[2][5] == "X")){
		if(Board.brd[3][6] == " "){
		    if((Board.brd[4][5] == "1") || (Board.brd[4][5] == "X")){
			if(Board.brd[5][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 55;
		count++;
			}
		    }
		}
	    }
	    //O,2 double jump down left
	    if((Board.brd[2][3] == "1") || (Board.brd[2][3] == "X")){
		if(Board.brd[3][2] == " "){
		    if((Board.brd[4][1] == "1") || (Board.brd[4][1] == "X")){
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
	    //O,2 down right
	    if(Board.brd[2][7] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //O,2 down left
	    if(Board.brd[2][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //O,2 jump down left
	    if((Board.brd[2][5] == "1") || (Board.brd[2][5] == "X")){
		if(Board.brd[3][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    //O,2 angle jump down left
	    if((Board.brd[2][5] == "1") || (Board.brd[2][5] == "X")){
		if(Board.brd[3][4] == " "){
		    if((Board.brd[4][5] == "1") || (Board.brd[4][5] == "X")){
			if(Board.brd[5][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 66;
		count++;
			}
		    }
		}
	    }
	    //O,2 double jump down left
	    if((Board.brd[2][5] == "1") || (Board.brd[2][5] == "X")){
		if(Board.brd[3][4] == " "){
		    if((Board.brd[4][3] == "1") || (Board.brd[4][3] == "X")){
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
	    //O,2 down right
	    if(Board.brd[4][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //O,2 jump down right
	    if((Board.brd[4][1] == "1") || (Board.brd[4][1] == "X")){
		if(Board.brd[5][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //O,2 angle jump down Right
	    if((Board.brd[4][1] == "1") || (Board.brd[4][1] == "X")){
		if(Board.brd[5][2] == " "){
		    if((Board.brd[6][1] == "1") || (Board.brd[6][1] == "X")){
			if(Board.brd[7][0] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 55;
		count++;
			}
		    }
		}
	    }
	    //O,2 double jump down right
	    if((Board.brd[4][1] == "1") || (Board.brd[4][1] == "X")){
		if(Board.brd[5][2] == " "){
		    if((Board.brd[6][3] == "1") || (Board.brd[6][3] == "X")){
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
	    //O,2 down right
	    if(Board.brd[4][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //O,2 down left
	    if(Board.brd[4][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //O,2 jump down right
	    if((Board.brd[4][3] == "1") || (Board.brd[4][3] == "X")){
		if(Board.brd[5][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //O,2 jump down left
	    if((Board.brd[4][1] == "1") || (Board.brd[4][1] == "X")){
		if(Board.brd[5][0] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    //O,2 angle jump down left
	    if((Board.brd[4][1] == "1") || (Board.brd[4][1] == "X")){
		if(Board.brd[5][0] == " "){
		    if((Board.brd[6][1] == "1") || (Board.brd[6][1] == "X")){
			if(Board.brd[7][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 66;
		count++;
			}
		    }
		}
	    }
	    //O,2 angle jump down right
	    if((Board.brd[4][3] == "1") || (Board.brd[4][3] == "X")){
		if(Board.brd[5][4] == " "){
		    if((Board.brd[6][3] == "1") || (Board.brd[6][3] == "X")){
			if(Board.brd[7][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 55;
		count++;
			}
		    }
		}
	    }
	    //O,2 double jump down right
	    if((Board.brd[4][3] == "1") || (Board.brd[4][3] == "X")){
		if(Board.brd[5][4] == " "){
		    if((Board.brd[6][5] == "1") || (Board.brd[6][5] == "X")){
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
	    //O,2 down right
	    if(Board.brd[4][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //O,2 down left
	    if(Board.brd[4][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //O,2 jump down right
	    if((Board.brd[4][5] == "1") || (Board.brd[4][5] == "X")){
		if(Board.brd[5][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //O,2 jump down left
	    if((Board.brd[4][3] == "1") || (Board.brd[4][3] == "X")){
		if(Board.brd[5][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    //O,2 angle jump down left
	    if((Board.brd[4][3] == "1") || (Board.brd[4][3] == "X")){
		if(Board.brd[5][2] == " "){
		    if((Board.brd[6][3] == "1") || (Board.brd[6][3] == "X")){
			if(Board.brd[7][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 66;
		count++;
			}
		    }
		}
	    }
	    //O,2 angle jump down right
	    if((Board.brd[4][5] == "1") || (Board.brd[4][5] == "X")){
		if(Board.brd[5][6] == " "){
		    if((Board.brd[6][5] == "1") || (Board.brd[6][5] == "X")){
			if(Board.brd[7][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 55;
		count++;
			}
		    }
		}
	    }
	    //O,2 double jump down left
	    if((Board.brd[4][3] == "1") || (Board.brd[4][3] == "X")){
		if(Board.brd[5][2] == " "){
		    if((Board.brd[6][1] == "1") || (Board.brd[6][1] == "X")){
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
	    //O,2 down right
	    if(Board.brd[4][7] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //O,2 down left
	    if(Board.brd[4][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //O,2 jump down left
	    if((Board.brd[4][5] == "1") || (Board.brd[4][5] == "X")){
		if(Board.brd[5][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    //O,2 angle jump down left
	    if((Board.brd[4][5] == "1") || (Board.brd[4][5] == "X")){
		if(Board.brd[5][4] == " "){
		    if((Board.brd[6][5] == "1") || (Board.brd[6][5] == "X")){
			if(Board.brd[7][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 66;
		count++;
			}
		    }
		}
	    }
	    //O,2 double jump down left
	    if((Board.brd[4][5] == "1") || (Board.brd[4][5] == "X")){
		if(Board.brd[5][4] == " "){
		    if((Board.brd[6][3] == "1") || (Board.brd[6][3] == "X")){
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
	    //O,2 down right
	    if(Board.brd[6][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //O,2 jump down right
	    if((Board.brd[6][1] == "1") || (Board.brd[6][1] == "X")){
		if(Board.brd[7][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	  
	    
	}
	if((r == 5) && (c == 2)){
	    //O,2 down right
	    if(Board.brd[6][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //O,2 down left
	    if(Board.brd[6][1] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //O,2 jump down right
	    if((Board.brd[6][3] == "1") || (Board.brd[6][3] == "X")){
		if(Board.brd[7][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //O,2 jump down left
	    if((Board.brd[6][1] == "1") || (Board.brd[6][1] == "X")){
		if(Board.brd[7][0] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }

	    
	}
	if((r == 5) && (c == 4)){
	    //O,2 down right
	    if(Board.brd[6][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //O,2 down left
	    if(Board.brd[6][3] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //O,2 jump down right
	    if((Board.brd[6][5] == "1") || (Board.brd[6][5] == "X")){
		if(Board.brd[7][6] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 33;
		count++;
		}
	    }
	    //O,2 jump down left
	    if((Board.brd[6][3] == "1") || (Board.brd[6][3] == "X")){
		if(Board.brd[7][2] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    
	  
	    
	}
	if((r == 5) && (c == 6)){
	    //O,2 down right
	    if(Board.brd[6][7] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 11;
		count++;
	    }
	    //O,2 down left
	    if(Board.brd[6][5] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 22;
		count++;
	    }
	    //O,2 jump down left
	    if((Board.brd[6][5] == "1") || (Board.brd[6][5] == "X")){
		if(Board.brd[7][4] == " "){
		holdValues[0][0] = r;
		holdValues[0][1] = c;
		holdValues[1][count] = 44;
		count++;
		}
	    }
	    
	}
	

    }
}
