package model;

import controller.GameScene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.characters.Player;
import model.maze.BinaryTreeMaze;
import model.maze.Grid;

public class MazeLoader {

    private Canvas canvas;
    private BinaryTreeMaze binaryTreeMaze;
    private Grid maze;
    public char[][] mazeMatrix;

    private static final MazeLoader mazeLoader = new MazeLoader();

    public static MazeLoader getMazeLoader() {
        return mazeLoader;
    }

    private MazeLoader () {
        this.binaryTreeMaze = new BinaryTreeMaze();
        this.maze = binaryTreeMaze.generateMaze(10, 10);
        this.mazeMatrix = maze.toCharMatrix();
        this.mazeMatrix[1][1] = 'p';
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public void drawMaze(){

        GraphicsContext cell = canvas.getGraphicsContext2D();

        for(int i = 0; i < mazeMatrix.length; i++) {
            for (int j = 0; j < mazeMatrix.length; j++) {

                if(mazeMatrix[i][j] == 'b') {
                    cell.drawImage(new Image("view/block1.PNG"), i * 32, j * 32);
                }

                if(mazeMatrix[i][j] == 'g') {
                    cell.drawImage(new Image("view/road.fw.PNG"), i * 32, j * 32);
                }

                if(mazeMatrix[i][j] == 'p') {
                    Player.getPlayer().draw(cell, i, j);
                }

            }
        }
    }

}
