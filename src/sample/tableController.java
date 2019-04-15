package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.text.TabableView;
import java.net.URL;
import java.util.ResourceBundle;




public class tableController implements Initializable {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @FXML
    private TableView<dataTable> tableDoctors;
    @FXML
    private TableColumn<dataTable,Integer> columnID;
    @FXML
    private TableColumn<dataTable,String> columnName;
    @FXML
    private TableColumn<dataTable,String> columnSurname;
    @FXML
    private TableColumn<dataTable,String> columnGender;
    @FXML
    private TableColumn<dataTable,String> columnTel;
    @FXML
    private TableColumn<dataTable,String> columnProf;

    ObservableList<dataTable> oblist = FXCollections.observableArrayList();

    @FXML
    private TableView<dataTable2> tablePatients;
    @FXML
    private TableColumn<dataTable2,Integer> patientID;
    @FXML
    private TableColumn<dataTable2,String> patientName;
    @FXML
    private TableColumn<dataTable2,String> patientSurname;
    @FXML
    private TableColumn<dataTable2,String> patientGender;
    @FXML
    private TableColumn<dataTable2,String> patientTel;
    @FXML
    private TableColumn<dataTable2,Integer> patientDid;

    ObservableList<dataTable2> oblist2 = FXCollections.observableArrayList();



    @Override
    public void initialize(URL location, ResourceBundle resources)  {



        connection = ConnectionUtil.connectdb();

        try {
            ResultSet rs = connection.createStatement().executeQuery("select * from doctors");

            while (rs.next()) {

                oblist.add(new dataTable(rs.getInt("doctorID"), rs.getString("doctorName"), rs.getString("doctorSurname"), rs.getString("gender"), rs.getString("tel"), rs.getString("prof")));

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        columnID.setCellValueFactory(new PropertyValueFactory<>("doctorID"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("doctorName"));
        columnSurname.setCellValueFactory(new PropertyValueFactory<>("doctorSurname"));
        columnGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        columnTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        columnProf.setCellValueFactory(new PropertyValueFactory<>("prof"));

        tableDoctors.setItems(oblist);

        try{
            ResultSet rs2 = connection.createStatement().executeQuery("select * from patients");

            while(rs2.next()){

                oblist2.add(new dataTable2(rs2.getInt("patientID"),rs2.getInt("doctorID"),rs2.getString("patientName"),rs2.getString("patientSurname"),rs2.getString("gender"),rs2.getString("tel")));

            }




        }catch (Exception e){
            e.printStackTrace();
        }

        patientID.setCellValueFactory(new PropertyValueFactory<>("patientID"));
        patientDid.setCellValueFactory(new PropertyValueFactory<>("doctorID"));
        patientName.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        patientSurname.setCellValueFactory(new PropertyValueFactory<>("patientSurname"));
        patientGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        patientTel.setCellValueFactory(new PropertyValueFactory<>("tel"));


        tablePatients.setItems(oblist2);






    }

}
