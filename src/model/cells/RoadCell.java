package model.cells;

import javafx.scene.canvas.GraphicsContext;

public class RoadCell implements Cell {

    CellState currentState;

    public RoadCell() {
        this.currentState = new RoadState();
    }

    @Override
    public void draw(GraphicsContext cell, int x, int y) {
        this.currentState.draw(cell, x, y);
    }

    @Override
    public void receivePlayer() {
        this.currentState.receivePlayer();
    }
}
