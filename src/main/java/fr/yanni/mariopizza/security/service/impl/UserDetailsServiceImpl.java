package fr.yanni.mariopizza.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.yanni.mariopizza.security.models.User;
import fr.yanni.mariopizza.security.repository.UserRepository;
import fr.yanni.mariopizza.security.utils.UserMapper;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	/** import the userRepository. */
	@Autowired
	private UserRepository userRepository;

	/**
	 * Load user's details from the DB.
	 */
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User NOT Found"));
		return UserMapper.userToPrincipal(user);
	}

	/**
	 *
	 * @param username a username
	 * @return the detail of the given user
	 * @throws UsernameNotFoundException
	 */
	public User loadUserDetails(final String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User NOT Found"));
		return user;
	}

	/**
	 * Update or create a user.
	 *
	 * @param user a user to save
	 * @return the updated user
	 */
	public User update(final User user) {

		return userRepository.save(user);
	}

	public boolean existsByUsername(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	public void save(User user) {
		// TODO Auto-generated method stub

	}

}
