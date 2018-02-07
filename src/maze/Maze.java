package maze;

/**
 * Created by Tulin Kilinc 1/19/2017.
 * KSU Programming Principles II
 */

//brendan's comment

public class Maze {

    //n, s, w, e 
    private char direction;
    private int r;  // x position of the mouse
    private int c;  //y position of the mouse
    private boolean exitFound = false;
    int[][] arrMaze;

    public Maze(int[][] arrMaze) {
        this.arrMaze = arrMaze;
        direction = 'N';
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

	// this needs some documentation.
	// this returns a one-dimensional array.
	// if the adjacent tile in the character's direction is a path, it will contains the x,y position of the next step.
	// if the tile is a wall, it will contain 2 elements, -1, -1.
	// the -1,-1 error values are chosen because, since the maze is stored as array, positions will always be >= 0.
	private int[] canMoveForward()
	{
		int[] position = {-1, -1};
		switch (direction) {
			case 'n':
				if (arrMaze[r][c+1] == 1) {
					position[0] = r;
					position[1] = c+1;
				}
				break;
			case 's':
				if (arrMaze[r][c-1] == 1) {
					position[0] = r;
					position[1] = c-1;
				}
				break;
			case 'e':
				if (arrMaze[r+1][c] == 1) {
					position[0] = r+1;
					position[1] = c;
				}
			case 'w':
				if (arrMaze[r-1][c] == 1) {
					position[0] = r-1;
					position[1] = c;
				}
			default:
				System.out.println("Uh, what?  Go back to preschool.");
				break;
		}
		return position;
	}

	private void turnLeft()
	{
		switch (direction) {
			case 'e':
				direction = 'n';
				break;
			case 'n':
				direction = 'w';
				break;
			case 'w':
				direction = 's';
				break;
			case 's':
				direction = 'e';
				break;
		}
	}


    public boolean takeStep() {
        //complete the code here
		int[] position = new int[2];
		position = canMoveForward();
		while (position[0] == -1) {
			turnLeft();
			position = canMoveForward();
		}
		r = position[0];
		c = position[1];

		// return value still unimplemented
    	return isAnExit();
    }
//Grant's comment
    private void moveNorth() {
        //complete the code here
    	arrMaze[r][c - 1] = '@';
    	arrMaze[r][c] = '1';
    	this.c -=1;
    	this.direction = 'n';
    	displayMaze();
    }

    private void moveSouth() {
        //complete the code here
    	arrMaze[r][c + 1] = '@';
    	arrMaze[r][c] = '1';
    	this.c += 1;
    	this.direction = 's';
    	displayMaze();
    }

    private void moveEast() {
        //complete the code here
    	arrMaze[r + 1][c] = '@';
    	arrMaze[r][c] = '1';
    	this.r += 1;
    	this.direction = 'e';
    	displayMaze();
    }

    private void moveWest() {
        //complete the code here
    	arrMaze[r - 1][c] = '@';
    	arrMaze[r][c] = '1';
    	this.r -= 1;
    	this.direction = 'w';
    	displayMaze();
    }


    private boolean isAnExit() {
        boolean exitFound = ( r == 0 || r == arrMaze.length || c == 0 || c == arrMaze[0].length );
        return exitFound;
    }

    //finds the path without stopping at every step
    public void findExit() {
        //complete the code here

    }
}