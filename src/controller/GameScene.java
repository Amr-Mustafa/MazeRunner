package controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import model.MazeLoader;
import model.characters.Player;

public class GameScene {

    @FXML
    private Canvas CanvasMaze;

    private MazeLoader mazeLoader;

    public void initialize(){
        mazeLoader = MazeLoader.getMazeLoader();
        mazeLoader.setCanvas(CanvasMaze);
        mazeLoader.drawMaze();
    }

    private void run() {
        while(true) {
            /* 1. Get user input. */

            /* 2. Update game state. */

            /* 3. Render game state. */
        }
    }
}
