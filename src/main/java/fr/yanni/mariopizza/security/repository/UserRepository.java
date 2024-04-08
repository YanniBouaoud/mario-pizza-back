package fr.yanni.mariopizza.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.yanni.mariopizza.security.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * find a user from its login.
	 *
	 * @param username the login
	 * @return an optional user if found
	 */
	Optional<User> findByUsername(String username);

}
