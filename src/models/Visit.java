package src.models;

import java.util.UUID;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Visit {
    private UUID id = UUID.randomUUID();

    private String patientFullName;

    private String doctorFullName;

    private Date regDate;

    private String status;

    public String getRegDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(regDate.getTime());
    }

    public UUID getId() {
        return id;
    }

    public String getPatientFullName(){
        return patientFullName;
    }

    public String getDoctorFullName(){ return doctorFullName; }
    public String getStatus(){
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Visit(String patientFullName,String doctorFullName, Date regDate, String status){
        this.patientFullName = patientFullName;
        this.doctorFullName = doctorFullName;
        this.regDate = regDate;
        this.status = status;
    }
}
