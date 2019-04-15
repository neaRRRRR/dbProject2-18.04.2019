package sample;

public class dataTable {

    int doctorID;
    String doctorName,doctorSurname,gender,tel,prof;

    public dataTable(int doctorID, String doctorName, String dcctorSurname, String gender, String tel, String prof) {
        this.doctorID = doctorID;
        this.doctorName = doctorName;
        this.doctorSurname = dcctorSurname;
        this.gender = gender;
        this.tel = tel;
        this.prof = prof;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorSurname = doctorName;
    }

    public String getDoctorSurname() {
        return doctorSurname;
    }

    public void setDoctorSurname(String surname) {
        this.doctorSurname = doctorSurname;
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

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }
}
