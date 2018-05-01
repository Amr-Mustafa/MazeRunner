package controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.MapLoading;

public class MazeController {

    @FXML
    private Canvas CanvasMaze;

    private MapLoading MapLoadingObject;

    public void drawMaze(){
        GraphicsContext g = CanvasMaze.getGraphicsContext2D ();


        for(int i=0;i<20;i++)
        {
            for (int j = 0; j < 20; j++)
            {
                if(MapLoadingObject.chooseType (i , j)=='b')
                {
                    g.setFill (Color.RED);
                    g.fillRect (i*30,j*30,30,30);
                    System.out.println ("b");
                }
                if(MapLoadingObject.chooseType (i , j)=='g')
                {
//                    g.drawImage (grassImage,i*30,j*30);
                    g.setFill (Color.BLUE);
                    g.fillRect (i*30,j*30,30,30);
                    System.out.println ("g");
                }

            }
        }
    }

    public void initialize(){
        MapLoadingObject = new MapLoading();
        drawMaze ();
    }

}
