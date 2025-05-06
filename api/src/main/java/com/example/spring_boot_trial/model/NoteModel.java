package com.example.spring_boot_trial.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NoteModel extends BaseModel {
    private Integer userId;
    private String title;
    private String content;
}
