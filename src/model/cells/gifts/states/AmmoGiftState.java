package model.cells.gifts.states;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.cells.CellState;

public class AmmoGiftState implements CellState {


    /* The giftPath is the location of the gift's image on drive. */
    private String giftPath;
    private Image sprite;

    public AmmoGiftState() {
        this.giftPath = "view/Arrows.png";
        this.sprite = new Image(giftPath);
    }

    @Override
    public void draw(GraphicsContext cell, int x, int y) {
        cell.drawImage(sprite, x * 32, y * 32);
    }

    @Override
    public void receivePlayer() {
        System.out.println("You gained 6 extra arrows!");

    }


}
