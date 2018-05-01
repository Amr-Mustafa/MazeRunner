
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.maze.BinaryTreeMaze;
import model.maze.Grid;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BinaryTreeMaze binaryTreeMaze = new BinaryTreeMaze();
        Grid maze = binaryTreeMaze.generateMaze(5, 5);
        System.out.println(maze.toString());
        maze.drawMaze();
        Parent root = FXMLLoader.load(getClass().getResource("/view/Maze.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}