package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Client;
import sample.Controllers.ShowCategory.*;

import java.io.IOException;

public class RangeController {

    Client client;
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    @FXML
    private Button backwards;

    @FXML
    private Button ButtonTablesChairs;

    @FXML
    private Button ButtonСushionedFurniture;

    @FXML
    private Button ButtonThumbs;

    @FXML
    private Button ButtonOfficeFurniture;

    @FXML
    private Button ButtonCabinets;

    @FXML
    private Button ButtonKitchens;

    @FXML
    private Button ButtonLivingRooms;

    @FXML
    private Button ButtonOtherFurniture;

    @FXML
    private Button newProduct;

    @FXML
    void initialize() {

        newProduct.setOnAction(event -> {
            newProduct.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/AddProduct.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            AddNewProductController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        ButtonTablesChairs.setOnAction(event -> {
            ButtonTablesChairs.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/ShowCategory/ShowCategory1.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            ShowCategory1Controller controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        ButtonThumbs.setOnAction(event -> {
            ButtonThumbs.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/ShowCategory/ShowCategory3.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            ShowCategory3Controller controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        ButtonСushionedFurniture.setOnAction(event -> {
            ButtonСushionedFurniture.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/ShowCategory/ShowCategory2.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            ShowCategory2Controller controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        ButtonKitchens.setOnAction(event -> {
            ButtonKitchens.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/ShowCategory/ShowCategory4.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            ShowCategory4Controller controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        ButtonCabinets.setOnAction(event -> {
            ButtonCabinets.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/ShowCategory/ShowCategory6.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            ShowCategory6Controller controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        ButtonOfficeFurniture.setOnAction(event -> {
            ButtonOfficeFurniture.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/ShowCategory/ShowCategory5.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            ShowCategory5Controller controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

         ButtonLivingRooms.setOnAction(event -> {
            ButtonLivingRooms.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/ShowCategory/ShowCategory7.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            ShowCategory7Controller controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        ButtonOtherFurniture.setOnAction(event -> {
            ButtonOtherFurniture.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/ShowCategory/ShowCategory8.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            ShowCategory8Controller controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        backwards.setOnAction(event -> {
            backwards.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/app.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            MenuController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }
}

