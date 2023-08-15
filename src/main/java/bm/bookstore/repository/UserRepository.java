package bm.bookstore.repository;

import bm.bookstore.entities.UserEntity;
import bm.bookstore.exceptions.UserNotFoundException;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByUsername(String username) throws UserNotFoundException;
    boolean existsByUsername(String username);
}
