package model.cells.characters.player.states;

import javafx.scene.canvas.GraphicsContext;
import model.cells.CellState;

public abstract class PlayerState implements CellState {

    /* Both the actions of drawing the player and receiving hits depends on the player state. */
    abstract void hit();
}
