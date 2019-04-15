package sample;

public class dataTable2 {


    int patientID,doctorID;
    String patientName,patientSurname,gender,tel;

    public dataTable2(int patientID, int doctorID, String patientName, String patientSurname, String gender, String tel) {
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.patientName = patientName;
        this.patientSurname = patientSurname;
        this.gender = gender;
        this.tel = tel;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
