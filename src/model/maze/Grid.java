package model.maze;

/**
 * Grid class is essentially a container for Cells.
 */

public class Grid {

    /* The number of rows and columns in this grid. */
    private int rows, columns;

    /* The backend of the Grid is a 2D matrix of Cells. */
    private Cell[][] skeleton;

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
        this.skeleton = new Cell[this.rows][this.columns];

        for (int row = 0; row < this.rows; row++)
            for (int column = 0; column < this.columns; column++)
                this.skeleton[row][column] = new Cell(row, column);
    }

    /**
     * Sets the neighbours of each Cell in the grid.
     */
    private void configureCells () {
        for (int row = 0; row < this.rows; row++)
            for (int column = 0; column < this.columns; column++) {

                Cell currentCell = this.skeleton[row][column];

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
     * Returns the Cell specified by the passed parameters if valid otherwise null.
     * @param row
     * @param column
     * @return Cell
     */
    public Cell getCell (int row, int column) {
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

                /* Get the current cell. */
                Cell cell = this.skeleton[row][column];

                /* Create a dummy cell just in case. */
                if (cell == null) cell = new Cell(-1, -1);

                /* Get the body of the current cell. */
                String body = "   ";

                /* Get the eastern wall of the current cell. */
                String easternWall = cell.areLinked(cell.getEast()) ? " " : "|";

                /* Add the body and the eastern wall to the running string top. */
                top = top + body + easternWall;

                /* Get the southern wall of the current cell. */
                String southWall = cell.areLinked(cell.getSouth()) ? "   " : "---";

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
        System.out.println(new String(new char[2 * this.columns + 1]).replace("\0", "#"));

        /* For each row. */
        for (int row = 0; row < rows; row++) {

            /* The western boundary of the maze is explicitly drawn. */
            String upperSubCells = "#",
                    lowerSubCells = "#";

            /* For each column. */
            for (int column = 0; column < columns; column++) {

                /* Get the current cell. */
                Cell cell = this.skeleton[row][column];

                /* Add the upper and lower sub-cells of the current cell. */
                upperSubCells += cell.getNorthWesternSubCell().getContent() + cell.getNorthEasternSubCell().getContent();
                lowerSubCells += cell.getSouthWesternSubCell().getContent() + cell.getSouthEasternSubCell().getContent();

            }

            System.out.println(upperSubCells);
            System.out.println(lowerSubCells);
        }

    }
}
