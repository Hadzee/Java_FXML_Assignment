package org.example;

import java.util.ArrayList;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private final StringProperty firstName = new SimpleStringProperty(this, "firstName", "");
    private final StringProperty lastName = new SimpleStringProperty(this, "lastName", "");
    private final StringProperty address = new SimpleStringProperty(this, "address");
    private final StringProperty speed = new SimpleStringProperty(this, "speed");
    private final StringProperty bandwidth = new SimpleStringProperty(this, "bandwidth");
    private final StringProperty duration = new SimpleStringProperty(this, "duration");

    public User() {
    }

    public User(String firstName, String lastName, String address, String speed, String bandwidth, String duration) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.address.set(address);
        this.speed.set(speed);
        this.bandwidth.set(bandwidth);
        this.duration.set(duration);

    }

    public User(String firstName) {
        this.firstName.set(firstName);
    }

    public User(String firstName, String lastName) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public StringProperty addressProperty() {
        return address;
    }

    public String getSpeed() {
        return speed.get();
    }

    public void setSpeed(String speed) {
        this.speed.set(speed);
    }

    public StringProperty speedProperty() {
        return speed;
    }

    public String getBandwidth() {
        return bandwidth.get();
    }

    public void setBandwidth(String bandwidth) {
        this.bandwidth.set(bandwidth);
    }

    public StringProperty bandwidthProperty() {
        return bandwidth;
    }

    public String getDuration() {
        return duration.get();
    }

    public void setDuration(String duration) {
        this.duration.set(duration);
    }

    public StringProperty durationProperty() {
        return duration;
    }


    private final ObjectProperty<ArrayList<String>> errorList = new SimpleObjectProperty<>(this, "errorList", new ArrayList<>());

    public ObjectProperty<ArrayList<String>> errorsProperty() {
        return errorList;
    }

    public boolean isValid() {
        boolean isValid = true;
        if (firstName.get() != null && firstName.get().equals("")) {
            errorList.getValue().add("First name should not be empty.");
            isValid = false;
        }
        if (lastName.get().equals("")) {
            errorList.getValue().add("Last name should not be empty.");
            isValid = false;
        }
        if (address.get().equals("")) {
            errorList.getValue().add("Address should not be empty.");
            isValid = false;
        }
        if (speed.get().equals("")) {
            errorList.getValue().add("Speed should not be empty.");
            isValid = false;
        }
        if (bandwidth.get().equals("")) {
            errorList.getValue().add("Bandwidth should not be empty.");
            isValid = false;
        }
        if (duration.get().equals("")) {
            errorList.getValue().add("Duration should not be empty.");
            isValid = false;
        }
        return isValid;
    }

}