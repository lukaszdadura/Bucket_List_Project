package pl.lukaszdadura.bucketlistproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.lukaszdadura.bucketlistproject.model.User;
import pl.lukaszdadura.bucketlistproject.repository.UserRepository;

import java.util.Collections;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) {

        User user = userRepository.findByUsername(userName);

        if (user == null) {
            throw new UsernameNotFoundException(userName);
        }

        List<GrantedAuthority> authorityList = Collections.emptyList();

        if (user.isAdmin()) {
            authorityList = AuthorityUtils.createAuthorityList(Roles.ADMIN);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorityList);

    }
}
