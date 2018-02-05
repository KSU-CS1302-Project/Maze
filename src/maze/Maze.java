package maze;

/**
 * Created by Tulin Kilinc 1/19/2017.
 * KSU Programming Principles II
 */

//brendan's comment

public class Maze {

    private char direction;
    private int r;  // x position of the mouse
    private int c;  //y position of the mouse
    private boolean exitFound = false;
    int[][] arrMaze;

    public Maze(int[][] arrMaze) {
        this.arrMaze = arrMaze;
    }

    //Prints out the maze without solution
    public void displayMaze() {
        for (int i = 0; i < arrMaze.length; ++i) {
		    for (int o = 0; o < arrMaze[i].length; ++o) {
		        if (arrMaze[i][o] == 0) {
				    System.out.print("#");}
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
        if(arrMaze[r + 1][c] == 0) {
        	moveEast();
        }
        else if(arrMaze[r][c - 1] == 0) {
        	moveNorth();
        }
        else if(arrMaze[r - 1][c] == 0) {
        	moveWest();
        }
        else if(arrMaze[r][c + 1] == 0) {
        	moveSouth();
        }
        else {
        	System.exit(0);
        }
    	
    	return isAnExit();
    }

    private void moveNorth() {
        //complete the code here
    	this.c -=1;
    }

    private void moveSouth() {
        //complete the code here
    	this.c += 1;
    }

    private void moveEast() {
        //complete the code here
    	this.r += 1;
    }

    private void moveWest() {
        //complete the code here
    	this.r -= 1;
    }


    private boolean isAnExit() {
        //complete the code here
        return exitFound;
    }

    //finds the path without stopping at every step
    public void findExit() {
        //complete the code here

    }
}
