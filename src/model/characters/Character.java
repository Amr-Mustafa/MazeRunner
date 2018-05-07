package model.characters;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Character {

    int health;
    String characterPath;
    Image sprite;

    abstract void move(int x,int y);
    abstract void draw(GraphicsContext cell, int x, int y);

}
