package model.cells.characters.player.states;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.cells.Cell;
import model.cells.CellState;
import model.cells.characters.player.Player;
import model.cells.walls.Wall;
import model.maze.Maze;

public class UnarmoredState extends PlayerState implements CellState {

    /* The characterPath is the location of the character image on drive. */
    private String characterPath;

    /* The sprite holds the character image after loading. */
    private Image sprite;

    public UnarmoredState() {

        /* Initialize instance variables. */
        this.characterPath = "view/NormalHero.PNG";
        this.sprite = new Image(characterPath);
    }

    @Override
    public void draw(GraphicsContext cell, int x, int y) {
        cell.drawImage(sprite, x * 32, y * 32);
    }

    @Override
    public void receivePlayer() {

    } // USELESS METHOD

    @Override
    public void hit() {

    } // USELESS METHOD

    @Override
    public void move(int x, int y, Maze maze) {

        Player player = Player.getPlayer();
        Cell src = maze.getMaze()[player.getCurrentRow()][player.getCurrentColumn()];
        Cell dest = maze.getMaze()[player.getCurrentRow() + x][player.getCurrentColumn() + y];

        /* Set the orientation of the player. */
        if (x == -1) // move left
            this.sprite = new Image("view/LeftNormalHero.PNG");
        else if (x == 1)  // move right
            this.sprite = new Image("view/NormalHero.PNG");

        /* Apply the action of the destination cell onto the player. */
        dest.receivePlayer();

        /* Move the player into the destination cell and redraw the maze if not a wall. */
        if (!(dest instanceof Wall)) {
            maze.getMaze()[player.getCurrentRow()][player.getCurrentColumn()] = maze.getMaze()[player.getCurrentRow() + x][player.getCurrentColumn() + y];
            maze.getMaze()[player.getCurrentRow() + x][player.getCurrentColumn() + y] = src;

            player.setCurrentRow(player.getCurrentRow() + x);
            player.setCurrentColumn(player.getCurrentColumn() + y);

            maze.drawMaze(maze.canvas);
        }
    }
}
