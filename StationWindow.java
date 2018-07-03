import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StationWindow
{

  public static void display(String title,  String message) throws IOException
  {
    Stage window = new Stage();

    //window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle(title);
    window.setMinWidth(250);


    // create  comboboxes
    ComboBox<String> dataChoice = new ComboBox();
    dataChoice.getItems().addAll(
    "Maximum Temperature",
    "Minimum Temperature",
    "Rainfall",
    "Days of Frost");
    dataChoice.setPromptText("Choose a category");

    ComboBox<String> yearChoice = new ComboBox();
    yearChoice.getItems().addAll(
    "2009",
    "2010",
    "2011",
    "2012",
    "2013",
    "2014",
    "2015",
    "2016",
    "2017");
    yearChoice.setPromptText("Choose a year");

    ComboBox<String> chartType = new ComboBox();
    chartType.getItems().addAll("Line Chart","Bar Chart");
    chartType.setPromptText("Choose a chart type");

    Button button = new Button("Generate Chart");


    button.setOnAction(e ->
    {
      Scene newScene;
      String fileName;
      List<List<String>> data;
      CategoryAxis xAxis = new CategoryAxis();
      CategoryAxis x1Axis = new CategoryAxis();

      NumberAxis yAxis = new NumberAxis();
      NumberAxis y1Axis = new NumberAxis();

      LineChart<String,Number> lc = new LineChart<String,Number>(x1Axis,y1Axis);
      BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
      bc.setTitle(yearChoice.getValue() + " " +dataChoice.getValue() + " Bar Chart");
      lc.setTitle(yearChoice.getValue() + " " +dataChoice.getValue() + " Line Chart");
      xAxis.setLabel("Number of Month");
      x1Axis.setLabel("Number of Month");

      yAxis.setLabel(dataChoice.getValue());
      y1Axis.setLabel(dataChoice.getValue());

      XYChart.Series series1 = new XYChart.Series();
      series1.setName("Data");

      fileName = title + ".csv";
      try
      {
        data = CSVReader.CSVReader(fileName);
        for(List<String> list : data)
        {


          if(list.get(0).equals(yearChoice.getValue()))
          {


            if(dataChoice.getValue() == "Maximum Temperature" )
            {
              series1.getData().add(new XYChart.Data(list.get(1), Double.parseDouble(list.get(2))));

            }
            if(dataChoice.getValue() == "Minimum Temperature" )
            {
              series1.getData().add(new XYChart.Data(list.get(1), Double.parseDouble(list.get(3))));

            }
            if(dataChoice.getValue() == "Days of Frost" )
            {
              series1.getData().add(new XYChart.Data(list.get(1), Double.parseDouble(list.get(4))));

            }
            if(dataChoice.getValue() == "Rainfall" )
            {
              series1.getData().add(new XYChart.Data(list.get(1), Double.parseDouble(list.get(5))));


            }
          }
        }
        if (chartType.getValue().equals("Line Chart"))
        {
          lc.getData().addAll(series1);
          newScene  = new Scene(lc,800,600);
        }
        else
        {
          bc.getData().addAll(series1);
          newScene  = new Scene(bc,800,600);
        }

        window.setScene(newScene);
        window.show();
      }
      catch(IOException exc)
      {
        System.out.println("file not found");
      }

    });

    TableColumn<Data, String> yearColumn = new TableColumn<>("Year");
    yearColumn.setMinWidth(150);
    yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

    TableColumn<Data, String> monthColumn = new TableColumn<>("Month");
    monthColumn.setMinWidth(150);
    monthColumn.setCellValueFactory(new PropertyValueFactory<>("month"));

    TableColumn<Data, String> tMaxColumn = new TableColumn<>("Max Temperature");
    tMaxColumn.setMinWidth(150);
    tMaxColumn.setCellValueFactory(new PropertyValueFactory<>("tMax"));

    TableColumn<Data, String> tMinColumn = new TableColumn<>("Min Temperature");
    tMinColumn.setMinWidth(150);
    tMinColumn.setCellValueFactory(new PropertyValueFactory<>("tMin"));

    TableColumn<Data, String> airFrostDaysColumn = new TableColumn<>("Total air frost Days");
    airFrostDaysColumn.setMinWidth(150);
    airFrostDaysColumn.setCellValueFactory(new PropertyValueFactory<>("airFrostDays"));

    TableColumn<Data, String> rainColumn = new TableColumn<>("Total Rainfall");
    rainColumn.setMinWidth(150);
    rainColumn.setCellValueFactory(new PropertyValueFactory<>("rain"));

    TableView table = new TableView<>();
    table.setItems(getData(title));
    table.getColumns().addAll(yearColumn, monthColumn, tMaxColumn, tMinColumn, airFrostDaysColumn, rainColumn);

    VBox vBox = new VBox();
    vBox.setPadding(new Insets(20,10,10,10));
    vBox.getChildren().addAll(table);


    HBox layout = new HBox(10);
    layout.setPadding(new Insets(10, 10, 10, 10));
    layout.getChildren().addAll(button, dataChoice, yearChoice, chartType);
    layout.setAlignment(Pos.CENTER);

    BorderPane borderPane = new BorderPane();
    borderPane.setTop(layout);
    borderPane.setCenter(vBox);

    Scene scene = new Scene(borderPane);
    window.setScene(scene);
    window.show();

  }

  public static ObservableList<Data1> getData(String title) throws IOException
  {
    String ending = ".csv";
    ObservableList<Data1> datas = FXCollections.observableArrayList();

    String filename = title + ending;
    List<List<String>> info = CSVReader.CSVReader(filename);
    for(List<String> list : info)
    {
      datas.add(new Data1( list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5)));
    }
    return datas;
  }

}
