package org.dibyendu.jsfspring.repository;

import java.util.List;

import org.dibyendu.jsfspring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



/**
 * Boilerplate code to automatically generate the persistence methods
 * for the {@link User} entity.
 * @author David
 *
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{

	@Query(value = "SELECT * from user_details WHERE email = ?", nativeQuery = true)
	User findExistingEmailId(String email);
	
	@Query(value = "SELECT * from user_details WHERE email = ?", nativeQuery = true)
	List<User> findUserByEmailId(String email);
	
}
