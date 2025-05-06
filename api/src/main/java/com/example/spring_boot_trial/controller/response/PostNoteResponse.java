package com.example.spring_boot_trial.controller.response;

import com.example.spring_boot_trial.model.NoteModel;

import lombok.Data;

@Data
public class PostNoteResponse {
    private String message;
    private NoteModel note;
}
