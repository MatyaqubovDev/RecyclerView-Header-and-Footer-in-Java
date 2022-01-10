package dev.bogibek.recyclerviewheaderandfooterinjava.model;

public class Member {
    private String name;
    private String phoneNumber;
    private Boolean isOnline;

    public Member() {
    }

    public Member(String name, String phoneNumber, Boolean isOnline) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isOnline = isOnline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean isOnline() {
        return isOnline;
    }

    public void setOnline(Boolean online) {
        isOnline = online;
    }
}
