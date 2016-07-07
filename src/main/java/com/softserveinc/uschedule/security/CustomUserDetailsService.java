package com.softserveinc.uschedule.security;

import com.softserveinc.uschedule.entity.User;
import com.softserveinc.uschedule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Component("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findOneByFirstName(username);
        if(username.isEmpty()) {
            throw new BadCredentialsException("Bad credentials");
        }
        return userOptional
                .map(user -> createCustomUserDetails(user))
                .orElseThrow(()->new UsernameNotFoundException("User with such name not found"));
    }

    public CustomUserDetails createCustomUserDetails(User user) {
        user.getApplicationRole().getUsers().isEmpty();//call method for load full object instead of lazy initialized proxy.
        user.getUserGroups().isEmpty();//call method for load full object instead of lazy initialized proxy.
        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.setLocked(user.getLocked());
        customUserDetails.setUsername(user.getFirstName());
        customUserDetails.setPassword(user.getPassword());
        customUserDetails.setApplicationRole(user.getApplicationRole());
        customUserDetails.setUserToGroups(user.getUserGroups());
        String userApplicationRole =  user.getApplicationRole().getRole();
        customUserDetails.setAuthorities(Collections.singleton(new SimpleGrantedAuthority(userApplicationRole)));
        return customUserDetails;
    }
}
