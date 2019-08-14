package com.revature.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.models.User;

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
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
	User findById(int id);
	User findByUsername(String username);

}