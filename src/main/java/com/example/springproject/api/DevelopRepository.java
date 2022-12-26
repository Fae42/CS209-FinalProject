package com.example.springproject.api;

import com.example.springproject.domain.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevelopRepository extends JpaRepository<Developer, Long> {
}
