package model.cells.walls.states;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.cells.CellState;

public class GrassWallState implements CellState {


    /* The wallPath is the location of the wall's image on drive. */
    private String wallPath;
    private Image sprite;

    public GrassWallState() {
        this.wallPath = "view/grassWall.fw.png";
        this.sprite = new Image(wallPath);
    }

    @Override
    public void draw(GraphicsContext cell, int x, int y) {
        cell.drawImage(sprite, x * 32, y * 32);
    }

    @Override
    public void receivePlayer() {
        System.out.println("You have to cut the grass first!");
    }
}
