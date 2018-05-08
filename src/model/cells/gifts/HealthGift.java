package model.cells.gifts;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.cells.characters.player.Player;
import model.cells.gifts.states.HealthGiftState;

public class HealthGift extends Gift {

    /* The amount of health the player receives when he eats the gift. */
    public final static int HEALTH_INCREMENT = 20;

    public HealthGift() {
        this.currentState = new HealthGiftState();
    }

    @Override
    public void draw(GraphicsContext cell, int x, int y) {
        this.currentState.draw(cell, x, y);
    }

    @Override
    public void receivePlayer() {
        this.currentState.receivePlayer();
    }
}
