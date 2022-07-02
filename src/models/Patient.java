package src.models;

import java.util.UUID;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Patient {
    private UUID id = UUID.randomUUID();

    private String fullName;

    private Date regDate;

    public String getRegDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(regDate.getTime());
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Patient(String fullName, Date regDate){
        this.fullName = fullName;
        this.regDate = regDate;
    }
}
