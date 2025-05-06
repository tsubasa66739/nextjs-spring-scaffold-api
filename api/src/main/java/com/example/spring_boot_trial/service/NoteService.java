package com.example.spring_boot_trial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot_trial.model.NoteModel;
import com.example.spring_boot_trial.repository.NoteRepository;

@Service
public class NoteService {
    
    private final NoteRepository noteRepo;

    @Autowired
    public NoteService(
        NoteRepository noteRepo
    ) {
        this.noteRepo = noteRepo;
    }

    public NoteModel createNote(NoteModel note) {
        noteRepo.insert(note);
    }
}
