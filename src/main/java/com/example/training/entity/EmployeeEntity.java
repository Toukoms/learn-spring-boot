package com.example.training.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "EMPLOYEES")
@Data
@ToString
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "EMPLOYEE_ID")
    private UUID employeeId;
    @Column(name = "FIST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "POSITION")
    private String position;


}
