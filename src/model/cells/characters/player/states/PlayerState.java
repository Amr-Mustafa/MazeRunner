package model.cells.characters.player.states;

import javafx.scene.canvas.GraphicsContext;
import model.cells.CellState;
import model.maze.Maze;

public abstract class PlayerState implements CellState {

    /* Both the actions of drawing the player and receiving hits depends on the player state. */
    public abstract void hit();
    public abstract void move(int x, int y, Maze maze);
}
