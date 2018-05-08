package model.cells.gifts;

import javafx.scene.canvas.GraphicsContext;
import model.cells.Cell;

public abstract class Gift implements Cell {

    public abstract void draw(GraphicsContext cell, int x, int y);

}
