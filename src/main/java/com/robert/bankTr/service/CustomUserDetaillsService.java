package com.robert.bankTr.service;

import com.robert.bankTr.miscellaneous.UserNotFoundException;
import com.robert.bankTr.model.Login;
import com.robert.bankTr.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetaillsService implements UserDetailsService {

    @Autowired
    LoginRepository lr;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<Login> byUsername = lr.findByUsername(userName);

        if (byUsername.isPresent()) {
            Login login = byUsername.get();
            UserDetails build = User.withDefaultPasswordEncoder().username(login.getUsername()).password(login.getPassword()).authorities(new ArrayList<>()).build();
            return build;

        } else {
            throw new UserNotFoundException(3l);
        }
    }
}
