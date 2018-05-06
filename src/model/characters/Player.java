package model.characters;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.MazeLoader;

public class Player extends Character {

    private static final Player playerInstance = new Player();

    private Player() {
        this.characterPath = "view/hero.PNG";
        this.sprite = new Image(characterPath);
    }

    public static Player getPlayer() {
        return playerInstance;
    }

    public void move() {

    }

    public void draw(GraphicsContext cell, int x, int y) {
        cell.drawImage(sprite, x * 32, y * 32);
    }

}
