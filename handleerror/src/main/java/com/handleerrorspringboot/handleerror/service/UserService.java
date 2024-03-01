package com.handleerrorspringboot.handleerror.service;

import com.handleerrorspringboot.handleerror.exception.BusinessException;
import com.handleerrorspringboot.handleerror.exception.RequestException;
import com.handleerrorspringboot.handleerror.model.User;
import com.handleerrorspringboot.handleerror.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){

        if(user.getEmail()==null || user.getEmail().isEmpty()) throw new RequestException("P-400","email is required");
        if(userRepository.findUserByEmail(user.getEmail())!=null) {
            throw new RequestException("P-409", "email is occupied");
        }
        return userRepository.save(user);
    }

    public Optional<User> getUser(Long id){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            return Optional.of(user);
        }
        return null;
    }

    public List<User> findAllUser(){
        return (List<User>) userRepository.findAll();
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }
}
