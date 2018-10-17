package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.SceneHelper;

import java.io.IOException;

public class MainController
{
    public Button NewGameBTN;
    public Button ResumeBTN;
    public Button ScoresBTN;
    public Button ExitBTN;

    public void BTNs_Action(ActionEvent actionEvent) throws IOException
    {
        String fxml = "";
        Stage stage = null;


        if (actionEvent.getSource() == NewGameBTN){
            stage = (Stage) NewGameBTN.getScene().getWindow();
            fxml = "../view/Maze.fxml";
        }
        if (actionEvent.getSource() == ResumeBTN){
            stage = (Stage) ResumeBTN.getScene().getWindow();
            fxml = "../view/Maze.fxml";
        }
        if (actionEvent.getSource() == ScoresBTN){
            stage = (Stage) ScoresBTN.getScene().getWindow();
            fxml = "../view/Scenes/ScoresScene.fxml";
        }
        if (actionEvent.getSource() == ExitBTN) System.exit(0);


        SceneHelper sceneHelper = new SceneHelper();
        sceneHelper.initStage(fxml,"/view/UI.css",1024,668);
        sceneHelper.getStage().show();

        stage.close();
    }
}
