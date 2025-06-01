package com.parmin.expensetracker.services;

import com.parmin.expensetracker.dto.RegisterUserDto;
import com.parmin.expensetracker.dto.LoginUserDto;
import com.parmin.expensetracker.model.User;
import com.parmin.expensetracker.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public User signUp(RegisterUserDto input) {

        User newUser = new User();

        newUser.setPassword(passwordEncoder.encode(input.getPassword()));
        newUser.setEmail(input.getEmail());
        newUser.setFullName(input.getFullName());

        return userRepository.save(newUser);

    }

    public User authenticate(LoginUserDto input) {

        Authentication authenticatedUser =  authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword()));

        if (authenticatedUser.isAuthenticated()) {
            return userRepository.findByEmail(input.getEmail()).orElseThrow( () -> new UsernameNotFoundException("User not found"));
        }

        throw new BadCredentialsException(("Authentication failed"));

    }
}
