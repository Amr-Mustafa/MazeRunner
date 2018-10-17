package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.SceneHelper;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ScoresController implements Initializable
{
    public Button HomeBTN;
    public Button PlayBTN;
    public Label TimeLabel;
    public Label ScoreLabel;


    public void BTNs_Action(ActionEvent actionEvent) throws IOException
    {
        String fxml = "";
        Stage stage = null;

        if (actionEvent.getSource() == HomeBTN) {
            stage = (Stage) HomeBTN.getScene().getWindow();
            fxml = "../view/Scenes/MainScene.fxml";
        }

        if (actionEvent.getSource() == PlayBTN) {
            stage = (Stage) PlayBTN.getScene().getWindow();
            fxml = "../view/Maze.fxml";
        }

        SceneHelper sceneHelper = new SceneHelper();
        sceneHelper.initStage(fxml,"/view/UI.css",1024,668);
        sceneHelper.getStage().show();

        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        Image homeImage = new Image(getClass().getResourceAsStream("../view/UIKit/HOME.png"));
        Image PlayImage = new Image(getClass().getResourceAsStream("../view/UIKit/PLAY.png"));

        HomeBTN.setGraphic(new ImageView(homeImage));
        PlayBTN.setGraphic(new ImageView(PlayImage));
    }
}
