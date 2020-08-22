package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
      private  Text firstName, lastNAme, year, month, day;
      private  Label titleLb, outputLb;
      private  TextField firstNameTf, lastNAmeTf, yearTf, monthTf, dayTf;
      private  Button calculateeHeartRatebtn;
      private  VBox root, yearVbox, monthVBox, dayVBox;
      private HBox dateHBox;
    @Override
    public void start(Stage primaryStage) throws Exception{
            //title
        titleLb=new Label("Heart Rate Caluclator");
        //text
        firstName=new Text("First Name");
        lastNAme=new Text("Last Name");
        year=new Text("Year");
        month=new Text("Month");
        day=new Text("Day");
        //text Fileds
        firstNameTf=new TextField("First Name");
        lastNAmeTf=new TextField("Last Name");
        yearTf=new TextField("Year");
        monthTf=new TextField("Month");
        dayTf=new TextField("day");


        primaryStage.setTitle("Heart Rate Calulator");

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
