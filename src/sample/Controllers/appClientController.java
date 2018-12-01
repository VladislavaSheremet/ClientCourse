package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.Client;
import sample.Controller;

import java.io.IOException;

public class appClientController {

    Client client;
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    @FXML
    private ImageView img6_button;
    @FXML
    private ImageView img5_button;

    @FXML
    private Button backwards;
    @FXML
    private Button Button5;
    @FXML
    private Button Button6;
    @FXML
    private Button Button51;
    @FXML
    private Button Button511;
    @FXML
    private Button ButtonWorkWith;
    @FXML
    private Button ButtonZakaz;

    @FXML
    void initialize() {
        Button5.setOnAction(event -> {
            Button5.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/ContactClient.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            ContactsClientController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        Button51.setOnAction(event -> {
            Button51.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/BuyProduct.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            BuyProductController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        Button511.setOnAction(event -> {
            Button511.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/Shops.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            ShopsController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });


        ButtonZakaz.setOnAction(event -> {
            ButtonZakaz.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/MyKorzin.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            MyKorzinController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });


        Button6.setOnAction(event -> {
            Button6.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/RangeForClient.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            RangeForClientController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        ButtonWorkWith.setOnAction(event -> {
            ButtonWorkWith.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/WorkInformationClient.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            WorkInformationClientController controller = loader.getController();
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
