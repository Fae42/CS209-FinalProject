package com.example.springproject.api;

import com.example.springproject.domain.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.Date;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
	
	@Modifying
	@Transactional
	public void deleteAllByRepoID(long repoID);
	
	@Query("select count(i) from Issue i where i.isOpen = true")
	long countByIsOpenTrue();
	
	@Query("select count(i) from Issue i where i.isOpen = false")
	long countByIsOpenFalse();
	
	@Query(value = "select TO_CHAR(avg(i.close_time - i.open_time), 'DD天hh小时mm分ss秒') from Issue i", nativeQuery = true)
	String avgSolveTime();
	
	@Query(value = "select TO_CHAR(max(i.close_time - i.open_time), 'DD天hh小时mm分ss秒') from Issue i", nativeQuery = true)
	String maxSolveTime();
	
	@Query(value = "select TO_CHAR(min(i.close_time - i.open_time), 'DD天hh小时mm分ss秒') from Issue i", nativeQuery = true)
	String minSolveTime();

}
