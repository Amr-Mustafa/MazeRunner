package model.maze;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import model.cells.Cell;
import model.maze.generator.BinaryTreeMaze;
import model.maze.generator.Grid;

public class Maze {

    private Cell[][] maze;
    private Grid grid;
    private int rows, columns;
    public Canvas canvas;

    public Maze (int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        grid = new BinaryTreeMaze().generateMaze((rows - 1) / 2, (columns - 1) / 2);
        maze = grid.toCellMatrix(grid.toCharMatrix());
    }

    public Cell[][] getMaze() {
        return this.maze;
    }

    public char[][] getCharMaze() { return grid.toCharMatrix(); }

    public void drawMaze(Canvas canvas) {

        this.canvas = canvas;
        GraphicsContext cell = canvas.getGraphicsContext2D();

        for (int row = 0; row < 21; row++) {
            for (int column = 0; column < 21; column++) {
                maze[row][column].draw(cell, row, column);
            }
        }
    }

}
