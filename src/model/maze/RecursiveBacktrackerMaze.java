package model.maze;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class RecursiveBacktrackerMaze {

    private Grid maze;

    /**
     * Generates a maze using Recursive Backtracker algorithm with the given number of rows and columns.
     * @param rows
     * @param columns
     * @return
     */
    public Grid generateMaze (int rows, int columns) {

        maze = new Grid(rows, columns);

        /* Choose a random starting SuperCell. */
        SuperCell startingCell = maze.getRandomCell();

        /* Initialize a Stack to keep track of visited cells. */
        Stack<SuperCell> stack = new Stack<>();
        stack.push(startingCell);

        /* Once the stack becomes empty, the algorithm finishes. */
        while (!stack.isEmpty()) {

            /* The current SuperCell is always at the top of the stack. */
            SuperCell currentCell = stack.peek();

            /* Get a list of unvisited neighbours of the current SuperCell. */
            ArrayList<SuperCell> unvisitedNeighbours = currentCell.getUnvisitedNeighbours();

            /* If we are at a dead end - the current SuperCell has no unvisited neighbours - we backtrack. */
            if (unvisitedNeighbours.isEmpty())
                stack.pop();

                /* Else if there is at least one unvisited neighbour we randomly choose one. */
            else {
                int randomIndex = ThreadLocalRandom.current().nextInt(0, unvisitedNeighbours.size());
                SuperCell neighbourToLink = unvisitedNeighbours.get(randomIndex);

                if (neighbourToLink != null) {
                    currentCell.link(neighbourToLink, true);

                    /* Make the new SuperCell the current SuperCell. */
                    stack.push(neighbourToLink);
                }
            }

        }

        /* After generating the maze, configure the sub-cells of each SuperCell in it. */
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                SuperCell currentCell = this.maze.getCell(row, column);
                currentCell.configureSubCells();
            }
        }

        return maze;
    }

}
