package com.example.springproject.api;

import com.example.springproject.domain.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
	@Query("select count(i) from Issue i where i.isOpen = true")
	long countByIsOpenTrue();
	
	@Query("select count(i) from Issue i where i.isOpen = false")
	long countByIsOpenFalse();
	
	@Query("select avg(i.closeTime-i.openTime) from Issue i")
	long avgSolveTime();
	
	@Query("select max(i.closeTime-i.openTime) from Issue i")
	long maxSolveTime();
	
	@Query("select min(i.closeTime-i.openTime) from Issue i")
	long minSolveTime();
}
