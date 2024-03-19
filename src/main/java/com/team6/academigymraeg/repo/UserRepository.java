package com.team6.academigymraeg.repo;

import com.team6.academigymraeg.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    int countByUsername(String username);
    User findUserByUsernameEquals(String username);

    Optional<User> findByUsername(String username);
}
