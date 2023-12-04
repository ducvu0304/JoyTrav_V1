package com.JoyTrav.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "passengers")
public class Passenger {
    @Id
    private int id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "gender")
    private boolean gender;
    @Column(name = "dob", columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "group_age")
    @Enumerated(value = EnumType.STRING)
    private Group group;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private  Booking booking;

    public Passenger() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
