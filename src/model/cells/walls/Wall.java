package model.cells.walls;

import javafx.scene.canvas.GraphicsContext;
import model.cells.Cell;

public abstract class Wall implements Cell {

    public abstract void draw(GraphicsContext cell, int x, int y);
    public abstract void receivePlayer();

}
