package com.example.springproject.api;

import com.example.springproject.domain.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
	@Modifying
	@Transactional
	void deleteAllByRepoID(long repoID);
}
