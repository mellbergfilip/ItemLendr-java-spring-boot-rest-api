package com.fmellberg.itemlendr.user.service;

import com.fmellberg.itemlendr.user.model.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<UserEntity> findByEmail(String email);

    UserEntity createUser(UserEntity user);

    UserEntity getUserById(Long userId);

    List<UserEntity> getAllUsers();

    UserEntity updateUser(UserEntity updatedUser);

    void deleteUser(Long userId);
}
