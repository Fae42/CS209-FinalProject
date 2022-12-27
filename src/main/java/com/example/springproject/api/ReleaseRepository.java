package com.example.springproject.api;

import com.example.springproject.domain.Developer;
import com.example.springproject.domain.Release;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ReleaseRepository extends JpaRepository<Release, Long> {
	@Modifying
	@Transactional
	public void deleteAllByRepoID(long repoID);
}
