package model.cells.characters.player;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.cells.characters.Character;
import model.infopanel.Observable;

public class Player extends Character implements Observable {

    //Change with player position
    private int tileX=1,tileY=1;

    private static final Player playerInstance = new Player();

    public int getTileX(){
        return tileX;
    }

    public int getTileY(){
        return tileY;
    }


    public void PlayerPhase(int checkState , char direction){
        if(checkState == 0)
        {
            if(direction == 'L')
            {
                characterPath = "view/LeftNormalHero.PNG";
                sprite = new Image(characterPath);
            }
            else if(direction == 'R')
            {
                characterPath = "view/NormalHero.PNG";
                sprite = new Image(characterPath);
            }
        }
        else if(checkState == 1)
        {
            if(direction == 'L')
            {
                characterPath = "view/LeftArmoredHero.PNG";
                sprite = new Image(characterPath);
            }
            else if(direction == 'R')
            {
                characterPath = "view/ArmoredHero.PNG";
                sprite = new Image(characterPath);
            }
        }
        else if(checkState == 2)
        {
            characterPath = "view/tomb.PNG";
            sprite = new Image(characterPath);
        }
    }

    private Player() {
        this.characterPath = "view/NormalHero.PNG";
        this.sprite = new Image(characterPath);
    }

    public static Player getPlayer() {
        return playerInstance;
    }

    public void move(int x,int y) {
        tileX = tileX + x ;
        tileY = tileY + y ;
    }

    public void draw(GraphicsContext cell, int x, int y) {
        cell.drawImage(sprite, x * 32, y * 32);
    }

}
