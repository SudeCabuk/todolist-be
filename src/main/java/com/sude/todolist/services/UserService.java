package com.sude.todolist.services;

import com.sude.todolist.core.Response;
import com.sude.todolist.dataAccess.UserRepository;
import com.sude.todolist.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı!"));
    }
    public Response<User> createUser(User user) {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            Response<User> response = new Response<>();
            response.setMessage("Bu email ile bir kullanıcı zaten var!");
            response.setSuccess(false);
            response.setData(null);
            return response;
        }
        User savedUser = userRepository.save(user);
        Response<User> response = new Response<>();
        response.setMessage("Kayıt başarılı");
        response.setSuccess(true);
        response.setData(savedUser);
        return response;
    }
    public Response<User> validateUser(String email, String password) {
        try {
            User loginUser = userRepository.findByEmail(email)
                    .filter(user -> user.getPassword().equals(password))
                    .orElseThrow(() -> new RuntimeException("Email veya şifre hatalı!"));
            Response<User> response = new Response<>();
            response.setMessage("Giriş başarılı");
            response.setSuccess(true);
            response.setData(loginUser);
            return response;

        } catch (RuntimeException e) {
            Response<User> response = new Response<>();
            response.setMessage("Kullanıcı adı ya da şifre hatalı");
            response.setSuccess(false);
            response.setData(null);
            return response;
        }

    }
}
