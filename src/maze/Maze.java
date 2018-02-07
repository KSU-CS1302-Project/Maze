package maze;

/**
 * Created by Tulin Kilinc 1/19/2017.
 * KSU Programming Principles II
 */

//brendan's comment

public class Maze {

    //n, s, w, e 
    private char direction;
    private int r = 16;  // x position of the mouse
    private int c = 0;  //y position of the mouse
    private boolean exitFound = false;
    int[][] arrMaze;

    public Maze(int[][] arrMaze) {
        this.arrMaze = arrMaze;
        direction = 'n';
    }

    //Prints out the maze without solution
    public void displayMaze() {
        for (int i = 0; i < arrMaze.length; ++i) {
		    for (int o = 0; o < arrMaze[i].length; ++o) {
		       if (arrMaze[i][o] == 0) {
				   System.out.print("#");}
		        else if (arrMaze[i][o] == '@') {
		        	System.out.print("@");}
		        else {
		        	System.out.print(" ");}

		    }
		    System.out.println();
	    }
    }

    //displays the Maze with the path taken
    public void displayPath() {
        //temporary
        displayMaze();
    }


    public boolean takeStep() {
        //complete the code here
	    if(direction == 'n') {    
    		if(arrMaze[r][c + 1] == 1) {
	        	moveEast();
	        }
	        else if(arrMaze[r - 1][c] == 1) {
	        	moveNorth();
	        }
	        else if(arrMaze[r][c - 1] == 1) {
	        	moveWest();
	        }
	        else if(arrMaze[r + 1][c] == 1) {
	        	moveSouth();
	        }
	        else {
	        	System.exit(0);
	        }
	    }
	    else if(direction == 'e') {
	    	if(arrMaze[r + 1][c] == 1) {
	    		moveSouth();
	    	}
	    	else if(arrMaze[r][c + 1] == 1) {
	    		moveEast();
	    	}
	    	else if(arrMaze[r - 1][c] == 1) {
	    		moveNorth();
	    	}
	    	
	    	else moveWest();

	    }
	    else if(direction == 's') {
	    	if(arrMaze[r][c - 1] == 1) {
	    		moveWest();
	    	}
	    	else if(arrMaze[r + 1][c] == 1) {
	    		moveSouth();
	    	}
	    	else if(arrMaze[r][c + 1] == 1) {
	    		moveEast();
	    	}
	    	else moveNorth();
	    	
	    }
	    else if(direction == 'w') {
	    	if(arrMaze[r - 1][c] == 1) {
	    		moveNorth();
	    	}
	    	else if(arrMaze[r][c - 1] == 1) {
	    		moveWest();
	    	}
	    	else if(arrMaze[r + 1][c] == 1) {
	    		moveSouth();
	    	}
	    	else moveEast();
	    }
	    else {
	    	System.exit(0);
	    }
	    
    	
    	return isAnExit();
    }
//Grant's comment
    private void moveNorth() {
        //complete the code here
    	arrMaze[r - 1][c] = '@';
    	arrMaze[r][c] = 1;
    	this.r -=1;
    	this.direction = 'n';
    	displayMaze();
    }

    private void moveSouth() {
        //complete the code here
    	arrMaze[r + 1][c] = '@';
    	arrMaze[r][c] = 1;
    	this.r += 1;
    	this.direction = 's';
    	displayMaze();
    }

    private void moveEast() {
        //complete the code here
    	arrMaze[r][c + 1] = '@';
    	arrMaze[r][c] = 1;
    	this.c += 1;
    	this.direction = 'e';
    	displayMaze();
    }

    private void moveWest() {
        //complete the code here
    	arrMaze[r][c - 1] = '@';
    	arrMaze[r][c] = 1;
    	this.c -= 1;
    	this.direction = 'w';
    	displayMaze();
    }


    private boolean isAnExit() {
        //boolean exitFound = ( r == 0 || r == arrMaze.length || c == 0 || c == arrMaze[0].length );
		// temporary fix: the exit of this particular maze is on the right side, so I'll check that.
		// we need to all talk about a permanent fix.
		boolean exitFound = ( c == arrMaze[0].length );
        return exitFound;
    }

    //finds the path without stopping at every step
    public void findExit() {
        //complete the code here
    	        while(!isAnExit()) // if it is not an exit then call the takeStep method.
    	            takeStep();


    }
}
