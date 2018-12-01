package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.AutorizationData;
import sample.Client;
import sample.Controller;
import sample.Lists.ListOfFurniture;
import sample.SerializeClasses.BuyData;
import sample.SerializeClasses.ShowInrormationAboutProductData;

import java.io.IOException;

public class BuyProductController {
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
    private Button ButtonZakaz;

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
    private void initialize() {

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
            this.tableProfit.setItems(this.ProductData);

        });


        ButtonZakaz.setOnAction(event -> {
            ShowInrormationAboutProductData product = tableProfit.getSelectionModel().getSelectedItem();

            System.out.println("Товар, который Вы желаете преобрести: ");
            System.out.println(" ID: " + product.getId() + "; Категория: " + product.getCategory() + "; Наименование: " + product.getName()
                    + "; Краткое описание: " + product.getDescription()+ "; Материал: " + product.getMaterial() + "; Цвет: " + product.getColor() +
                    "; Страна: " +product.getCountry() + "; Цена: " + product.getPrice() + "; Количество на складе: " + product.getKlSklad());
            BuyData buyList = new  BuyData();

            buyList.setId(product.getId());
            client.write(buyList);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            boolean res = client.readBoolean();
            System.out.println(res);
            if(res == false){
                alert.setTitle("Увы!");
                alert.setHeaderText(null);
                alert.setContentText("К сожалению, товара " + product.getName() + " нет в наличии! Пожалуйста, посмотрите другую нашу продукцию, возможно Вы найдете что-то подходящее!");
                alert.showAndWait();
            }else{
                alert.setTitle("УРА!");
                alert.setHeaderText(null);
                alert.setContentText("Товар " + product.getName() + " удачно заказан!");
                alert.showAndWait();
            }
        });


        backwards.setOnAction(event -> {
            backwards.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/appForClient.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
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
            ProductData.add(buffer);
        }

    }

}

