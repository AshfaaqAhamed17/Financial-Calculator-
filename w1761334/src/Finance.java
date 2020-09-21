import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;

public class Finance {
    public static File file;                //PAST CALC
    public static PrintWriter printfile;    //Print writer for past calc
    public static FileWriter fileWriter;    //File writer for past calc
    public static File FileFV;              //FUTURE VALUE RETURN
    public static PrintWriter PrintFileFV;  //print writer to write the recent past calc.
    public static FileWriter FileWriterFV;  //file writer to write & append recent past calc.
    public static String [] DisplayNewFV;         //store recent past calc.
    public static File FilePMT;              //PMT RETURN
    public static PrintWriter PrintFilePMT;  //print writer to write the recent past calc.
    public static FileWriter FileWriterPMT;  //file writer to write & append recent past calc.
    public static String [] DisplayNewPMT;         //store recent past calc.
    public static File FileINT;              //INTEREST.RATE RETURN
    public static PrintWriter PrintFileINT;  //print writer to write the recent past calc.
    public static FileWriter FileWriterINT;  //file writer to write & append recent past calc.
    public static String [] DisplayNewINT;         //store recent past calc.
    public static File FileNUM;              //NUM.OF.PERIODS RETURN
    public static PrintWriter PrintFileNUM;  //print writer to write the recent past calc.
    public static FileWriter FileWriterNUM;  //file writer to write & append recent past calc.
    public static String [] DisplayNewNUM;         //store recent past calc.
    public static File FileSTART;              //START PRINCIPAL RETURN
    public static PrintWriter PrintFileSTART;  //print writer to write the recent past calc.
    public static FileWriter FileWriterSTART;  //file writer to write & append recent past calc.
    public static String [] DisplayNewSTART;         //store recent past calc.

    public static Scene financeScene(){

        Label mainName = new Label(" Finance Calculator");   //Main heading
        mainName.setLayoutX(22);
        mainName.setLayoutY(30);
        mainName.setMinSize(570,75);
        mainName.setStyle("-fx-font-size: 60; -fx-text-fill:black;-fx-border-color:white ;-fx-border-radius:15; -fx-background-radius:15; -fx-background-color:#00ced1; -fx-opacity:0.4 ");

        Image img = new Image("file:calculator-img.png");
        ImageView viewImg = new ImageView(img);
        viewImg.setFitHeight(75);
        viewImg.setFitWidth(75);
        viewImg.setLayoutX(505);
        viewImg.setLayoutY(30);
//=====================================================================================================================>
        TabPane form1 = new TabPane();      //tab pane created
        form1.setLayoutY(130);
//=====================================================================================================================>
// Tab1 items    //FV
        Tab tab1 = new Tab("Future Value");      //tab created "FUTURE VALUE"
        Pane tab1contents = new Pane();
        tab1.setClosable(false);
        tab1.setStyle("-fx-font-size: 16; -fx-border-color: lightblue");

        Label numP1 = new Label("No. of periods");      // Label for No. of periods [1]
        numP1.setLayoutX(60);
        numP1.setLayoutY(50);
        numP1.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField numP1TF = new TextField();                // No. of periods text field [-1]
        numP1TF.setLayoutX(250);
        numP1TF.setLayoutY(45);
        numP1TF.setPromptText("Years");
        numP1TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Label startPr1 = new Label("Start Principal");  // Start Principal label [2]
        startPr1.setLayoutX(60);
        startPr1.setLayoutY(100);
        startPr1.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField startPr1TF = new TextField();             // Start Principal textfield [-2]
        startPr1TF.setLayoutX(250);
        startPr1TF.setLayoutY(95);
        startPr1TF.setPromptText("$");
        startPr1TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Label IntR1 = new Label("Interest Rate");       //interest rate label [3]
        IntR1.setLayoutX(60);
        IntR1.setLayoutY(150);
        IntR1.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField IntR1TF = new TextField();                // interest rate text field [-3]
        IntR1TF.setLayoutX(250);
        IntR1TF.setLayoutY(145);
        IntR1TF.setPromptText("%");
        IntR1TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Label pmt1 = new Label("Annuity Payment");      // Annuity Payment label [4]
        pmt1.setLayoutX(60);
        pmt1.setLayoutY(200);
        pmt1.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField pmt1TF = new TextField();                 // Annuity Payment text field [-4]
        pmt1TF.setLayoutX(250);
        pmt1TF.setLayoutY(195);
        pmt1TF.setPromptText("$");
        pmt1TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Button calculate1 = new Button("Calculate Future Value"); // calculate button
        calculate1.setLayoutX(85);
        calculate1.setLayoutY(340);
        calculate1.setMinSize(300,55);
        calculate1.setStyle(" -fx-font-size: 22; -fx-font-weight: bold;-fx-background-radius:15 ; -fx-border-radius:15 ; -fx-background-color:forestgreen; -fx-border-color: black ;-fx-text-fill: white");

        Button clear1 = new Button("Clear All"); // clear button
        clear1.setLayoutX(155);
        clear1.setLayoutY(415);
        clear1.setMinSize(150,40);
        clear1.setStyle("-fx-font-size: 22;-fx-font-weight: bold;-fx-background-radius:15 ; -fx-border-radius:15 ; -fx-background-color:red; -fx-border-color: black ;-fx-text-fill: white");
//=====================================================================================================================>
//Tab2 items    //PMT
        Tab tab2 = new Tab("PMT");              //tabs created "MONTHLY PAYMENT"
        Pane tab2contents = new Pane();
        tab2.setClosable(false);
        tab2.setStyle("-fx-font-size: 16 ; -fx-border-color: lightblue");

        Label fv2 = new Label("Future Value");  // Label for Future Value [1]
        fv2.setLayoutX(60);
        fv2.setLayoutY(50);
        fv2.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField fv2TF = new TextField();          // Future Value text field [-1]
        fv2TF.setLayoutX(250);
        fv2TF.setLayoutY(45);
        fv2TF.setPromptText("$");
        fv2TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Label numP2 = new Label("No. of periods");  // Label for No. of periods [2]
        numP2.setLayoutX(60);
        numP2.setLayoutY(100);
        numP2.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField numP2TF = new TextField();            // No. of periods text field [-2]
        numP2TF.setLayoutX(250);
        numP2TF.setLayoutY(95);
        numP2TF.setPromptText("Years");
        numP2TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Label startPr2 = new Label("Start Principal");  // Start Principal label [3]
        startPr2.setLayoutX(60);
        startPr2.setLayoutY(150);
        startPr2.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField startPr2TF = new TextField();             // Start Principal textfield [-3]
        startPr2TF.setLayoutX(250);
        startPr2TF.setLayoutY(145);
        startPr2TF.setPromptText("$");
        startPr2TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Label IntR2 = new Label("Interest Rate");       //  Interest Rate label [4]
        IntR2.setLayoutX(60);
        IntR2.setLayoutY(200);
        IntR2.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField IntR2TF = new TextField();                // Interest Rate text field [-4]
        IntR2TF.setLayoutX(250);
        IntR2TF.setLayoutY(195);
        IntR2TF.setPromptText("%");
        IntR2TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Button calculate2 = new Button("Calculate Periodic Payement"); // calculate button
        calculate2.setLayoutX(85);
        calculate2.setLayoutY(340);
        calculate2.setMinSize(300,55);
        calculate2.setStyle(" -fx-font-size: 22; -fx-font-weight: bold;-fx-background-radius:15 ; -fx-border-radius:15 ; -fx-background-color:forestgreen; -fx-border-color: black ;-fx-text-fill: white");

        Button clear2 = new Button("Clear All"); // clear button
        clear2.setLayoutX(155);
        clear2.setLayoutY(415);
        clear2.setMinSize(150,40);
        clear2.setStyle("-fx-font-size: 22;-fx-font-weight: bold;-fx-background-radius:15 ; -fx-border-radius:15 ; -fx-background-color:red; -fx-border-color: black ;-fx-text-fill: white");
//=====================================================================================================================>
//Tab3 items    //I/Y
        Tab tab3 = new Tab("Int. Rate");  //tabs created "Interest Rate"
        Pane tab3contents = new Pane();
        tab3.setClosable(false);
        tab3.setStyle("-fx-font-size: 16; -fx-border-color: lightblue");

        Label fv3 = new Label("Future Value");  // Label for Future Value [1]
        fv3.setLayoutX(60);
        fv3.setLayoutY(50);
        fv3.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField fv3TF = new TextField();          // Future Value text field [-1]
        fv3TF.setLayoutX(250);
        fv3TF.setLayoutY(45);
        fv3TF.setPromptText("$");
        fv3TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Label numP3 = new Label("No. of periods");  // Label for No. of periods [2]
        numP3.setLayoutX(60);
        numP3.setLayoutY(125);
        numP3.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField numP3TF = new TextField();            // No. of periods text field [-2]
        numP3TF.setLayoutX(250);
        numP3TF.setLayoutY(120);
        numP3TF.setPromptText("Years");
        numP3TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Label startPr3 = new Label("Start Principal");  // Start Principal label [3]
        startPr3.setLayoutX(60);
        startPr3.setLayoutY(200);
        startPr3.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField startPr3TF = new TextField();             // Start Principal textfield [-3]
        startPr3TF.setLayoutX(250);
        startPr3TF.setLayoutY(195);
        startPr3TF.setPromptText("$");
        startPr3TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Button calculate3 = new Button("Calculate Rate of Interest"); // calculate button
        calculate3.setLayoutX(85);
        calculate3.setLayoutY(340);
        calculate3.setMinSize(300,55);
        calculate3.setStyle(" -fx-font-size: 22; -fx-font-weight: bold;-fx-background-radius:15 ; -fx-border-radius:15 ; -fx-background-color:forestgreen; -fx-border-color: black ;-fx-text-fill: white");

        Button clear3 = new Button("Clear All"); // clear button
        clear3.setLayoutX(155);
        clear3.setLayoutY(415);
        clear3.setMinSize(150,40);
        clear3.setStyle("-fx-font-size: 22;-fx-font-weight: bold;-fx-background-radius:15 ; -fx-border-radius:15 ; -fx-background-color:red; -fx-border-color: black ;-fx-text-fill: white");
//=====================================================================================================================>
//Tab4 items    //N
        Tab tab4 = new Tab("No. of periods");  //tabs created "Number of Payment"
        Pane tab4contents = new Pane();
        tab4.setClosable(false);
        tab4.setStyle("-fx-font-size: 16; -fx-border-color: lightblue");

        Label fv4 = new Label("Future Value");  // Label for Future Value [1]
        fv4.setLayoutX(60);
        fv4.setLayoutY(50);
        fv4.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField fv4TF = new TextField();          // Future Value text field [-1]
        fv4TF.setLayoutX(250);
        fv4TF.setLayoutY(45);
        fv4TF.setPromptText("$");
        fv4TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Label IntR4 = new Label("Interest Rate");  // Label for Interest Rate [2]
        IntR4.setLayoutX(60);
        IntR4.setLayoutY(100);
        IntR4.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField IntR4TF = new TextField();            // Interest Rate text field [-2]
        IntR4TF.setLayoutX(250);
        IntR4TF.setLayoutY(95);
        IntR4TF.setPromptText("%");
        IntR4TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Label startPr4 = new Label("Start Principal");  // Start Principal label [3]
        startPr4.setLayoutX(60);
        startPr4.setLayoutY(150);
        startPr4.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField startPr4TF = new TextField();             // Start Principal textfield [-3]
        startPr4TF.setLayoutX(250);
        startPr4TF.setLayoutY(145);
        startPr4TF.setPromptText("$");
        startPr4TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Label pmt4 = new Label("Annuity Payment");    //  Annuity Payment label [4]
        pmt4.setLayoutX(60);
        pmt4.setLayoutY(200);
        pmt4.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField pmt4TF = new TextField();               // Annuity Payment text field [-4]
        pmt4TF.setLayoutX(250);
        pmt4TF.setLayoutY(195);
        pmt4TF.setPromptText("$");
        pmt4TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Button calculate4 = new Button("Calculate the No. of Periods"); // calculate button
        calculate4.setLayoutX(85);
        calculate4.setLayoutY(340);
        calculate4.setMinSize(300,55);
        calculate4.setStyle(" -fx-font-size: 22; -fx-font-weight: bold;-fx-background-radius:15 ; -fx-border-radius:15 ; -fx-background-color:forestgreen; -fx-border-color: black ;-fx-text-fill: white");

        Button clear4 = new Button("Clear All"); // clear button
        clear4.setLayoutX(155);
        clear4.setLayoutY(415);
        clear4.setMinSize(150,40);
        clear4.setStyle("-fx-font-size: 22;-fx-font-weight: bold;-fx-background-radius:15 ; -fx-border-radius:15 ; -fx-background-color:red; -fx-border-color: black ;-fx-text-fill: white");
//=====================================================================================================================>
//Tab 5 items   //Start Principal
        Tab tab5 = new Tab("Start Principal");  //tabs created "Start Principal"
        Pane tab5contents = new Pane();
        tab5.setClosable(false);
        tab5.setStyle("-fx-font-size: 16; -fx-border-color: lightblue");

        Label fv5 = new Label("Future Value");  // Label for Future Value [1]
        fv5.setLayoutX(60);
        fv5.setLayoutY(50);
        fv5.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField fv5TF = new TextField();          // Future Value text field [-1]
        fv5TF.setLayoutX(250);
        fv5TF.setLayoutY(45);
        fv5TF.setPromptText("$");
        fv5TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Label IntR5 = new Label("Interest Rate");  // Label for Interest Rate [2]
        IntR5.setLayoutX(60);
        IntR5.setLayoutY(100);
        IntR5.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField IntR5TF = new TextField();            // Interest Rate text field [-2]
        IntR5TF.setLayoutX(250);
        IntR5TF.setLayoutY(95);
        IntR5TF.setPromptText("%");
        IntR5TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Label numP5 = new Label("No. of periods");  // No. of periods label [3]
        numP5.setLayoutX(60);
        numP5.setLayoutY(150);
        numP5.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField numP5TF = new TextField();            // No. of periods textfield [-3]
        numP5TF.setLayoutX(250);
        numP5TF.setLayoutY(145);
        numP5TF.setPromptText("Years");
        numP5TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Label pmt5 = new Label("Annuity Payment");    //  Annuity Payment label [4]
        pmt5.setLayoutX(60);
        pmt5.setLayoutY(200);
        pmt5.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField pmt5TF = new TextField();               // Annuity Payment text field [-4]
        pmt5TF.setLayoutX(250);
        pmt5TF.setLayoutY(195);
        pmt5TF.setPromptText("$");
        pmt5TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Button calculate5 = new Button("Calculate the Start Principal"); // calculate button
        calculate5.setLayoutX(85);
        calculate5.setLayoutY(340);
        calculate5.setMinSize(300,55);
        calculate5.setStyle(" -fx-font-size: 22; -fx-font-weight: bold;-fx-background-radius:15 ; -fx-border-radius:15 ; -fx-background-color:forestgreen; -fx-border-color: black ;-fx-text-fill: white");

        Button clear5 = new Button("Clear All");        // clear button
        clear5.setLayoutX(155);
        clear5.setLayoutY(415);
        clear5.setMinSize(150,40);
        clear5.setStyle("-fx-font-size: 22;-fx-font-weight: bold;-fx-background-radius:15 ; -fx-border-radius:15 ; -fx-background-color:red; -fx-border-color: black ;-fx-text-fill: white");
//=====================================================================================================================>
//result section
        Label headlbl = new Label("Calculated Amounts");     // label to display monthly amount      //[1]
        headlbl.setLayoutX(95);
        headlbl.setLayoutY(130);
        headlbl.setMinWidth(370);
        headlbl.setStyle(" -fx-font-size: 40; -fx-alignment: center; -fx-underline:true");

        Label displaylbl = new Label();         // Name display label                   //[2]
        displaylbl.setLayoutX(70);
        displaylbl.setLayoutY(240);
        displaylbl.setMinWidth(400);
        displaylbl.setStyle("-fx-font-size: 35 ;-fx-text-fill: white; -fx-alignment: center");

        Label displayRes = new Label();         // calculated amount display       //[-2]
        displayRes.setLayoutX(70);
        displayRes.setLayoutY(300);
        displayRes.setMinWidth(400);
        displayRes.setStyle("-fx-font-size: 30 ;-fx-text-fill: white; -fx-alignment: center ; -fx-font-weight: bolder");

        Label displayPresentVal = new Label("Present Value");    // Present value label                   //[2]
        displayPresentVal.setLayoutX(70);
        displayPresentVal.setLayoutY(360);
        displayPresentVal.setMinWidth(400);
        displayPresentVal.setStyle("-fx-font-size: 35 ;-fx-text-fill: white; -fx-alignment: center");

        Label displayPresentValRes = new Label();    // Present value calculated amount display       //[-2]
        displayPresentValRes.setLayoutX(70);
        displayPresentValRes.setLayoutY(420);
        displayPresentValRes.setMinWidth(400);
        displayPresentValRes.setStyle("-fx-font-size: 30 ;-fx-text-fill: white; -fx-alignment: center ; -fx-font-weight: bolder");
//=====================================================================================================================>
//Change label names when tab changes
        tab1.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                if (tab1.isSelected() ){
                    displaylbl.setText("Fututre Value");
                    displayRes.setText("");
                    displayPresentValRes.setText("");
                }
            }
        });

        tab2.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                if (tab2.isSelected()) {
                    displaylbl.setText("Annuity Payement");
                    displayRes.setText("");
                    displayPresentValRes.setText("");
                }
            }
        });

        tab3.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                if (tab3.isSelected()) {
                    displaylbl.setText("Interest Rate per Year");
                    displayRes.setText("");
                    displayPresentValRes.setText("");
                }
            }
        });

        tab4.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                if (tab4.isSelected()) {
                    displaylbl.setText("Number of Periods");
                    displayRes.setText("");
                    displayPresentValRes.setText("");
                }
            }
        });

        tab5.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                if (tab5.isSelected()) {
                    displaylbl.setText("Start Principal");
                    displayRes.setText("");
                    displayPresentValRes.setText("");
                }
            }
        });
//=====================================================================================================================>
 //calculate [FV]
        calculate1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{    //changing inputs to String
                    String numberOfPeriods = numP1TF.getText();
                    String interestAmnt = IntR1TF.getText();
                    String startPrincipal = startPr1TF.getText();
                    String payment = pmt1TF.getText();
                    //check if there is any txtfield is left blank
                    if (numberOfPeriods.equals("") || interestAmnt.equals("") || startPrincipal.equals("") || payment.equals("")){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setHeaderText(null);
                        alert.setContentText("Please enter in all the fields!");
                        alert.showAndWait();
                    }
                    double InterstValue = Double.parseDouble(interestAmnt)/100;
                    double Startprincipal = Double.parseDouble(startPrincipal);
                    double numberOfPrds = Double.parseDouble(numberOfPeriods);
                    double Payment = Double.parseDouble(payment);

                    double fvUP = Startprincipal * Math.pow(1 + InterstValue,numberOfPrds);
                    double fvDOWN = (Payment * ((Math.pow(1 + InterstValue,numberOfPrds)) - 1) / InterstValue);
                    double FutureVal = fvUP + fvDOWN;

                    double PresentVal = FutureVal * Math.pow(1 + InterstValue,-numberOfPrds);

                    String FV = NumberFormat.getCurrencyInstance().format(FutureVal);              //Format string to a currency($)
                    String PV = NumberFormat.getCurrencyInstance().format(PresentVal);              //Format string to a currency($)

                    displayRes.setText(FV);
                    displayPresentValRes.setText(PV);
                    //Creating a file to collect past calculations
                    try {
                        file = new File("FinanceFile.txt");        //check if there is file in that name
                        file.createNewFile();                               // else create a file
                        FileFV = new File("FVfile.txt");            //check if there is file in that name
                        FileFV.createNewFile();                             // else create a file
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        fileWriter = new FileWriter(file,true);     //append the text to the file
                        printfile = new PrintWriter(fileWriter, true );     //autoflush enabled
                        printfile.print("\n\nPresent Value = "+PV+ "\nFuture Value = "+FV+
                                "\nDATE = "+ LocalDate.now()+"\t||\tTIME = "+ java.time.LocalTime.now()); //writing to past calc file
                        fileWriter.close();                                 //close file writer
                        printfile.close();                                  //close print writer

                        FileWriterFV = new FileWriter(FileFV);
                        PrintFileFV = new PrintWriter(FileWriterFV, true);
                        PrintFileFV.print(numberOfPeriods + "," + startPrincipal + "," + interestAmnt + "," + payment);//writing to file
                        FileWriterFV.close();                               //close file writer
                        PrintFileFV.close();                                //close print writer
                    }
                }
                catch (NumberFormatException | IOException e){      //check if anything other than integers or double is entered
                    Alert alerttxt = new Alert(Alert.AlertType.ERROR);
                    alerttxt.setTitle("ERROR!!!");
                    alerttxt.setHeaderText(null);
                    alerttxt.setContentText("Please enter valid Inputs!");
                    alerttxt.showAndWait();
                }
            }
        });
        clear1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                numP1TF.setText("");
                IntR1TF.setText("");
                startPr1TF.setText("");
                pmt1TF.setText("");
                displayRes.setText("");
                displayPresentValRes.setText("");
            }
        });
//=====================================================================================================================>
//calculate [PMT]
        calculate2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{    //changing inputs to String
                    String numberOfPeriods = numP2TF.getText();
                    String interestAmnt = IntR2TF.getText();
                    String startPrincipal = startPr2TF.getText();
                    String futureVal = fv2TF.getText();
                    //check if there is any txtfield is left blank
                    if (numberOfPeriods.equals("") || interestAmnt.equals("") || startPrincipal.equals("") || futureVal.equals("")){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setHeaderText(null);
                        alert.setContentText("Please enter in all the fields!");
                        alert.showAndWait();
                    }
                    double InterstValue = Double.parseDouble(interestAmnt)/100;
                    double Startprincipal = Double.parseDouble(startPrincipal);
                    double numberOfPrds = Double.parseDouble(numberOfPeriods);
                    double futureValue = Double.parseDouble(futureVal);

                    double PmtUP = futureValue - Startprincipal*(Math.pow(1 + InterstValue, numberOfPrds));
                    double PmtDOWN = ((Math.pow(1 + InterstValue, numberOfPrds))-1)/InterstValue;
                    double Payment = (PmtUP / PmtDOWN);

                    double PresentVal = futureValue * Math.pow(1 + InterstValue,-numberOfPrds);

                    String PV = NumberFormat.getCurrencyInstance().format(PresentVal);              //Format string to a currency($)
                    String PMT = NumberFormat.getCurrencyInstance().format(Payment);              //Format string to a currency($)

                    displayRes.setText(PMT);
                    displayPresentValRes.setText(PV);
                    //Creating a file to collect past calculations
                    try {
                        file = new File("FinanceFile.txt");        //check if there is file in that name
                        file.createNewFile();                               // else create a file
                        FilePMT = new File("PMTfile.txt");
                        FilePMT.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        fileWriter = new FileWriter(file,true);                 //append the text to the file
                        printfile = new PrintWriter(fileWriter, true );        //autoflush enabled
                        printfile.print("\n\nPresent Value = "+PV+ "\nAnnuity Payment Value = "+PMT+
                                "\nDATE = "+ LocalDate.now()+"\t||\tTIME = "+ java.time.LocalTime.now()); //writing to past calc file
                        fileWriter.close();                                 //close file writer
                        printfile.close();                                  //close print writer

                        FileWriterPMT = new FileWriter(FilePMT);
                        PrintFilePMT = new PrintWriter(FileWriterPMT, true);
                        PrintFilePMT.print(futureVal + "," + numberOfPeriods + "," + startPrincipal + "," + interestAmnt);  //writing to file
                        FileWriterPMT.close();
                        PrintFilePMT.close();
                    }
                }
                catch (NumberFormatException | IOException e){      //check if anything other than integers or double is entered
                    Alert alerttxt = new Alert(Alert.AlertType.ERROR);
                    alerttxt.setTitle("ERROR!!!");
                    alerttxt.setHeaderText(null);
                    alerttxt.setContentText("Please enter valid Inputs!");
                    alerttxt.showAndWait();
                }
            }
        });
        clear2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                numP2TF.setText("");
                IntR2TF.setText("");
                startPr2TF.setText("");
                fv2TF.setText("");
                displayRes.setText("");
                displayPresentValRes.setText("");
            }
        });
//=====================================================================================================================>
//calculate [I/Y]
        calculate3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {//changing inputs to String
                try {
                    String numberOfPeriods = numP3TF.getText();
                    String startPrincipal = startPr3TF.getText();
                    String futureVal = fv3TF.getText();
                    //check if there is any txtfield is left blank
                    if (numberOfPeriods.equals("") || startPrincipal.equals("") || futureVal.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setHeaderText(null);
                        alert.setContentText("Please enter in all the fields!");
                        alert.showAndWait();
                    }
                        double Startprincipal = Double.parseDouble(startPrincipal);
                        double numberOfPrds = Double.parseDouble(numberOfPeriods);
                        double futureValue = Double.parseDouble(futureVal);

                        double interestAmnt = (Math.pow((futureValue / Startprincipal), 1 / numberOfPrds) - 1);
                        double interestVal = (interestAmnt * 100);
                        double PresentVal = futureValue * Math.pow(1 + interestAmnt, -numberOfPrds);

                        DecimalFormat IntRate = new DecimalFormat("###.##");                  //Decimal format for Interest rate
                        String INTERESTRate = String.valueOf(IntRate.format(interestVal));
                        String PV = NumberFormat.getCurrencyInstance().format(PresentVal);              //Format string to a currency($)

                        displayRes.setText(INTERESTRate+" %");
                        displayPresentValRes.setText(PV);

                    //Creating a file to collect past calculations
                    try {
                        file = new File("FinanceFile.txt");        //check if there is file in that name
                        file.createNewFile();                               // else create a file
                        FileINT = new File("InterestRateFile.txt");
                        FileINT.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        fileWriter = new FileWriter(file,true);     //append the text to the file
                        printfile = new PrintWriter(fileWriter, true );     //autoflush enabled
                        printfile.print("\n\nPresent Value = "+PV+ "\nInterest Rate = "+INTERESTRate+
                                " %\nDATE = "+ LocalDate.now()+"\t||\tTIME = "+ java.time.LocalTime.now()); //writing to file
                        fileWriter.close();                                 //close file writer
                        printfile.close();                                  //close print writer
                        FileWriterINT = new FileWriter(FileINT);
                        PrintFileINT = new PrintWriter(FileWriterINT, true);
                        PrintFileINT.print(futureVal + "," + numberOfPeriods + "," + startPrincipal); //writing to file
                        FileWriterINT.close();                              //close file writer
                        PrintFileINT.close();                               //close print writer
                    }
                }catch (NumberFormatException | IOException e) {      //check if anything other than integers or double is entered
                    Alert alerttxt = new Alert(Alert.AlertType.ERROR);
                    alerttxt.setTitle("ERROR!!!");
                    alerttxt.setHeaderText(null);
                    alerttxt.setContentText("Please enter valid Inputs!");
                    alerttxt.showAndWait();
                }
            }
        });

        clear3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                numP3TF.setText("");
                fv3TF.setText("");
                startPr3TF.setText("");
                displayRes.setText("");
                displayPresentValRes.setText("");

            }
        });
//=====================================================================================================================>
//calculate [N]
        calculate4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{//changing inputs to String
                    String interestAmnt = IntR4TF.getText();
                    String payment = pmt4TF.getText();
                    String startPrincipal = startPr4TF.getText();
                    String futureVal = fv4TF.getText();
                    //check if there is any txtfield is left blank
                    if (interestAmnt.equals("") || payment.equals("") || startPrincipal.equals("") || futureVal.equals("")){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setHeaderText(null);
                        alert.setContentText("Please enter in all the fields!");
                        alert.showAndWait();
                    }
                    double InterestValue = Double.parseDouble(interestAmnt)/100;
                    double Startprincipal = Double.parseDouble(startPrincipal);
                    double Payment = Double.parseDouble(payment);
                    double futureValue = Double.parseDouble(futureVal);

                    double NumberOfPeriodsLog1 = Math.log((futureValue * InterestValue + Payment) / (Startprincipal * InterestValue + Payment));
                    double NumberOfPeriodsLog2 = Math.log(1+InterestValue);
                    double NumberOfPeriods = NumberOfPeriodsLog1 / NumberOfPeriodsLog2;             //Calculating number of periods

                    double PresentVal = futureValue * Math.pow(1 + InterestValue, -NumberOfPeriods);
                    String PV = NumberFormat.getCurrencyInstance().format(PresentVal);              //Format string to a currency($)

                    DecimalFormat NumberOfP = new DecimalFormat("###.#");                  //Decimal format for Time periods
                    String NumDATE = String.valueOf(NumberOfP.format(NumberOfPeriods));
                    displayRes.setText(NumDATE+" years");
                    displayPresentValRes.setText(PV);
                    //Creating a file to collect past calculations
                    try {
                        file = new File("FinanceFile.txt");        //check if there is file in that name
                        file.createNewFile();                               // else create a file
                        FileNUM = new File("Num.Of.Periods.txt");
                        FileNUM.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        fileWriter = new FileWriter(file,true);     //append the text to the file
                        printfile = new PrintWriter(fileWriter, true );     //autoflush enabled
                        printfile.print("\n\nPresent Value = "+PV+ "\nNumber of Periods = "+NumDATE+
                                " years\nDATE = "+ LocalDate.now()+"\t||\tTIME = "+ java.time.LocalTime.now()); //writing to file
                        fileWriter.close();                                 //close file writer
                        printfile.close();                                  //close print writer
                        FileWriterNUM = new FileWriter(FileNUM);
                        PrintFileNUM = new PrintWriter(FileWriterNUM, true);
                        PrintFileNUM.print(futureVal + "," + interestAmnt + "," + startPrincipal + "," + payment); //writing to file
                        FileWriterNUM.close();                              //close file writer
                        PrintFileNUM.close();                               //close print writer
                    }
                }
                catch (NumberFormatException | IOException e) {      //check if anything other than integers or double is entered
                    Alert alerttxt = new Alert(Alert.AlertType.ERROR);
                    alerttxt.setTitle("ERROR!!!");
                    alerttxt.setHeaderText(null);
                    alerttxt.setContentText("Please enter valid Inputs!");
                    alerttxt.showAndWait();
                }
            }
        });

        clear4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fv4TF.setText("");
                IntR4TF.setText("");
                startPr4TF.setText("");
                pmt4TF.setText("");
                displayRes.setText("");
                displayPresentValRes.setText("");
            }
        });
//=====================================================================================================================>
//calculate [SRART PRINCIPAL]
        calculate5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{//changing inputs to String
                String futureValue = fv5TF.getText();
                String interestAmnt = IntR5TF.getText();
                String numberOfPeriods = numP5TF.getText();
                String payment = pmt5TF.getText();
                //check if there is any txtfield is left blank
                if (futureValue.equals("") || interestAmnt.equals("") || numberOfPeriods.equals("") || payment.equals("")){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR!!!");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter in all the fields!");
                    alert.showAndWait();
                }
                double InterestValue = Double.parseDouble(interestAmnt)/100;
                double FutureValue = Double.parseDouble(futureValue);
                double numOfPrds = Double.parseDouble(numberOfPeriods);
                double Payment = Double.parseDouble(payment);

                double StartPrincipalUP = FutureValue - Payment*((Math.pow(1 + InterestValue,numOfPrds)-1)/InterestValue);
                double StartPrincipalDOWN = Math.pow(1 + InterestValue,numOfPrds);
                double StartPrincipal = (StartPrincipalUP / StartPrincipalDOWN);

                double PresentVal = FutureValue * Math.pow(1 + InterestValue,-numOfPrds);

                String PV = NumberFormat.getCurrencyInstance().format(PresentVal);                      //Format string to a currency($)
                String StartP = NumberFormat.getCurrencyInstance().format(StartPrincipal);              //Format string to a currency($)

                displayRes.setText(StartP);
                displayPresentValRes.setText(PV);
                    //Creating a file to collect past calculations
                    try {
                        file = new File("FinanceFile.txt");         //check if there is file in that name
                        file.createNewFile();                                // else create a file
                        FileSTART = new File("StartFile.txt");
                        FileSTART.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        fileWriter = new FileWriter(file,true);                 //append the text to the file
                        printfile = new PrintWriter(fileWriter, true );        //autoflush enabled
                        printfile.print("\n\nPresent Value = "+PV+ "\nStart Principle Value = "+StartP+
                                "\nDATE = "+ LocalDate.now()+"\t||\tTime = "+ java.time.LocalTime.now()); //write to the file
                        fileWriter.close();                                 //close file writer
                        printfile.close();                                  //close print writer

                        FileWriterSTART = new FileWriter(FileSTART);
                        PrintFileSTART = new PrintWriter(FileWriterSTART, true);
                        PrintFileSTART.print(futureValue + "," + interestAmnt + "," + numberOfPeriods + "," + payment); //write to the file
                        FileWriterSTART.close();
                        PrintFileSTART.close();
                    }
                }
                catch (NumberFormatException | IOException e) {      //check if anything other than integers or double is entered
                    Alert alerttxt = new Alert(Alert.AlertType.ERROR);
                    alerttxt.setTitle("ERROR!!!");
                    alerttxt.setHeaderText(null);
                    alerttxt.setContentText("Please enter valid Inputs!");
                    alerttxt.showAndWait();
                }
            }
        });

        clear5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                numP5TF.setText("");
                IntR5TF.setText("");
                fv5TF.setText("");
                pmt5TF.setText("");
                displayRes.setText("");
                displayPresentValRes.setText("");
            }
        });
//=====================================================================================================================>
//Past calculations
        Button backBTN = new Button("Back");
        backBTN.setLayoutX(930);
        backBTN.setMinSize(70,40);
        backBTN.setStyle("-fx-background-color: red ; -fx-text-fill: white; -fx-font-weight: bolder");

        Label pastHeading = new Label("Past Finance Calculations");
        pastHeading.setLayoutX(330);
        pastHeading.setLayoutY(30);
        pastHeading.setStyle("-fx-font-family: serif;-fx-font-size: 35; -fx-font-weight: bolder; -fx-underline: true");

        Label pastValues = new Label();
        pastValues.setLayoutX(35);
        pastValues.setLayoutY(100);
        pastValues.setStyle("-fx-font-family: serif;-fx-font-size: 20");

        Button past = new Button("Past Calculations");
        past.setLayoutX(145);
        past.setLayoutY(570);
        past.setMinSize(250,50);
        past.setStyle(" -fx-font-size: 23; -fx-font-weight: bold;-fx-background-radius:15 ; -fx-border-radius:15 ; -fx-background-color:brown; -fx-border-color: black ;-fx-text-fill: white");
//=====================================================================================================================>
// writing in Finance.txt   //Creating new window
        past.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage past = new Stage();
                Pane pastPane = new Pane();
                pastPane.setStyle("-fx-background-color: lightblue");
                pastValues.setText("");
                ScrollPane historyScroll = new ScrollPane();                                    //ScrollPane because there are many information in it
                historyScroll.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.NEVER);  //disable horizontal scroll bar
                String readOUT= null;                                                           //
                FileReader fileREADER = null;
                try {       //check if there is file in that name
                    file = new File("FinanceFile.txt");                           // else create a file
                    file.createNewFile();
                } catch (IOException e) {
                    System.out.println("Creating File");
                }
                try {
                    fileREADER = new FileReader("FinanceFile.txt");                    //FILE Writer created
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                BufferedReader buffer =new BufferedReader(fileREADER);                          //Buffer reader created to read the txt file
                while (true){
                    try {
                        if (!((readOUT= buffer.readLine()) != null)) break;                     //read the file until there is empty space
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    pastValues.setText(readOUT+"\n"+pastValues.getText());                      //printing the txt to the label
                }
                backBTN.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        past.close();
                    }
                });
                pastPane.getChildren().addAll(backBTN,pastValues,pastHeading);
                historyScroll.setContent(pastPane);
                historyScroll.setStyle("-fx-background-color: lightblue");
                past.setTitle("Past Finance Calculations");
                past.setMaxWidth(1020);
                past.setScene(new Scene(historyScroll,1000,500));
                past.show();
            }
        });
//=====================================================================================================================>
//[FV] restore text field
        String fvREAD = null;                                                           //To reference one line at a time
        FileReader fvFileReader = null;
        try{
            FileFV = new File("FVfile.txt");
            FileFV.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fvFileReader = new FileReader("FVfile.txt");                    //FILE Reader created

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader fvbuffer =new BufferedReader(fvFileReader);                          //Buffer reader created to read the txt file
        while (true){
            try {
                if ((fvREAD = fvbuffer.readLine()) == null) break;    //read the file until there is empty space
                DisplayNewFV = fvREAD.split(",");               //splitting the file to read the text
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            numP1TF.setText(DisplayNewFV[0]);
            startPr1TF.setText(DisplayNewFV[1]);
            IntR1TF.setText(DisplayNewFV[2]);
            pmt1TF.setText(DisplayNewFV[3]);
        } catch (NullPointerException ex){
            System.out.println("Nothing to read");
        }
//=====================================================================================================================>
//[PMT] restore text field
        String pmtREAD = null;                                                   //To reference one line at a time
        FileReader pmtFileReader = null;
        try{
            FilePMT = new File("PMTfile.txt");
            FilePMT.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            pmtFileReader = new FileReader("PMTfile.txt");               //FILE Reader created

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader pmtbuffer =new BufferedReader(pmtFileReader);            //Buffer reader created to read the txt file
        while (true){
            try {
                if ((pmtREAD = pmtbuffer.readLine()) == null) break;            //read the file until there is empty space
                DisplayNewPMT = pmtREAD.split(",");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fv2TF.setText(DisplayNewPMT[0]);
            numP2TF.setText(DisplayNewPMT[1]);
            startPr2TF.setText(DisplayNewPMT[2]);
            IntR2TF.setText(DisplayNewPMT[3]);
        } catch (NullPointerException ex){                                      //Exception if the file is empty
            System.out.println("Nothing to read");
        }
//=====================================================================================================================>
//[I/Y] restore text field
        String intREAD = null;                                                   //To reference one line at a time
        FileReader intFileReader = null;
        try{
            FileINT = new File("InterestRateFile.txt");
            FileINT.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            intFileReader = new FileReader("InterestRateFile.txt");               //FILE Reader created

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader intbuffer =new BufferedReader(intFileReader);            //Buffer reader created to read the txt file
        while (true){
            try {
                if ((intREAD = intbuffer.readLine()) == null) break;            //read the file until there is empty space
                DisplayNewINT = intREAD.split(",");                       //splitting the file to read the text
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fv3TF.setText(DisplayNewINT[0]);
            numP3TF.setText(DisplayNewINT[1]);
            startPr3TF.setText(DisplayNewINT[2]);
        } catch (NullPointerException ex){                                      //Exception if the file is empty
            System.out.println("Nothing to read");
        }
//=====================================================================================================================>
//[N] restore text field
        String numREAD = null;                                                   //To reference one line at a time
        FileReader numFileReader = null;
        try{
            FileNUM = new File("Num.Of.Periods.txt");
            FileNUM.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            numFileReader = new FileReader("Num.Of.Periods.txt");               //FILE Reader created

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader numbuffer =new BufferedReader(numFileReader);            //Buffer reader created to read the txt file
        while (true){
            try {
                if ((numREAD = numbuffer.readLine()) == null) break;            //read the file until there is empty space
                DisplayNewNUM = numREAD.split(",");                       //splitting the file to read the text
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fv4TF.setText(DisplayNewNUM[0]);
            IntR4TF.setText(DisplayNewNUM[1]);
            startPr4TF.setText(DisplayNewNUM[2]);
            pmt4TF.setText(DisplayNewNUM[3]);
        } catch (NullPointerException ex){                                      //Exception if the file is empty
            System.out.println("Nothing to read");
        }
//=====================================================================================================================>
// [start principal] restore text field
        String startREAD = null;                                                   //To reference one line at a time
        FileReader startFileReader = null;

        try{
            FileSTART = new File("StartFile.txt");
            FileSTART.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            startFileReader = new FileReader("StartFile.txt");               //FILE Reader created

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader startbuffer =new BufferedReader(startFileReader);            //Buffer reader created to read the txt file
        while (true){
            try {
                if ((startREAD = startbuffer.readLine()) == null) break;            //read the file until there is empty space
                DisplayNewSTART = startREAD.split(",");                       //splitting the file to read the text
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fv5TF.setText(DisplayNewSTART[0]);
            IntR5TF.setText(DisplayNewSTART[1]);
            numP5TF.setText(DisplayNewSTART[2]);
            pmt5TF.setText(DisplayNewSTART[3]);
        } catch (NullPointerException ex){                                          //splitting the file to read the text
            System.out.println("Nothing to read");
        }
//=====================================================================================================================>
//KEYBOARD ACCESS [FV]
        numP1TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                numP1TF.setText(NumberPad.NumpadSetText());
            }
        });
        IntR1TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                IntR1TF.setText(NumberPad.NumpadSetText());
            }
        });
        startPr1TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                startPr1TF.setText(NumberPad.NumpadSetText());
            }
        });
        pmt1TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pmt1TF.setText(NumberPad.NumpadSetText());
            }
        });
//=====================================================================================================================>
//KEYBOARD ACCESS [PMT]
        numP2TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                numP2TF.setText(NumberPad.NumpadSetText());
            }
        });
        IntR2TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                IntR2TF.setText(NumberPad.NumpadSetText());
            }
        });
        startPr2TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                startPr2TF.setText(NumberPad.NumpadSetText());
            }
        });
        fv2TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                fv2TF.setText(NumberPad.NumpadSetText());
            }
        });
//=====================================================================================================================>
//KEYBOARD ACCESS [I/Y]
        fv3TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                fv3TF.setText(NumberPad.NumpadSetText());
            }
        });
        numP3TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                numP3TF.setText(NumberPad.NumpadSetText());
            }
        });
        startPr3TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                startPr3TF.setText(NumberPad.NumpadSetText());
            }
        });
//=====================================================================================================================>
//KEYBOARD ACCESS [N]
        fv4TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                fv4TF.setText(NumberPad.NumpadSetText());
            }
        });
        IntR4TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                IntR4TF.setText(NumberPad.NumpadSetText());
            }
        });
        startPr4TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                startPr4TF.setText(NumberPad.NumpadSetText());
            }
        });
        pmt4TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pmt4TF.setText(NumberPad.NumpadSetText());
            }
        });
//=====================================================================================================================>
//KEYBOARD ACCESS [Start Principal]
        numP5TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                numP5TF.setText(NumberPad.NumpadSetText());
            }
        });
        IntR5TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                IntR5TF.setText(NumberPad.NumpadSetText());
            }
        });
        fv5TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                fv5TF.setText(NumberPad.NumpadSetText());
            }
        });
        pmt5TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pmt5TF.setText(NumberPad.NumpadSetText());
            }
        });
//=====================================================================================================================>
        form1.getTabs().addAll(tab1,tab2,tab3,tab4,tab5);     // adding the tabs to the pane
        Pane insertForm1 = new Pane(mainName,viewImg,form1);          // adding the tab pane to another pane || Textfields
        Pane result = new Pane();                   // pane to display calculated amount
        Pane selectPane = new Pane();               // pane to select scene

        HBox financeBox = new HBox();                // pane contains all the pane
        financeBox.setStyle("-fx-background-color: #236B8E; -fx-font-family: serif");

        Scene financeScene = new Scene(financeBox, 1500,730);   // scene that contains the Hbox

        selectPane.setMinWidth(500);
        result.setMinWidth(500);
        form1.setMinWidth(500);
//=====================================================================================================================>
//Inserting Pane and elements
        tab1contents.getChildren().addAll(numP1,numP1TF,startPr1,startPr1TF,IntR1,IntR1TF,pmt1,pmt1TF,calculate1,clear1);
        tab2contents.getChildren().addAll(fv2,fv2TF,numP2,numP2TF,startPr2,startPr2TF,IntR2,IntR2TF,calculate2,clear2);
        tab3contents.getChildren().addAll(fv3,fv3TF,numP3,numP3TF,startPr3,startPr3TF,calculate3,clear3);
        tab4contents.getChildren().addAll(fv4,fv4TF,IntR4,IntR4TF,startPr4,startPr4TF,pmt4,pmt4TF,calculate4,clear4);
        tab5contents.getChildren().addAll(fv5,fv5TF,IntR5,IntR5TF,numP5,numP5TF,pmt5,pmt5TF,calculate5,clear5);
        tab1.setContent(tab1contents);
        tab2.setContent(tab2contents);
        tab3.setContent(tab3contents);
        tab4.setContent(tab4contents);
        tab5.setContent(tab5contents);
        result.getChildren().addAll(past,headlbl,displaylbl,displayRes,displayPresentVal,displayPresentValRes); //result pane
        selectPane.getChildren().addAll(NumberPad.keyboard());             //selecting scene
        financeBox.getChildren().addAll(insertForm1,result,selectPane);    //adding panes to hBox

        return financeScene;
    }
}