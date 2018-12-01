package sample.Controllers;

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
import sample.Lists.ListOfResult;
import sample.SerializeClasses.ShowResultProfit;

import java.io.IOException;

public class ShowResultProfitController {

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
    private ObservableList<ShowResultProfit> ProductData = FXCollections.observableArrayList();

    @FXML
    private TableView<ShowResultProfit> tableProfit;

    @FXML
    private TableColumn<ShowResultProfit, Integer> idColumn;
    @FXML
    private TableColumn<ShowResultProfit, String> categoryColumn;
    @FXML
    private TableColumn<ShowResultProfit, String> nameColumn;
    @FXML
    private TableColumn<ShowResultProfit, String> priceColumn;
    @FXML
    private TableColumn<ShowResultProfit, String> klSkladColumn;
    @FXML
    private TableColumn<ShowResultProfit, String> klBuyColumn;
    @FXML
    private TableColumn<ShowResultProfit, String> grossColumn;
    @FXML
    private TableColumn<ShowResultProfit, String> sellingColumn;
    @FXML
    private TableColumn<ShowResultProfit, String> managementColumn;
    @FXML
    private TableColumn<ShowResultProfit, String> resultColumn;

    @FXML
    private void initialize() {

        ButtonUpdate.setOnAction(event -> {

            tableProfit.getItems().clear();

            this.initData();
            this.idColumn.setCellValueFactory(new PropertyValueFactory("id"));
            this.resultColumn.setCellValueFactory(new PropertyValueFactory("result"));
            this.categoryColumn.setCellValueFactory(new PropertyValueFactory("Category"));
            this.nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
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
        ListOfResult list ;
        ShowResultProfit show= new ShowResultProfit();
        client.write(show);
        list = (ListOfResult) client.read();
        for(int i=0; i<list.getListOfResult().size();i++)
        {
            ShowResultProfit buffer = new ShowResultProfit();
            buffer.setId(list.listOfFurniture.get(i).getId());
            buffer.setResult(list.listOfFurniture.get(i).getResult());
            buffer.setCategory(list.listOfFurniture.get(i).getCategory());
            buffer.setName(list.listOfFurniture.get(i).getName());
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
