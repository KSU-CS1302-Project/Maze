package maze;

/**
 * Created by Tulin Kilinc 1/19/2017.
 * KSU Programming Principles II
 */

public class Maze {

    private char direction;
    private int r;  // x position of the mouse
    private int c;  //y position of the mouse
    private boolean exitFound = false;




    public Maze(int[][] arrMaze) {
     }

    //Prints out the maze without solution
    public void displayMaze() {

    }

    //displays the Maze with the path taken
    public void displayPath() {

    }


    public boolean takeStep() {
        //complete the code here

        return isAnExit();
    }

    private void moveNorth() {
        //complete the code here

    }

    private void moveSouth() {
        //complete the code here

    }

    private void moveEast() {
        //complete the code here

    }

    private void moveWest() {
        //complete the code here

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