package model;

import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private String address;
    private String phone;
    private int classID;

    public Student() {
    }

    public Student(String name, String email, LocalDate dateOfBirth, String address, String phone, int classID) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phone = phone;
        this.classID = classID;
    }

    public Student(int id, String name, String email, LocalDate dateOfBirth, String address, String phone, int classID) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phone = phone;
        this.classID = classID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }
}
