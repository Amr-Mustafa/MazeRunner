package model.characters.States;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import model.cells.characters.Cell;

import java.util.Map;

public interface PlayerState
{
    void hitBomb(Cell source, Cell destination, Object bomb, Object matrix);

    void setImage(Image image);

    Image getImage();

    void setProperties(Map<String, Integer> properties);

    Map<String, Integer> getProperties();
}
