package com.AssignmentGeekster.User.Management.System.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_Id;
    @Column
    @Length(min = 3,max = 20,message = "user_name length should be 3 to 20 letters")
    private String user_Name;

    @JsonFormat(pattern = "dd-mm-yyyy",shape = JsonFormat.Shape.STRING)
    @Column(name = "birthdate")
    private String user_DateOfBirth;
    @Column
    @Email(message = "Enter valid Email")
    private String user_Email;
    @Column
    @Digits(integer = 12,fraction = 0,message = "Phone number should contain 12 including country code")
    private String user_PhoneNumber;
    @Column(nullable = false,name = "created_date")
    @CreationTimestamp
    private LocalDate date;
    @Column(name = "created_time")
    @CreationTimestamp
    private LocalTime time;


}
