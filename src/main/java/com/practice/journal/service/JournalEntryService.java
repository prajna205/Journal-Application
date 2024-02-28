package com.practice.journal.service;

import com.practice.journal.entity.JournalEntry;
import com.practice.journal.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository repository;

    public void saveEntry(JournalEntry entry){

        repository.save(entry);
    }
    public List<JournalEntry> getAll(){
        return repository.findAll();
    }
    public Optional<JournalEntry> findById(ObjectId id){
        return repository.findById(id);
    }
}
