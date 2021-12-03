package com.example.note.Controller;

import com.example.note.entity.Note;
import com.example.note.entity.Note_User;
import com.example.note.service.impl.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteServiceImpl service;

    @GetMapping
    @Cacheable("getAllNote")
    public List<Note_User> getAll(){
        return service.getAll();
    }
    @PostMapping
    @CacheEvict(cacheNames = {"getAllNote", "getNoteByUser"}, allEntries = true)
    public Note addNote(@RequestBody Note note){
        return service.addNote(note);
    }
    @GetMapping("/userId/{id}")
    @Cacheable("getNoteByUser")
    public List<Note> getByUserId(@PathVariable Long id,@RequestParam int page,@RequestParam int limit){
        Pageable pageable= PageRequest.of(page-1, limit);
        return service.getByUserId(id,pageable);
    }

    @PostMapping("/update")
    @CacheEvict(cacheNames = {"getAllNote", "getNoteByUser","getById"}, allEntries = true)
    public Note updateNote(@RequestBody Note note){
        Note note1= service.getById(note.getId()).getNote();
        note.setCreatedAt(note1.getCreatedAt());
       return service.updateNote(note);
    }

    @GetMapping("/{id}")
    @Cacheable(cacheNames = "getById")
    public  Note_User getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping("/delete/{id}")
    @CacheEvict(cacheNames = {"getAllNote", "getNoteByUser","getById"}, allEntries = true)
    public String deleteNote(@PathVariable Long id){
        try {
            service.deleteNote(id);


        }catch (Exception e){

        }
        return "Xóa thành công";
    }
}
