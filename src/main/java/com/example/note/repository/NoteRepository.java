package com.example.note.repository;

import com.example.note.entity.Note;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note,Long> {
    List<Note> findByUserIdOrderByUpdateAtDesc(Long userId, Pageable pageable);
}
