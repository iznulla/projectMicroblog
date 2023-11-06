package com.merylpor.microblog.service;

import com.merylpor.microblog.entity.Posts;
import com.merylpor.microblog.entity.User;
import com.merylpor.microblog.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;


@Data
@Builder
@Service
public class UserService {
    private final UserRepository userRepository;


    public void saveUser(User user) {
        userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }


    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
