package com.example.note.service;

import com.example.note.entity.Note;
import com.example.note.entity.Note_User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NoteService {
    Note addNote(Note note);
    List<Note_User> getAll();
    List<Note> getByUserId(Long id, Pageable pageable);
    Note_User getById(Long id);
    Note updateNote(Note note);
    void deleteNote(Long id);
}
