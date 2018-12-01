package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Client;
import sample.Lists.ListForAnalis;
import sample.SerializeClasses.DataForAnalis;

import java.io.IOException;

public class MyKorzinController {

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
    private BarChart<String, Integer> barChar;

    @FXML
    void initialize() {
        backwards.setOnAction(event -> {
            backwards.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXMLFiles/appForClient.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            appClientController controller = loader.getController();
            controller.setClient(client);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        ButtonUpdate.setOnAction(event -> {
            this.initData();
        });
    }

    private void initData() {
        ListForAnalis list ;
        DataForAnalis data = new DataForAnalis();
        client.write(data);

        barChar.getData().clear();
        list = (ListForAnalis) client.read();

        XYChart.Series set = new XYChart.Series();
        set.setName("Количество проданных единиц");

        for(int i=0; i<list.getlistForAnalis().size();i++)
        {
            DataForAnalis buffer = new DataForAnalis();
            buffer.setName(list.listForAnalis.get(i).getName());
            buffer.setKl(list.listForAnalis.get(i).getKl());
            set.getData().add(new XYChart.Data<>(buffer.getName(), buffer.getKl()));
        }
        barChar.getData().addAll(set);
    }

}
