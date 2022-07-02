package src.models;

import java.util.UUID;

public class Doctor {
    private UUID id = UUID.randomUUID();

    private String fullName;

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Doctor(String fullName) {
        this.fullName = fullName;
    }
}
