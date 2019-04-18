package sample;

public class dataTable4 {


    int staffID,sdoctorId;
    String staffName,staffSurname,staffDept,staffGender;


    public dataTable4(int staffID, int sdoctorId, String staffName, String staffSurname, String staffDept, String staffGender) {
        this.staffID = staffID;
        this.sdoctorId = sdoctorId;
        this.staffName = staffName;
        this.staffSurname = staffSurname;
        this.staffDept = staffDept;
        this.staffGender = staffGender;
    }



    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public int getSdoctorId() {
        return sdoctorId;
    }

    public void setSdoctorId(int sdoctorId) {
        this.sdoctorId = sdoctorId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffSurname() {
        return staffSurname;
    }

    public void setStaffSurname(String staffSurname) {
        this.staffSurname = staffSurname;
    }

    public String getStaffDept() {
        return staffDept;
    }

    public void setStaffDept(String staffDept) {
        this.staffDept = staffDept;
    }

    public String getStaffGender() {
        return staffGender;
    }

    public void setStaffGender(String staffGender) {
        this.staffGender = staffGender;
    }
}
