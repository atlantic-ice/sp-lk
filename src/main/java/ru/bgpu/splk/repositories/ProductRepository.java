package ru.bgpu.splk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bgpu.splk.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
} 