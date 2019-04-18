package sample;




public class dataTable3 {
    int patientID, roomID;
    String dateTime;

    public dataTable3(int patientID, int roomID, String dateTime) {
        this.patientID = patientID;
        this.roomID = roomID;
        this.dateTime = dateTime;
    }



    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

}
