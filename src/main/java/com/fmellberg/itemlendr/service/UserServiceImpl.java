package com.fmellberg.itemlendr.service;

import com.fmellberg.itemlendr.model.entity.UserEntity;
import com.fmellberg.itemlendr.repository.UserRepository;
import com.fmellberg.itemlendr.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        Optional<UserEntity> userEntity = userRepository.findByEmailIgnoreCase(email);

        if(userEntity.isPresent()) {
            return userEntity;
        } else {
            throw new UsernameNotFoundException("User with email: {} - Not Found " + email);
        }
    }

}
