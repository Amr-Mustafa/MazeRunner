package model.characters;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.MazeLoader;

public class Player extends Character {

    //Change with player position
    private int tileX=1,tileY=1;

    private static final Player playerInstance = new Player();

    public int getTileX(){ return tileX; }

    public int getTileY(){ return tileY; }


    public void PlayerPhase(int checkState ,int freezeState, char direction){
        if(checkState == 0)
        {
            if(freezeState == 0 )
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
            else if(freezeState == 1 )
            {
                if(direction == 'L')
                {
                    characterPath = "view/LeftFreezedNormalHero.PNG";
                    sprite = new Image(characterPath);
                }
                else if(direction == 'R')
                {
                    characterPath = "view/FreezedNormalHero.PNG";
                    sprite = new Image(characterPath);
                }
            }

        }
        else if(checkState == 1)
        {
            if(freezeState == 0)
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
            else if(freezeState == 1 )
            {
                if(direction == 'L')
                {
                    characterPath = "view/LeftFreezedArmoredHero.PNG";
                    sprite = new Image(characterPath);
                }
                else if(direction == 'R')
                {
                    characterPath = "view/FreezedArmoredHero.PNG";
                    sprite = new Image(characterPath);
                }
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
