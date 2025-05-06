package com.example.spring_boot_trial.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserModel extends BaseModel {
    private String email;
}
