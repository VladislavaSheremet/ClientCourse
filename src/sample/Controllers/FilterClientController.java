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
import sample.Lists.ListOfFilter;
import sample.SerializeClasses.ShowForFilter;

import java.io.IOException;

public class FilterClientController {
   Client client;
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    @FXML
    private ObservableList<ShowForFilter> ProductData = FXCollections.observableArrayList();

    @FXML
    private TableView<ShowForFilter> tableProfit;

    @FXML
    private TableColumn<ShowForFilter, Integer> idColumn;
    @FXML
    private TableColumn<ShowForFilter, String> categoryColumn;
    @FXML
    private TableColumn<ShowForFilter, String> nameColumn;
    @FXML
    private TableColumn<ShowForFilter, String> definitionColumn;
    @FXML
    private TableColumn<ShowForFilter, String> materialColumn;
    @FXML
    private TableColumn<ShowForFilter, String> colorColumn;
    @FXML
    private TableColumn<ShowForFilter, String> countryColumn;
    @FXML
    private TableColumn<ShowForFilter, String> priceColumn;
    @FXML
    private TableColumn<ShowForFilter, String> klSkladColumn;
    @FXML
    private TableColumn<ShowForFilter, String> klBuyColumn;
    @FXML
    private TableColumn<ShowForFilter, String> grossColumn;
    @FXML
    private TableColumn<ShowForFilter, String> sellingColumn;
    @FXML
    private TableColumn<ShowForFilter, String> managementColumn;

    @FXML
    private Button ButtonFilter;

    @FXML
    private RadioButton RadioName;

    @FXML
    private RadioButton RadioPrice;

    @FXML
    private RadioButton RadioKlSklad;

    @FXML
    private RadioButton RadioKlProd;

    @FXML
    private TextField Ot;

    @FXML
    private TextField Do;

    @FXML
    private Button backwards;





    @FXML
    private void initialize() {

        ButtonFilter.setOnAction(event -> {

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
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/WorkInformationClient.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            WorkInformationClientController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }

    private void initData() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        ListOfFilter list;
        ShowForFilter showInrormation = new ShowForFilter();
        int type=0;
        if(RadioName.isSelected()){
            type = 1;
            String otText = Ot.getText().trim();
            String doText = Do.getText().trim();
            if (!otText.equals("") && !doText.equals("")) {
                showInrormation.setOtInt(Integer.parseInt(otText));
                showInrormation.setDoInt(Integer.parseInt(doText));
            } else{
                alert.setTitle("Внимание!");
                alert.setHeaderText(null);
                alert.setContentText("Параметры фильтрации не заполнены!");
                alert.showAndWait();
            }
        } else if(RadioPrice.isSelected()){
            type = 2;
            String otText = Ot.getText().trim();
            String doText = Do.getText().trim();
            if (!otText.equals("") && !doText.equals("")) {
                showInrormation.setOtDouble(Double.parseDouble(otText));
                showInrormation.setDoDouble(Double.parseDouble(doText));
            }else{
                alert.setTitle("Внимание!");
                alert.setHeaderText(null);
                alert.setContentText("Параметры фильтрации не заполнены!");
                alert.showAndWait();
            }
        } else if(RadioKlSklad.isSelected()) {
            type = 3;
            String otText = Ot.getText().trim();
            String doText = Do.getText().trim();
            if (!otText.equals("") && !doText.equals("")) {
                showInrormation.setOtInt(Integer.parseInt(otText));
                showInrormation.setDoInt(Integer.parseInt(doText));
            }else{
                alert.setTitle("Внимание!");
                alert.setHeaderText(null);
                alert.setContentText("Параметры фильтрации не заполнены!");
                alert.showAndWait();
            }
        } else if(RadioKlProd.isSelected()){
            type = 4;
            String otText = Ot.getText().trim();
            String doText = Do.getText().trim();
            if (!otText.equals("") && !doText.equals("")) {
                showInrormation.setOtInt(Integer.parseInt(otText));
                showInrormation.setDoInt(Integer.parseInt(doText));
            }else{
                alert.setTitle("Внимание!");
                alert.setHeaderText(null);
                alert.setContentText("Параметры фильтрации не заполнены!");
                alert.showAndWait();
            }
        }
        showInrormation.setType(type);
        client.write(showInrormation);

        list = (ListOfFilter) client.read();
        for(int i=0; i<list.getListOfFilter().size();i++)
        {
            ShowForFilter buffer = new ShowForFilter();
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

