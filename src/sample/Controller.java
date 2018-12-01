package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Controllers.BuyProductController;
import sample.Controllers.MenuController;
import sample.Controllers.RegistrationController;
import sample.Controllers.appClientController;
import sample.SerializeClasses.BlackListProverka;
import sample.SerializeClasses.BuyData;
import sample.SerializeClasses.StatusProv;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    Client client;
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    @FXML
    private Button CheckInButton;

    @FXML
    private Button ComeInButton;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;


    @FXML
    void initialize() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        //КНОПКА ВОЙТИ
        ComeInButton.setOnAction(event -> {
            //Обработка вводимых данных
            String loginText = login_field.getText().trim();
            String loginPassword = password_field.getText().trim();

            if (!loginText.equals("") && !loginPassword.equals("")){

                AutorizationData autorizationData = new AutorizationData();
                autorizationData.setLogin(loginText);
                autorizationData.setPassword(loginPassword);
                client.write(autorizationData);


                boolean Result = client.readBoolean();
                System.out.println("РЕЗУЛЬТАТ АВТОРИЗАЦИИ: " + Result);
                if(Result == true){

                    boolean k = true;
                    StatusProv prov = new StatusProv();
                    prov.isK(k);
                    client.write(prov);
                    int resultStatus = client.readInt();
                    System.out.println("СТАТУС: " + resultStatus);
                    if(resultStatus == 1) {
                        alert.setTitle("Внимание!");
                        alert.setHeaderText(null);
                        alert.setContentText("Добро пожаловать, администратор!");
                        alert.showAndWait();

                        ComeInButton.getScene().getWindow().hide();
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/sample/FXMLFiles/app.fxml"));
                    try{
                        loader.load();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                    MenuController controller = loader.getController();
                    controller.setClient(client);
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                    } else if (resultStatus == 2) {


                        BlackListProverka please = new BlackListProverka();
                        please.setLogin(loginText);
                        client.write(please);
                        boolean black = client.readBoolean();
                        if (black == false) {
                            alert.setTitle("Внимание!");
                            alert.setHeaderText(null);
                            alert.setContentText("Добро пожаловать, " + loginText + "!");
                            alert.showAndWait();

                            ComeInButton.getScene().getWindow().hide();
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
                            stage.showAndWait();
                        }else{
                            alert.setTitle("Внимание!");
                            alert.setHeaderText(null);
                            alert.setContentText("К сожалению, Вы находитесь в черном списке и не имеете возможности работы с приложением!");
                            alert.showAndWait();
                        }
                    }

                }
                else{
                    alert.setTitle("Внимание!");
                    alert.setHeaderText(null);
                    alert.setContentText("Пользователя с такими данными не существует!");
                    alert.showAndWait();
                }
            }else{
                alert.setTitle("Внимание!");
                alert.setHeaderText(null);
                alert.setContentText("Некоторые данные не заполнены!");
                alert.showAndWait();
            }
        });

        CheckInButton.setOnAction(event -> {
            CheckInButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/registration.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            RegistrationController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }
}

