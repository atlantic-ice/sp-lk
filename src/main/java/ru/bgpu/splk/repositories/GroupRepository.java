package ru.bgpu.splk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bgpu.splk.models.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
} 