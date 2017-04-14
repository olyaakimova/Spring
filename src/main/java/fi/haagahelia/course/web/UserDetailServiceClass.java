//Spring UserDetailService - user authentification and authorization


package fi.haagahelia.course.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fi.haagahelia.course.domain.User;
import fi.haagahelia.course.domain.UserRepository;

@Service
public class UserDetailServiceClass implements UserDetailsService{
	private final UserRepository Urepository;
	
	
	//constructor for service
	@Autowired
	public UserDetailServiceClass(UserRepository Urepository){
		this.Urepository = Urepository;
	}
	
	
	//method for loading users by username
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User currentUser = Urepository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username, currentUser.getPasswordHash(), AuthorityUtils.createAuthorityList(currentUser.getRole()));
	return user;	
	}
}