package model.Save;

import java.util.ArrayList;

public class Originator {

    private  Maze game;

    public Memento createMemento(){
        Memento memento =new Memento();
        memento.setMemoMaze(this.game);
        return memento;
    }

    public void getMementoState(Memento game){
        this.game = game.getMemoMaze();
    }


}
