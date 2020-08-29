package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;


public class Main extends Application  {
      private  Text firstName, lastNAme, year, monthTx, day;
      private  Label titleLb, outputLb;
      private  TextField firstNameTf, lastNAmeTf, yearTf, monthTf, dayTf;
      private  Button calculateeHeartRatebtn;
      private  VBox root, yearVbox, monthVBox, dayVBox;
      private HBox dateHBox;
      private  Alert alt;

      private  Button resetButton;
    @Override
    public void start(Stage primaryStage) throws Exception{
            //title
        titleLb=new Label("Heart Rate Caluclator");
        titleLb.setStyle("-fx-font:26px Arial");
        //text
        firstName=new Text("First Name");
        lastNAme=new Text("Last Name");
        year=new Text("Year");
        monthTx=new Text("Month");
        day=new Text("Day");
        //text Fileds
        firstNameTf=new TextField();
        lastNAmeTf=new TextField();
        yearTf=new TextField();
        monthTf=new TextField();
        dayTf=new TextField();
        outputLb=new Label();
        outputLb.setStyle("-fx-font:24px Arial; -fx-text-fill:red;");
        //button
        calculateeHeartRatebtn=new Button("Calculate Heart Rate");
        resetButton=new Button("Rest");
        //creteing chlid vBox year month day

        yearVbox=new VBox();
        monthVBox=new VBox();
        dayVBox=new VBox();
        //adding lables and TxFields
        yearVbox.getChildren().addAll(year, yearTf);
        monthVBox.getChildren().addAll(monthTx,monthTf);
        dayVBox.getChildren().addAll(day,dayTf);
       //creating date HBox
          dateHBox=new HBox();
          dateHBox.setSpacing(20);
          dateHBox.getChildren().addAll(yearVbox,monthVBox,dayVBox);

        //creating root VBox
         root=new VBox();

         root.getChildren().addAll(titleLb,firstName, firstNameTf, lastNAme,lastNAmeTf, dateHBox,
                 calculateeHeartRatebtn,resetButton,outputLb);

         alt=new Alert(Alert.AlertType.INFORMATION);

         calculateeHeartRatebtn.setOnAction(event -> {
             int year = Integer.parseInt(yearTf.getText());
             String monthtext = monthTf.getText();
             int day= Integer.parseInt(dayTf.getText());
             String fullName= firstNameTf.getText()+ " " + lastNAmeTf.getText();

             Month monthm= getMonth(monthtext);
             int ageInYear=getAgeInYears(year,monthm,day);

              double maximumHeartRate= getHeartRAte(ageInYear);
              String targetHeartRate=getTargetHeartRate(maximumHeartRate);

              String reutl;
              reutl= "Name:" + fullName + "\n" +
                      "Age: " + ageInYear + "\n" +
                      "Maximum heart Rate: " + maximumHeartRate + "\n" +
                      "Target Rate: " +
                      targetHeartRate;
              outputLb.setText(reutl);
              String outfilName=firstNameTf.getText();





              File file=new File("C:\\Users\\Awab Sabir\\Documents\\UserValue\\"+outfilName+".txt");

             try{
                 // Create file
                 FileWriter fstream = new FileWriter(file);
                 BufferedWriter out = new BufferedWriter(fstream);
                 out.write(reutl);
                 //Close the output stream
                 out.close();
                 alt.setContentText("A text file is saved" );
                 alt.show();

             }
             catch (Exception e){//Catch exception if any
                 System.err.println("Error: " + e.getMessage());
             }




         });
         resetButton.setOnAction(event -> {
             firstNameTf.clear();
             lastNAmeTf.clear();
             dayTf.clear();
             yearTf.clear();
             monthTf.clear();
             String restult=null;
             outputLb.setText(restult);

         });

        root.setSpacing(20);
        root.setPadding(new Insets(40));
        Scene scene=new Scene(root,500,600);



        primaryStage.setTitle("Heart Rate Calulator");
        primaryStage.setScene(scene);
        primaryStage.show();





    }

    private int getAgeInYears(int year, Month m,int day) {
        LocalDate today = LocalDate.now();
        LocalDate bd = LocalDate.of(year,m,day);
        Period period = Period.between(bd,today);
        return (period.getYears());
    }
    private Month getMonth(String month){
        Month m;
        if(month.equalsIgnoreCase("January")){
            m = Month.JANUARY;
        }else if(month.equalsIgnoreCase("February")){
            m = Month.FEBRUARY;
        }else if(month.equalsIgnoreCase("March")){
            m = Month.MARCH;
        }else if(month.equalsIgnoreCase("april")){
            m = Month.APRIL;
        }
        else if(month.equalsIgnoreCase("may")){
            m = Month.MAY;
        }
        else if(month.equalsIgnoreCase("june")){
            m = Month.JUNE;
        }
        else if(month.equalsIgnoreCase("July")){
            m = Month.JULY;
        }
        else if(month.equalsIgnoreCase("August")){
            m = Month.AUGUST;
        }
        else if(month.equalsIgnoreCase("September")){
            m = Month.SEPTEMBER;
        }
        else if(month.equalsIgnoreCase("October")){
            m = Month.OCTOBER;
        }
        else if(month.equalsIgnoreCase("NOVEMBER")){
            m = Month.NOVEMBER;
        }
        else if(month.equalsIgnoreCase("DECEMBER")){
            m = Month.DECEMBER;
        }
        else {
            m = Month.JANUARY;
        }
        return m;


    }
    private  double  getHeartRAte(int year){
      return  220 - year;
    }

    private  String getTargetHeartRate(double heartRate){
        return  (int)(heartRate * 0.5) + " - " + (int)(heartRate * 0.85);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
