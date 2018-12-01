package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Client;
import sample.Controllers.CategoryControllers.*;

import java.io.IOException;

public class CategoriesForCalculationController {

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
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/CategoryCalculation/CalculationCategory1.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            CalculationCategory1Controller controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        ButtonСushionedFurniture.setOnAction(event -> {
            ButtonСushionedFurniture.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/CategoryCalculation/CalculationCategory2.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            CalculationCategory2Controller controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        ButtonThumbs.setOnAction(event -> {
            ButtonThumbs.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/CategoryCalculation/CalculationCategory3.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            CalculationCategory3Controller controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        ButtonOfficeFurniture.setOnAction(event -> {
            ButtonOfficeFurniture.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/CategoryCalculation/CalculationCategory5.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            CalculationCategory5Controller controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        ButtonCabinets.setOnAction(event -> {
            ButtonCabinets.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/CategoryCalculation/CalculationCategory6.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            CalculationCategory6Controller controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        ButtonKitchens.setOnAction(event -> {
            ButtonKitchens.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/CategoryCalculation/CalculationCategory4.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            CalculationCategory4Controller controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        ButtonLivingRooms.setOnAction(event -> {
            ButtonLivingRooms.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/CategoryCalculation/CalculationCategory7.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            CalculationCategory7Controller controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        ButtonOtherFurniture.setOnAction(event -> {
            ButtonOtherFurniture.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/CategoryCalculation/CalculationCategory8.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            CalculationCategory8Controller controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        backwards.setOnAction(event -> {
            backwards.getScene().getWindow().hide();
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
    }
}
