package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Client;
import sample.Controllers.ShowCategory.*;
import sample.Controllers.ShowCategoryClient.*;

import java.io.IOException;

public class RangeForClientController {

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
    void initialize() {

        ButtonTablesChairs.setOnAction(event -> {
            ButtonTablesChairs.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/ShowCategoryClient/ShowCategory1Client.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            ShowCategory1ClientController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        ButtonThumbs.setOnAction(event -> {
            ButtonThumbs.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/ShowCategoryClient/ShowCategory3Client.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            ShowCategory3ClientController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        ButtonСushionedFurniture.setOnAction(event -> {
            ButtonСushionedFurniture.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/ShowCategoryClient/ShowCategory2Client.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            ShowCategory2ClientController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        ButtonKitchens.setOnAction(event -> {
            ButtonKitchens.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/ShowCategoryClient/ShowCategory4Client.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            ShowCategory4ClientController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        ButtonCabinets.setOnAction(event -> {
            ButtonCabinets.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/ShowCategoryClient/ShowCategory6Client.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            ShowCategory6ClientController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        ButtonOfficeFurniture.setOnAction(event -> {
            ButtonOfficeFurniture.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/ShowCategoryClient/ShowCategory5Client.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            ShowCategory5ClientController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        ButtonLivingRooms.setOnAction(event -> {
            ButtonLivingRooms.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/ShowCategoryClient/ShowCategory7Client.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            ShowCategory7ClientController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        ButtonOtherFurniture.setOnAction(event -> {
            ButtonOtherFurniture.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/ShowCategoryClient/ShowCategory8Client.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            ShowCategory8ClientController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        backwards.setOnAction(event -> {
            backwards.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/appForClient.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            appClientController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }
}
