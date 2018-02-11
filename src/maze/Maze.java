package maze;

/**
 * Created by Tulin Kilinc 1/19/2017.
 * KSU Programming Principles II
 */

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
				   System.out.print("#");
				   System.out.print(" ");
				} else if (arrMaze[i][o] == '@') {
		        	System.out.print("@");
					System.out.print(" ");
				} else if (arrMaze[i][o] == 2) {
					System.out.print("~");
					System.out.print(" ");
				} else {
		        	System.out.print(" ");
					System.out.print(" ");
				}
			}
		    System.out.println();
	    }
    }

    //displays the Maze with the path taken
    public void displayPath() {
        //temporary
        displayMaze();
    }

	private boolean isWalkable(int r, int c)
	{
		int tile = arrMaze[r][c];
		if (tile == 1 || tile == 2) {
			return true;
		} else {
			return false;
		}
	}


    public boolean takeStep() {
        //complete the code here
	    if(direction == 'n') {    
    		if(isWalkable(r, c+1)) {
	        	moveEast();
	        }
	        else if(isWalkable(r-1, c)) {
	        	moveNorth();
	        }
	        else if(isWalkable(r, c-1)) {
	        	moveWest();
	        }
	        else if(isWalkable(r+1, c)) {
	        	moveSouth();
	        }
	        else {
	        	System.exit(0);
	        }
	    }
	    else if(direction == 'e') {
	    	if(isWalkable(r+1, c)) {
	    		moveSouth();
	    	}
	    	else if(isWalkable(r, c+1)) {
	    		moveEast();
	    	}
	    	else if(isWalkable(r-1, c)) {
	    		moveNorth();
	    	} else if (isWalkable(r, c-1)) {
				moveWest();
			}
	    }
	    else if(direction == 's') {
	    	if(isWalkable(r, c-1)) {
	    		moveWest();
	    	}
	    	else if(isWalkable(r+1, c)) {
	    		moveSouth();
	    	}
	    	else if(isWalkable(r, c+1)) {
	    		moveEast();
	    	} else if(isWalkable(r-1, c)) {
				moveNorth();
			}
	    	
	    }
	    else if(direction == 'w') {
	    	if(isWalkable(r-1, c)) {
	    		moveNorth();
	    	}
	    	else if(isWalkable(r, c-1)) {
	    		moveWest();
	    	}
	    	else if(isWalkable(r+1, c)) {
	    		moveSouth();
	    	} else if (isWalkable(r, c+1)) {
				moveEast();
			}
	    }
	    else {
	    	System.exit(0);
	    }
	    
    	
    	return isAnExit();
    }

    private void moveNorth() {
        //complete the code here
    	arrMaze[r - 1][c] = '@';
    	arrMaze[r][c] = 2;
    	this.r -=1;
    	this.direction = 'n';
    	displayMaze();
    }

    private void moveSouth() {
        //complete the code here
    	arrMaze[r + 1][c] = '@';
    	arrMaze[r][c] = 2;
    	this.r += 1;
    	this.direction = 's';
    	displayMaze();
    }

    private void moveEast() {
        //complete the code here
    	arrMaze[r][c + 1] = '@';
    	arrMaze[r][c] = 2;
    	this.c += 1;
    	this.direction = 'e';
    	displayMaze();
    }

    private void moveWest() {
        //complete the code here
    	arrMaze[r][c - 1] = '@';
    	arrMaze[r][c] = 2;
    	this.c -= 1;
    	this.direction = 'w';
    	displayMaze();
    }


    private boolean isAnExit() {
        //boolean exitFound = ( r == 0 || r == arrMaze.length || c == 0 || c == arrMaze[0].length );
		// temporary fix: the exit of this particular maze is on the right side, so I'll check that.
		// we need to all talk about a permanent fix.
    	exitFound=arrMaze[r].length-1 == c; // exit is found if the last location of row is equal to the columns
 	   
        return exitFound;
    }

    //finds the path without stopping at every step
    public void findExit() {
        //complete the code here
    	        while(!isAnExit()) // if it is not an exit then call the takeStep method.
    	            takeStep();


    }
}
