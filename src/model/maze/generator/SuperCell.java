package model.maze.generator;

import java.util.ArrayList;

public class SuperCell {

    /* A SuperCell has four neighbours. */
    public final static int NUM_NEIGHBOURS = 4;

    /* Each SuperCell must know its position in the grid. */
    private int row, column;

    /* Each SuperCell is divided into four subcells. */
    private SubCell northWesternSubCell;
    private SubCell northEasternSubCell;
    private SubCell southWesternSubCell;
    private SubCell southEasternSubCell;

    /* Keep track of the SuperCell's neighbours. */
    private SuperCell north, east, south, west;

    /* Keep track of the neighbouring cells that have a passage to the SuperCell. */
    private ArrayList<SuperCell> links;

    public SuperCell (int row, int column) {
        this.row = row;
        this.column = column;
        this.links = new ArrayList<>();
    }

    /**
     * Links this SuperCell with a given SuperCell bidirectionally.
     * @param SuperCell
     * @param bidirectional
     */
    public void link (SuperCell SuperCell, boolean bidirectional) {

        /* Links this SuperCell with the given SuperCell. */
        this.links.add(SuperCell);

        /* Links the given SuperCell with this SuperCell.*/
        if (bidirectional) SuperCell.link(this, false);
    }

    /**
     * Unlinks this SuperCell and a given SuperCell bidirectionally.
     * @param SuperCell
     * @param bidirectional
     */
    public void unlink (SuperCell SuperCell, boolean bidirectional) {

        /* Unlinks this SuperCell and the given SuperCell. */
        this.links.remove(SuperCell);

        /* Unlinks the given SuperCell and this SuperCell.*/
        if (bidirectional) SuperCell.unlink(this, false);
    }

    /**
     * Returns the cells linked with this SuperCell.
     * @return ArrayList<SuperCell>
     */
    public ArrayList<SuperCell> getLinks () {
        return this.links;
    }

    /**
     * Checks whether a given SuperCell is linked with this SuperCell.
     * @param SuperCell
     * @return boolean
     */
    public boolean areLinked (SuperCell SuperCell) {
        return this.links.contains(SuperCell);
    }

    /**
     * Returns the northern neighbour of this SuperCell if exists otherwise null.
     * @return SuperCell
     */
    public SuperCell getNorth () {
        return this.north;
    }

    /**
     * Returns the eastern neighbour of this SuperCell if exists otherwise null.
     * @return SuperCell
     */
    public SuperCell getEast () {
        return this.east;
    }

    /**
     * Returns the southern neighbour of this SuperCell if exists otherwise null.
     * @return SuperCell
     */
    public SuperCell getSouth () {
        return this.south;
    }

    /**
     * Returns the western neighbour of this SuperCell if exists otherwise null.
     * @return SuperCell
     */
    public SuperCell getWest () {
        return this.west;
    }

    /**
     * Sets the northern neighbour of this SuperCell.
     */
    public void setNorth (SuperCell northernCell) {
        this.north = northernCell;
    }

    /**
     * Sets the eastern neighbour of this SuperCell.
     */
    public void setEast (SuperCell easternCell) {
        this.east = easternCell;
    }

    /**
     * Sets the southern neighbour of this SuperCell.
     */
    public void setSouth (SuperCell souternCell) {
        this.south = souternCell;
    }

    /**
     * Sets the western neighbour of this SuperCell.
     */
    public void setWest (SuperCell westernCell) {
        this.west = westernCell;
    }

    /**
     * Sets the sub-cells of the SuperCell based on the SuperCell's links with its neighbours.
     */
    public void configureSubCells () {

        /* The northWesternSubCell is always a passage. */
        this.northWesternSubCell = new SubCell("g");

        /* The southEasternSubCell is always a passage. */
        this.southEasternSubCell = new SubCell("b");

        /* If the SuperCell is linked to its southern neighbour, then make the southWesternSubCell a
           passage, otherwise make it a wall. */
        if (this.areLinked(this.south)) {
            this.southWesternSubCell = new SubCell("g");
        } else this.southWesternSubCell = new SubCell("b");

        /* If the SuperCell is linked to its eastern neighbour, then make the northEasternSubCell a
           passage, otherwise make it a wall. */
        if (this.areLinked(this.east)) {
            this.northEasternSubCell = new SubCell("g");
        } else this.northEasternSubCell = new SubCell("b");

    }

    /**
     * Getter for the north western sub-SuperCell.
     * @return SubCell
     */
    public SubCell getNorthWesternSubCell() {
        return northWesternSubCell;
    }

    /**
     * Getter for the north eastern sub-SuperCell.
     * @return SubCell
     */
    public SubCell getNorthEasternSubCell() {
        return northEasternSubCell;
    }

    /**
     * Getter for the south western sub-SuperCell.
     * @return SubCell
     */
    public SubCell getSouthWesternSubCell() {
        return southWesternSubCell;
    }

    /**
     * Getter for the south eastern sub-SuperCell.
     * @return SubCell
     */
    public SubCell getSouthEasternSubCell() {
        return southEasternSubCell;
    }

    public ArrayList<SuperCell> getUnvisitedNeighbours() {

        ArrayList<SuperCell> unvisitedNeighbours = new ArrayList<>();

        /* We need to get each neighbouring SuperCell and check whether it is linked with this SuperCell or not. */
        if (this.north != null && !this.links.contains(this.north)) unvisitedNeighbours.add(this.north);
        if (this.east != null && !this.links.contains(this.east)) unvisitedNeighbours.add(this.east);
        if (this.south != null && !this.links.contains(this.south)) unvisitedNeighbours.add(this.south);
        if (this.west != null && !this.links.contains(this.west)) unvisitedNeighbours.add(this.west);

        return unvisitedNeighbours;
    }
}
