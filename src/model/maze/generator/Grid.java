package model.maze.generator;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import controller.GameScene;
import model.cells.Cell;
import model.cells.RoadCell;
import model.cells.characters.player.Player;
import model.cells.gifts.GiftFactory;
import model.cells.walls.Wall;
import model.cells.walls.WallFactory;

/**
 * Grid class is essentially a container for Cells.
 */

public class Grid {

    /* The number of rows and columns in this grid. */
    private int rows, columns;

    /* The backend of the Grid is a 2D matrix of Cells. */
    private SuperCell[][] skeleton;

    public Grid (int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.initializeSkeleton();
        this.configureCells();
    }

    /**
     * Fills the skeleton of the grid with Cells.
     */
    private void initializeSkeleton () {
        this.skeleton = new SuperCell[this.rows][this.columns];

        for (int row = 0; row < this.rows; row++)
            for (int column = 0; column < this.columns; column++)
                this.skeleton[row][column] = new SuperCell(row, column);
    }

    /**
     * Sets the neighbours of each SuperCell in the grid.
     */
    private void configureCells () {
        for (int row = 0; row < this.rows; row++)
            for (int column = 0; column < this.columns; column++) {

                SuperCell currentCell = this.skeleton[row][column];

                if (row > 0) currentCell.setNorth(this.skeleton[row - 1][column]);
                else currentCell.setNorth(null);

                if (row < this.rows - 1) currentCell.setSouth(this.skeleton[row + 1][column]);
                else currentCell.setSouth(null);

                if (column < this.columns - 1) currentCell.setEast(this.skeleton[row][column + 1]);
                else currentCell.setEast(null);

                if (column > 0) currentCell.setWest(this.skeleton[row][column - 1]);
                else currentCell.setWest(null);
            }
    }

    /**
     * Returns the SuperCell specified by the passed parameters if valid otherwise null.
     * @param row
     * @param column
     * @return SuperCell
     */
    public SuperCell getCell (int row, int column) {
        if (row < 0 || row > this.rows || column < 0 || column > this.columns) return null;
        return this.skeleton[row][column];
    }

    /**
     * Converts the grid into a string representation to be printed on terminal.
     * @return String
     */
    @Override
    public String toString () {

        /* The output string is initialized with the northern wall of the grid. */
        String output = "+"
                + new String(new char[this.columns]).replace("\0", "---+")
                + "\n";

        /* For each row. */
        for (int row = 0; row < this.rows; row++) {

            /* The top string accumulates eastern walls and cells' body. */
            String top = "|";

            /* The bottom string accumulate southern walls. */
            String bottom = "+";

            /* For each column. */
            for (int column = 0; column < this.columns; column++) {

                /* Get the current SuperCell. */
                SuperCell SuperCell = this.skeleton[row][column];

                /* Create a dummy SuperCell just in case. */
                if (SuperCell == null) SuperCell = new SuperCell(-1, -1);

                /* Get the body of the current SuperCell. */
                String body = "   ";

                /* Get the eastern wall of the current SuperCell. */
                String easternWall = SuperCell.areLinked(SuperCell.getEast()) ? " " : "|";

                /* Add the body and the eastern wall to the running string top. */
                top = top + body + easternWall;

                /* Get the southern wall of the current SuperCell. */
                String southWall = SuperCell.areLinked(SuperCell.getSouth()) ? "   " : "---";

                /* Add the southern wall and a corner to the running string bottom. */
                bottom = bottom + southWall + "+";
            }

            /* For each row add its string to the running output string. */
            output += top + "\n" + bottom + "\n";
        }

        return output;

    }

    /**
     * Getter for the number of rows of the grid.
     * @return int
     */
    public int getRows() {
        return rows;
    }

    /**
     * Getther for the number of columns of the grid.
     * @return int
     */
    public int getColumns() {
        return columns;
    }

    public void drawMaze() {

        /* The northern boundary of the maze is explicitly drawn. */
        System.out.println(new String(new char[2 * this.columns + 1]).replace("\0", "b"));

        /* For each row. */
        for (int row = 0; row < rows; row++) {

            /* The western boundary of the maze is explicitly drawn. */
            String upperSubCells = "b",
                    lowerSubCells = "b";

            /* For each column. */
            for (int column = 0; column < columns; column++) {

                /* Get the current SuperCell. */
                SuperCell SuperCell = this.skeleton[row][column];

                /* Add the upper and lower sub-cells of the current SuperCell. */
                upperSubCells += SuperCell.getNorthWesternSubCell().getContent() + SuperCell.getNorthEasternSubCell().getContent();
                lowerSubCells += SuperCell.getSouthWesternSubCell().getContent() + SuperCell.getSouthEasternSubCell().getContent();

            }

            System.out.println(upperSubCells);
            System.out.println(lowerSubCells);
        }

    }

    /**
     * Returns a random SuperCell from the grid.
     * @return SuperCell
     */
    public SuperCell getRandomCell () {
        int randomRow = ThreadLocalRandom.current().nextInt(0, this.rows);
        int randomColumn = ThreadLocalRandom.current().nextInt(0, this.columns);
        return this.skeleton[randomColumn][randomColumn];
    }

    /**
     *
     * @returns a 2D matrix of characters to be drawn.
     */
    public char[][] toCharMatrix () {

        char[][] matrix = new char[2 * this.rows + 1][2 * this.columns + 1];

        /* The northern boundary of the maze is explicitly drawn. */
        String maze = new String(new char[2 * this.columns + 1]).replace("\0", "w");

        /* For each row. */
        for (int row = 0; row < rows; row++) {

            /* The western boundary of the maze is explicitly drawn. */
            String upperSubCells = "w",
                    lowerSubCells = "w";

            /* For each column. */
            for (int column = 0; column < columns; column++) {

                /* Get the current SuperCell. */
                SuperCell SuperCell = this.skeleton[row][column];

                /* Add the upper and lower sub-cells of the current SuperCell. */
                upperSubCells += SuperCell.getNorthWesternSubCell().getContent() + SuperCell.getNorthEasternSubCell().getContent();
                lowerSubCells += SuperCell.getSouthWesternSubCell().getContent() + SuperCell.getSouthEasternSubCell().getContent();

            }

            maze += upperSubCells;
            maze += lowerSubCells;

        }

        /* Fill in the character matrix from the string. */
        int stringCols = 0;
        for (int row = 0; row < 2 * this.rows + 1; row++) {
            for (int column = 0; column < 2 * this.columns + 1; column++) {
                matrix[row][column] = maze.toCharArray()[stringCols++];
            }
        }

        /* Add the player initial position. */
        matrix[1][1] = 'p';

        /* Randomize bombs. */
        int bombs = GameScene.BOMBS;
        while (bombs > 0) {

            /* Get some random row and column. */
            int row = ThreadLocalRandom.current().nextInt(2, 2 * this.rows + 1);
            int column = ThreadLocalRandom.current().nextInt(2, 2 * this.columns + 1);

            /* Make sure that random cell is empty (i.e. a road). */
            if (matrix[row][column] == 'r') {

                /* Randomly choose whether to put a freeze bomb or a fire bomb. */
                int bombType = ThreadLocalRandom.current().nextInt(0, 2);
                matrix[row][column] = bombType == 0 ? 'f' : 'b';

                bombs--;
            }
        }

        /* Randomize grass walls. */
        int grassWalls = GameScene.GRASS_WALLS;
        while (grassWalls > 0) {

            /* Get some random row and column. */
            int row = ThreadLocalRandom.current().nextInt(1, 2 * this.rows);
            int column = ThreadLocalRandom.current().nextInt(1, 2 * this.columns);

            /* Make sure that random cell is a wall. */
            if (matrix[row][column] == 'w') {
                matrix[row][column] = 'l';
                grassWalls--;
            }
        }

        /* Randomize gifts. */
        int gifts = GameScene.GIFTS;
        int giftType = 0;
        while (gifts > 0) {

            /* Get some random row and column. */
            int row = ThreadLocalRandom.current().nextInt(1, 2 * this.rows);
            int column = ThreadLocalRandom.current().nextInt(1, 2 * this.columns);

            /* Make sure that random cell is empty (i.e. a road). */
            if (matrix[row][column] == 'r') {

                if (giftType == 0) matrix[row][column] = 'a';
                else if (giftType == 1) matrix[row][column] = 'h';
                else matrix[row][column] = 't';

                gifts--;
                giftType++;
            }
        }

        /* Randomize weapon location. */
        int weapon = 1;
        while (weapon > 0) {

            /* Get some random row and column. */
            int row = ThreadLocalRandom.current().nextInt(1, 2 * this.rows);
            int column = ThreadLocalRandom.current().nextInt(1, 2 * this.columns);

            /* Make sure that random cell is empty (i.e. a road). */
            if (matrix[row][column] == 'r') {

                matrix[row][column] = 'm';
                weapon--;
            }
        }

        return matrix;
    }

    public Cell[][] toCellMatrix (char[][] charMatrix) {

        /* A 2D matrix of Cells. */
        Cell[][] cellMatrix = new Cell[2 * this.rows + 1][2 * this.columns + 1];

        /* We want to convert the matrix of chars to a matrix of Cells. */
        for (int row = 0; row < 2 * this.rows + 1; row++) {
            for (int column = 0; column < 2 * this.columns + 1; column++) {

                /* If the character cell represent the player. */
                if (charMatrix[row][column] == 'p')
                    cellMatrix[row][column] = Player.getPlayer();

                /* If the character cell represents a bomb. */
                //else if (charMatrix[row][column] == 'b' || charMatrix[row][column] == 'f')
                //    cellMatrix[row][column] = new BombFactory().getBomb(charMatrix[row][column]);

                /* If the character cell represents a wall. */
                else if (charMatrix[row][column] == 'w' || charMatrix[row][column] == 'l')
                    cellMatrix[row][column] = new WallFactory().getWall(charMatrix[row][column]);

                /* If the character cell represents a gift. */
                else if (charMatrix[row][column] == 'a' || charMatrix[row][column] == 'h' || charMatrix[row][column] == 't')
                    cellMatrix[row][column] = new GiftFactory().getGift(charMatrix[row][column]);

                /* If the character cell represents a road. */
                else if (charMatrix[row][column] == 'r')
                    cellMatrix[row][column] = new RoadCell();

                /* If the character cell represents a weapon. */
                else if (charMatrix[row][column] == 'm')
                    cellMatrix[row][column] = new RoadCell();

                /* Else the character cell represents a gate. */
                else
                    cellMatrix[row][column] = new RoadCell();
            }
        }

        return cellMatrix;
    }
}