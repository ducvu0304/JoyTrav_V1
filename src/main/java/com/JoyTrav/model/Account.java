package com.JoyTrav.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "account")
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private int id;
    @Column(name="firstname", length = 80, unique = true)
    private String firstname;
    @Column(name="lastname", length = 80, unique = true)
    private String lastname;
    @Column(name="email", length = 80, unique = true, nullable = false)
    private String email;
    @Column(name="phone", length = 15, nullable = false)
    private String phone;
    @Column(name="password", nullable = false)
    private String password;
    @Column(name="gender")
    private  boolean gender;
    @Column(name="address")
    private String address;
    @Column(name="dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name="avatar")
    private String avatar;
    @Column(name = "role")
    private String role;

    @Column(name = "status")
    private boolean status;

    @Column(name = "is_login")
    private boolean isLogin;

    private enum Role {
        ADMIN, USER
    }

    public Account() {
    }

    public Account( String firstname, String lastname, String email, String phone, String password, boolean gender, String address, Date dob, String avatar, String role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.gender = gender;
        this.address = address;
        this.dob = dob;
        this.avatar = avatar;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", avatar='" + avatar + '\'' +
                ", role='" + role + '\'' +
                ", status=" + status +
                '}';
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }
}

