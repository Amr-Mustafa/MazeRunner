package model.cells.characters.player.states;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.cells.CellState;

public class DeadState extends PlayerState implements CellState {

    /* The characterPath is the location of the character image on drive. */
    private String characterPath;

    /* The sprite holds the character image after loading. */
    private Image sprite;

    public DeadState() {

        /* Initialize instance variables. */
        this.characterPath = "view/tomb.PNG";
        this.sprite = new Image(characterPath);
    }

    @Override
    public void draw(GraphicsContext cell, int x, int y) {
        cell.drawImage(sprite, x * 32, y * 32);
    }

    @Override
    void hit() {

    }
}
