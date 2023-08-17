package com.fmellberg.itemlendr.service.interfaces;

import com.fmellberg.itemlendr.model.entity.UserEntity;

import java.util.Optional;

public interface UserService {

    Optional<UserEntity> findByEmail(String email);
}
