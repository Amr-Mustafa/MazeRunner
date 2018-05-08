package model.cells.characters;

import model.cells.Cell;
import model.maze.Maze;

public interface Character extends Cell {
    
    void move(int x, int y, Maze maze);

}
