package model.cells.characters.player;

import javafx.scene.canvas.GraphicsContext;
import model.cells.CellState;
import model.cells.characters.player.states.UnarmoredState;
import model.cells.gifts.HealthGift;
import model.infopanel.InfoPanel;

import java.util.Observable;

public class Player extends Observable implements IPlayer {

    /* The state of the player is either alive-armored, alive-unarmored, dead. */
    private CellState playerState;

    /* Player score and health are increased/decreased based on game play. */
    private int score;
    private int health;

    /* The user can set a player name at the start of the game. */
    private String name;

    private int tileX=1,tileY=1; // ------------------------------------------------------------------>

    /* Reference to the singleton object. */
    private static final Player playerInstance = new Player ();

    /**
     * Private constructor (Singleton DP).
     */
    private Player () {

        this.score = 0;
        this.health = 100;
        this.playerState = new UnarmoredState();

        /* Registers the information panel as an observer to the player. */
        this.addObserver(InfoPanel.getInfoPanel());
    }

    /**
     * This method is the only way to reference the singleton Player object.
     * @return reference to the Player object.
     */
    public static Player getPlayer () {
        return playerInstance;
    }

    public void move (int x,int y) {
        tileX = tileX + x ;
        tileY = tileY + y ;
    } // ---------------------------------------------------------->

    /**
     * The draw method delegates the action of drawing to the current state of the player.
     * @param cell
     * @param x
     * @param y
     */
    public void draw (GraphicsContext cell, int x, int y) {
        playerState.draw(cell, x, y);
    }

    public int getTileX (){ return tileX; } // --------------------------------------------------------->

    public int getTileY (){ return tileY; } // --------------------------------------------------------->

    public void PlayerPhase (int checkState ,int freezeState, char direction){
//        if(checkState == 0)
//        {
//            if(freezeState == 0 )
//            {
//                if(direction == 'L')
//                {
//                    characterPath = "view/LeftNormalHero.PNG";
//                    sprite = new Image(characterPath);
//                }
//                else if(direction == 'R')
//                {
//                    characterPath = "view/NormalHero.PNG";
//                    sprite = new Image(characterPath);
//                }
//            }
//            else if(freezeState == 1 )
//            {
//                if(direction == 'L')
//                {
//                    characterPath = "view/LeftFreezedNormalHero.PNG";
//                    sprite = new Image(characterPath);
//                }
//                else if(direction == 'R')
//                {
//                    characterPath = "view/FreezedNormalHero.PNG";
//                    sprite = new Image(characterPath);
//                }
//            }
//
//        }
//        else if(checkState == 1)
//        {
//            if(freezeState == 0)
//            {
//                if(direction == 'L')
//                {
//                    characterPath = "view/LeftArmoredHero.PNG";
//                    sprite = new Image(characterPath);
//                }
//                else if(direction == 'R')
//                {
//                    characterPath = "view/ArmoredHero.PNG";
//                    sprite = new Image(characterPath);
//                }
//            }
//            else if(freezeState == 1 )
//            {
//                if(direction == 'L')
//                {
//                    characterPath = "view/LeftFreezedArmoredHero.PNG";
//                    sprite = new Image(characterPath);
//                }
//                else if(direction == 'R')
//                {
//                    characterPath = "view/FreezedArmoredHero.PNG";
//                    sprite = new Image(characterPath);
//                }
//            }
//        }
//        else if(checkState == 2)
//        {
//            characterPath = "view/tomb.PNG";
//            sprite = new Image(characterPath);
//        }
    } // --------------------->

    /**
     * This method is the getter for the instance field score.
     * @return current score of the player.
     */
    public int getScore () {
        return this.score;
    }

    /**
     * This method is the setter for the instance field score.
     * @param newScore : int
     */
    public void setScore (int newScore) {

        /* Update the score. */
        this.score = newScore;

        /* Notify the observers. */
        setChanged();
        notifyObservers(newScore);
    }

    /**
     * This method is the getter for the instance field health.
     * @return current health of the player.
     */
    public int getHealth () {
        return this.health;
    }

    /**
     * This method is the setter for the instance field health.
     * @param newHealth : int
     */
    public void setHealth (int newHealth) {

        /* Update the score. */
        newHealth = newHealth > 100 ? 100 : newHealth; // Maximum health is 100.
        this.health = newHealth;

        /* Notify the observers. */
        setChanged();
        notifyObservers(newHealth);
    }

    /**
     * This method is called when the player eats a gift resulting in an increase in health.
     */
    public void eat () {
        this.setHealth(this.health + HealthGift.HEALTH_INCREMENT);
    }

    /**
     * This method is the getter for the name of the player.
     * @return name of the player.
     */
    public String getName () {
        return name;
    }

    /**
     * This method is the setter for the name of the player.
     * @param name : String
     */
    public void setName (String name) {
        this.name = name;
    }

    public void attack () { // ------------------------------------------------------------------>
        // Attack logic.
    }
}
