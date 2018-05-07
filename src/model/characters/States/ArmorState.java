package model.characters.States;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.cells.characters.Cell;

import java.util.HashMap;
import java.util.Map;

public class ArmorState implements PlayerState
{

    private Map<String, Integer> properties = new HashMap<>();
    private Image image;

    public ArmorState()
    {
        properties.put("armor", 0);
        properties.put("health", 100);
        properties.put("score", 100);
        properties.put("arrows", 0);
    }

    public ArmorState(Map<String, Integer> properties)
    {
        this.properties.replace("armor", properties.get("armor"));
        this.properties.replace("health", properties.get("health"));
        this.properties.replace("arrows", properties.get("arrows"));
        this.properties.replace("score", properties.get("score"));
    }

    /*-----------------------------------------------------------------------------------------*/

    @Override
    public void hitBomb(Cell source, Cell destination, Object bomb)
    {

    }

    /*-----------------------------------------------------------------------------------------*/

    @Override
    public void setImage(Image image)
    {
        this.image = image;
    }

    @Override
    public Image getImage()
    {
        return image;
    }

    /*-----------------------------------------------------------------------------------------*/

    @Override
    public void setProperties(Map<String, Integer> properties)
    {
        this.properties = properties;
    }

    @Override
    public Map<String, Integer> getProperties()
    {
        return this.properties;
    }
}
