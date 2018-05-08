package model.cells.gifts;

import javafx.scene.canvas.GraphicsContext;
import model.cells.RoadState;
import model.cells.gifts.states.AmmoGiftState;
import model.cells.gifts.states.ArmorGiftState;

public class ArmorGift extends Gift {

    public ArmorGift() {
        this.currentState = new ArmorGiftState();
    }

    @Override
    public void draw(GraphicsContext cell, int x, int y) {
        this.currentState.draw(cell, x, y);
    }

    @Override
    public void receivePlayer() {
        this.currentState.receivePlayer();
        this.currentState = new RoadState();
    }
}
