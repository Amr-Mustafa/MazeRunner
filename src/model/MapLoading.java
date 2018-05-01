package model;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class MapLoading {

    private Scanner map;

    private String MapLoading[] = new String[20];

    private Image bricks,grass;

    public MapLoading(){

    }


    public void openFile(){
        try{
            map = new Scanner(new File("Map.txt"));
        }
        catch (Exception e)
        {

        }
    }

    public void readFile(){
        while(map.hasNext())
        {
            for(int i=0;i<20;i++)
            {
                MapLoading[i] = map.next();
            }
        }

    }
    public void closeFile(){
        map.close ();

    }

    public String getMap(int x, int y){
        String index = MapLoading[y].substring(x,x+1);
        return index;
    }

    public char chooseType(int x,int y){
        char MapInChar[][] = {{'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b'}
                ,{'b','g','g','g','g','g','g','g','g','g','g','g','g','g','g','g','g','g','g','b'}
                ,{'b','g','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','g','b'}
                ,{'b','g','g','g','b','b','b','b','b','b','b','b','b','b','b','b','b','b','g','b'}
                ,{'b','g','b','g','g','b','b','b','b','b','b','b','b','b','b','b','b','b','g','b'}
                ,{'b','g','b','b','g','b','b','b','b','b','b','b','b','g','g','g','b','b','g','b'}
                ,{'b','g','b','g','g','b','b','b','b','b','b','b','b','g','b','g','b','b','g','b'}
                ,{'b','g','b','g','b','b','g','g','g','g','g','b','b','g','b','g','b','b','g','b'}
                ,{'b','g','b','g','b','b','g','b','b','b','g','b','b','g','b','g','b','b','g','b'}
                ,{'b','g','b','g','b','b','g','b','b','b','g','b','b','g','b','g','b','b','g','b'}
                ,{'b','g','b','g','g','b','g','b','b','b','g','b','b','g','b','g','b','b','g','b'}
                ,{'b','g','b','b','g','b','g','b','b','b','g','g','g','g','b','g','b','b','g','b'}
                ,{'b','g','b','b','g','b','g','b','b','b','b','b','b','b','b','g','b','b','g','b'}
                ,{'b','g','b','b','g','b','g','b','b','b','b','b','b','b','b','g','b','b','g','b'}
                ,{'b','g','b','b','g','b','g','b','b','b','b','b','b','b','b','g','g','g','g','b'}
                ,{'b','g','b','b','g','b','g','b','b','b','b','b','b','b','b','b','b','b','g','b'}
                ,{'b','g','b','b','g','g','g','b','b','b','b','b','b','b','b','b','b','b','g','b'}
                ,{'b','g','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','g','b'}
                ,{'b','g','g','g','g','g','g','g','g','g','g','g','g','g','g','g','g','g','g','b'}
                ,{'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b'}};
        return MapInChar[x][y];
    }

    public Image getBricks(){
        return bricks;
    }

    public Image getGrass(){
        return grass;
    }

}
