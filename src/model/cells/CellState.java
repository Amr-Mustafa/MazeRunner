package model.cells;

import javafx.scene.canvas.GraphicsContext;

public interface CellState {

    void draw(GraphicsContext cell, int x, int y);

}
