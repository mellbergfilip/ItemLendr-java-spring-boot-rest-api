package com.fmellberg.itemlendr.user.service;

import com.fmellberg.itemlendr.errorhandling.exceptions.ResourceNotFoundException;
import com.fmellberg.itemlendr.user.model.UserEntity;
import com.fmellberg.itemlendr.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity updateUser(UserEntity updatedUser) {
        if (!userRepository.existsById(updatedUser.getId())) {
            throw new ResourceNotFoundException("User", "id", updatedUser.getId());
        }

        return userRepository.save(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User", "id", userId);
        }

        userRepository.deleteById(userId);
    }

}
