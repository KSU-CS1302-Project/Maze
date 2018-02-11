package maze;

/**
 * Created by Tulin Kilinc 1/19/2017.
 * KSU Programming Principles II
 */

public class Maze {

    //n, s, w, e 
    private char direction;
    private int r;  // x position of the mouse
    private int c;  //y position of the mouse
    private boolean exitFound = false;
    int[][] arrMaze;
	int stepsTaken = 0;

    public Maze(int[][] arrMaze) {
        this.arrMaze = arrMaze;
        direction = 'n';
		r = 16;
		c = 0;
		stepsTaken = 0;
    }

    //Prints out the maze without solution
    public void displayMaze() {
        for (int i = 0; i < arrMaze.length; ++i) {
		    for (int o = 0; o < arrMaze[i].length; ++o) {
		       if (arrMaze[i][o] == 0) {
				   System.out.print("#");
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
		++stepsTaken;
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
    	arrMaze[r - 1][c] = '@';
    	arrMaze[r][c] = 2;
    	this.r -=1;
    	this.direction = 'n';
    	displayMaze();
    }

    private void moveSouth() {
    	arrMaze[r + 1][c] = '@';
    	arrMaze[r][c] = 2;
    	this.r += 1;
    	this.direction = 's';
    	displayMaze();
    }

    private void moveEast() {
    	arrMaze[r][c + 1] = '@';
    	arrMaze[r][c] = 2;
    	this.c += 1;
    	this.direction = 'e';
    	displayMaze();
    }

    private void moveWest() {
    	arrMaze[r][c - 1] = '@';
    	arrMaze[r][c] = 2;
    	this.c -= 1;
    	this.direction = 'w';
    	displayMaze();
    }


    private boolean isAnExit() {
		if (stepsTaken < 4)
			return false;
		return ( r == 0 || r == arrMaze.length - 1 || c == 0 || c == arrMaze[r].length -1);
    }

    //finds the path without stopping at every step
    public void findExit() {
    	while(!takeStep()); // if it is not an exit then call the takeStep method.
    }
}
