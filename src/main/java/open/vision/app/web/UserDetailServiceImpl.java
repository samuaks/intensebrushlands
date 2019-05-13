package open.vision.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import open.vision.app.domain.User;
import open.vision.app.domain.UserRepository;



@Service
public class UserDetailServiceImpl implements UserDetailsService{
	private final UserRepository repo;
	
	@Autowired
	public UserDetailServiceImpl(UserRepository userRepo) {
		// TODO Auto-generated constructor stub
		this.repo = userRepo;
	}
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User currentuser = repo.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username, currentuser.getPasswordCheck(), AuthorityUtils.createAuthorityList(currentuser.getRole()));
		return user;
	}
	
}