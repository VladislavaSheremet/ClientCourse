package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import sample.Client;
import sample.Controller;

import java.io.IOException;

public class MenuController {

    Client client;
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    @FXML
    private ImageView img1_button;

    @FXML
    private ImageView img2_button;

    @FXML
    private ImageView img3_button;

    @FXML
    private ImageView img4_button;

    @FXML
    private ImageView img6_button;

    @FXML
    private ImageView img5_button;

    @FXML
    private Button backwards;

    @FXML
    private Button Button1;

    @FXML
    private Button Button2;

    @FXML
    private Button Button3;

    @FXML
    private Button Button4;

    @FXML
    private Button Button5;

    @FXML
    private Button Button6;

    @FXML
    void initialize() {

        Button1.setOnAction(event -> {
            Button1.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/CalculationOptions.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            CalculationOptionsController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        Button2.setOnAction(event -> {
            Button2.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/MenuWorkWithInformation.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            WorkWithInformationController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        Button3.setOnAction(event -> {
            Button3.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/Gistogram.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            GistogramController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        Button4.setOnAction(event -> {
            Button4.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/InformationAboutMethod.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            InformationAboutMethodController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        Button5.setOnAction(event -> {
            Button5.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/Users.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            UsersController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        Button6.setOnAction(event -> {
            Button6.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/Range.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            RangeController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        backwards.setOnAction(event -> {
            backwards.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/sample.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            Controller controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }
}