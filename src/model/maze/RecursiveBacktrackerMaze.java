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

        /* Choose a random starting cell. */
        Cell startingCell = maze.getRandomCell();

        /* Initialize a Stack to keep track of visited cells. */
        Stack<Cell> stack = new Stack<>();
        stack.push(startingCell);

        /* Once the stack becomes empty, the algorithm finishes. */
        while (!stack.isEmpty()) {

            /* The current cell is always at the top of the stack. */
            Cell currentCell = stack.peek();

            /* Get a list of unvisited neighbours of the current cell. */
            ArrayList<Cell> unvisitedNeighbours = currentCell.getUnvisitedNeighbours();

            /* If we are at a dead end - the current cell has no unvisited neighbours - we backtrack. */
            if (unvisitedNeighbours.isEmpty())
                stack.pop();

                /* Else if there is at least one unvisited neighbour we randomly choose one. */
            else {
                int randomIndex = ThreadLocalRandom.current().nextInt(0, unvisitedNeighbours.size());
                Cell neighbourToLink = unvisitedNeighbours.get(randomIndex);

                if (neighbourToLink != null) {
                    currentCell.link(neighbourToLink, true);

                    /* Make the new cell the current cell. */
                    stack.push(neighbourToLink);
                }
            }

        }

        /* After generating the maze, configure the sub-cells of each cell in it. */
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                Cell currentCell = this.maze.getCell(row, column);
                currentCell.configureSubCells();
            }
        }

        return maze;
    }

}
