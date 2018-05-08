package model.cells.gifts;

import javafx.scene.canvas.GraphicsContext;
import model.cells.Cell;
import model.cells.CellState;

public abstract class Gift implements Cell {

    protected CellState currentState;
    public abstract void draw(GraphicsContext cell, int x, int y);
    public abstract void receivePlayer();

}
