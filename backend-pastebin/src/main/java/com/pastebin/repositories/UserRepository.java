package com.pastebin.repositories;

import com.pastebin.models.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, Integer> {
    ApplicationUser findByUsername(String username);
}
