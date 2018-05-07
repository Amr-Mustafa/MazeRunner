package model.Save;

import java.util.ArrayList;

public class SaveNLoad {

    private ArrayList<Memento> savedGamesList;

    public void addGameMemo(Memento memento){
        savedGamesList.add(memento);
    }

    public Memento retrievegameMemo(Memento memento){
        return savedGamesList.get(savedGamesList.indexOf(memento));
    }



}
