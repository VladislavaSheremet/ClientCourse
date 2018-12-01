package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Client client = new Client();
        FXMLLoader loader =  new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/FXMLFiles/sample.fxml")); //  МЕНЯЙ
        try {
            loader.load();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        Controller controller = loader.getController();//МЕНЯЙ
        controller.setClient(client);
        Parent root = loader.getRoot();
        primaryStage.setTitle("Добро пожаловать");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }

    public static void main(String[] args) throws InterruptedException{
        launch(args);
    }
}
