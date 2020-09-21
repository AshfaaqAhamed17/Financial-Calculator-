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
import java.text.NumberFormat;
import java.time.LocalDate;

public class AutoLoan {

    public static File file;
    public static PrintWriter printfile;                    //print writer to write the past calc.
    public static FileWriter fileWriter;                    //file writer to write & append past calc.
    public static File returnFileMonthly;
    public static PrintWriter returnPrintFileMonthly;      //print writer to write the recent past calc.
    public static FileWriter returnFileWriterMonthly;      //file writer to write & append recent past calc.
    public static String [] DisplayNewMonthly;             //store recent past calc ARRAY
    public static File returnFileVehicle;
    public static PrintWriter returnPrintFileVehicle;      //print writer to write the recent past calc.
    public static FileWriter returnFileWriterVehicle;      //file writer to write & append recent past calc.
    public static String [] DisplayNewVehicle;             //store recent past calc ARRAY

    public static Scene loanScene(){

        Label mainName = new Label(" Auto Loan Calculator");     //Main heading
        mainName.setLayoutX(22);
        mainName.setLayoutY(30);
        mainName.setMinSize(640,75);
        mainName.setStyle("-fx-font-size: 60; -fx-text-fill:black; -fx-border-color:white ;-fx-border-radius:15;-fx-background-radius:15; -fx-background-color:#00ced1; -fx-opacity:0.4 ");

        Image img = new Image("file:calculator-img.png");
        ImageView viewImg = new ImageView(img);
        viewImg.setFitHeight(75);
        viewImg.setFitWidth(75);
        viewImg.setLayoutX(575);
        viewImg.setLayoutY(30);
//=====================================================================================================================>
        TabPane form1 = new TabPane();      //tab pane created
        form1.setLayoutY(130);
//=====================================================================================================================>
//Tab1
        Tab tab1 = new Tab("Monthly Pay");              //"TOTAL PRICE" tab created
        Pane tab1contents = new Pane();
        tab1.setClosable(false);
        tab1.setStyle("-fx-font-size: 16; -fx-border-color: lightblue");

        Label autoPrice1 = new Label("Auto Price");     // Label for auto price [1]
        autoPrice1.setLayoutX(70);
        autoPrice1.setLayoutY(50);
        autoPrice1.setStyle("-fx-font-size:20;-fx-text-fill: white");

        TextField autoPrice1TF = new TextField();           // auto price text field [-1]
        autoPrice1TF.setLayoutX(220);
        autoPrice1TF.setLayoutY(45);
        autoPrice1TF.setPromptText("$");
        autoPrice1TF.setStyle("-fx-alignment: center-right ; -fx-font-size: 20");

        Label loanTerm1 = new Label("Loan Term");       // loan term label [2]
        loanTerm1.setLayoutX(70);
        loanTerm1.setLayoutY(100);
        loanTerm1.setStyle("-fx-font-size:20;-fx-text-fill: white");

        TextField loanTerm1TF = new TextField();            // loan term textfield [-2]
        loanTerm1TF.setLayoutX(220);
        loanTerm1TF.setLayoutY(95);
        loanTerm1TF.setPromptText("Years");
        loanTerm1TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Label IntR1 = new Label("Interest Rate");       //interest rate label [3]
        IntR1.setLayoutX(70);
        IntR1.setLayoutY(150);
        IntR1.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField IntR1TF = new TextField();                // interest rate text field [-3]
        IntR1TF.setLayoutX(220);
        IntR1TF.setLayoutY(145);
        IntR1TF.setPromptText("%");
        IntR1TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Label dp1 = new Label("Down Payment");          // down payment label [4]
        dp1.setLayoutX(70);
        dp1.setLayoutY(200);
        dp1.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField dp1TF = new TextField();                  // down payment text field [-4]
        dp1TF.setLayoutX(220);
        dp1TF.setLayoutY(195);
        dp1TF.setPromptText("$");
        dp1TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Label salesTax1 = new Label("Sales Tax");       // salesTax in value label [5]
        salesTax1.setLayoutX(70);
        salesTax1.setLayoutY(250);
        salesTax1.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField salesTax1TF = new TextField();            // salesTax text field [-5]
        salesTax1TF.setLayoutX(220);
        salesTax1TF.setLayoutY(245);
        salesTax1TF.setPromptText("%");
        salesTax1TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Button calculate1 = new Button("Calculate Monthly Pay");    // calculate button
        calculate1.setLayoutX(85);
        calculate1.setLayoutY(340);
        calculate1.setMinSize(300,55);
        calculate1.setStyle(" -fx-font-size: 22; -fx-background-radius:15 ; -fx-border-radius:15 ; -fx-font-weight: bold; -fx-background-color:forestgreen; -fx-border-color: black ;-fx-text-fill: white");

        Button clear1 = new Button("Clear All");         // clear button
        clear1.setLayoutX(155);
        clear1.setLayoutY(415);
        clear1.setMinSize(150,40);
        clear1.setStyle("-fx-font-size: 22;-fx-font-weight: bold; -fx-background-radius:15 ; -fx-border-radius:15 ; -fx-background-color:red; -fx-border-color: black ;-fx-text-fill: white");
//=====================================================================================================================>
//Tab 2
        Tab tab2 = new Tab("Auto Price");           // "Auto Price" tab created
        Pane tab2contents = new Pane();
        tab2.setClosable(false);
        tab2.setStyle("-fx-font-size: 16; -fx-border-color: lightblue");

        Label MP2 = new Label("Monthly Pay");       // Label for Monthly Pay [1]
        MP2.setLayoutX(70);
        MP2.setLayoutY(50);
        MP2.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField MP2TF = new TextField();              // Monthly Pay text field [-1]
        MP2TF.setLayoutX(220);
        MP2TF.setLayoutY(45);
        MP2TF.setPromptText("$");
        MP2TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Label loanTerm2 = new Label("Loan Term");  // loan term label [2]
        loanTerm2.setLayoutX(70);
        loanTerm2.setLayoutY(100);
        loanTerm2.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField loanTerm2TF = new TextField();        // loan term textfield [-2]
        loanTerm2TF.setLayoutX(220);
        loanTerm2TF.setLayoutY(95);
        loanTerm2TF.setPromptText("Years");
        loanTerm2TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Label IntR2 = new Label("Interest Rate");  //interest rate label [3]
        IntR2.setLayoutX(70);
        IntR2.setLayoutY(150);
        IntR2.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField IntR2TF = new TextField();           // interest rate text field [-3]
        IntR2TF.setLayoutX(220);
        IntR2TF.setLayoutY(145);
        IntR2TF.setPromptText("%");
        IntR2TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Label dp2 = new Label("Down Payment");    //  down payment label [4]
        dp2.setLayoutX(70);
        dp2.setLayoutY(200);
        dp2.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField dp2TF = new TextField();            // down payment text field [-4]
        dp2TF.setLayoutX(220);
        dp2TF.setLayoutY(195);
        dp2TF.setPromptText("$");
        dp2TF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Label sales2Tax = new Label("Sales Tax"); // salesTax in value label [5]
        sales2Tax.setLayoutX(70);
        sales2Tax.setLayoutY(250);
        sales2Tax.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField sales2TaxTF = new TextField();      // salesTax text field [-5]
        sales2TaxTF.setLayoutX(220);
        sales2TaxTF.setLayoutY(245);
        sales2TaxTF.setPromptText("%");
        sales2TaxTF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Button calculate2 = new Button("Calculate Auto Price"); // calculate button
        calculate2.setLayoutX(85);
        calculate2.setLayoutY(340);
        calculate2.setMinSize(300,55);
        calculate2.setStyle(" -fx-font-size: 22; -fx-font-weight: bold;-fx-background-radius:15 ; -fx-border-radius:15 ; -fx-background-color:forestgreen; -fx-border-color: black ;-fx-text-fill: white");

        Button clear2 = new Button("Clear All");                    // clear button
        clear2.setLayoutX(155);
        clear2.setLayoutY(415);
        clear2.setMinSize(150,40);
        clear2.setStyle("-fx-font-size: 22;-fx-font-weight: bold;-fx-background-radius:15 ; -fx-border-radius:15 ; -fx-background-color:red; -fx-border-color: black ;-fx-text-fill: white");
//=====================================================================================================================>
//result section
        Label headlbl = new Label("Calculated Amounts");     // HEADING
        headlbl.setLayoutX(95);
        headlbl.setLayoutY(130);
        headlbl.setMinWidth(370);
        headlbl.setStyle(" -fx-font-size: 40; -fx-alignment: center; -fx-underline:true");

        Label monthlyPay = new Label("Monthly Pay");    // Monthly pay value label  [1]
        monthlyPay.setLayoutX(50);
        monthlyPay.setLayoutY(200);
        monthlyPay.setMinWidth(400);
        monthlyPay.setStyle("-fx-font-size: 35 ;-fx-text-fill: white");

        Label monthlyRes = new Label(":");              // Monthly pay value calculated amount display    [-1]
        monthlyRes.setLayoutX(105);
        monthlyRes.setLayoutY(200);
        monthlyRes.setMinWidth(400);
        monthlyRes.setStyle("-fx-font-size: 30 ; -fx-alignment: center ; -fx-font-weight: bolder;-fx-text-fill: white;");

        Label loanAmount = new Label("Total Loan Amount");    // Total loan amount label  [2]
        loanAmount.setLayoutX(50);
        loanAmount.setLayoutY(270);
        loanAmount.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        Label loanAmountRes = new Label(":");       // Total loan amount calculated amount display   [-2]
        loanAmountRes.setLayoutX(300);
        loanAmountRes.setLayoutY(270);
        loanAmountRes.setStyle("-fx-font-size: 20;-fx-text-fill: white; -fx-font-weight: bold");

        Label sales = new Label("Sale Tax");        // Sales Tax label     [3]
        sales.setLayoutX(50);
        sales.setLayoutY(320);
        sales.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        Label salesRes = new Label(":");            // Sales Tax calculated amount display      [-3]
        salesRes.setLayoutX(300);
        salesRes.setLayoutY(320);
        salesRes.setStyle("-fx-font-size: 20;-fx-text-fill: white; -fx-font-weight: bold");

        Label UpP = new Label("Up Front Payment");  // Upfront payment label     [4]
        UpP.setLayoutX(50);
        UpP.setLayoutY(370);
        UpP.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        Label UpPRes = new Label(":");              // upfront payment calculated amount display     [-4]
        UpPRes.setLayoutX(300);
        UpPRes.setLayoutY(370);
        UpPRes.setStyle("-fx-font-size: 20;-fx-text-fill: white; -fx-font-weight: bold");

        Label LPmt = new Label("Total of Loan Payments");   //total loan payments label       [5]
        LPmt.setLayoutX(50);
        LPmt.setLayoutY(420);
        LPmt.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        Label LPmtRes = new Label(":");                     //total loann payments calculated amount display      [-5]
        LPmtRes.setLayoutX(300);
        LPmtRes.setLayoutY(420);
        LPmtRes.setStyle("-fx-font-size: 20;-fx-text-fill: white; -fx-font-weight: bold");

        Label TotInt = new Label("Total Loan Interest");    // total loan interest label        [6]
        TotInt.setLayoutX(50);
        TotInt.setLayoutY(470);
        TotInt.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        Label TotIntRes = new Label(":");                   // total loan interest calculated amount display     [-6]
        TotIntRes.setLayoutX(300);
        TotIntRes.setLayoutY(470);
        TotIntRes.setStyle("-fx-font-size: 20;-fx-text-fill: white; -fx-font-weight: bold");
//=====================================================================================================================>
//Calculate Monthly payment amount
        calculate1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {   //changing inputs to String
                    final double months = 12;
                    String autoPrice1 = autoPrice1TF.getText();     //autoprice text field
                    String loanTrms = loanTerm1TF.getText();        //loan term txt fld
                    String totInt = IntR1TF.getText();              //interest txt fld
                    String dp1 = dp1TF.getText();                   //down pmt text field
                    String salesT1 = salesTax1TF.getText();         //sales tax txt field
                    //check if there is any txtfield is left blank
                    if (autoPrice1.equals("") || dp1.equals("") || salesT1.equals("") || totInt.equals("") || loanTrms.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setHeaderText(null);
                        alert.setContentText("Please enter in all the fields!");
                        alert.showAndWait();
                    }
                    double TotLoan1 = Double.parseDouble(autoPrice1) - Double.parseDouble(dp1);                   //Calculating total loan amount

                    double saleTax1 = (Double.parseDouble(autoPrice1) * (Double.parseDouble(salesT1) / 100));     //Calculating sales tax

                    double PMTup1 = (TotLoan1 * (Double.parseDouble(totInt) / (months * 100)) * Math.pow(1 + (Double.parseDouble(totInt) / (months*100)) , Double.parseDouble(loanTrms)*12 ));
                    double PMTdwn1 = (Math.pow(1 + (Double.parseDouble(totInt)/(months*100)),Double.parseDouble(loanTrms)*12 ) - 1);
                    double PMT1 = PMTup1 / PMTdwn1;                                                             //Calculating monthly pmt

                    double upFront1 = Double.parseDouble(dp1) + saleTax1;                                       //upfront calculating

                    double loanPAYMENT = PMT1 * Double.parseDouble(loanTrms)*12;                                //total loan of payments calculating

                    double totLoanInterst = loanPAYMENT - TotLoan1;                                             //calculating total loan interest

                    double autoP = Double.parseDouble(autoPrice1);                                              //change to double to string format to currency

                    String AUTOP = NumberFormat.getCurrencyInstance().format(autoP);                            //Format string to a currency($)    AutoPrice
                    String totLOAN = NumberFormat.getCurrencyInstance().format(TotLoan1);                       //Format string to a currency($)    TotalLoan
                    String salesTAX = NumberFormat.getCurrencyInstance().format(saleTax1);                      //Format string to a currency($)    SalesTax
                    String monthlyPayment = NumberFormat.getCurrencyInstance().format(PMT1);                    //Format string to a currency($)    MonthlyPayment
                    String upFRONT1 = NumberFormat.getCurrencyInstance().format(upFront1);                      //Format string to a currency($)    UpFront
                    String totPMT = NumberFormat.getCurrencyInstance().format(loanPAYMENT);                     //Format string to a currency($)    TotalPayment
                    String loanINT = NumberFormat.getCurrencyInstance().format(totLoanInterst);                 //Format string to a currency($)    TotalLoanInterest

                    monthlyRes.setText("\t\t"+monthlyPayment);      //Monthly payment
                    loanAmountRes.setText(totLOAN);                 //loan amnt
                    salesRes.setText(salesTAX);                     //sales tax
                    UpPRes.setText(upFRONT1);                       //upfront
                    LPmtRes.setText(totPMT);                        //total loan payment
                    TotIntRes.setText(loanINT);                     //total loan interest

                    //Creating a file to collect past calculations
                    try {
                        file = new File("AutoLoanFile.txt");                        //File for past calculations
                        returnFileMonthly = new File("ReturnMonthlyAutoLoan.txt");  //File to fill the  text fields
                        file.createNewFile();                   // else create a file
                        returnFileMonthly.createNewFile();      // else create a file
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        fileWriter = new FileWriter(file,true);               //append the text to the file
                        printfile = new PrintWriter(fileWriter, true );      //autoflush enabled
                        printfile.print("\n\nTotal Loan Interest = "+loanINT+ "\nTotal Sales Tax = "+salesTAX+"\nTotal Loan Amount = "+totLOAN+
                                "\nAuto Price Amount = "+AUTOP+"\nMonthly Payment Amount = "+monthlyPayment+
                                "\nDATE = "+ LocalDate.now()+"\t||\tTime = "+ java.time.LocalTime.now()); //witing to the file
                        fileWriter.close();     //close file writer
                        printfile.close();      //close print writer

                        returnFileWriterMonthly = new FileWriter(returnFileMonthly);      //file writer to return text to text field
                        returnPrintFileMonthly = new PrintWriter(returnFileWriterMonthly, true );     //autoflush enabled
                        returnPrintFileMonthly.print(autoPrice1 + "," + loanTrms + ","  + totInt + "," + dp1 +  "," + salesT1); //witing to the file
                        returnFileWriterMonthly.close();    //close file writer
                        returnPrintFileMonthly.close();     //close print writer
                    }
                }
                catch (NumberFormatException | IOException e){    //check if anything other than integers or double is entered
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
                autoPrice1TF.setText("");
                dp1TF.setText("");
                salesTax1TF.setText("");
                IntR1TF.setText("");
                loanTerm1TF.setText("");
                monthlyRes.setText(":");
                loanAmountRes.setText(":");
                salesRes.setText(":");
                UpPRes.setText(":");
                LPmtRes.setText(":");
                TotIntRes.setText(":");
            }
        });
//=====================================================================================================================>
//Calculate Auto Price amount
        calculate2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {   //changing inputs to String
                    final double months = 12;
                    String monthly2 = MP2TF.getText();
                    String loanTrms = loanTerm2TF.getText();
                    String totInt = IntR2TF.getText();
                    String dp2 = dp2TF.getText();
                    String salesT2 = sales2TaxTF.getText();
                    //check if there is any txtfield is left blank
                    if (monthly2.equals("") || dp2.equals("") || salesT2.equals("") || totInt.equals("") || loanTrms.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setHeaderText(null);
                        alert.setContentText("Please enter in all the fields!");
                        alert.showAndWait();
                    }
                    double monthly = Double.parseDouble(monthly2);                                        //convert years to months
                    double IntVal = Double.parseDouble(totInt) / 100;                                     //converting int % to decimal

                    double TotPMT = Double.parseDouble(monthly2) * Double.parseDouble(loanTrms) *12;      // calculating total loan PMT

                    double LoanAmntUP = Double.parseDouble(monthly2) * (Math.pow(1 + IntVal / months, Double.parseDouble(loanTrms)*12) - 1);
                    double LoanAmntDWN = (IntVal / months * Math.pow(1 + IntVal / months, Double.parseDouble(loanTrms)*12));
                    double LoanAmnt = LoanAmntUP / LoanAmntDWN;                                         //calculating total loan amnt

                    double AutoP = LoanAmnt + Double.parseDouble(dp2);                                  //calculating auto price

                    double saleTax1 = AutoP * (Double.parseDouble(salesT2) / 100);                      //calculating sales tax

                    double UpFront = Double.parseDouble(dp2) + saleTax1;                                //calculating upfront

                    double TotLaonInt = TotPMT - LoanAmnt;                                              //calculating tot loan interest

                    String Monthly = NumberFormat.getCurrencyInstance().format(monthly);                //Format string to a currency($)    Monthly Payment
                    String totPMT = NumberFormat.getCurrencyInstance().format(TotPMT);                  //Format string to a currency($)    TotalPayment
                    String AutoPrice = NumberFormat.getCurrencyInstance().format(AutoP);                //Format string to a currency($)    AutoPrice
                    String TotLoan = NumberFormat.getCurrencyInstance().format(LoanAmnt);               //Format string to a currency($)    TotalLoan
                    String TotIntAmnt = NumberFormat.getCurrencyInstance().format(TotLaonInt);          //Format string to a currency($)    TotalInterestAmount
                    String salesTAX = NumberFormat.getCurrencyInstance().format(saleTax1);              //Format string to a currency($)    SalesTax
                    String upFRONT = NumberFormat.getCurrencyInstance().format(UpFront);                //Format string to a currency($)    UpFront

                    loanAmountRes.setText(TotLoan);     //Total Loan amount
                    salesRes.setText(salesTAX);         //SalesTax
                    monthlyRes.setText("\t\t"+AutoPrice);//AutoPrice
                    UpPRes.setText(upFRONT);            //UpFRONT
                    LPmtRes.setText(totPMT);            //Total Loan Payment
                    TotIntRes.setText(TotIntAmnt);      //total loan interest

                    try {   //Creating a file to collect past calculations
                        file = new File("AutoLoanFile.txt");
                        file.createNewFile();
                        returnFileVehicle = new File("ReturnVehicleAutoLoan.txt");
                        returnFileVehicle.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        fileWriter = new FileWriter(file,true);             //File for past calculations
                        printfile = new PrintWriter(fileWriter, true );    //File writer for past calc
                        printfile.print("\n\nTotal Loan Interest = "+TotIntAmnt+ "\nTotal Sales Tax = "+salesTAX+"\nTotal Loan Amount = "+TotLoan+
                                "\nMonthly Payment Amount = "+Monthly+"\nAuto Price  Amount = "+AutoPrice+
                                "\nDATE = "+ LocalDate.now()+"\t||\tTime = "+ java.time.LocalTime.now()); //writing the text to the file
                        fileWriter.close();     //close file writer
                        printfile.close();      //close print writer

                        returnFileWriterVehicle = new FileWriter(returnFileVehicle);        //file to recollect data to text field
                        returnPrintFileVehicle = new PrintWriter(returnFileWriterVehicle, true );       //autoflush enabled
                        returnPrintFileVehicle.print(monthly2 + "," + loanTrms + "," + totInt + "," + dp2 + "," + salesT2);     //write to the file
                        returnFileWriterVehicle.close();        //close file writer
                        returnPrintFileVehicle.close();         //close print writer
                    }
                }
                catch (NumberFormatException | IOException e){  //check if anything other than integers or double is entered
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
                MP2TF.setText("");
                dp2TF.setText("");
                sales2TaxTF.setText("");
                IntR2TF.setText("");
                loanTerm2TF.setText("");
                monthlyRes.setText(":");
                loanAmountRes.setText(":");
                salesRes.setText(":");
                UpPRes.setText(":");
                LPmtRes.setText(":");
                TotIntRes.setText(":");
            }
        });
//=====================================================================================================================>
//Past calculations
        Button backBTN = new Button("Back");
        backBTN.setLayoutX(930);
        backBTN.setMinSize(70,40);
        backBTN.setStyle("-fx-background-color: red ; -fx-text-fill: white; -fx-font-weight: bolder");

        Label pastHeading = new Label("Past Auto Loan Calculations");
        pastHeading.setLayoutX(300);
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
// writing in AutoLoanFile.txt   //Creating new window
        past.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage past = new Stage();
                Pane pastPane = new Pane();
                pastPane.setStyle("-fx-background-color: lightblue");
                pastValues.setText("");
                ScrollPane historyScroll = new ScrollPane();                                    //ScrollPane because there are many information in it
                historyScroll.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.NEVER);  //disable horizontal scroll bar
                String readOUT= null;                                                           //To reference one line at a time
                FileReader fileREADER = null;

                try {       //check if there is file in that name
                    file = new File("AutoLoanFile.txt");                           // else create a file
                    file.createNewFile();
                } catch (IOException e) {
                    System.out.println("Creating File");
                }
                try {
                    fileREADER = new FileReader("AutoLoanFile.txt");                    //FILE Reader created
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                BufferedReader buffer =new BufferedReader(fileREADER);                          //Buffer reader created to read the txt file
                while (true){
                    try {
                        if ((readOUT = buffer.readLine()) == null) break;                       //read the file until there is empty space
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
                past.setTitle("Past Auto Loan Calculations");
                past.setMaxWidth(1020);
                past.setScene(new Scene(historyScroll,1000,500));
                past.show();
            }
        });
//=====================================================================================================================>
//Setting the text to the text field if the app gets closed     [MONTHLY PAY TAB]
        String returnREADMonthly = null;                                                    //To reference one line at a time
        FileReader returnFileReaderMonthly = null;

        try {   //Creating a file to collect past calculations
            returnFileMonthly = new File("ReturnMonthlyAutoLoan.txt");
            returnFileMonthly.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            returnFileReaderMonthly = new FileReader("ReturnMonthlyAutoLoan.txt");  //FILE Reader created

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferMonthly =new BufferedReader(returnFileReaderMonthly);          //Buffer reader created to read the txt file
        while (true){
            try {
                if ((returnREADMonthly = bufferMonthly.readLine()) == null) break;          //read the file until there is empty space
                DisplayNewMonthly = returnREADMonthly.split(",");                     //splitting the file to read the text
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            autoPrice1TF.setText(DisplayNewMonthly[0]);
            loanTerm1TF.setText(DisplayNewMonthly[1]);
            IntR1TF.setText(DisplayNewMonthly[2]);
            dp1TF.setText(DisplayNewMonthly[3]);
            salesTax1TF.setText(DisplayNewMonthly[4]);
        }catch (NullPointerException e){                                                    //Exception if the file is empty
            System.out.println("Nothing to read");
        }
//=====================================================================================================================>
//Setting the text to the text field if the app gets closed  [AUTO PRICE TAB]
        String returnREADVehicle = null;                                                    //To reference one line at a time
        FileReader returnFileReaderVehicle = null;

        try {   //Creating a file to collect past calculations
            returnFileVehicle = new File("ReturnVehicleAutoLoan.txt");
            returnFileVehicle.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            returnFileReaderVehicle = new FileReader("ReturnVehicleAutoLoan.txt");   //FILE Reader created
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferVehicle =new BufferedReader(returnFileReaderVehicle);           //Buffer reader created to read the txt file
        while (true){
            try {
                if ((returnREADVehicle = bufferVehicle.readLine()) == null) break;          //read the file until there is empty space
                DisplayNewVehicle = returnREADVehicle.split(",");                     //splitting the file to read the text
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            MP2TF.setText(DisplayNewVehicle[0]);
            loanTerm2TF.setText(DisplayNewVehicle[1]);
            IntR2TF.setText(DisplayNewVehicle[2]);
            dp2TF.setText(DisplayNewVehicle[3]);
            sales2TaxTF.setText(DisplayNewVehicle[4]);
        }catch (NullPointerException e){                                                    //Exception if the file is empty
            System.out.println("Nothing to read");
        }
//=====================================================================================================================>
//Change label items when changing tabs
        tab2.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                if (tab2.isSelected()){
                    monthlyPay.setText("Auto Price");
                    monthlyRes.setText(":");
                    loanAmountRes.setText(":");
                    salesRes.setText(":");
                    monthlyRes.setText(":");
                    UpPRes.setText(":");
                    LPmtRes.setText(":");
                    TotIntRes.setText(":");
                }
                else{
                    monthlyPay.setText("Monthly Pay");
                    monthlyRes.setText(":");
                    loanAmountRes.setText(":");
                    salesRes.setText(":");
                    monthlyRes.setText(":");
                    UpPRes.setText(":");
                    LPmtRes.setText(":");
                    TotIntRes.setText(":");
                }
            }
        });
//=====================================================================================================================>
// tab1 KEYBOARD ACCESS
        autoPrice1TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                autoPrice1TF.setText(NumberPad.NumpadSetText());
            }
        });
        dp1TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                dp1TF.setText(NumberPad.NumpadSetText());
            }
        });
        loanTerm1TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                loanTerm1TF.setText(NumberPad.NumpadSetText());
            }
        });
        IntR1TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                IntR1TF.setText(NumberPad.NumpadSetText());
            }
        });
        loanTerm1TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                loanTerm1TF.setText(NumberPad.NumpadSetText());
            }
        });
        salesTax1TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                salesTax1TF.setText(NumberPad.NumpadSetText());
            }
        });
//=====================================================================================================================>
//TAB2 keyboard acess
        MP2TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                MP2TF.setText(NumberPad.NumpadSetText());
            }
        });
        dp2TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                dp2TF.setText(NumberPad.NumpadSetText());
            }
        });
        loanTerm2TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                loanTerm2TF.setText(NumberPad.NumpadSetText());
            }
        });
        IntR2TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                IntR2TF.setText(NumberPad.NumpadSetText());
            }
        });
        loanTerm2TF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                loanTerm2TF.setText(NumberPad.NumpadSetText());
            }
        });
        sales2TaxTF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sales2TaxTF.setText(NumberPad.NumpadSetText());
            }
        });
//=====================================================================================================================>
//Inserting items to the pane
        form1.getTabs().addAll(tab1,tab2);           // adding the tabs to the pane
        Pane insertForm1 = new Pane(mainName,viewImg,form1); // adding the tab pane to another blank pane
        Pane result = new Pane();                    // pane to display calculated amount
        Pane selectPane = new Pane();                // pane to select scene

        HBox loanBox = new HBox();                   // Hbox pane contains all the pane
        loanBox.setStyle("-fx-background-color: #236B8E; -fx-font-family: serif");

        Scene loanScene = new Scene(loanBox, 1500,730);   // scene that contains the Hbox

        selectPane.setMinWidth(500);
        result.setMinWidth(500);
        form1.setMinWidth(500);
//=====================================================================================================================>
        tab1contents.getChildren().addAll(autoPrice1,autoPrice1TF,loanTerm1,loanTerm1TF,IntR1,IntR1TF,dp1,dp1TF,salesTax1,salesTax1TF,calculate1,clear1);   //Tab 1 contents
        tab2contents.getChildren().addAll(MP2,MP2TF,loanTerm2,loanTerm2TF,IntR2,IntR2TF,dp2,dp2TF,sales2Tax,sales2TaxTF,calculate2,clear2);                 //Tab 2 contents
        tab1.setContent(tab1contents);  //TAB1
        tab2.setContent(tab2contents);  //TAB2
        result.getChildren().addAll(past,headlbl,monthlyPay,monthlyRes,loanAmount,loanAmountRes,sales,salesRes,UpP,UpPRes,LPmt,LPmtRes,TotInt,TotIntRes);   //Result pane contents
        selectPane.getChildren().addAll(NumberPad.keyboard());          //selecting scene
        loanBox.getChildren().addAll(insertForm1,result,selectPane);    //adding panes to hBox

        return loanScene;
    }
}