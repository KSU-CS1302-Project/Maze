package maze;

/**
 * Created by Tulin Kilinc 1/19/2017.
 * KSU Programming Principles II
 */
/**
 * Edited by Spencer Brown, Brendan Pope, Grant Williams.
 * CS 1302-05 Spring 2018 Professor Nalamothu.
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
					
				}else {
		        	System.out.print(" ");
					System.out.print(" ");
				}
			}
		    System.out.println();
	    }
    }

    public boolean takeStep() {
        if(direction == 'n'){
            if(arrMaze[r][c + 1]==1) { 
                moveEast();
            } else if(arrMaze[r - 1][c] == 1 || arrMaze[r - 1][c] == 2) {
                moveNorth();
            }
            else if(arrMaze[r][c - 1] == 1) {
                moveWest();
            }
            else
                moveSouth();
        }
        else if(direction=='e'){
            if(arrMaze[r + 1][c]==1){
                moveSouth();
            }
            else if(arrMaze[r][c + 1]==1 || arrMaze[r][c+1] == 2){
                moveEast();
            }
            else if(arrMaze[r - 1][c]==1){
                moveNorth();
            }
            else
                moveWest();
        }
        else if(direction=='w'){
            if(arrMaze[r-1][c]==1){
                moveNorth();
            }
            else if(arrMaze[r][c-1]==1 || arrMaze[r][c - 1] == 2){
                moveWest();
            }
            else if(arrMaze[r + 1][c]==1){
                moveSouth();
            }
            else
                moveEast();
        }
        else if(direction=='s'){
            if(arrMaze[r][c - 1]==1){
                moveWest();
            }
            else if(arrMaze[r + 1][c]==1 || arrMaze[r + 1][c] == 2){
                moveSouth();
            }
            else if(arrMaze[r][c + 1]==1){
                moveEast();
            }
            else
                moveNorth();
        }

	    
    	return isAnExit();
    }

    private void moveNorth() {
        direction = 'n';
        r -=1;
        
        if(arrMaze[r][c] == 1)
            arrMaze[r + 1][c] = 2;
        
        if(arrMaze[r][c] == 2)
            arrMaze[r + 1][c] = 3;
        
        arrMaze[r][c] = '@';
        
        stepsTaken++;
        displayPath();
        System.out.println("\n\n");
    }

    private void moveSouth() {
        direction = 's';
        r +=1;
        
        if(arrMaze[r][c] == 1)
            arrMaze[r - 1][c] = 2;
        
        if(arrMaze[r][c] == 2)
            arrMaze[r - 1][c] = 3;
        
        arrMaze[r][c] = '@';
        
        stepsTaken++;
        displayPath();
        System.out.println("\n\n");
    }

    private void moveEast() {
        direction = 'e';
        c +=1;
        
        if(arrMaze[r][c] == 1)
            arrMaze[r][c - 1] = 2;
        
        if(arrMaze[r][c] == 2)
            arrMaze[r][c - 1] = 3;
        
        arrMaze[r][c] = '@';
        
        stepsTaken++;
        displayPath();
        System.out.println("\n\n");
    }

    private void moveWest() {
    	direction = 'w';
        c -= 1;
        
        if(arrMaze[r][c] == 1)
            arrMaze[r][c + 1] = 2;
        
        if(arrMaze[r][c] == 2)
            arrMaze[r][c + 1] = 3;
        
        arrMaze[r][c] = '@';
        
        stepsTaken++;
        displayPath();
        System.out.println("\n\n");
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
