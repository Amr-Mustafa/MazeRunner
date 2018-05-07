package model.cells.characters;

import javafx.scene.image.Image;

public abstract class Character implements Cell {

    protected int health;
    protected String characterPath;
    protected Image sprite;

    protected abstract void move(int x, int y);
}
