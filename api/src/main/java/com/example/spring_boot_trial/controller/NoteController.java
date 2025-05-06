package com.example.spring_boot_trial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_trial.controller.request.PostNoteRequest;
import com.example.spring_boot_trial.controller.response.PostNoteResponse;

@RestController
@RequestMapping("/note")
public class NoteController {
    
    @PostMapping
    public ResponseEntity<PostNoteResponse> createNote(
        @RequestBody PostNoteRequest req
    ) {
        var res = new PostNoteResponse();
        
        res.setMessage("Create note scceeded.");
        return ResponseEntity.ok(res);
    }
}
