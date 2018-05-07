package model.maze;

import model.cells.characters.Cell;
import model.maze.generator.BinaryTreeMaze;
import model.maze.generator.Grid;

public class Maze {

    private Cell[][] maze;

    public Maze(int rows, int columns) {
        Grid grid = new BinaryTreeMaze().generateMaze((rows - 1) / 2, (columns - 1) / 2);
        maze = grid.toCellMatrix(grid.toCharMatrix());
    }

    public Cell[][] getMaze() {
        return this.maze;
    }

}
