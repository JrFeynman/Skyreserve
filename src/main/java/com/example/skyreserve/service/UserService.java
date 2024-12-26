package com.example.skyreserve.service;

import com.example.skyreserve.entity.User;
import com.example.skyreserve.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Kullanıcı oluşturma
    public User createUser(User user) {
        // Burada ek validasyon yapılabilir (username unique mi vb.)
        return userRepository.save(user);
    }

    // ID ile kullanıcı bulma
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
    }

    // Tüm kullanıcıları listeleme
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Kullanıcı güncelleme
    public User updateUser(Long id, User updatedUser) {
        User user = getUserById(id);
        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        user.setRole(updatedUser.getRole());
        return userRepository.save(user);
    }

    // Kullanıcı silme
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Kullanıcı adı ile arama (login için gerekli olabilir)
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found with username: " + username));
    }
}
