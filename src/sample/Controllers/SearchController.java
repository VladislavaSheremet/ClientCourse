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
import sample.Lists.ListOfSearch;
import sample.SerializeClasses.ShowForSearch;

import java.io.IOException;

public class SearchController {

    Client client;
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    @FXML
    private ObservableList<ShowForSearch> ProductData = FXCollections.observableArrayList();

    @FXML
    private TableView<ShowForSearch> tableProfit;

    @FXML
    private TableColumn<ShowForSearch, Integer> idColumn;
    @FXML
    private TableColumn<ShowForSearch, String> categoryColumn;
    @FXML
    private TableColumn<ShowForSearch, String> nameColumn;
    @FXML
    private TableColumn<ShowForSearch, String> definitionColumn;
    @FXML
    private TableColumn<ShowForSearch, String> materialColumn;
    @FXML
    private TableColumn<ShowForSearch, String> colorColumn;
    @FXML
    private TableColumn<ShowForSearch, String> countryColumn;
    @FXML
    private TableColumn<ShowForSearch, String> priceColumn;
    @FXML
    private TableColumn<ShowForSearch, String> klSkladColumn;
    @FXML
    private TableColumn<ShowForSearch, String> klBuyColumn;
    @FXML
    private TableColumn<ShowForSearch, String> grossColumn;
    @FXML
    private TableColumn<ShowForSearch, String> sellingColumn;
    @FXML
    private TableColumn<ShowForSearch, String> managementColumn;

    @FXML
    private RadioButton RadioMaterial;

    @FXML
    private Button backwards;

    @FXML
    private Button ButtonSearch;

    @FXML
    private RadioButton RadioID;

    @FXML
    private RadioButton RadioName;

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
    private void initialize() {

        ButtonSearch.setOnAction(event -> {

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
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        ListOfSearch list;
        ShowForSearch showInrormation = new ShowForSearch();
        int type=0;
        if(RadioID.isSelected()){
            type = 1;
            String parametrText = Znachen.getText().trim();
            if (!parametrText.equals("")) {
                showInrormation.setParametrInt(Integer.parseInt(parametrText));
            } else{
                alert.setTitle("Внимание!");
                alert.setHeaderText(null);
                alert.setContentText("Параметры поиска не заполнен!");
                alert.showAndWait();
            }
        } else if(RadioName.isSelected()){
            type = 2;
            String parametrText = Znachen.getText().trim();
            if (!parametrText.equals("")) {
                showInrormation.setParametrStr(parametrText);
            }else{
                alert.setTitle("Внимание!");
                alert.setHeaderText(null);
                alert.setContentText("Параметры поиска не заполнен!");
                alert.showAndWait();
            }
        } else if(RadioMaterial.isSelected()) {
            type = 3;
            String parametrText = Znachen.getText().trim();
            if (!parametrText.equals("")) {
                showInrormation.setParametrStr(parametrText);
            }else{
                alert.setTitle("Внимание!");
                alert.setHeaderText(null);
                alert.setContentText("Параметры поиска не заполнен!");
                alert.showAndWait();
            }
        } else if(RadioColor.isSelected()){
            type = 4;
            String parametrText = Znachen.getText().trim();
            if (!parametrText.equals("")) {
                showInrormation.setParametrStr(parametrText);
            }else{
                alert.setTitle("Внимание!");
                alert.setHeaderText(null);
                alert.setContentText("Параметры поиска не заполнен!");
                alert.showAndWait();
            }
        } else if(RadioCountry.isSelected()){
            type = 5;
            String parametrText = Znachen.getText().trim();
            if (!parametrText.equals("")) {
                showInrormation.setParametrStr(parametrText);
            }else{
                alert.setTitle("Внимание!");
                alert.setHeaderText(null);
                alert.setContentText("Параметры поиска не заполнен!");
                alert.showAndWait();
            }
        } else if(RadioPrice.isSelected()){
            type = 6;
            String parametrText = Znachen.getText().trim();
            if (!parametrText.equals("")) {
                showInrormation.setParametrDouble(Double.parseDouble(parametrText));
            }else{
                alert.setTitle("Внимание!");
                alert.setHeaderText(null);
                alert.setContentText("Параметры поиска не заполнен!");
                alert.showAndWait();
            }
        } else if(RadioKlSklad.isSelected()){
            type = 7;
            String parametrText = Znachen.getText().trim();
            if (!parametrText.equals("")) {
                showInrormation.setParametrInt(Integer.parseInt(parametrText));
            }else{
                alert.setTitle("Внимание!");
                alert.setHeaderText(null);
                alert.setContentText("Параметры поиска не заполнен!");
                alert.showAndWait();
            }
        } else if(RadioKlProd.isSelected()){
            type = 8;
            String parametrText = Znachen.getText().trim();
            if (!parametrText.equals("")) {
                showInrormation.setParametrInt(Integer.parseInt(parametrText));
            }else{
                alert.setTitle("Внимание!");
                alert.setHeaderText(null);
                alert.setContentText("Параметры поиска не заполнен!");
                alert.showAndWait();
            }
        }
        showInrormation.setType(type);
        client.write(showInrormation);

       list = (ListOfSearch) client.read();
        for(int i=0; i<list.getListOfSearch().size();i++)
        {
            ShowForSearch buffer = new ShowForSearch();
            buffer.setId(list.listOfSearch.get(i).getId());
            buffer.setCategory(list.listOfSearch.get(i).getCategory());
            buffer.setName(list.listOfSearch.get(i).getName());
            buffer.setDescription(list.listOfSearch.get(i).getDescription());
            buffer.setMaterial(list.listOfSearch.get(i).getMaterial());
            buffer.setColor(list.listOfSearch.get(i).getColor());
            buffer.setCountry(list.listOfSearch.get(i).getCountry());
            buffer.setPrice(list.listOfSearch.get(i).getPrice());
            buffer.setKlSklad(list.listOfSearch.get(i).getKlSklad());
            buffer.setKlBuy(list.listOfSearch.get(i).getKlBuy());
            buffer.setGross(list.listOfSearch.get(i).getGross());
            buffer.setSelling(list.listOfSearch.get(i).getSelling());
            buffer.setManagement(list.listOfSearch.get(i).getManagement());
            ProductData.add(buffer);
        }
    }

}
