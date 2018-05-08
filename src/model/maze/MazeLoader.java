package model.maze;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.cells.characters.player.Player;
import model.maze.generator.BinaryTreeMaze;
import model.maze.generator.Grid;

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

        /* Generate the maze with the given dimensions. */
        Maze maze = new Maze(21, 21);

        /* Get a 2D character matrix representing the maze. */
        this.mazeMatrix = maze.getCharMaze();

        this.mazeMatrix[1][1] = 'p';
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

//    public void drawMaze(){
//
//        GraphicsContext cell = canvas.getGraphicsContext2D();
//
//        for(int i = 0; i < mazeMatrix.length; i++) {
//            for (int j = 0; j < mazeMatrix.length; j++) {
//
//                if(mazeMatrix[i][j] == 'w') {
//                    cell.drawImage(new Image("view/block1.PNG"), i * 32, j * 32);
//                }
//
//                if(mazeMatrix[i][j] == 'r') {
//                    cell.drawImage(new Image("view/road.fw.PNG"), i * 32, j * 32);
//                }
//
//                if(mazeMatrix[i][j] == 'p') {
//                    Player.getPlayer().draw(cell, i, j);
//                }
//                if(mazeMatrix[i][j] == 't') {
//                    cell.drawImage(new Image("view/ArmorSet.png"), i * 32, j * 32);
//                }
//                if(mazeMatrix[i][j] == 'f') {
//                    cell.drawImage(new Image("view/bomb.PNG"), i * 32, j * 32);
//                }
//                if(mazeMatrix[i][j] == 'b') {
//                    cell.drawImage(new Image("view/FreezeBomb.PNG"), i * 32, j * 32);
//                }
//                if(mazeMatrix[i][j] == 'a') {
//                    cell.drawImage(new Image("view/Arrows.PNG"), i * 32, j * 32);
//                }
//                if(mazeMatrix[i][j] == 'm') {
//                    cell.drawImage(new Image("view/Bow.PNG"), i * 32, j * 32);
//                }
//                if(mazeMatrix[i][j] == 'h') {
//                    cell.drawImage(new Image("view/foodGift.png"), i * 32, j * 32);
//                }
//                if(mazeMatrix[i][j] == 'l') {
//                    cell.drawImage(new Image("view/grassWall.fw.PNG"), i * 32, j * 32);
//                }
//            }
//
//        }
//    }

    public void moveInMaze(int playerX ,int playerY){

        GraphicsContext cell = canvas.getGraphicsContext2D();
        cell.drawImage(new Image("view/road.fw.PNG"),  32,  32);
        Player.getPlayer().draw(cell,playerX,playerY);

    }

}
