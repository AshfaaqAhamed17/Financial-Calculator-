import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.Optional;

public class Main extends Application{
    private static Stage mainStage;     //cannot be accessed by other class directly

    public static Stage getStage(){     //making the stage public in-order set scene from other classes. Indirect access to stage
        return mainStage;               //primary stage gets returned
    }

    public void start(Stage primaryStage){
        mainStage = primaryStage;
        mainStage.setMinWidth(1520);
        mainStage.setMinHeight(780);
        mainStage.setTitle("MY CALCULATOR");
        Pane mainPane = new Pane();

        Button help = new Button("Help");
        help.setLayoutX(1400);
        help.setMinHeight(40);
        help.setMinWidth(100);
        help.setStyle("-fx-background-color: orangered; -fx-text-fill: white; -fx-font-weight: bolder; -fx-font-size: 20");

        Label main = new Label("MY CALCULATOR");
        main.setLayoutX(800);
        main.setLayoutY(130);
        main.setStyle("-fx-font-size: 85 ; -fx-font-family: Algerian "); //"Bookman Old Style"

        Button btn1 = new Button("Mortgage Calculator");
        btn1.setStyle("-fx-alignment: center ; -fx-background-color: #00ced1 ; -fx-border-color: lightblue ; -fx-font-size:22");
        btn1.setLayoutX(1000);
        btn1.setLayoutY(290);
        btn1.setMinWidth(240);
        btn1.setMinHeight(50);

        Button btn2 = new Button("Finance Calculator");
        btn2.setStyle("-fx-alignment: center ; -fx-background-color: #00ced1 ; -fx-border-color: lightblue ; -fx-font-size:22");
        btn2.setLayoutX(1000);
        btn2.setLayoutY(370);
        btn2.setMinWidth(240);
        btn2.setMinHeight(50);

        Button btn3 = new Button("Auto Loan Calculator");
        btn3.setStyle("-fx-alignment: center ; -fx-background-color: #00ced1 ; -fx-border-color: lightblue; -fx-font-size:22");
        btn3.setLayoutX(1000);
        btn3.setLayoutY(450);
        btn3.setMinWidth(240);
        btn3.setMinHeight(50);

        Label myName = new Label("Owned-by : Ashfaaq Ahamed\nStd_ID : 2019394");
        myName.setLayoutX(1200);
        myName.setLayoutY(680);
        myName.setStyle("-fx-text-alignment:right;-fx-font-weight: bold ; -fx-font-family: 'Bookman Old Style';-fx-font-size: 19");

        help.setOnAction(new EventHandler<ActionEvent>() {        //change scene to finance
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("My Calculator usage");
                alert.setHeaderText("HOW TO USE THE APP?\t\t\t\t\t\t\t\t\t\t\t");
                alert.setContentText("1) Select the Calculator of which you want to do the calculations.\n\n" +
                        "2) Next select the the required category you want to calculate by clicking on the relevant tabs.\n" +
                        "\t\ti) Mortgage Calculator\n\t\tii) Auto Loan Calculator\n\t\t\t\t* Monthly Price\n\t\t\t\t* Auto Price" +
                        "\n\t\tiii) Finance Calculator\n\t\t\t\t* Future Value\n\t\t\t\t* Annuity Payment\n\t\t\t\t* Interest Rate\n\t\t\t\t* No. of Payments\n\t\t\t\t* Start Principal\n\n" +
                        "3) Input the values using the in-built keyboard, then select the desired text field it to which it should be placed in.\n\n" +
                        "4) Click on calculate button after inputting all the values in the text field.\n If there is nothing to input, then place zero(0) in it.\n\n" +
                        "5) \"Clear All\" button clears all the text inside the text fields and the display section.\n\n" +
                        "6) All calculations are done in Years\n\n" +
                        "7) The Annual Interest Rate is calculated with zero(0) annual payments in Finance Calculator.\n\n"+
                        "8) You can view the past calculations made using the app by clicking on the \"Past Calculations\" button.");
                Optional<ButtonType> result = alert.showAndWait();
            }
        });

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainStage.setScene(Mortgage.mortgageScene());
                mainStage.setTitle("Mortgage Calculator");
            }
        });

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainStage.setScene(Finance.financeScene());
                mainStage.setTitle("Finance Calculator");
            }
        });

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainStage.setScene(AutoLoan.loanScene());
                mainStage.setTitle("Auto Loan Calculator");
            }
        });
//=====================================================================================================================>
// BACKGROUND IMAGE
        Image img = new Image("file:calculator.jpg");
        ImageView viewImg = new ImageView(img);
        viewImg.fitHeightProperty().bind(mainPane.heightProperty());
        viewImg.fitWidthProperty().bind(mainPane.widthProperty());
//=====================================================================================================================>
//adding elements to the pane
        mainPane.getChildren().addAll(viewImg,main,help,btn1,btn2,btn3,myName);
        mainPane.setStyle("-fx-font-family: serif");

        Scene calc = new Scene(mainPane, 1500,730);
        mainStage.setScene(calc);
        mainStage.show();
    }
}