package com.revature.models;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
public interface DoomRepository extends JpaRepository<User, Integer> {

	void save(Item item);

	User findByEmail(String email);

	Optional<User> findById(int id);

	@Query("FROM items i where i.user.id = :userid")
	List<Item> findAllByUser(@Param("userid") int userid);

	// public List<User> findAllByWinner(String winner);
}