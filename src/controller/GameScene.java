package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.maze.Maze;
import model.maze.MazeLoader;
import model.cells.characters.player.Player;

import java.net.URL;
import java.util.ResourceBundle;

public class GameScene implements Initializable
{

    public Label HealthLBL;
    public Label ScoreLBL;
    public Label TimeLBL;
    public Label AmmoLBL;

    public Button SaveBTN;
    public Button PauseBTN;
    @FXML
    private Canvas CanvasMaze;

    public final static int BOMBS = 5;
    public final static int GRASS_WALLS = 15;
    public final static int GIFTS = 3;
    private final static int ROWS = 21;
    private final static int COLUMNS = 21;

    private MazeLoader mazeLoader;
    private Player player;
    private Maze maze;

    private boolean pause = false;

    Image PlayImage = new Image(getClass().getResourceAsStream("../view/UIKit/PlayIcon.png"));
    Image PauseImage = new Image(getClass().getResourceAsStream("../view/UIKit/PauseIcon.png"));

    int checkState = 0 ;
    int freezeState = 0;
    int freezed = 0;
    char direction ='R';
    char clickedButton ;

    public void keyPress(KeyEvent keyEvent) {

        /* If the player wants to move upwards. */
        if (keyEvent.getCode() == KeyCode.W) {
            player.move(0, -1, maze);
        }

        /* If the player wants to move downwards. */
        if(keyEvent.getCode() == KeyCode.S){
            player.move(0, 1, maze);
        }

        /* If the player wants to move leftwards. */
        if(keyEvent.getCode()==KeyCode.A) {
            player.move(-1, 0, maze);
        }

        /* If the player wants to move rightwards. */
        if(keyEvent.getCode()==KeyCode.D){
            player.move(1, 0, maze);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        /* Generate a new maze with the given dimensions. */
        maze = new Maze(ROWS, COLUMNS);

        /* Draw the initial state of the maze. */
        maze.drawMaze(CanvasMaze);

        /* Get a reference to the player singleton. */
        player = Player.getPlayer();

        /* Set focus on the canvas. */
        CanvasMaze.setFocusTraversable(true);



        PauseBTN.setGraphic(new ImageView(PauseImage));
    }

    public void BTNs_Action(ActionEvent actionEvent)
    {
        if (actionEvent.getSource() == SaveBTN) {
            //Save Data
        }

        if (actionEvent.getSource() == PauseBTN) {
            if (pause) {
                PauseBTN.setGraphic(new ImageView(PauseImage));
                pause = false;
            }
            else {
                PauseBTN.setGraphic(new ImageView(PlayImage));
                pause = true;
            }
        }
    }
}
