package com.example.springproject.api;

import com.example.springproject.domain.Developer;
import com.example.springproject.domain.Release;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseRepository extends JpaRepository<Release, Long> {
}
