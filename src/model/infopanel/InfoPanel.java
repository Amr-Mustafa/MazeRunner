package model.infopanel;

import java.util.Observable;
import java.util.Observer;

public class InfoPanel implements Observer {

    /* Reference to the singleton object. */
    private static final InfoPanel infoPanel = new InfoPanel();

    /**
     * Private constructor (Singleton DP).
     */
    private InfoPanel() {

    }

    /**
     * This method is the only way to reference the singleton InfoPanel object.
     * @return reference to the InfoPanel object.
     */
    public static InfoPanel getInfoPanel() {
        return infoPanel;
    }

    @Override
    public void update(Observable observable, Object o) {
        System.out.println("New score: " + o);
    }

}
