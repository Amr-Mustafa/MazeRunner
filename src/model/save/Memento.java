package model.save;

import model.maze.Maze;

public class Memento {

    private Maze memoMaze;

    public Maze getMemoMaze() {
        return memoMaze;
    }

    public void setMemoMaze(Maze memoMaze) {
        this.memoMaze = memoMaze;
    }
}
