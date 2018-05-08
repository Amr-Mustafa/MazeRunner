package model.cells.gifts;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class HealthGift extends Gift {

    /* The amount of health the player receives when he eats the gift. */
    public final static int HEALTH_INCREMENT = 20;

    /* The giftPath is the location of the gift's image on drive. */
    private String giftPath;
    private Image sprite;

    public HealthGift () {
        this.giftPath = "view/foodGift.png";
        this.sprite = new Image(giftPath);
    }


    @Override
    public void draw(GraphicsContext cell, int x, int y) {

    }
}
