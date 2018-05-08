package controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.maze.Maze;
import model.maze.MazeLoader;
import model.cells.characters.player.Player;

public class GameScene {

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

    public void initialize(){

        /* Generate a new maze with the given dimensions. */
        maze = new Maze(ROWS, COLUMNS);

        /* Draw the initial state of the maze. */
        maze.drawMaze(CanvasMaze);

        /* Get a reference to the player singleton. */
        player = Player.getPlayer();

        /* Set focus on the canvas. */
        CanvasMaze.setFocusTraversable(true);

        //mazeLoader = MazeLoader.getMazeLoader();
        //mazeLoader.setCanvas(CanvasMaze);
        //mazeLoader.drawMaze();
    }

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


//        mazeLoader.drawMaze();
//        if(mazeLoader.mazeMatrix[player.getCurrentRow()][player.getCurrentColumn()] == 'a')
//        {
//            checkState = 1;
//            //mazeLoader.mazeMatrix[player.getCurrentRow()][player.getCurrentColumn()] = 'g';
//        }
//        if(mazeLoader.mazeMatrix[player.getCurrentRow()][player.getCurrentColumn()] == 'd')
//        {
//            if(checkState == 1)
//                checkState =0;
//            else if(checkState ==0)
//                checkState =2;
//            mazeLoader.mazeMatrix[player.getCurrentRow()+1][player.getCurrentColumn()+1] = 'g';
//            mazeLoader.mazeMatrix[player.getCurrentRow()+1][player.getCurrentColumn()] = 'g';
//            mazeLoader.mazeMatrix[player.getCurrentRow()][player.getCurrentColumn()+1] = 'g';
//            mazeLoader.mazeMatrix[player.getCurrentRow()-1][player.getCurrentColumn()-1] = 'g';
//            mazeLoader.mazeMatrix[player.getCurrentRow()-1][player.getCurrentColumn()] = 'g';
//            mazeLoader.mazeMatrix[player.getCurrentRow()][player.getCurrentColumn()-1] = 'g';
//            mazeLoader.mazeMatrix[player.getCurrentRow()+1][player.getCurrentColumn()-1] = 'g';
//            mazeLoader.mazeMatrix[player.getCurrentRow()-1][player.getCurrentColumn()+1] = 'g';
//            maze.drawMaze(CanvasMaze);
//            mazeLoader.mazeMatrix[player.getCurrentRow()][player.getCurrentColumn()] = 'g';
//        }
//        if(mazeLoader.mazeMatrix[player.getCurrentRow()][player.getCurrentColumn()] == 'f')
//        {
//            freezeState = 1;
//            freezed = 5 ;
//        }
//        if(freezed ==0)
//        {
//            freezeState = 0;
//        }
//
//        player.PlayerPhase(checkState,freezeState,direction);
//        mazeLoader.moveInMaze(player.getCurrentRow(),player.getCurrentColumn());
//        mazeLoader.mazeMatrix[player.getCurrentRow()][player.getCurrentColumn()] = 'p';
//        maze.drawMaze(CanvasMaze);

    }

}
