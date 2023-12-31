package com.plus.reviewproject.user.repository;

import com.plus.reviewproject.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findAllById(Long userId);

    Optional<User> findByUsername(String username);

    Optional<User> findByNickname(String nickname);

    Optional<User> findByPhoneNumber(String phoneNumber);

    Optional<User> findByAddress(String address);

    Optional<User> findByAge(int age);
}
