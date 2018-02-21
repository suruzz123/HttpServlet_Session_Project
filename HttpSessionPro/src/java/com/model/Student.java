package com.model;

public class Student {

    private int roll;
    private String name;
    private String email;
    private String department;
    private String session;
    private String country;

    public Student() {
    }

    public Student(int roll, String name, String email, String department, String session, String country) {
        this.roll = roll;
        this.name = name;
        this.email = email;
        this.department = department;
        this.session = session;
        this.country = country;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Student{" + "roll=" + roll + ", name=" + name + ", email=" + email + ", department=" + department + ", session=" + session + ", country=" + country + '}';
    }

}
