package com.Challenge.Alkemy.auth.service;

import com.Challenge.Alkemy.auth.dto.UserDTO;
import com.Challenge.Alkemy.auth.entity.UserEntity;
import com.Challenge.Alkemy.auth.repository.UserRepository;
import com.Challenge.Alkemy.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsCustomService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;


    /*Obtenido de:
    * https://www.baeldung.com/spring-security-registration-password-encoding-bcrypt
    *  */
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity=userRepository.findByUsername(username);

        if(userEntity == null){
            throw new UsernameNotFoundException("Username or password not found");
        }
        
        return new User(userEntity.getUsername(),userEntity.getPassword(), Collections.emptyList() );
    }


    public boolean save (UserDTO userDTO){
        UserEntity userEntity= new UserEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userEntity=this.userRepository.save(userEntity);
        if(userEntity!=null){
            emailService.sendWelcomeEmailTo(userEntity.getUsername());
        }

        return userEntity!=null;

    }
}
