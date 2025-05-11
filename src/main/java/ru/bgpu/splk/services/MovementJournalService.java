package ru.bgpu.splk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bgpu.splk.models.MovementJournal;
import ru.bgpu.splk.repositories.MovementJournalRepository;

@Service
public class MovementJournalService {
    
    private final MovementJournalRepository movementJournalRepository;
    
    @Autowired
    public MovementJournalService(MovementJournalRepository movementJournalRepository) {
        this.movementJournalRepository = movementJournalRepository;
    }
    
    public MovementJournal save(MovementJournal movementJournal) {
        return movementJournalRepository.save(movementJournal);
    }
} 