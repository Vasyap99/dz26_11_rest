package org.example.repo;

import org.example.models.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface NewsRepository extends CrudRepository<News, Integer> {
    Optional<News> findByHeader(String header);
    List<News> findAll();
}