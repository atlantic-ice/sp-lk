package ru.bgpu.splk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bgpu.splk.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
} 