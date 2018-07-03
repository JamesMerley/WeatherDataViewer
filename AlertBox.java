import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.geometry.*;

public class AlertBox
{
  public static void display(String title,  String message)
  {
    Stage window = new Stage();

    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle(title);
    window.setMinWidth(250);

    Label label = new Label();
    label.setText(message);
    label.setPadding(new Insets(10,10,10,10));
    Button button = new Button("Close the window");
    button.setOnAction(e -> window.close());
    button.setPadding(new Insets(10, 10, 10, 10));

    VBox layout = new VBox(10);
    layout.getChildren().addAll(label, button);
    layout.setAlignment(Pos.CENTER);
    layout.setPadding(new Insets(10,10,10,10));

    Scene scene = new Scene(layout);
    window.setScene(scene);
    window.showAndWait();
  }
}
