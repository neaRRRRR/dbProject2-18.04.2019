package sample;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Controller {


    public TextField textField;
    public Label textLabel;
    public TextField textUsr;
    public TextField textPw;


    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    Stage dialogStage =  new Stage();
    Scene scene;


    public Controller(){

        connection = ConnectionUtil.connectdb();



    }

    public void button(ActionEvent actionEvent){



        String usrname = textUsr.getText().toString();
        String password = textPw.getText().toString();

        String sql = "Select * From login WHERE id = ? and pw = ?";

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,usrname);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){

                alertBox("Please enter correct username and password",null,"Failed");


            }
            else{
                alertBox("Logged in Succesfully !",null,"Success");
                Node node = (Node) actionEvent.getSource();
                dialogStage = (Stage) node.getScene().getWindow();
                dialogStage.close();
                scene = new Scene(FXMLLoader.load(getClass().getResource("menu.fxml")));
                dialogStage.setScene(scene);
                dialogStage.show();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }







    }

    public static void alertBox(String infoMessage,String headerText,String
                                title){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    public void LoadDataFromDatabase(ActionEvent event){









    }






}
