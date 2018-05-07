package controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import model.MazeLoader;
import model.characters.Player;

public class GameScene {

    @FXML
    private Canvas CanvasMaze;

    private MazeLoader mazeLoader;
    private Player player;

    public void initialize(){
        mazeLoader = MazeLoader.getMazeLoader();
        mazeLoader.setCanvas(CanvasMaze);
        mazeLoader.drawMaze();
        CanvasMaze.setFocusTraversable(true);

    }

    private void run() {
        while(true) {
            /* 1. Get user input. */

            /* 2. Update game state. */

            /* 3. Render game state. */
        }
    }
    int checkState = 0 ;
    char direction ='R';
    public void keyPress(KeyEvent keyEvent) {

        player = Player.getPlayer();
        mazeLoader = MazeLoader.getMazeLoader();

                if(keyEvent.getCode()==KeyCode.W){
                    if(mazeLoader.mazeMatrix[player.getTileX()][player.getTileY()-1] != 'b') {
                        player.move(0, -1);
                    }
                }

                if(keyEvent.getCode()==KeyCode.S){
                    if(mazeLoader.mazeMatrix[player.getTileX()][player.getTileY()+1] != 'b') {
                        player.move(0,1);
                        System.out.println("up");
                    }
                }

                if(keyEvent.getCode()==KeyCode.A){
                    if(mazeLoader.mazeMatrix[player.getTileX()-1][player.getTileY()] != 'b') {
                        player.move(-1,0);
                        direction = 'L';
                    }
                }


                if(keyEvent.getCode()==KeyCode.D){
                    if(mazeLoader.mazeMatrix[player.getTileX()+1][player.getTileY()] != 'b') {
                        player.move(1,0);
                        direction = 'R';                    }
                }

        mazeLoader.drawMaze();
        if(mazeLoader.mazeMatrix[player.getTileX()][player.getTileY()] == 'a')
        {
            checkState = 1;
            mazeLoader.mazeMatrix[player.getTileX()][player.getTileY()] = 'g';
        }
        if(mazeLoader.mazeMatrix[player.getTileX()][player.getTileY()] == 'd')
        {
            if(checkState == 1)
                checkState =0;
            else if(checkState ==0)
                checkState =2;
            mazeLoader.mazeMatrix[player.getTileX()+1][player.getTileY()+1] = 'g';
            mazeLoader.mazeMatrix[player.getTileX()+1][player.getTileY()] = 'g';
            mazeLoader.mazeMatrix[player.getTileX()][player.getTileY()+1] = 'g';
            mazeLoader.mazeMatrix[player.getTileX()-1][player.getTileY()-1] = 'g';
            mazeLoader.mazeMatrix[player.getTileX()-1][player.getTileY()] = 'g';
            mazeLoader.mazeMatrix[player.getTileX()][player.getTileY()-1] = 'g';
            mazeLoader.mazeMatrix[player.getTileX()+1][player.getTileY()-1] = 'g';
            mazeLoader.mazeMatrix[player.getTileX()-1][player.getTileY()+1] = 'g';
            mazeLoader.drawMaze();
            mazeLoader.mazeMatrix[player.getTileX()][player.getTileY()] = 'g';
        }
        player.PlayerPhase(checkState,direction);
        mazeLoader.moveInMaze(player.getTileX(),player.getTileY());


    }
}