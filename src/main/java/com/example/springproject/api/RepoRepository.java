package com.example.springproject.api;

import com.example.springproject.domain.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoRepository extends JpaRepository<Repo, Long> {
	public Repo findRepoByOwnerAndName(String owner, String name);
}
