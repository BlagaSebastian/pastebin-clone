package com.pastebin.Services;

import com.pastebin.models.ApplicationUser;
import com.pastebin.models.RegistrationObject;
import com.pastebin.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(RegistrationObject ro) {
        ApplicationUser user = new ApplicationUser();
        user.setEmail(ro.getEmail());
        user.setUsername(ro.getUsername());
        user.setPassword(passwordEncoder.encode(ro.getPassword()));
        userRepo.save(user);
    }
}
