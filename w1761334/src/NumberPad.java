import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import java.util.Optional;

public class NumberPad {
    public static TextField output1; // Text field to set text to other textfields
    public static Pane keyboard(){

        Label headlbl = new Label("Number Keyboard");   //Keyboard heading
        headlbl.setLayoutX(170);
        headlbl.setLayoutY(300);
        headlbl.setStyle("-fx-font-size: 22 ; -fx-underline: true ; -fx-font-weight: bold");

        Button num7 = new Button("7");
        num7.setLayoutX(130);
        num7.setLayoutY(350);
        num7.setMinHeight(60);
        num7.setMinWidth(60);
        num7.setStyle("-fx-font-size: 22; -fx-font-weight: bolder; -fx-background-color: silver; -fx-border-color: white");

        Button num8 = new Button("8");
        num8.setLayoutX(200);
        num8.setLayoutY(350);
        num8.setMinHeight(60);
        num8.setMinWidth(60);
        num8.setStyle("-fx-font-size: 22; -fx-font-weight: bolder; -fx-background-color: silver; -fx-border-color: white");

        Button num9 = new Button("9");
        num9.setLayoutX(270);
        num9.setLayoutY(350);
        num9.setMinHeight(60);
        num9.setMinWidth(60);
        num9.setStyle("-fx-font-size: 22; -fx-font-weight: bolder; -fx-background-color: silver; -fx-border-color: white");

        Button num4 = new Button("4");
        num4.setLayoutX(130);
        num4.setLayoutY(420);
        num4.setMinHeight(60);
        num4.setMinWidth(60);
        num4.setStyle("-fx-font-size: 22; -fx-font-weight: bolder; -fx-background-color: silver; -fx-border-color: white");

        Button num5 = new Button("5");
        num5.setLayoutX(200);
        num5.setLayoutY(420);
        num5.setMinHeight(60);
        num5.setMinWidth(60);
        num5.setStyle("-fx-font-size: 22; -fx-font-weight: bolder; -fx-background-color: silver; -fx-border-color: white");

        Button num6 = new Button("6");
        num6.setLayoutX(270);
        num6.setLayoutY(420);
        num6.setMinHeight(60);
        num6.setMinWidth(60);
        num6.setStyle("-fx-font-size: 22; -fx-font-weight: bolder; -fx-background-color: silver; -fx-border-color: white");

        Button num1 = new Button("1");
        num1.setLayoutX(130);
        num1.setLayoutY(490);
        num1.setMinHeight(60);
        num1.setMinWidth(60);
        num1.setStyle("-fx-font-size: 22; -fx-font-weight: bolder; -fx-background-color: silver; -fx-border-color: white");

        Button num2 = new Button("2");
        num2.setLayoutX(200);
        num2.setLayoutY(490);
        num2.setMinHeight(60);
        num2.setMinWidth(60);
        num2.setStyle("-fx-font-size: 22; -fx-font-weight: bolder; -fx-background-color: silver; -fx-border-color: white");

        Button num3 = new Button("3");
        num3.setLayoutX(270);
        num3.setLayoutY(490);
        num3.setMinHeight(60);
        num3.setMinWidth(60);
        num3.setStyle("-fx-font-size: 22; -fx-font-weight: bolder; -fx-background-color: silver; -fx-border-color: white");

        Button num0 = new Button("0");
        num0.setLayoutX(130);
        num0.setLayoutY(560);
        num0.setMinHeight(60);
        num0.setMinWidth(130);
        num0.setStyle("-fx-font-size: 22; -fx-font-weight: bolder; -fx-background-color: silver; -fx-border-color: white");

        Button deci = new Button(".");
        deci.setLayoutX(270);
        deci.setLayoutY(560);
        deci.setMinHeight(60);
        deci.setMinWidth(60);
        deci.setStyle("-fx-font-size: 22; -fx-font-weight: bolder; -fx-background-color: silver; -fx-border-color: white");

        Button bck = new Button("CE");      //BackSpace btn
        bck.setLayoutX(340);
        bck.setLayoutY(490);
        bck.setMinHeight(60);
        bck.setMinWidth(60);
        bck.setStyle("-fx-font-size: 20; -fx-font-weight: bolder; -fx-background-color: silver; -fx-border-color: white");

        Button fullbck = new Button("C");   //Clear all btn
        fullbck.setLayoutX(340);
        fullbck.setLayoutY(350);
        fullbck.setMinHeight(130);
        fullbck.setMinWidth(60);
        fullbck.setStyle("-fx-font-size: 22; -fx-font-weight: bolder; -fx-background-color: red; -fx-text-fill: white; -fx-border-color: white ");

        Button minus = new Button("-");
        minus.setLayoutX(340);
        minus.setLayoutY(560);
        minus.setMinHeight(60);
        minus.setMinWidth(60);
        minus.setStyle("-fx-font-size: 22; -fx-font-weight: bolder; -fx-background-color: silver; -fx-border-color: white");
//=====================================================================================================================>
        output1 = new TextField();
        output1.setLayoutX(130);
        output1.setLayoutY(630);
        output1.setMinHeight(50);
        output1.setMinWidth(270);
        output1.setStyle("-fx-alignment: center-right; -fx-font-size: 20");
        output1.setPromptText("Select text field to set text");
//=====================================================================================================================>
//SETTING ACTIONS FOR BUTTONS
        num1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                output1.setText(output1.getText() + "1");}
        });

        num2.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                output1.setText(output1.getText() + "2");}
        });

        num3.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                output1.setText(output1.getText() + "3");}
        });

        num4.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                output1.setText(output1.getText() + "4");}
        });

        num5.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                output1.setText(output1.getText() + "5");}
        });

        num6.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                output1.setText(output1.getText() + "6");}
        });

        num7.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                output1.setText(output1.getText() + "7");}
        });

        num8.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                output1.setText(output1.getText() + "8");}
        });

        num9.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                output1.setText(output1.getText() + "9");}
        });

        num0.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                output1.setText(output1.getText() + "0");}
        });

        deci.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if (!output1.getText().contains(".")) //Check if there is a decimal place already
                    output1.setText(output1.getText() + ".");}
        });

        minus.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if (!output1.getText().contains("-")) // check if {-} is there already
                    output1.setText("-" + output1.getText());}   //{-}sign should be there only at the beginning
        });

        bck.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String value = output1.getText();
                if (value.length() > 0){
                    value = value.substring(0, value.length()-1);  //backspace | removes values one by one
                    output1.setText(value);
                }}
        });

        fullbck.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                output1.setText("");}
        });
//=====================================================================================================================>
        Button help = new Button("Help");       //Help btn
        help.setLayoutX(400);
        help.setMinHeight(40);
        help.setMinWidth(100);
        help.setStyle("-fx-background-color: orangered; -fx-text-fill: white ; -fx-font-weight: bolder; -fx-font-size: 20");

        Button mortgagebtn = new Button("Mortgage Calculator");    // mortgage btn to change scene
        mortgagebtn.setLayoutX(145);
        mortgagebtn.setLayoutY(100);
        mortgagebtn.setMinWidth(220);
        mortgagebtn.setStyle("-fx-font-size: 20; -fx-background-color:grey;-fx-background-radius:15 ; -fx-border-radius:15 ; -fx-text-fill:white ; -fx-border-color:black");

        Button financebtn = new Button("Finance Calculator");      // finance btn to change scene
        financebtn.setLayoutX(145);
        financebtn.setLayoutY(160);
        financebtn.setMinWidth(220);
        financebtn.setStyle("-fx-font-size: 20; -fx-background-color:grey;-fx-background-radius:15 ; -fx-border-radius:15 ; -fx-text-fill:white ; -fx-border-color:black");

        Button loanbtn = new Button("Auto Loan Calculator");            //loan btn to change scene
        loanbtn.setLayoutX(145);
        loanbtn.setLayoutY(220);
        loanbtn.setMinWidth(220);
        loanbtn.setStyle("-fx-font-size: 20; -fx-background-color:grey;-fx-background-radius:15 ; -fx-border-radius:15 ; -fx-text-fill:white ; -fx-border-color:black");
//=====================================================================================================================>
//help button
        help.setOnAction(new EventHandler<ActionEvent>() {        //How to use the app?
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

        financebtn.setOnAction(new EventHandler<ActionEvent>() {        //change scene to finance
            @Override
            public void handle(ActionEvent event) {
                Main.getStage().setScene(Finance.financeScene());
                Main.getStage().setTitle("Finance Calculator");
            }
        });

        mortgagebtn.setOnAction(new EventHandler<ActionEvent>() {        //change scene to finance
            @Override
            public void handle(ActionEvent event) {
                Main.getStage().setScene(Mortgage.mortgageScene());
                Main.getStage().setTitle("Mortgage Calculator");
            }
        });

        loanbtn.setOnAction(new EventHandler<ActionEvent>() {        //change scene to finance
            @Override
            public void handle(ActionEvent event) {
                Main.getStage().setScene(AutoLoan.loanScene());
                Main.getStage().setTitle("Auto Loan Calculator");
            }
        });
//=====================================================================================================================>
        Pane keyboard = new Pane();
        keyboard.getChildren().addAll(help,mortgagebtn,financebtn,loanbtn,headlbl,num0,num1,num2,num3,num4,num5,num6,num7,num8,num9,deci,bck,fullbck,minus,output1);
        return keyboard;
    }
    public static String NumpadSetText(){       // making the texting field to return the text
        return output1.getText();
    }
}
