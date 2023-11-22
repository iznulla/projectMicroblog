package com.merylpor.microblog.service;

import com.merylpor.microblog.dto.UserEditDto;
import com.merylpor.microblog.entity.UserEntity;
import com.merylpor.microblog.repository.UserRepository;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Data
@Service
@Builder
public class UserService {
    private final UserRepository userRepository;


    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }

    public void updateUser(Long id, UserEditDto userEditDto) {
        UserEntity user = userRepository.findById(id).orElseThrow();
        user.setUsername(userEditDto.getUsername());
        user.setName(userEditDto.getName());
        user.setRole(userEditDto.getRole());
        user.setPassword(userEditDto.getPassword());
        userRepository.save(user);
    }

    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }


    public List<UserEntity> allUsers() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void deleteUser(Long id) {
        UserEntity user = userRepository.findById(id).orElse(null);
        assert user != null;
        userRepository.delete(user);
    }
}
