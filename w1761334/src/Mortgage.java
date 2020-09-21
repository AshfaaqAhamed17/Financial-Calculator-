import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;

public class Mortgage {
    public static File file;
    public static PrintWriter printfile;            //print writer to write the past calc.
    public static FileWriter fileWriter;            //file writer to write & append past calc.
    public static File returnFile;
    public static PrintWriter returnPrintFile;      //print writer to write the recent past calc.
    public static FileWriter returnFileWriter;      //file writer to write & append recent past calc.
    public static String [] DisplayNew;             //store recent past calc ARRAY.

    public static Scene mortgageScene() {

        Label mainName = new Label(" Mortgage Calculator");      //Main Heading
        mainName.setLayoutX(22);
        mainName.setLayoutY(30);
        mainName.setMinSize(610,75);
        mainName.setStyle("-fx-font-size: 60; -fx-text-fill:black;-fx-border-color:white ;-fx-border-radius:15; -fx-background-radius:15; -fx-background-color:#00ced1; -fx-opacity:0.4 ");

        Image img = new Image("file:calculator-img.png");
        ImageView viewImg = new ImageView(img);
        viewImg.setFitHeight(75);
        viewImg.setFitWidth(75);
        viewImg.setLayoutX(545);
        viewImg.setLayoutY(30);

        Pane form1 = new Pane();                            // Pane for the text field area
        Pane result = new Pane();                           // Pane to display calculated amounts
        Pane selectPane = new Pane();                       // Pane to change the calculator

        HBox mortgageBox = new HBox();                      // Pane that contains all the above panes
        mortgageBox.setStyle("-fx-background-color: #236B8E; -fx-font-family: serif ");

        Scene mortgageScene = new Scene(mortgageBox, 1500,730);   // Scene that contains the pane

        selectPane.setMinWidth(500);
        result.setMinWidth(500);        //Width of all 3 panes
        form1.setMinWidth(500);
//=====================================================================================================================>
        Label homePrice = new Label("Home Price");      // Label for home price
        homePrice.setLayoutX(70);
        homePrice.setLayoutY(190);
        homePrice.setStyle("-fx-font-size:20;-fx-text-fill: white");

        TextField homePriceTF = new TextField();            // home price text field
        homePriceTF.setLayoutX(220);
        homePriceTF.setLayoutY(185);
        homePriceTF.setPromptText("$");
        homePriceTF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Label DP = new Label("Down Payement");          //down payment label
        DP.setLayoutX(70);
        DP.setLayoutY(240);
        DP.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField DPTF = new TextField();                   //down payment textfield
        DPTF.setLayoutX(220);
        DPTF.setLayoutY(235);
        DPTF.setPromptText("$");
        DPTF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Label loan = new Label("Loan Term");            //loan term label
        loan.setLayoutX(70);
        loan.setLayoutY(290);
        loan.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField loanTF = new TextField();                 // loan term text field
        loanTF.setLayoutX(220);
        loanTF.setLayoutY(285);
        loanTF.setPromptText("Years");
        loanTF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Label IntR = new Label("Interest Rate");       // interest rate label
        IntR.setLayoutX(70);
        IntR.setLayoutY(340);
        IntR.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField IntRTF = new TextField();                 // interest rate text field
        IntRTF.setLayoutX(220);
        IntRTF.setLayoutY(335);
        IntRTF.setPromptText("%");
        IntRTF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Label SDate = new Label("Start Year");          // start date label
        SDate.setLayoutX(70);
        SDate.setLayoutY(390);
        SDate.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        TextField SDateTF = new TextField("2020");          // start date text field
        SDateTF.setLayoutX(220);
        SDateTF.setLayoutY(385);
        SDateTF.setPromptText("Year");
        SDateTF.setStyle("-fx-alignment: center-right; -fx-font-size: 20");

        Button calculate = new Button("Calculate Monthly Pay");    // calculate button
        calculate.setLayoutX(85);
        calculate.setLayoutY(510);
        calculate.setMinSize(300,55);
        calculate.setStyle(" -fx-font-size: 22; -fx-background-radius:15 ; -fx-border-radius:15 ; -fx-font-weight: bold; -fx-background-color:forestgreen; -fx-border-color: black ;-fx-text-fill: white");

        Button clear = new Button("Clear All");         // clear button
        clear.setLayoutX(155);
        clear.setLayoutY(585);
        clear.setMinSize(150,40);
        clear.setStyle("-fx-font-size: 22;-fx-font-weight: bold; -fx-background-radius:15 ; -fx-border-radius:15 ; -fx-background-color:red; -fx-border-color: black ;-fx-text-fill: white");

//=====================================================================================================================>
/*result show*/

        Label headlbl = new Label("Calculated Amounts");     // HEADING
        headlbl.setLayoutX(95);
        headlbl.setLayoutY(130);
        headlbl.setMinWidth(370);
        headlbl.setStyle(" -fx-font-size: 40; -fx-alignment: center; -fx-underline:true");

        Label monthly = new Label("Monthly Pay");    // Monthly pay value label                   //[1]
        monthly.setLayoutX(50);
        monthly.setLayoutY(200);
        monthly.setMinWidth(400);
        monthly.setStyle("-fx-font-size: 35 ;-fx-text-fill: white");

        Label monthlyRes = new Label(":");          // Monthly pay value calculated amount display       //[-1]
        monthlyRes.setLayoutX(105);
        monthlyRes.setLayoutY(200);
        monthlyRes.setMinWidth(400);
        monthlyRes.setStyle("-fx-font-size: 30 ; -fx-alignment: center ; -fx-font-weight: bolder;-fx-text-fill: white;");

        Label houseP = new Label("House Price");    // house price label  [2]
        houseP.setLayoutX(50);
        houseP.setLayoutY(270);
        houseP.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        Label houseRes = new Label(":");            // house price calculated amount display  [-2]
        houseRes.setLayoutX(300);
        houseRes.setLayoutY(270);
        houseRes.setStyle("-fx-font-size: 20 ;-fx-text-fill: white; -fx-font-weight: bold");

        Label Loanamt = new Label("Loan Amount");       // loan amount label    [3]
        Loanamt.setLayoutX(50);
        Loanamt.setLayoutY(320);
        Loanamt.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        Label LoanamtRes = new Label(":");              // loan amount calculated amount display    [-3]
        LoanamtRes.setLayoutX(300);
        LoanamtRes.setLayoutY(320);
        LoanamtRes.setStyle("-fx-font-size: 20;-fx-text-fill: white; -fx-font-weight: bold");

        Label DownP = new Label("Down Payment");        // down payment label   [4]
        DownP.setLayoutX(50);
        DownP.setLayoutY(370);
        DownP.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        Label DownPRes = new Label(":");                // down payment calculated amount display   [-4]
        DownPRes.setLayoutX(300);
        DownPRes.setLayoutY(370);
        DownPRes.setStyle("-fx-font-size: 20;-fx-text-fill: white; -fx-font-weight: bold");

        Label MPmt = new Label("Total Mortgage Payments");   //total mortgage label
        MPmt.setLayoutX(50);
        MPmt.setLayoutY(420);
        MPmt.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        Label MPmtRes = new Label(":");                 // total mortgage calculated amount display
        MPmtRes.setLayoutX(300);
        MPmtRes.setLayoutY(420);
        MPmtRes.setStyle("-fx-font-size: 20;-fx-text-fill: white; -fx-font-weight: bold");

        Label TotInt = new Label("Total Interest");     // total interest label
        TotInt.setLayoutX(50);
        TotInt.setLayoutY(470);
        TotInt.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        Label TotIntRes = new Label(":");               // total interest calculated amount display
        TotIntRes.setLayoutX(300);
        TotIntRes.setLayoutY(470);
        TotIntRes.setStyle("-fx-font-size: 20;-fx-text-fill: white; -fx-font-weight: bold");

        Label PayOff = new Label("Mortgage PayOff Date");       // payoff date label
        PayOff.setLayoutX(50);
        PayOff.setLayoutY(520);
        PayOff.setStyle("-fx-font-size: 20;-fx-text-fill: white");

        Label PayOffRes = new Label(":");               // payoff date calculated amount display
        PayOffRes.setLayoutX(300);
        PayOffRes.setLayoutY(520);
        PayOffRes.setStyle("-fx-font-size: 20;-fx-text-fill: white; -fx-font-weight: bold");
//=====================================================================================================================>
        calculate.setOnAction(new EventHandler<ActionEvent>() { //Calculate monthly mortgage amount
            @Override
            public void handle(ActionEvent event) {
                try {   //Get text as string
                    final double months = 12;
                    String HomePrice = homePriceTF.getText();
                    String DownPayment = DPTF.getText();
                    String Loantrms = loanTF.getText();
                    String IR = IntRTF.getText();
                    String StrtDte = SDateTF.getText();
                    //check if there is any txtfield is left blank
                    if (HomePrice.equals("") || DownPayment.equals("") || Loantrms.equals("") || IR.equals("") || StrtDte.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setHeaderText(null);
                        alert.setContentText("Please enter in all the fields!");
                        alert.showAndWait();
                    }
                    double PayOff = Double.parseDouble(StrtDte) + Double.parseDouble(Loantrms);              //To find Pay off date

                    double LoanAmount = Double.parseDouble(HomePrice) - Double.parseDouble(DownPayment);    //Calculation to find loan amount

                    double PMTup = (LoanAmount * (Double.parseDouble(IR) / (months * 100)) * Math.pow(1 + (Double.parseDouble(IR) / (months * 100)), Double.parseDouble(Loantrms) * months));
                    double PMTdwn = (Math.pow(1 + (Double.parseDouble(IR) / (months * 100)), Double.parseDouble(Loantrms) * months) - 1);
                    double PMT = PMTup / PMTdwn;                                                            //calculation to find monthly payment

                    double TotMortgage = PMT * Double.parseDouble(Loantrms) * months;                       //calculation to find total mortgage

                    double TotInterest = TotMortgage - LoanAmount;                                          //calculate total interest

                    double HP = Double.parseDouble(HomePrice);                                              //change to double to string format to currency
                    double DP = Double.parseDouble(DownPayment);                                            //change to double to string format to currency
                    DecimalFormat DATE = new DecimalFormat("####");                                  //Decimal format date to 2 decimals

                    String monthlyPayment = NumberFormat.getCurrencyInstance().format(PMT);              //Format string to a currency($)   monthly payment
                    String TotLoan = NumberFormat.getCurrencyInstance().format(LoanAmount);              //Format string to a currency($)   Loan Amount
                    String TotMort = NumberFormat.getCurrencyInstance().format(TotMortgage);             //Format string to a currency($)   total mortgage
                    String TotInt = NumberFormat.getCurrencyInstance().format(TotInterest);              //Format string to a currency($)   total interest
                    String HousePRICE = NumberFormat.getCurrencyInstance().format(HP);                   //Format string to a currency($)   home price
                    String DwnPmt = NumberFormat.getCurrencyInstance().format(DP);                       //Format string to a currency($)   down payment

                    monthlyRes.setText("\t\t"+monthlyPayment);                                           //SET TEXT TO RESULT PANE
                    houseRes.setText(HousePRICE);
                    LoanamtRes.setText(TotLoan);
                    DownPRes.setText(DwnPmt);
                    PayOffRes.setText(String.valueOf(DATE.format(PayOff)));
                    MPmtRes.setText(String.valueOf(TotMort));
                    TotIntRes.setText(String.valueOf(TotInt));

                    //Creating a file to collect past calculations
                    try {
                        file = new File("MortgageFile.txt");        //check if there is file in that name
                        returnFile = new File("ReturnMortgage.txt");
                        file.createNewFile();                               // else create a file
                        returnFile.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        fileWriter = new FileWriter(file,true);              //append the text to the file
                        printfile = new PrintWriter(fileWriter, true );     //autoflush enabled
                        printfile.print("\n\nTotal Interest = "+TotInt+ "\nTotal Mortgage Payments = "+TotMort+"\nTotal Loan Amount = "+TotLoan+
                                "\nHome Price = "+HousePRICE+"\nMonthly Payment Amount = "+monthlyPayment+
                                "\nDATE = "+ LocalDate.now()+"\t||\tTIME = "+ java.time.LocalTime.now()); //Writing to the file
                        fileWriter.close();                                 //close file writer
                        printfile.close();                                  //close print writer

                        returnFileWriter = new FileWriter(returnFile);              //file writer to return text to text field
                        returnPrintFile = new PrintWriter(returnFileWriter, true );     //autoflush enabled
                        returnPrintFile.print(HomePrice +","+ DownPayment +","+ Loantrms +","+ IR +","+ StrtDte);   //witing to the file
                        returnFileWriter.close();                           //Close file writer
                        returnPrintFile.close();                            //Close print writer
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
//=====================================================================================================================>
//Past calculations button
        Button backBTN = new Button("Back");
        backBTN.setLayoutX(930);
        backBTN.setMinSize(70,40);
        backBTN.setStyle("-fx-background-color: red ; -fx-text-fill: white; -fx-font-weight: bolder");

        Label pastHeading = new Label("Past Mortgage Calculations");
        pastHeading.setLayoutX(320);
        pastHeading.setLayoutY(30);
        pastHeading.setStyle("-fx-font-family: serif;-fx-font-size: 35; -fx-font-weight: bolder; -fx-underline: true");

        Label pastValues = new Label();
        pastValues.setLayoutX(35);
        pastValues.setLayoutY(100);
        pastValues.setStyle("-fx-font-family: serif ; -fx-font-size: 20");

        Button past = new Button("Past Calculations");
        past.setLayoutX(145);
        past.setLayoutY(570);
        past.setMinSize(250,50);
        past.setStyle(" -fx-font-size: 23; -fx-font-weight: bold;-fx-background-radius:15 ; -fx-border-radius:15 ; -fx-background-color:brown; -fx-border-color: black ;-fx-text-fill: white");
//=====================================================================================================================>
//writing in Mortgage.txt   //Creating new window       //Reading from file
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
                    file = new File("MortgageFile.txt");                           // else create a file
                    file.createNewFile();
                } catch (IOException e) {
                    System.out.println("Creating File");
                }
                try {
                    fileREADER = new FileReader("MortgageFile.txt");                    //FILE Reader created
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                BufferedReader buffer =new BufferedReader(fileREADER);                          //Buffer reader created to read the txt file
                while (true){
                    try {
                        if ((readOUT = buffer.readLine()) == null) break;                      //read the file until there is empty space
                        pastValues.setText(readOUT+"\n"+pastValues.getText());                 //printing the txt to the label
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                backBTN.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        past.close();
                    }
                });
                pastPane.getChildren().addAll(backBTN,pastValues,pastHeading);
                historyScroll.setContent(pastPane);
                past.setTitle("Past Mortgage Calculations");
                past.setMaxWidth(1020);
                past.setScene(new Scene(historyScroll,1000,500));
                past.show();
            }
        });
//=====================================================================================================================>
//Setting the text to the text field if the app gets closed
        String returnREAD = null;                                                       //To reference one line at a time
        FileReader returnFileReader = null;

        try {       //check if there is file in that name
            returnFile = new File("ReturnMortgage.txt");                           // else create a file
            returnFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            returnFileReader = new FileReader("ReturnMortgage.txt");            //FILE Reader created
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader buffer =new BufferedReader(returnFileReader);                    //Buffer reader created to read the txt file
        while (true){
            try {
                if ((returnREAD = buffer.readLine()) == null) break;                    //read the file until there is empty space
                DisplayNew = returnREAD.split(",");                               //splitting the file to read the text
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            homePriceTF.setText(DisplayNew[0]);
            DPTF.setText(DisplayNew[1]);
            loanTF.setText(DisplayNew[2]);
            IntRTF.setText(DisplayNew[3]);
            SDateTF.setText(DisplayNew[4]);
        } catch (NullPointerException ex){                                               //Exception if the file is empty
            System.out.println("Nothing to read");
        }
//=====================================================================================================================>
//KEYBOARD ACCESS
        homePriceTF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                homePriceTF.setText(NumberPad.NumpadSetText());
            }
        });

        DPTF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                DPTF.setText(NumberPad.NumpadSetText());
            }
        });

        loanTF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                loanTF.setText(NumberPad.NumpadSetText());
            }
        });

        IntRTF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                IntRTF.setText(NumberPad.NumpadSetText());
            }
        });

        SDateTF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                SDateTF.setText(NumberPad.NumpadSetText());
            }
        });

        clear.setOnAction(new EventHandler<ActionEvent>() {     //Clear btn
            @Override
            public void handle(ActionEvent event) {
                homePriceTF.setText("");
                DPTF.setText("");
                loanTF.setText("");
                IntRTF.setText("");
                SDateTF.setText("");
                monthlyRes.setText(":");
                houseRes.setText(":");
                LoanamtRes.setText(":");
                DownPRes.setText(":");
                PayOffRes.setText(":");
                MPmtRes.setText(":");
                TotIntRes.setText(":");
            }
        });
//=====================================================================================================================>
//adding items to pane
        form1.getChildren().addAll(mainName,viewImg,homePrice, homePriceTF, DP, DPTF, loan, loanTF, IntR, IntRTF, SDate, SDateTF, calculate, clear);    //pane with textfields
        result.getChildren().addAll(past,houseP,headlbl, monthly,monthlyRes, Loanamt, DownP, MPmt, TotInt, PayOff, houseRes, LoanamtRes, DownPRes, MPmtRes, TotIntRes, PayOffRes); //pane which displays results
        selectPane.getChildren().addAll(NumberPad.keyboard()); //adding the keyboard to a pane
        mortgageBox.getChildren().addAll(form1, result, selectPane);    //Hbox whcih contains all the 3 panes

        return mortgageScene;
    }
}