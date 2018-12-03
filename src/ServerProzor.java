import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Admin on 1/13/2018.
 */
public class ServerProzor extends Application{
    Stage window;
    Scene scena1;
    TextArea labela1;
    TextArea labela2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Narucivanje pice - Server");

        window.setOnCloseRequest(e -> {
            e.consume();
            window.close();
            System.exit(6);
        });

        labela1 = new TextArea();
        labela2 = new TextArea();

        labela1.setMinHeight(150);
        labela1.setMaxWidth(1500);
        labela2.setMinHeight(150);
        labela2.setMaxWidth(1500);

        VBox layout = new VBox();
        //Dodaj sve na trenutnu sliku
        layout.getChildren().addAll(labela1, labela2);
        layout.setAlignment(Pos.TOP_LEFT);
        layout.setSpacing(10);

        scena1 = new Scene(layout, 1500, 400);
        window.setScene(scena1);
        window.show();
        new Server(labela1, labela2).start();
    }
}
