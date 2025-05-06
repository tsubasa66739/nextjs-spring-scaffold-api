package com.example.spring_boot_trial.model;

import java.sql.Date;

import lombok.Data;

@Data
public class BaseModel {
    private Integer id;
    private Date createdAt;
    private Date updatedAt; 
}
