import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneSampleEvents extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Label messageLbl = new Label();
        Label userIdLbl = new Label("User ID:");
        TextField userIdTxt = new TextField();
        Label userPwdLbl = new Label("Password:");
        PasswordField userPwdTxt = new PasswordField();
        Button signInBtn = new Button ("Sign In");
        Button cancelBtn = new Button ("Cancel");
        Button darkMode= new Button("Dark Mode");
        Hyperlink forgotPwdLink = new Hyperlink("Forgot password");
        GridPane root = new GridPane();
        root.setVgap(20);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);
        GridPane.setConstraints(userIdLbl, 0, 0);
        GridPane.setConstraints(userIdTxt, 1, 0);
        GridPane.setConstraints(userPwdLbl, 0, 1);
        GridPane.setConstraints(userPwdTxt, 1, 1);
        GridPane.setConstraints(signInBtn, 0, 2);
        GridPane.setConstraints(cancelBtn, 1, 2);

        GridPane.setConstraints(darkMode, 1,2, 1, 1, HPos.RIGHT, VPos.CENTER);
        GridPane.setConstraints(forgotPwdLink, 0, 3,2,1);
        GridPane.setConstraints(messageLbl,0,4,2,1);
        root.getChildren().addAll(userIdLbl, userIdTxt, userPwdLbl, userPwdTxt,signInBtn, cancelBtn, darkMode,messageLbl,forgotPwdLink);
        Scene scene = new Scene(root,250,200);

        messageLbl.textProperty().bind(message);
        signInBtn.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent evt){
                System.out.println(
                        "Anonymous class handler. Sign in clicked.");
            }
        });
        cancelBtn.setOnAction(evt ->
                message.set(" Cancel clicked.")
        );
        darkMode.setOnAction(evt ->{
            root.setId("scene");
                    scene.getStylesheets().add(getClass().getResource("application2.css").toExternalForm());
                }


        );
        forgotPwdLink.setOnAction(this::forgotPwdHandler);


        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private StringProperty message = new SimpleStringProperty();
    private void forgotPwdHandler(ActionEvent actionEvent) {
        System.out.println(
                "Method reference handler. Forgot password clicked");

    }
}
