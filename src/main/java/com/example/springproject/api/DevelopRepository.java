package com.example.springproject.api;

import com.example.springproject.domain.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DevelopRepository extends JpaRepository<Developer, Long> {
	@Modifying
	@Transactional
	public void deleteAllByRepoID(long repoID);
}
