package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Client;
import sample.Lists.ListOfFurniture;
import sample.SerializeClasses.ShowForReduct;
import sample.SerializeClasses.ShowInrormationAboutProductData;

import java.io.IOException;

public class ReductController {

    Client client;
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    @FXML
    private ObservableList<ShowInrormationAboutProductData> ProductData = FXCollections.observableArrayList();

    @FXML
    private TableView<ShowInrormationAboutProductData> tableProfit;

    @FXML
    private TableColumn<ShowInrormationAboutProductData, Integer> idColumn;
    @FXML
    private TableColumn<ShowInrormationAboutProductData, String> categoryColumn;
    @FXML
    private TableColumn<ShowInrormationAboutProductData, String> nameColumn;
    @FXML
    private TableColumn<ShowInrormationAboutProductData, String> definitionColumn;
    @FXML
    private TableColumn<ShowInrormationAboutProductData, String> materialColumn;
    @FXML
    private TableColumn<ShowInrormationAboutProductData, String> colorColumn;
    @FXML
    private TableColumn<ShowInrormationAboutProductData, String> countryColumn;
    @FXML
    private TableColumn<ShowInrormationAboutProductData, String> priceColumn;
    @FXML
    private TableColumn<ShowInrormationAboutProductData, String> klSkladColumn;
    @FXML
    private TableColumn<ShowInrormationAboutProductData, String> klBuyColumn;
    @FXML
    private TableColumn<ShowInrormationAboutProductData, String> grossColumn;
    @FXML
    private TableColumn<ShowInrormationAboutProductData, String> sellingColumn;
    @FXML
    private TableColumn<ShowInrormationAboutProductData, String> managementColumn;
    @FXML
    private RadioButton RadioMaterial;

    @FXML
    private Button backwards;

    @FXML
    private Button ButtonReduct;

    @FXML
    private RadioButton RadioName;

    @FXML
    private RadioButton RadioDefinition;

    @FXML
    private RadioButton RadioColor;

    @FXML
    private TextField Znachen;

    @FXML
    private RadioButton RadioCountry;

    @FXML
    private RadioButton RadioPrice;

    @FXML
    private RadioButton RadioKlSklad;

    @FXML
    private RadioButton RadioKlProd;

    @FXML
    private RadioButton RadioCategory;

    @FXML
    private RadioButton RadioGross;

    @FXML
    private RadioButton RadioManagement;

    @FXML
    private RadioButton RadioSelling;

    @FXML
    private Button ButtonUpdate;

    @FXML
    private void initialize() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        ButtonUpdate.setOnAction(event -> {

            tableProfit.getItems().clear();

            this.initData();
            this.idColumn.setCellValueFactory(new PropertyValueFactory("id"));
            this.categoryColumn.setCellValueFactory(new PropertyValueFactory("Category"));
            this.nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
            this.definitionColumn.setCellValueFactory(new PropertyValueFactory("description"));
            this.materialColumn.setCellValueFactory(new PropertyValueFactory("material"));
            this.colorColumn.setCellValueFactory(new PropertyValueFactory("color"));
            this.countryColumn.setCellValueFactory(new PropertyValueFactory("country"));
            this.priceColumn.setCellValueFactory(new PropertyValueFactory("price"));
            this.klSkladColumn.setCellValueFactory(new PropertyValueFactory("klSklad"));
            this.klBuyColumn.setCellValueFactory(new PropertyValueFactory("klBuy"));
            this.grossColumn.setCellValueFactory(new PropertyValueFactory("gross"));
            this.sellingColumn.setCellValueFactory(new PropertyValueFactory("selling"));
            this.managementColumn.setCellValueFactory(new PropertyValueFactory("management"));
            this.tableProfit.setItems(this.ProductData);

        });


        ButtonReduct.setOnAction(event -> {
            ShowInrormationAboutProductData product = tableProfit.getSelectionModel().getSelectedItem();
            System.out.println("Товар, информацию о котором необходимо отредактировать: ");
            System.out.println(" ID: " + product.getId() + "; Категория: " + product.getCategory() + "; Наименование: " + product.getName());

            ShowForReduct red = new ShowForReduct();


            int type=0;
            if(RadioCategory.isSelected()){
                type = 1;
                String parametrText = Znachen.getText().trim();
                if (!parametrText.equals("")) {
                    red.setParametrStr(parametrText);
                } else{
                    alert.setTitle("Внимание!");
                    alert.setHeaderText(null);
                    alert.setContentText("Параметры редактирования не заполнен!");
                    alert.showAndWait();
                }
            } else  if(RadioName.isSelected()){
                type = 2;
                String parametrText = Znachen.getText().trim();
                if (!parametrText.equals("")) {
                    red.setParametrStr(parametrText);
                } else{
                    alert.setTitle("Внимание!");
                    alert.setHeaderText(null);
                    alert.setContentText("Параметры редактирования не заполнен!");
                    alert.showAndWait();
                }
            }else  if(RadioDefinition.isSelected()){
                type = 3;
                String parametrText = Znachen.getText().trim();
                if (!parametrText.equals("")) {
                    red.setParametrStr(parametrText);
                } else{
                    alert.setTitle("Внимание!");
                    alert.setHeaderText(null);
                    alert.setContentText("Параметры редактирования не заполнен!");
                    alert.showAndWait();
                }
            }else  if(RadioMaterial.isSelected()){
                type = 4;
                String parametrText = Znachen.getText().trim();
                if (!parametrText.equals("")) {
                    red.setParametrStr(parametrText);
                } else{
                    alert.setTitle("Внимание!");
                    alert.setHeaderText(null);
                    alert.setContentText("Параметры редактирования не заполнен!");
                    alert.showAndWait();
                }
            }else  if(RadioColor.isSelected()){
                type = 5;
                String parametrText = Znachen.getText().trim();
                if (!parametrText.equals("")) {
                    red.setParametrStr(parametrText);
                } else{
                    alert.setTitle("Внимание!");
                    alert.setHeaderText(null);
                    alert.setContentText("Параметры редактирования не заполнен!");
                    alert.showAndWait();
                }
            }else  if(RadioCountry.isSelected()){
                type = 6;
                String parametrText = Znachen.getText().trim();
                if (!parametrText.equals("")) {
                    red.setParametrStr(parametrText);
                } else{
                    alert.setTitle("Внимание!");
                    alert.setHeaderText(null);
                    alert.setContentText("Параметры редактирования не заполнен!");
                    alert.showAndWait();
                }
            }else  if(RadioPrice.isSelected()){
                type = 7;
                String parametrText = Znachen.getText().trim();
                if (!parametrText.equals("")) {
                    red.setParametrDouble(Double.parseDouble(parametrText));
                } else{
                    alert.setTitle("Внимание!");
                    alert.setHeaderText(null);
                    alert.setContentText("Параметры редактирования не заполнен!");
                    alert.showAndWait();
                }
            }else  if(RadioKlSklad.isSelected()){
                type = 8;
                String parametrText = Znachen.getText().trim();
                if (!parametrText.equals("")) {
                    red.setParametrInt(Integer.parseInt(parametrText));
                } else{
                    alert.setTitle("Внимание!");
                    alert.setHeaderText(null);
                    alert.setContentText("Параметры редактирования не заполнен!");
                    alert.showAndWait();
                }
            }else  if(RadioKlProd.isSelected()){
                type = 9;
                String parametrText = Znachen.getText().trim();
                if (!parametrText.equals("")) {
                    red.setParametrInt(Integer.parseInt(parametrText));
                } else{
                    alert.setTitle("Внимание!");
                    alert.setHeaderText(null);
                    alert.setContentText("Параметры редактирования не заполнен!");
                    alert.showAndWait();
                }
            }else  if(RadioGross.isSelected()){
                type = 10;
                String parametrText = Znachen.getText().trim();
                if (!parametrText.equals("")) {
                    red.setParametrDouble(Double.parseDouble(parametrText));
                } else{
                    alert.setTitle("Внимание!");
                    alert.setHeaderText(null);
                    alert.setContentText("Параметры редактирования не заполнен!");
                    alert.showAndWait();
                }
            }else  if(RadioSelling.isSelected()){
                type = 11;
                String parametrText = Znachen.getText().trim();
                if (!parametrText.equals("")) {
                    red.setParametrDouble(Double.parseDouble(parametrText));
                } else{
                    alert.setTitle("Внимание!");
                    alert.setHeaderText(null);
                    alert.setContentText("Параметры редактирования не заполнен!");
                    alert.showAndWait();
                }
            }else  if(RadioManagement.isSelected()){
                type = 12;
                String parametrText = Znachen.getText().trim();
                if (!parametrText.equals("")) {
                    red.setParametrDouble(Double.parseDouble(parametrText));
                } else{
                    alert.setTitle("Внимание!");
                    alert.setHeaderText(null);
                    alert.setContentText("Параметры редактирования не заполнен!");
                    alert.showAndWait();
                }
            }

            red.setType(type);
            red.setId(product.getId());
            client.write(red);
        });



        backwards.setOnAction(event -> {
            backwards.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/MenuWorkWithInformation.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            WorkWithInformationController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }

    private void initData() {
        ListOfFurniture list ;
        ShowInrormationAboutProductData showInrormationAboutProductData = new ShowInrormationAboutProductData();
        client.write(showInrormationAboutProductData);
        list = (ListOfFurniture) client.read();
        for(int i=0; i<list.getListOfFurniture().size();i++)
        {
            ShowInrormationAboutProductData buffer = new ShowInrormationAboutProductData();
            buffer.setId(list.listOfFurniture.get(i).getId());
            buffer.setCategory(list.listOfFurniture.get(i).getCategory());
            buffer.setName(list.listOfFurniture.get(i).getName());
            buffer.setDescription(list.listOfFurniture.get(i).getDescription());
            buffer.setMaterial(list.listOfFurniture.get(i).getMaterial());
            buffer.setColor(list.listOfFurniture.get(i).getColor());
            buffer.setCountry(list.listOfFurniture.get(i).getCountry());
            buffer.setPrice(list.listOfFurniture.get(i).getPrice());
            buffer.setKlSklad(list.listOfFurniture.get(i).getKlSklad());
            buffer.setKlBuy(list.listOfFurniture.get(i).getKlBuy());
            buffer.setGross(list.listOfFurniture.get(i).getGross());
            buffer.setSelling(list.listOfFurniture.get(i).getSelling());
            buffer.setManagement(list.listOfFurniture.get(i).getManagement());
            ProductData.add(buffer);
        }
    }
}
