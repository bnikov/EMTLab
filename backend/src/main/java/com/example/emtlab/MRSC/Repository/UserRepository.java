package com.example.emtlab.MRSC.Repository;

import com.example.emtlab.MRSC.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

//    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findUserByUsernameAndPassword(String username, String password);
}
