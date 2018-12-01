package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Client;
import sample.Lists.ListOfFurniture;
import sample.Lists.ListOfSort;
import sample.SerializeClasses.ShowForSorting;
import sample.SerializeClasses.ShowInrormationAboutProductData;

import java.io.IOException;

public class SortingController {

    Client client;
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    @FXML
    private ObservableList<ShowForSorting> ProductData = FXCollections.observableArrayList();

    @FXML
    private TableView<ShowForSorting> tableProfit;

    @FXML
    private TableColumn<ShowForSorting, Integer> idColumn;
    @FXML
    private TableColumn<ShowForSorting, String> categoryColumn;
    @FXML
    private TableColumn<ShowForSorting, String> nameColumn;
    @FXML
    private TableColumn<ShowForSorting, String> definitionColumn;
    @FXML
    private TableColumn<ShowForSorting, String> materialColumn;
    @FXML
    private TableColumn<ShowForSorting, String> colorColumn;
    @FXML
    private TableColumn<ShowForSorting, String> countryColumn;
    @FXML
    private TableColumn<ShowForSorting, String> priceColumn;
    @FXML
    private TableColumn<ShowForSorting, String> klSkladColumn;
    @FXML
    private TableColumn<ShowForSorting, String> klBuyColumn;
    @FXML
    private TableColumn<ShowForSorting, String> grossColumn;
    @FXML
    private TableColumn<ShowForSorting, String> sellingColumn;
    @FXML
    private TableColumn<ShowForSorting, String> managementColumn;

    @FXML
    private Button ButtonSort;

    @FXML
    private RadioButton RadioName;

    @FXML
    private RadioButton RadioPrice;

    @FXML
    private RadioButton RadioCountry;

    @FXML
    private RadioButton SortVozr;

    @FXML
    private RadioButton SortUb;

    @FXML
    private Button backwards;


    @FXML
    private void initialize() {

        ButtonSort.setOnAction(event -> {

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
        ListOfSort list;
        ShowForSorting showInrormation = new ShowForSorting();
        int type = 0;
        if(RadioName.isSelected() && SortVozr.isSelected()){
            type = 1;
        } else if(RadioName.isSelected() && SortUb.isSelected()){
            type = 2;
        } else if(RadioPrice.isSelected() && SortVozr.isSelected()){
            type = 3;
        } else if(RadioPrice.isSelected() && SortUb.isSelected()) {
            type = 4;
        } else if(RadioCountry.isSelected() && SortVozr.isSelected()){
            type = 5;
        } else if(RadioCountry.isSelected() && SortUb.isSelected()) {
            type = 6;
        }

        showInrormation.setType(type);
        client.write(showInrormation);

        list = (ListOfSort) client.read();
        for(int i=0; i<list.getListOfSort().size();i++)
        {
            ShowForSorting buffer = new ShowForSorting();
            buffer.setId(list.listOfSort.get(i).getId());
            buffer.setCategory(list.listOfSort.get(i).getCategory());
            buffer.setName(list.listOfSort.get(i).getName());
            buffer.setDescription(list.listOfSort.get(i).getDescription());
            buffer.setMaterial(list.listOfSort.get(i).getMaterial());
            buffer.setColor(list.listOfSort.get(i).getColor());
            buffer.setCountry(list.listOfSort.get(i).getCountry());
            buffer.setPrice(list.listOfSort.get(i).getPrice());
            buffer.setKlSklad(list.listOfSort.get(i).getKlSklad());
            buffer.setKlBuy(list.listOfSort.get(i).getKlBuy());
            buffer.setGross(list.listOfSort.get(i).getGross());
            buffer.setSelling(list.listOfSort.get(i).getSelling());
            buffer.setManagement(list.listOfSort.get(i).getManagement());
            ProductData.add(buffer);
        }
    }
}
