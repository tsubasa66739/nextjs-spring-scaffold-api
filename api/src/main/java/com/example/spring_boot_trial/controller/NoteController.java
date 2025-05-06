package com.example.spring_boot_trial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_trial.controller.request.PostNoteRequest;
import com.example.spring_boot_trial.controller.response.PostNoteResponse;
import com.example.spring_boot_trial.model.NoteModel;
import com.example.spring_boot_trial.service.NoteService;

@RestController
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteSvc;

    @Autowired
    public NoteController(
        NoteService noteSvc
    ) {
        this.noteSvc = noteSvc;
    }
    
    @PostMapping
    public ResponseEntity<PostNoteResponse> createNote(
        @RequestBody PostNoteRequest req
    ) {
        var res = new PostNoteResponse();

        try {
            var note = new NoteModel();
            note.setTitle(req.getTitle());
            note.setContent(req.getContent());
            var result = noteSvc.createNote(note, req.getEmail());

            res.setNote(result);
        } catch (Exception e) {
            res.setMessage(e.getMessage());
            return ResponseEntity.internalServerError().body(res);
        }
        
        res.setMessage("Create note scceeded.");
        return ResponseEntity.ok(res);
    }
}
