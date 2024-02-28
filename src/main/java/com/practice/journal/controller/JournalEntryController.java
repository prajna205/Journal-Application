package com.practice.journal.controller;

import com.practice.journal.entity.JournalEntry;
import com.practice.journal.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService service;

    @GetMapping
    public List<JournalEntry> getAll() {
        return service.getAll();
    }

    @PostMapping
    public JournalEntry createJournal(@RequestBody JournalEntry entry) {
        service.saveEntry(entry);
        return entry;
    }

    @GetMapping("/id/{id}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping ("/id/{id}")
    public JournalEntry updateEntryById(@PathVariable ObjectId id,@RequestBody JournalEntry newEntry) {
        JournalEntry old=service.findById(id).orElse(null);
        if(old != null){
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle():old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent():old.getContent());
        }
        service.saveEntry(old);
        return old;
    }

}