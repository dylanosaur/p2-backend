package com.revature;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.User;

/*
 * Spring Data provies a number of helpful repository types, with this hierarchy:
 * 
 * 1) Repository - Basic Repository Structure
 * 2) CrudRepository - Repository with CRUD helper methods
 * 3) PagingAndSortingRepository - Repository with methods to help with 
 * 			pagination and sorting of results and queries
 * 4) JpaRepository - Repository built with fluent query language and 
 * 			full support of JPA features
 */
@Repository
public interface DoomRepository extends JpaRepository<User, Integer>{

	//public List<User> findAllByWinner(String winner);
}