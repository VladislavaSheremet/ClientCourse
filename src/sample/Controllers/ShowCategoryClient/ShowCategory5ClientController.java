package sample.Controllers.ShowCategoryClient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Client;
import sample.Controllers.RangeForClientController;
import sample.Lists.ListOfFurnitureCategories;
import sample.SerializeClasses.ShowInformationForCategory;

import java.io.IOException;

public class ShowCategory5ClientController {
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
    private Button ButtonUpdate;

    @FXML
    private ObservableList<ShowInformationForCategory> ProductData = FXCollections.observableArrayList();

    @FXML
    private TableView<ShowInformationForCategory> tableProfit;

    @FXML
    private TableColumn<ShowInformationForCategory, Integer> idColumn;
    @FXML
    private TableColumn<ShowInformationForCategory, String> nameColumn;
    @FXML
    private TableColumn<ShowInformationForCategory, String> definitionColumn;
    @FXML
    private TableColumn<ShowInformationForCategory, String> materialColumn;
    @FXML
    private TableColumn<ShowInformationForCategory, String> colorColumn;
    @FXML
    private TableColumn<ShowInformationForCategory, String> countryColumn;
    @FXML
    private TableColumn<ShowInformationForCategory, String> priceColumn;
    @FXML
    private TableColumn<ShowInformationForCategory, String> klSkladColumn;

    @FXML
    private void initialize() {

        ButtonUpdate.setOnAction(event -> {
            tableProfit.getItems().clear();
            this.initData();
            this.idColumn.setCellValueFactory(new PropertyValueFactory("id"));
            this.nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
            this.definitionColumn.setCellValueFactory(new PropertyValueFactory("description"));
            this.materialColumn.setCellValueFactory(new PropertyValueFactory("material"));
            this.colorColumn.setCellValueFactory(new PropertyValueFactory("color"));
            this.countryColumn.setCellValueFactory(new PropertyValueFactory("country"));
            this.priceColumn.setCellValueFactory(new PropertyValueFactory("price"));
            this.klSkladColumn.setCellValueFactory(new PropertyValueFactory("klScklad"));
            this.tableProfit.setItems(this.ProductData);
        });

        backwards.setOnAction(event -> {
            backwards.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/RangeForClient.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            RangeForClientController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }

    private void initData() {
        ListOfFurnitureCategories list;
        ShowInformationForCategory showInrormationAboutProductData = new ShowInformationForCategory();
        showInrormationAboutProductData.setCategory(5);
        client.write(showInrormationAboutProductData);

        list = (ListOfFurnitureCategories) client.read();
        for (int i = 0; i < list.getListOfFurniture().size(); i++) {
            ShowInformationForCategory buffer = new ShowInformationForCategory();
            buffer.setId(list.listOfFurniture.get(i).getId());
            buffer.setCategory(list.listOfFurniture.get(i).getCategory());
            buffer.setName(list.listOfFurniture.get(i).getName());
            buffer.setDescription(list.listOfFurniture.get(i).getDescription());
            buffer.setMaterial(list.listOfFurniture.get(i).getMaterial());
            buffer.setColor(list.listOfFurniture.get(i).getColor());
            buffer.setCountry(list.listOfFurniture.get(i).getCountry());
            buffer.setPrice(list.listOfFurniture.get(i).getPrice());
            buffer.setKlScklad(list.listOfFurniture.get(i).getKlScklad());
            ProductData.add(buffer);
        }
    }
}