import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.*;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.FileOutputStream;


public class WeatherStationApp extends Application
{
  Stage window;
  TableView<Data> table;
  ComboBox<String> stationComboBox;


  public static void main(String[] args)
  {
    launch(args);
  }
  // Has to have a start method
  @Override
  public void start(Stage primaryStage) throws Exception
  {

      window = primaryStage;
      window.setTitle("Weather Data Application");



  // Adding columns
      TableColumn<Data, String> stationColumn = new TableColumn<>("Weather Station");
      stationColumn.setMinWidth(200);
      stationColumn.setCellValueFactory(new PropertyValueFactory<>("station"));

      TableColumn<Data, Double> tMaxColumn = new TableColumn<>("Monthly Max. Mean Temperature");
      tMaxColumn.setMinWidth(150);
      tMaxColumn.setCellValueFactory(new PropertyValueFactory<>("tMax"));

      TableColumn<Data, Double> tMinColumn = new TableColumn<>("Monthly Min. Mean Temperature");
      tMinColumn.setMinWidth(150);
      tMinColumn.setCellValueFactory(new PropertyValueFactory<>("tMin"));

      TableColumn<Data, String> airFrostDaysColumn = new TableColumn<>("Total air frost Days");
      airFrostDaysColumn.setMinWidth(150);
      airFrostDaysColumn.setCellValueFactory(new PropertyValueFactory<>("airFrostDays"));

      TableColumn<Data, Double> rainColumn = new TableColumn<>("Total Rainfall");
      rainColumn.setMinWidth(150);
      rainColumn.setCellValueFactory(new PropertyValueFactory<>("rain"));

      table = new TableView<>();
      table.setItems(getData());
      table.getColumns().addAll(stationColumn, tMaxColumn, tMinColumn, airFrostDaysColumn, rainColumn);

      HBox top = new HBox(200);
      top.setAlignment(Pos.CENTER);
      top.setPadding(new Insets(30, 20, 0, 20));

      Button reportButton = new Button("Generate Report");

      reportButton.setOnAction(e ->
      {
        try
        {
          int counter = 0;
          String report = "";
          String ending = ".csv";
          ArrayList<String> stations = new ArrayList();
          Collections.addAll(stations,
            "Aberporth",
            "Armagh",
            "Ballypatrick Forest",
            "Bradford",
            "Braemar",
            "Camborne",
            "Cambridge NIAB",
            "Cardiff Bute Park",
            "Chivenor",
            "Dunstaffnage",
            "Durham",
            "Eastbourne",
            "Eskdalemuir",
            "Heathrow",
            "Hurn",
            "Lerwick",
            "Leuchars",
            "Lowestoft",
            "Manston",
            "Nairn",
            "Newton Rigg",
            "Oxford",
            "Paisley",
            "Ross-on-Wye",
            "Shawbury",
            "Sheffield",
            "Stornoway Airport",
            "Sutton Bonington",
            "Tiree",
            "Valley",
            "Waddington",
            "Whitby",
            "Wick Airport",
            "Yeovilton"
            );
            for (String station : stations)
            {

              counter +=1;
              String filename = station + ending;
              ArrayList<String> info = TableInfo.getReportInfo(filename);
              String keyFacts = "Number:" + Integer.toString(counter) + "\nStation:" + station + "\nHighest: "
                              + info.get(0) + "\nLowest: " + info.get(1) + "\nAverage annual af: "
                              + info.get(2) + "\nAverage annual rainfall: " + info.get(3) + "\n\n";
              report += keyFacts;
            }

            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Report.txt"), "utf-8"));

            writer.write(report);
            writer.close();

            AlertBox.display("Report", "A report has been Generated and added to the folder that contains this Application");

          }
          catch(IOException ex)
          {
            System.out.println("Error");
          }
      });



      stationComboBox = new ComboBox();
      stationComboBox.getItems().addAll(
      "Aberporth",
      "Armagh",
      "Ballypatrick Forest",
      "Bradford",
      "Braemar",
      "Camborne",
      "Cambridge NIAB",
      "Cardiff Bute Park",
      "Chivenor",
      "Dunstaffnage",
      "Durham",
      "Eastbourne",
      "Eskdalemuir",
      "Heathrow",
      "Hurn",
      "Lerwick",
      "Leuchars",
      "Lowestoft",
      "Manston",
      "Nairn",
      "Newton Rigg",
      "Oxford",
      "Paisley",
      "Ross-on-Wye",
      "Shawbury",
      "Sheffield",
      "Stornoway Airport",
      "Sutton Bonington",
      "Tiree",
      "Valley",
      "Waddington",
      "Whitby",
      "Wick Airport",
      "Yeovilton"
      );

      stationComboBox.setPromptText("Select Weather Station for more Infomation");
      stationComboBox.setOnAction(e ->
      {
        try
        {
        StationWindow.display(stationComboBox.getValue(),"stuff");
        }
        catch (IOException exc)
        {
          System.out.println("Error");
        }
      });

      top.getChildren().addAll(reportButton, stationComboBox);


      VBox vBox = new VBox();
      vBox.setPadding(new Insets(20,10,10,10));
      vBox.getChildren().addAll(table);

      BorderPane layout = new BorderPane();
      layout.setTop(top);
      layout.setCenter(vBox);

      Scene scene = new Scene(layout, 850, 500);
      window.setScene(scene);
      window.show();

  }

  public ObservableList<Data> getData() throws IOException
  {
    String ending = ".csv";
    ObservableList<Data> datas = FXCollections.observableArrayList();
    ArrayList<String> stations = new ArrayList();
    Collections.addAll(stations,
      "Aberporth",
      "Armagh",
      "Ballypatrick Forest",
      "Bradford",
      "Braemar",
      "Camborne",
      "Cambridge NIAB",
      "Cardiff Bute Park",
      "Chivenor",
      "Dunstaffnage",
      "Durham",
      "Eastbourne",
      "Eskdalemuir",
      "Heathrow",
      "Hurn",
      "Lerwick",
      "Leuchars",
      "Lowestoft",
      "Manston",
      "Nairn",
      "Newton Rigg",
      "Oxford",
      "Paisley",
      "Ross-on-Wye",
      "Shawbury",
      "Sheffield",
      "Stornoway Airport",
      "Sutton Bonington",
      "Tiree",
      "Valley",
      "Waddington",
      "Whitby",
      "Wick Airport",
      "Yeovilton"
    );
    for(String station : stations )
    {
      String filename = station + ending;
      ArrayList<Double> info = TableInfo.getInfo(filename);
      datas.add(new Data(station, info.get(0), info.get(1), info.get(2).intValue(), info.get(3)));
    }



    return datas;
  }

}
