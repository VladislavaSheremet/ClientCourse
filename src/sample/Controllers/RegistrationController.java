package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Client;
import sample.Controller;
import sample.SerializeClasses.RegistrationData;

import java.io.IOException;

public class RegistrationController {

    Client client;
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client;}

    @FXML
    private TextField signUp_UserName;

    @FXML
    private TextField signUp_login;

    @FXML
    private TextField signUp_email;

    @FXML
    private Button RegisterButton;

    @FXML
    private TextField signUp_TelephoneNumber;

    @FXML
    private Button backwards;

    @FXML
    private TextField signUp_UserSurn;

    @FXML
    private PasswordField signUp_password;

    @FXML
    private PasswordField signUp_password1;

    @FXML
    void initialize() {
        //КНОПКА "ЗАРЕГИСТРИРОВАТЬСЯ"
        RegisterButton.setOnAction(event -> {
            signUpNewUser();
        });

        //КНОПКА "НАЗАД"

        backwards.setOnAction(event -> {
            backwards.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/sample.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Controller controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }

    private void signUpNewUser() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        String UserNameField = signUp_UserName.getText().trim();
        String UserSurnameField = signUp_UserSurn.getText().trim();
        String EmailField = signUp_email.getText().trim();
        String TelephoneField = signUp_TelephoneNumber.getText().trim();
        String LoginField = signUp_login.getText().trim();
        String PasswordField = signUp_password.getText().trim();
        String PasswordField1 = signUp_password1.getText().trim();
        if(UserNameField.equals("") || UserSurnameField.equals("") || EmailField.equals("") ||
                TelephoneField.equals("") || LoginField.equals("") || PasswordField.equals("") || PasswordField1.equals("")){
            alert.setTitle("Внимание!");
            alert.setHeaderText(null);
            alert.setContentText("Некоторые данные не заполнены!");
            alert.showAndWait();
        }
        else {

            if (PasswordField.equals(PasswordField1)) {

                RegistrationData registrationData = new RegistrationData();
                registrationData.setUserName(UserNameField);
                registrationData.setUserSurname(UserSurnameField);
                registrationData.setEmail(EmailField);
                registrationData.setTelephoneNumber(TelephoneField);
                registrationData.setLogin(LoginField);
                registrationData.setPassword(PasswordField);
                client.write(registrationData);
                System.out.println("ОТПРАВЛЕНО: " + registrationData);

                boolean Result = client.readBoolean();
                if(Result == true){
                    alert.setTitle("Внимание!");
                    alert.setHeaderText(null);
                    alert.setContentText("Вы успешно зарегестрированы!");
                    alert.showAndWait();
                }
                else{
                    alert.setTitle("Внимание!");
                    alert.setHeaderText(null);
                    alert.setContentText("Пользователь с таким логином уже существует!");
                    alert.showAndWait();
                }
            } else{
                alert.setTitle("Внимание!");
                alert.setHeaderText(null);
                alert.setContentText("Пароль подтвержден неверно!");
                alert.showAndWait();
            }
        }
    }
}

