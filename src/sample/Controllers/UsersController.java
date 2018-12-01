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
import sample.Client;
import sample.Lists.ListOfUsers;
import sample.SerializeClasses.BlackListData;
import sample.SerializeClasses.BlackListDelData;
import sample.SerializeClasses.ShowClientData;

import java.io.IOException;

public class UsersController {
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
    private Button ButtonBlck;

    @FXML
    private Button ButtonBlckDl;

    @FXML
    private ObservableList<ShowClientData> UsersData = FXCollections.observableArrayList();

    @FXML
    private TableView<ShowClientData> tableUsers;

    @FXML
    private TableColumn<ShowClientData, Integer> idColumn;
    @FXML
    private TableColumn<ShowClientData, String> loginColumn;
    @FXML
    private TableColumn<ShowClientData, String> nameColumn;
    @FXML
    private TableColumn<ShowClientData, String> surnameColumn;
    @FXML
    private TableColumn<ShowClientData, Integer> telephoneColumn;
    @FXML
    private TableColumn<ShowClientData, String> emailColumn;
    @FXML
    private TableColumn<ShowClientData, String> blackColumn;


    @FXML
    private void initialize() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        ButtonUpdate.setOnAction(event -> {
            tableUsers.getItems().clear();
            this.initData();
            this.idColumn.setCellValueFactory(new PropertyValueFactory("id"));
            this.loginColumn.setCellValueFactory(new PropertyValueFactory("login"));
            this.nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
            this.surnameColumn.setCellValueFactory(new PropertyValueFactory("surname"));
            this.telephoneColumn.setCellValueFactory(new PropertyValueFactory("telephone"));
            this.emailColumn.setCellValueFactory(new PropertyValueFactory("email"));
            this.blackColumn.setCellValueFactory(new PropertyValueFactory("black"));
            this.tableUsers.setItems(this.UsersData);

        });


        ButtonBlck.setOnAction(event -> {
            ShowClientData user = tableUsers.getSelectionModel().getSelectedItem();
            System.out.println("Пользователь, которого необходимо добавить в ЧС: ");
            System.out.println(" ID: " + user.getId() + "; Логин: " + user.getLogin() + "; Имя: " + user.getName()
                    + "; Фамилия: " + user.getSurname()+ "; Телефон: " + user.getTelephone() + "; E-mail: " + user.getEmail());
            BlackListData blackList = new  BlackListData();
            blackList.setLogin(user.getLogin());
            client.write(blackList);
            alert.setTitle("Внимание!");
            alert.setHeaderText(null);
            alert.setContentText("Пользователь " + user.getLogin() + " добавлен в черный список!");
            alert.showAndWait();
        });

        ButtonBlckDl.setOnAction(event -> {
            ShowClientData user = tableUsers.getSelectionModel().getSelectedItem();
            System.out.println("Пользователь, которого необходимо удалить из ЧС: ");
            System.out.println(" ID: " + user.getId() + "; Логин: " + user.getLogin() + "; Имя: " + user.getName()
                    + "; Фамилия: " + user.getSurname()+ "; Телефон: " + user.getTelephone() + "; E-mail: " + user.getEmail());
            BlackListDelData blackList = new  BlackListDelData();
            blackList.setLogin(user.getLogin());
            client.write(blackList);
            alert.setTitle("Внимание!");
            alert.setHeaderText(null);
            alert.setContentText("Пользователь " + user.getLogin() + " удален из черного списка!");
            alert.showAndWait();
        });

        backwards.setOnAction(event -> {
            backwards.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/app.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            MenuController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }

    private void initData() {
        ListOfUsers list ;
        ShowClientData showClient = new ShowClientData();
        client.write(showClient);
        list = (ListOfUsers) client.read();
        for(int i=0; i<list.getListOfUser().size();i++)
        {
            ShowClientData buffer = new ShowClientData();
            buffer.setId(list.listOfUser.get(i).getId());
            buffer.setLogin(list.listOfUser.get(i).getLogin());
            buffer.setName(list.listOfUser.get(i).getName());
            buffer.setSurname(list.listOfUser.get(i).getSurname());
            buffer.setTelephone(list.listOfUser.get(i).getTelephone());
            buffer.setEmail(list.listOfUser.get(i).getEmail());
            buffer.setBlack(list.listOfUser.get(i).getBlack());
            UsersData.add(buffer);
        }
    }
}