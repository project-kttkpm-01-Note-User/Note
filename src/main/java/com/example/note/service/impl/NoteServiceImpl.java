package com.example.note.service.impl;

import com.example.note.config.ConfigRestTemplate;
import com.example.note.entity.Note;
import com.example.note.entity.Note_User;
import com.example.note.entity.User;
import com.example.note.repository.NoteRepository;
import com.example.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Note addNote(Note note) {
        note.setCreatedAt(new Date());
        note.setUpdateAt(new Date());
        repository.save(note);
        return note;
    }

    @Override
    public List<Note_User> getAll() {
        List<Note_User> listNE=new ArrayList<Note_User>();
        List<Note> list =repository.findAll();

        for (Note e: list) {
            User u=  restTemplate.getForObject("/"+e.getUserId(),User.class);
            Note_User nu= new Note_User(e,u);
            listNE.add(nu);
        }

        return listNE;
    }

    @Override
    public List<Note> getByUserId(Long id, Pageable pageable) {

        return repository.findByUserIdOrderByUpdateAtDesc(id,pageable);
    }

    @Override
    public Note_User getById(Long id) {

       Note note =repository.findById(id).get();
       User u=  restTemplate.getForObject("/"+note.getUserId(),User.class);
        return new Note_User(note, u);
    }

    @Override
    public Note updateNote(Note note) {
        note.setUpdateAt(new Date());
        repository.save(note);
        return note;
    }

    @Override
    public void deleteNote(Long id) {
        repository.deleteById(id);
    }
}
