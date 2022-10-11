package com.huntermuze.bankaccountservice.dto;

import java.util.Objects;

public class User {
    private long id;
    private String name;
    private String address;
    private int age;
    private String job;
    private String email;
    private String mobileNumber;

    public User(long id, String name, String address, int age, String job, String email, String mobileNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.job = job;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(id, user.id) && Objects.equals(name, user.name) &&
                Objects.equals(address, user.address) && Objects.equals(job, user.job) &&
                Objects.equals(email, user.email) && Objects.equals(mobileNumber, user.mobileNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, age, job, email, mobileNumber);
    }

    @Override
    public String toString() {
        return "UserPOJO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
