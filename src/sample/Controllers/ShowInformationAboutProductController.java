package sample.Controllers;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Client;
import javafx.scene.control.Button;
import sample.Lists.ListOfFurniture;
import sample.SerializeClasses.BlackListDelData;
import sample.SerializeClasses.DeleteProduct;
import sample.SerializeClasses.ShowClientData;
import sample.SerializeClasses.ShowInrormationAboutProductData;


import java.io.IOException;

public class ShowInformationAboutProductController {
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
    private Button ButtonDelete;

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

        ButtonDelete.setOnAction(event -> {
            ShowInrormationAboutProductData product = tableProfit.getSelectionModel().getSelectedItem();
            System.out.println("Товар, информацию о котором необходимо удалить: ");
            System.out.println(" ID: " + product.getId() + "; Категория: " + product.getCategory() + "; Наименование: " + product.getName());
            DeleteProduct del = new  DeleteProduct();
            del.setId(product.getId());
            client.write(del);
            alert.setTitle("Внимание!");
            alert.setHeaderText(null);
            alert.setContentText("Информация о товаре \"" + product.getName() + "\" удалена!");
            alert.showAndWait();
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

