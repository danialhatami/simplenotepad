package com.danial.notepad.controller;

import com.danial.notepad.exception.ResourceNotFoundException;
import com.danial.notepad.model.Note;
import com.danial.notepad.repository.NotePadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    NotePadRepository notePadRepository;

    @GetMapping("notes")
    public List<Note> getAllNotes() {
        return notePadRepository.findAll();
    }

    @PostMapping("notes")
    public Note createNote(@Valid Note note) {

        return notePadRepository.save(note);
    }

    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable(value = "id") Long noteId) {
        return notePadRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }

    @PutMapping("/notes/{id}")
    public Note updateNote(@PathVariable(value = "id") Long noteId,
                           @Valid @RequestBody Note noteDetails) {

        Note note = notePadRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        Note updatedNote = notePadRepository.save(note);
        return updatedNote;
    }

    // Delete a Note
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        Note note = notePadRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        notePadRepository.delete(note);

        return ResponseEntity.ok().build();
    }
}