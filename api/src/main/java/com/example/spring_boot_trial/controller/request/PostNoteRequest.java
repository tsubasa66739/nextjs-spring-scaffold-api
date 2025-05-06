package com.example.spring_boot_trial.controller.request;

import lombok.Data;

@Data
public class PostNoteRequest {
    private String email;
    private String title;
    private String content;
}
