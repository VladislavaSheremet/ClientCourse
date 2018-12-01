package sample.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import sample.Client;
import sample.SerializeClasses.AddNewProductData;

import java.io.IOException;

public class AddNewProductController{

    Client client;
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client;}

    @FXML
    private Button backwards;

    @FXML
    private RadioButton radio1;
    @FXML
    private RadioButton radio3;

    @FXML
    private RadioButton radio5;

    @FXML
    private RadioButton radio7;

    @FXML
    private RadioButton radio2;

    @FXML
    private RadioButton radio4;

    @FXML
    private RadioButton radio6;

    @FXML
    private RadioButton radio8;

    @FXML
    private TextField signUp_ProductDescription;

    @FXML
    private TextField signUp_Material;

    @FXML
    private TextField signUp_Color;

    @FXML
    private TextField signUp_Country;

    @FXML
    private TextField signUp_Information;

    @FXML
    private TextField signUp_Price;

    @FXML
    private TextField signUp_grassProfit;

    @FXML
    private TextField signUp_sellingExpenses;

    @FXML
    private TextField signUp_managementExpenses;

    @FXML
    private Button finishhh;

    @FXML
    private TextField signUp_ProductName;

    @FXML
    private TextField signUp_KlSkld;


    @FXML
    void initialize() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        finishhh.setOnAction(event -> {
            addNew();
        });

        backwards.setOnAction(event -> {
            backwards.getScene().getWindow().hide();
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
    }

    private void addNew() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        String categories = "";
        String ProductName = signUp_ProductName.getText().trim();
        String ProductDescription = signUp_ProductDescription.getText().trim();
        String Material = signUp_Material.getText().trim();
        String Color = signUp_Color.getText().trim();
        String Country = signUp_Country.getText().trim();
        String Information = signUp_Information.getText().trim();
        String Price = signUp_Price.getText().trim();
        String grassProfit = signUp_grassProfit.getText().trim();
        String sellingExpenses = signUp_sellingExpenses.getText().trim();
        String managementExpenses = signUp_managementExpenses.getText().trim();
        String klSklad = signUp_KlSkld.getText().trim();
        if(radio1.isSelected()){
            categories = "Столы и стулья";
        } else if(radio2.isSelected()){
            categories = "Мягкая мебель";
        } else if(radio3.isSelected()){
            categories = "Тумбы и комоды";
        } else if(radio4.isSelected()){
            categories = "Кухни";
        } else if(radio5.isSelected()){
            categories = "Офисная мебель";
        } else if(radio6.isSelected()){
            categories = "Шкафы";
        }else if(radio7.isSelected()){
            categories = "Гостинные";
        }else if(radio8.isSelected()){
            categories = "Другое";
        }

        if(categories.equals("") || ProductName.equals("") || Material.equals("") ||
                Color.equals("") || Country.equals("") || Price.equals("") || grassProfit.equals("")
                || sellingExpenses.equals("") || managementExpenses.equals("") || klSklad.equals("")){

            alert.setTitle("Внимание!");
            alert.setHeaderText(null);
            alert.setContentText("Некоторые данные не заполнены!");
            alert.showAndWait();
        }
        else {
            AddNewProductData addNewProduct = new AddNewProductData();
            addNewProduct.setCategories(categories);
            addNewProduct.setProductName(ProductName);
            addNewProduct.setProductDescription(ProductDescription);
            addNewProduct.setMaterial(Material);
            addNewProduct.setColor(Color);
            addNewProduct.setCountry(Country);
            addNewProduct.setInformation(Information);
            addNewProduct.setPrice(Price);
            addNewProduct.setGrassProfit(grassProfit);
            addNewProduct.setSellingExpenses(sellingExpenses);
            addNewProduct.setManagementExpenses(managementExpenses);
            addNewProduct.setKlSklad(klSklad);
            client.write(addNewProduct);

            alert.setTitle("Внимание!");
            alert.setHeaderText(null);
            alert.setContentText("Товар \"" + ProductName + "\" добавлен в базу!");
            alert.showAndWait();
        }
    }
}
