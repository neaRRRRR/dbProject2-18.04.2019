package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.sql.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;




public class tableController implements Initializable {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Stage dialogStage =  new Stage();
    Scene scene;
    public TextField textName;
    public TextField textID;
    public TextField textSurname;
    public TextField textGender;
    public TextField textTel;
    public TextField textDid;
    Statement stmt = null;
    public TextField textD;
    public  TextField textDname;
    public TextField textDsurname;
    public TextField textDgender;
    public TextField textDtel;
    public TextField textDp;

    public TextField prid;
    public  TextField rid;
    public DatePicker datePicker;

    public TextField sid;
    public TextField stName;
    public TextField stSurname;
    public TextField deptName;
    public TextField staffGen;
    public TextField stafDoc;

    public TextField patDelete;
    public TextField docDel;
    public TextField staffDel;
    public TextField roomDel;
    public TextField selPat;

    public TextArea txtAr;




    private AnchorPane content;

    private AnchorPane menuPane;


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

    @FXML
    private  TableView<dataTable3>  tableRooms;
    @FXML
    private TableColumn<dataTable3,Integer> patID;
    @FXML
    private TableColumn<dataTable3,Integer> roomID;
    @FXML
    private TableColumn<dataTable3, String> dateTim;

    ObservableList<dataTable3> oblist3 = FXCollections.observableArrayList();

    @FXML
    private TableView<dataTable4> tableStaff;
    @FXML
    private TableColumn<dataTable4,Integer> staaID;
    @FXML
    private TableColumn<dataTable4,String> staaName;
    @FXML
    private TableColumn<dataTable4,String> staaSurname;
    @FXML
    private TableColumn<dataTable4,String> staaDept;
    @FXML
    private TableColumn<dataTable4,String> staaGender;
    @FXML
    private TableColumn<dataTable4,Integer> staaDid;

    ObservableList<dataTable4> oblist4 = FXCollections.observableArrayList();




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

        try{
            ResultSet rs3 = connection.createStatement().executeQuery("select * from room");


            while(rs3.next()){


                oblist3.add(new dataTable3(rs3.getInt("patientID"),rs3.getInt("roomID"),rs3.getString("roomDate")));


            }


        }catch (Exception e){
            e.printStackTrace();
        }


        patID.setCellValueFactory(new PropertyValueFactory<>("patientID"));
        roomID.setCellValueFactory(new PropertyValueFactory<>("roomID"));
        dateTim.setCellValueFactory(new PropertyValueFactory<>("dateTime"));


        tableRooms.setItems(oblist3);

        try{
            ResultSet rs4 = connection.createStatement().executeQuery("select * from staff");

            while(rs4.next()){

                oblist4.add(new dataTable4(rs4.getInt("StaffID"),rs4.getInt("DoctorID"),rs4.getString("StaffName"),rs4.getString("StaffSurName"),rs4.getString("DeptName"),rs4.getString("Gender")));

            }


        }catch (Exception e){
            e.printStackTrace();
        }

        staaID.setCellValueFactory(new PropertyValueFactory<>("staffID"));
        staaDid.setCellValueFactory(new PropertyValueFactory<>("sdoctorId"));
        staaName.setCellValueFactory(new PropertyValueFactory<>("staffName"));
        staaSurname.setCellValueFactory(new PropertyValueFactory<>("staffSurname"));
        staaDept.setCellValueFactory(new PropertyValueFactory<>("staffDept"));
        staaGender.setCellValueFactory(new PropertyValueFactory<>("staffGender"));

        tableStaff.setItems(oblist4);


    }

    public void addPatient(ActionEvent e){

        connection = ConnectionUtil.connectdb();


        String pID = textID.getText();
        String pName = textName.getText();
        String pSurname = textSurname.getText();
        String pGender = textGender.getText();
        String pTel = textTel.getText();
        String pDid = textDid.getText();

        String sql = "INSERT INTO patients (patientID, patientName, patientSurname, gender, tel, doctorID) VALUES ('"+pID+"', '"+pName+"', '"+pSurname+"', '"+pGender+"', '"+pTel+"', '"+pDid+"');";


        try{

                PreparedStatement statement = connection.prepareStatement(sql);
                statement.executeUpdate();


        }
        catch (Exception ex){
            ex.printStackTrace();
        }







    }

    public void addDoctor(ActionEvent ac){

        connection = ConnectionUtil.connectdb();


        String dID = textD.getText();
        String dName = textDname.getText();
        String dSurname = textDsurname.getText();
        String dGender = textDgender.getText();
        String dTel = textDtel.getText();
        String dDid = textDp.getText();

        String sql = "INSERT INTO doctors (doctorID, doctorName, doctorSurname, gender, tel, prof) VALUES ('"+dID+"', '"+dName+"', '"+dSurname+"', '"+dGender+"', '"+dTel+"', '"+dDid+"');";


        try{

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();


        }
        catch (Exception ex){
            ex.printStackTrace();
        }






    }

    public void addRoom(ActionEvent act){


        connection = ConnectionUtil.connectdb();


        String pr = prid.getText();
        String ri = rid.getText();
        LocalDate dat = datePicker.getValue();
        System.out.println(dat);

        String sql = "INSERT INTO room (patientID, roomID, roomDate) VALUES ('"+pr+"', '"+ri+"', '"+dat+"');";


        try{

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();


        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void addStaff(ActionEvent avt){

        connection = ConnectionUtil.connectdb();

        String sidd = sid.getText();
        String sttName = stName.getText();
        String sttSurname = stSurname.getText() ;
        String depttName = deptName.getText();
        String stafGen = staffGen.getText();
        String staffDoc = stafDoc.getText();

        String sql = "INSERT INTO staff (StaffID, StaffName, StaffSurname, DeptName, Gender, DoctorID) VALUES ('"+sidd+"', '"+sttName+"', '"+sttSurname+"','"+depttName+"','"+stafGen+"','"+staffDoc+"');";

        try{

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();


        }
        catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public void deletePat(ActionEvent actv){

        String del1 = patDelete.getText();

        String sql = "DELETE FROM patients WHERE patientID = '"+del1+"'";

        try{

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();


        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void deleteDoc(ActionEvent actvv){

        String del1 = docDel.getText();

        String sql = "DELETE FROM doctors WHERE doctorID = '"+del1+"'";

        try{

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();


        }
        catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public void deleteStaff(ActionEvent actr){

        String del1 = staffDel.getText();

        String sql = "DELETE FROM staff WHERE StaffID = '"+del1+"'";

        try{

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();


        }
        catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public void deleteRoom(ActionEvent edc){

        String del1 = roomDel.getText();

        String sql = "DELETE FROM room WHERE roomID = '"+del1+"'";

        try{

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();


        }
        catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public void showDisp(ActionEvent avtr){

        String sql = "SELECT * FROM outpatient";

        try{

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){

                int pid = rs.getInt("pid");
                String pname = rs.getString("pname");
                String psurname = rs.getString("psurname");
                String dsc = rs.getString("discharged");

                txtAr.appendText("OLD patient ID:"+pid+"\n"+
                "OLD Patient name:"+pname+"\n"+"OLD Patient surname:"+psurname+"\n"+"Discharged time:"+dsc+"\n"+"~~~~~~~~~~~~~~"+"\n");





            }

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }




    }

    public void createRep(ActionEvent eac){




        try {
            Node node = (Node) eac.getSource();
            dialogStage = (Stage) node.getScene().getWindow();

            scene = new Scene(FXMLLoader.load(Main.class.getResource("reportInfo.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();

        }
        catch (Exception ev){
            ev.printStackTrace();
        }



    }

    public void totalBill(ActionEvent axz){

        String sql = "SELECT * FROM totalbill";

        try{

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){

                int pid = rs.getInt("PatientID");
                int total = rs.getInt("total");

                txtAr.appendText("Patient ID: "+pid+"\n"+"Cost: "+total+"$"+"\n"+"-----------------");





            }

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public void genderOrd(ActionEvent azxz){

        String sql = "Call genderClasf()";

        txtAr.appendText("PATIENTS\n");
        try{

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){

                int m = rs.getInt("males");
                int f = rs.getInt("females");
                int t = rs.getInt("total");

                txtAr.appendText("Total male : "+m+"\n"+"Total female : "+f+"\n"+"Total Patient : "+t);





            }

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public void getPat(ActionEvent azxc){


        String id = selPat.getText();

        String sql = "select decPat('"+id+"');";

        try{

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){

               String d = rs.getString(1);
                txtAr.appendText("Patient Status: "+d);





            }

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }





    }

    public void staffPay(ActionEvent aqzd){



        String sql = "call staffPayment();";

        try{

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){

                String id = rs.getString(1);
                String pay = rs.getString(2);

                txtAr.appendText("Staff ID: "+id+"\n"+"Total Salary: "+pay+"\n"+"---------"+"\n");





            }

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }






    }

    public void sortStaff(ActionEvent avzq){


        String sql = "call staffPayment();";

        try{

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){

                String id = rs.getString(1);
                String pay = rs.getString(2);

                int payi = Integer.parseInt(pay);
                if(payi > 400){

                    txtAr.appendText("High tier Staff\n");


                }

                else if(payi < 400 && payi > 200){

                    txtAr.appendText("Medium tier Staff\n");

                }

                else{
                    txtAr.appendText("Low tier Staff\n");
                }

                txtAr.appendText("Staff ID: "+id+"\n"+"Total Salary: "+pay+"\n"+"---------"+"\n");





            }

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }





    }

    public void genDoc(ActionEvent azcbs){

        String sql = "Call genderClassfD()";

        try{

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);

            txtAr.appendText("DOCTORS\n");
            while(rs.next()){


                int m = rs.getInt("males");
                int f = rs.getInt("females");
                int t = rs.getInt("total");

                txtAr.appendText("Total male : "+m+"\n"+"Total female : "+f+"\n"+"Total Doctors : "+t+"\n");





            }

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }





    }

    public void staffGen(ActionEvent kmfds){

        String sql = "Call genderClassfS()";

        try{

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);

            txtAr.appendText("STAFFS\n");
            while(rs.next()){

                int m = rs.getInt("males");
                int f = rs.getInt("females");
                int t = rs.getInt("total");

                txtAr.appendText("Total male : "+m+"\n"+"Total female : "+f+"\n"+"Total Staff : "+t+"\n");





            }

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void sortDocp(ActionEvent adfdf){

        String sql = "call docPaym();";

        try{

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);

            txtAr.appendText("DOCTOR'S SALARY\n");

            while(rs.next()){

                String id = rs.getString(1);
                String pay = rs.getString(2);

                txtAr.appendText("Doctor ID: "+id+"\n"+"Total Salary: "+pay+"\n"+"---------"+"\n");





            }

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }







    }




}



