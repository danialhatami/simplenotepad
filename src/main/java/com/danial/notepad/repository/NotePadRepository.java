package com.danial.notepad.repository;

import com.danial.notepad.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotePadRepository extends JpaRepository<Note, Long> {

}
