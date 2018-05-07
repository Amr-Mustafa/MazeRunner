package controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.maze.MazeLoader;
import model.cells.characters.player.Player;

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
    int freezeState = 0;
    int freezed = 0;
    char direction ='R';
    char clickedButton ;
    public void keyPress(KeyEvent keyEvent) {

        player = Player.getPlayer();
        mazeLoader = MazeLoader.getMazeLoader();

                if(keyEvent.getCode()==KeyCode.W){
                    if(freezed!=0)
                    {
                        freezed--;
                    }
                    else if(mazeLoader.mazeMatrix[player.getTileX()][player.getTileY()-1] != 'b') {
                        mazeLoader.mazeMatrix[player.getTileX()][player.getTileY()] = 'g';
                        player.move(0, -1);
                        clickedButton = 'w';
                    }
                }

                if(keyEvent.getCode()==KeyCode.S){
                    if(freezed!=0)
                    {
                        freezed--;
                    }
                    else if(mazeLoader.mazeMatrix[player.getTileX()][player.getTileY()+1] != 'b') {
                        mazeLoader.mazeMatrix[player.getTileX()][player.getTileY()] = 'g';
                        player.move(0,1);
                        clickedButton = 's';
                    }
                }

                if(keyEvent.getCode()==KeyCode.A){
                    if(freezed!=0)
                    {
                        freezed--;
                    }
                    else if(mazeLoader.mazeMatrix[player.getTileX()-1][player.getTileY()] != 'b') {
                        mazeLoader.mazeMatrix[player.getTileX()][player.getTileY()] = 'g';
                        player.move(-1,0);
                        direction = 'L';
                        clickedButton = 'a';
                    }
                }


                if(keyEvent.getCode()==KeyCode.D){
                    if(freezed!=0)
                    {
                        freezed--;
                    }
                    else if(mazeLoader.mazeMatrix[player.getTileX()+1][player.getTileY()] != 'b') {
                        mazeLoader.mazeMatrix[player.getTileX()][player.getTileY()] = 'g';
                        player.move(1,0);
                        direction = 'R';
                        clickedButton = 'd';}
                }


//        mazeLoader.drawMaze();
        if(mazeLoader.mazeMatrix[player.getTileX()][player.getTileY()] == 'a')
        {
            checkState = 1;
            //mazeLoader.mazeMatrix[player.getTileX()][player.getTileY()] = 'g';
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
        if(mazeLoader.mazeMatrix[player.getTileX()][player.getTileY()] == 'f')
        {
            freezeState = 1;
            freezed = 5 ;
        }
        if(freezed ==0)
        {
            freezeState = 0;
        }

        player.PlayerPhase(checkState,freezeState,direction);
        mazeLoader.moveInMaze(player.getTileX(),player.getTileY());
        mazeLoader.mazeMatrix[player.getTileX()][player.getTileY()] = 'p';
        mazeLoader.drawMaze();

    }
}
