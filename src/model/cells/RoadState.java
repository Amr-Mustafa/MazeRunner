package model.cells;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class RoadState implements CellState {

    /* The roadPath is the location of the road's image on drive. */
    private String roadPath;
    private Image sprite;

    public RoadState() {
        this.roadPath = "view/road.fw.png";
        this.sprite = new Image(roadPath);
    }

    @Override
    public void draw(GraphicsContext cell, int x, int y) {
        cell.drawImage(sprite, x * 32, y * 32);
    }

    @Override
    public void receivePlayer() {
        System.out.println("You are walking on an empty road!");
    }
}
