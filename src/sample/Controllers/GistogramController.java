package sample.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import sample.Client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Lists.ListForGistogram;
import sample.SerializeClasses.DataForGistogram;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class GistogramController {

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
    private Button ButtonFilter;

    @FXML
    private Button ButtonOtchot;

    @FXML
    private BarChart<String, Double> barChar;

    private static String fileName = "C://Users//User//Desktop//COURSE PROJECT//Report.txt";

    @FXML
    void initialize() {
        ButtonFilter.setOnAction(event -> {
            this.initData();
        });

        ButtonOtchot.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            ListForGistogram list = null;
            DataForGistogram data = new DataForGistogram();
            client.write(data);
            String product = "";
            String productMin = "";
            double mMax, max = 0, mMin;
            int number=0, number1=0;
            list = (ListForGistogram) client.read();
            for(int i=0; i<list.getlistForGistogram().size();i++)
            {
                product = list.listForGistogram.get(number).getName();
                mMax = list.listForGistogram.get(i).getResult();
                if(max < mMax){
                    max = mMax;
                    number = i;
                }
            }
            double min = max;
            for(int i=0; i<list.getlistForGistogram().size();i++)
            {
                productMin = list.listForGistogram.get(number1).getName();
                mMin = list.listForGistogram.get(i).getResult();
                if(min > mMin){
                    min = mMin;
                    number1 = i;
                }
            }
            String lineSeparator = System.getProperty("line.separator");
            File file = new File(fileName);
            try {
                if(!file.exists()){
                    file.createNewFile();
                }
                PrintWriter out = new PrintWriter(file.getAbsoluteFile());
                try {
                    out.print(" ОТЧЕТ ПО РЕЗУЛЬТАТАМ РАСЧЕТОВ ПРИБЫЛИ ОТ ПРОДАЖ" + lineSeparator + lineSeparator + lineSeparator +  " Максимальную прибыль от продаж - " + max + " - имеет товар " + product + "."+ lineSeparator +
                              " Данный вид продукции является наиболее популярным и востребованным среди покупателей нашего мебельного салона." + lineSeparator + lineSeparator +
                              " Минимальную прибыльот продаж - " + min + " - имеет товар " + product + "." + lineSeparator +
                              " Данный вид продукции в меньшей степени заинтересовал покупателей нашего мебельного слаона." + lineSeparator +
                              " Необходимо принять меры для улучшения результатов прибыли от продаж по данному виду продукции." + lineSeparator + lineSeparator +
                              " (!) Стоит обратить внимание, что на прибыль от продаж оказывают влияние следующие основные факторы: " + lineSeparator +
                              " · объем продаж (чем больше организация продает рентабельной продукции, тем больше она получает прибыли);" + lineSeparator +
                              " · структура продаж (отдельные виды продаваемой продукции работ, услуг имеют различную рентабельность. Некоторые " + lineSeparator +
                              "   из них могут оказаться убыточными для предприятия. Поэтому от того, каков ассортимент продаваемой продукции, во" + lineSeparator +
                              "   многом зависит величина прибыли организации);" + lineSeparator +
                              " · цены на продаваемые продукцию, работы и услуги (их повыщение позволяет предприятию получить дополнительную прибыль." + lineSeparator +
                              "   Однако изменение этого фактора имеет ограничения в условиях высокой конкуренции, так как продавцы строят свою ценовую" + lineSeparator +
                              "   политику исходя не столько из уровня приемлемой для себя рентабельности, сколько из среднего уровня цен на аналогичные товары, работы, услуги);" + lineSeparator +
                              " · уровень затрат, включенных в себестоимость продукции (их рост приводит к уменьшению прибыли в том же размере).");
                    alert.setTitle("Внимание!");
                    alert.setHeaderText(null);
                    alert.setContentText("Отчет по результатам расчетов прибыли записан в файл \"Report.txt\".");
                    alert.showAndWait();
                } finally {
                    out.close();
                }
            } catch(IOException e) {
                throw new RuntimeException(e);
            }
        });

        backwards.setOnAction(event -> {
            backwards.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample//FXMLFiles/app.fxml"));
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
            stage.show();
        });
    }

    private void initData() {
        ListForGistogram list ;
        DataForGistogram data = new DataForGistogram();
        client.write(data);

        barChar.getData().clear();
        list = (ListForGistogram) client.read();

        XYChart.Series set = new XYChart.Series();
        set.setName("Прибыль от продаж($)");

        for(int i=0; i<list.getlistForGistogram().size();i++)
        {
            DataForGistogram buffer = new DataForGistogram();
            buffer.setName(list.listForGistogram.get(i).getName());
            buffer.setResult(list.listForGistogram.get(i).getResult());


            set.getData().add(new XYChart.Data<>(buffer.getName(), buffer.getResult()));

        }
        barChar.getData().addAll(set);
    }

}




