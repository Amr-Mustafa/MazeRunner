package model.maze;

import model.maze.Cell;
import model.maze.Grid;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class BinaryTreeMaze {

    private Grid maze;

    /**
     * Generates a maze using Binary Tree algorithm with the given number of rows and columns.
     * @param rows
     * @param columns
     * @return
     */
    public Grid generateMaze (int rows, int columns) {

        this.maze = new Grid(rows, columns);

        for (int row = 0; row < rows; row++)
            for (int column = 0; column < columns; column++) {

                Cell currentCell = this.maze.getCell(row, column);

                /* Get the northern and eastern neighbours of the current cell if exists. */
                ArrayList<Cell> neighbours = new ArrayList<>();
                Cell northernNeighbour = currentCell.getNorth();
                Cell easternNeighbour = currentCell.getEast();

                if (northernNeighbour != null) neighbours.add(northernNeighbour);
                if (easternNeighbour != null) neighbours.add(easternNeighbour);

                /* Randomly decide whether to carve a passage north or east. */
                int randomIndex = 0;
                Cell neighbourToLink = null;
                if (neighbours.size() > 0) {
                    randomIndex = ThreadLocalRandom.current().nextInt(0, neighbours.size());
                    neighbourToLink = neighbours.get(randomIndex);
                }

                /* Link the cells. */
                if (neighbourToLink != null) { // Take into consideration the northeast cell.
                    this.maze.getCell(row, column).link(neighbourToLink, true);

                }
            }

        /* After generating the maze, configure the sub-cells of each cell in it. */
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                Cell currentCell = this.maze.getCell(row, column);
                currentCell.configureSubCells();
            }
        }

        return this.maze;
    }

}
