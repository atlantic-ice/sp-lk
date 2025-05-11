package ru.bgpu.splk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bgpu.splk.models.MovementJournal;

@Repository
public interface MovementJournalRepository extends JpaRepository<MovementJournal, Long> {
} 