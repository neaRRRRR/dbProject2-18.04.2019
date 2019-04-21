package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class repController {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public String pat,tre,rec;

    Stage dialogStage =  new Stage();
    Scene scene;

    public TextArea patAr;
    public TextArea treAr;
    public TextArea recAr;
    public TextField txtPat;



    public void submitRep(ActionEvent acvt){

        connection = ConnectionUtil.connectdb();

        TextArea repAr = new TextArea();
        repAr.setPrefHeight(400);
        repAr.setPrefWidth(300);

        repController rc = new repController();

        rc.pat = patAr.getText();
        rc.tre = treAr.getText();
        rc.rec = recAr.getText();
        String pid = txtPat.getText();

        patientReport pr = new patientReport();

        String sql = "SELECT * FROM patients WHERE patientID = "+pid+"";

        try{

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){

                pr.patientID = rs.getInt("patientID");
                pr.doctorID = rs.getInt("doctorID");
                pr.patientName = rs.getString("patientName");
                pr.patientSurname = rs.getString("patientSurname");
                pr.patientGender = rs.getString("gender");

            }

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        pr.patDetail = rc.pat;
        pr.treatDetail = rc.tre;
        pr.recomm = rc.rec;


        repAr.appendText("~~~~~~~~~~~~Patient REPORT~~~~~~~~~~~~"+"\n"+"Patient ID :"+pr.patientID+"\n"+"Patient Name:"+pr.patientName+"\n"+"Patient Surname:"+pr.patientSurname+"\n"+"Patient Gender:"+pr.patientGender+"\n"+"--------------------------------------------"+"\n"+
                "Details of Patient:"+"\n\n"+pr.patDetail+"\n\n"+"--------------------------------------------"+"\n\n"+"Treatment Detail:"+"\n\n"+pr.treatDetail+"\n\n"+"--------------------------------------------"+"\n\n"+"Recommendation:"+"\n\n"+pr.recomm+"\n"+"--------------------------------------------");

        VBox vbox = new VBox(repAr);
        vbox.getChildren().addAll();
        Scene sc = new Scene(vbox);
        dialogStage.setScene(sc);
        dialogStage.showAndWait();


        try {
            Node node = (Node) acvt.getSource();
            dialogStage = (Stage) node.getScene().getWindow();

            scene = new Scene(FXMLLoader.load(Main.class.getResource("menu.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();

        }
        catch (Exception ev){
            ev.printStackTrace();
        }




    }

    public void backMenu(ActionEvent avcb){


        try {
            Node node = (Node) avcb.getSource();
            dialogStage = (Stage) node.getScene().getWindow();

            scene = new Scene(FXMLLoader.load(Main.class.getResource("menu.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();

        }
        catch (Exception ev){
            ev.printStackTrace();
        }





    }


}
