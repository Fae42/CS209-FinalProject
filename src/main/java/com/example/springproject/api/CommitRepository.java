package com.example.springproject.api;

import com.example.springproject.domain.Commit;
import com.example.springproject.domain.Developer;
import org.hibernate.annotations.SQLDeleteAll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface CommitRepository extends JpaRepository<Commit, Long> {
	long countByTimeLessThanAndTimeGreaterThan(Date time, Date time1);
	@Modifying
	@Transactional
	public void deleteAllByRepoID(long repoID);
}
