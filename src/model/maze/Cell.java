package model.maze;

import java.util.ArrayList;

public class Cell {

    /* A cell has four neighbours. */
    public final static int NUM_NEIGHBOURS = 4;

    /* Each cell must know its position in the grid. */
    private int row, column;

    /* Each cell is divided into four subcells. */
    private SubCell northWesternSubCell;
    private SubCell northEasternSubCell;
    private SubCell southWesternSubCell;
    private SubCell southEasternSubCell;

    /* Keep track of the cell's neighbours. */
    private Cell north, east, south, west;

    /* Keep track of the neighbouring cells that have a passage to the cell. */
    private ArrayList<Cell> links;

    public Cell (int row, int column) {
        this.row = row;
        this.column = column;
        this.links = new ArrayList<>();
    }

    /**
     * Links this cell with a given cell bidirectionally.
     * @param cell
     * @param bidirectional
     */
    public void link (Cell cell, boolean bidirectional) {

        /* Links this cell with the given cell. */
        this.links.add(cell);

        /* Links the given cell with this cell.*/
        if (bidirectional) cell.link(this, false);
    }

    /**
     * Unlinks this cell and a given cell bidirectionally.
     * @param cell
     * @param bidirectional
     */
    public void unlink (Cell cell, boolean bidirectional) {

        /* Unlinks this cell and the given cell. */
        this.links.remove(cell);

        /* Unlinks the given cell and this cell.*/
        if (bidirectional) cell.unlink(this, false);
    }

    /**
     * Returns the cells linked with this cell.
     * @return ArrayList<Cell>
     */
    public ArrayList<Cell> getLinks () {
        return this.links;
    }

    /**
     * Checks whether a given cell is linked with this cell.
     * @param cell
     * @return boolean
     */
    public boolean areLinked (Cell cell) {
        return this.links.contains(cell);
    }

    /**
     * Returns the northern neighbour of this cell if exists otherwise null.
     * @return Cell
     */
    public Cell getNorth () {
        return this.north;
    }

    /**
     * Returns the eastern neighbour of this cell if exists otherwise null.
     * @return Cell
     */
    public Cell getEast () {
        return this.east;
    }

    /**
     * Returns the southern neighbour of this cell if exists otherwise null.
     * @return Cell
     */
    public Cell getSouth () {
        return this.south;
    }

    /**
     * Returns the western neighbour of this cell if exists otherwise null.
     * @return Cell
     */
    public Cell getWest () {
        return this.west;
    }

    /**
     * Sets the northern neighbour of this cell.
     */
    public void setNorth (Cell northernCell) {
        this.north = northernCell;
    }

    /**
     * Sets the eastern neighbour of this cell.
     */
    public void setEast (Cell easternCell) {
        this.east = easternCell;
    }

    /**
     * Sets the southern neighbour of this cell.
     */
    public void setSouth (Cell souternCell) {
        this.south = souternCell;
    }

    /**
     * Sets the western neighbour of this cell.
     */
    public void setWest (Cell westernCell) {
        this.west = westernCell;
    }

    /**
     * Sets the sub-cells of the cell based on the cell's links with its neighbours.
     */
    public void configureSubCells () {

        /* The northWesternSubCell is always a passage. */
        this.northWesternSubCell = new SubCell("g");

        /* The southEasternSubCell is always a passage. */
        this.southEasternSubCell = new SubCell("b");

        /* If the cell is linked to its southern neighbour, then make the southWesternSubCell a
           passage, otherwise make it a wall. */
        if (this.areLinked(this.south)) {
            this.southWesternSubCell = new SubCell("g");
        } else this.southWesternSubCell = new SubCell("b");

        /* If the cell is linked to its eastern neighbour, then make the northEasternSubCell a
           passage, otherwise make it a wall. */
        if (this.areLinked(this.east)) {
            this.northEasternSubCell = new SubCell("g");
        } else this.northEasternSubCell = new SubCell("b");

    }

    /**
     * Getter for the north western sub-cell.
     * @return SubCell
     */
    public SubCell getNorthWesternSubCell() {
        return northWesternSubCell;
    }

    /**
     * Getter for the north eastern sub-cell.
     * @return SubCell
     */
    public SubCell getNorthEasternSubCell() {
        return northEasternSubCell;
    }

    /**
     * Getter for the south western sub-cell.
     * @return SubCell
     */
    public SubCell getSouthWesternSubCell() {
        return southWesternSubCell;
    }

    /**
     * Getter for the south eastern sub-cell.
     * @return SubCell
     */
    public SubCell getSouthEasternSubCell() {
        return southEasternSubCell;
    }

    public ArrayList<Cell> getUnvisitedNeighbours() {

        ArrayList<Cell> unvisitedNeighbours = new ArrayList<>();

        /* We need to get each neighbouring cell and check whether it is linked with this cell or not. */
        if (this.north != null && !this.links.contains(this.north)) unvisitedNeighbours.add(this.north);
        if (this.east != null && !this.links.contains(this.east)) unvisitedNeighbours.add(this.east);
        if (this.south != null && !this.links.contains(this.south)) unvisitedNeighbours.add(this.south);
        if (this.west != null && !this.links.contains(this.west)) unvisitedNeighbours.add(this.west);

        return unvisitedNeighbours;
    }
}
