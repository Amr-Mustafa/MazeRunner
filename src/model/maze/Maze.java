package model.maze;

import model.cells.Cell;
import model.maze.generator.BinaryTreeMaze;
import model.maze.generator.Grid;

public class Maze {

    private Cell[][] maze;
    private Grid grid;

    public Maze (int rows, int columns) {
        grid = new BinaryTreeMaze().generateMaze((rows - 1) / 2, (columns - 1) / 2);
        maze = grid.toCellMatrix(grid.toCharMatrix());
    }

    public Cell[][] getMaze() {
        return this.maze;
    }

    public char[][] getCharMaze() { return grid.toCharMatrix(); }

}
