package com.example.training.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private UUID id;
    private String firstName;
    private String lastName;
    private String position;
}
