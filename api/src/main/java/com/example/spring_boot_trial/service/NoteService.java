package com.example.spring_boot_trial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot_trial.model.NoteModel;
import com.example.spring_boot_trial.repository.NoteRepository;
import com.example.spring_boot_trial.repository.UserRepository;

@Service
public class NoteService {
    
    private final NoteRepository noteRepo;

    private final UserRepository userRepo;

    @Autowired
    public NoteService(
        NoteRepository noteRepo,
        UserRepository userRepo
    ) {
        this.noteRepo = noteRepo;
        this.userRepo = userRepo;
    }

    public NoteModel createNote(NoteModel note, String email) throws Exception {
        var user = userRepo.selectByEmail(email);
        if (user.isEmpty()) {
            throw new Exception("resource not found.");
        }
        note.setUserId(user.get().getId());

        noteRepo.insert(note);

        var result = noteRepo.selectByTitleAndUserEmail(note.getTitle(), email);
        if (result.isEmpty()) {
            throw new Exception("resource not found.");
        }

        return result.get();
    }
}
