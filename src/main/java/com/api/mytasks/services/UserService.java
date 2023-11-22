package com.api.mytasks.services;

import com.api.mytasks.entity.User;
import com.api.mytasks.repository.UserRespository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRespository respository;

    public UserService(UserRespository respository) {this.respository = respository;}

    public List<User> findAllUsers(){
        return respository.findAll();
    }

    public  User findUser(@PathVariable UUID id){
        return respository.findById(id).get();
    }
    public User insertUser(@RequestBody User from){
        from.setCreation(LocalDateTime.now());
        return respository.save(from);
    }

    public void deleteUser(@PathVariable UUID id){
        respository.deleteById(id);
    }

    public User updateUser(@PathVariable UUID id, @RequestBody User from){
        Optional<User> userGet = respository.findById(id);
        if (userGet.isPresent()){
            User user = userGet.get();
            user.setLastName(from.getLastName());
            user.setEmail(from.getEmail());
            user.setLastUpdate(LocalDateTime.now() );
            user = respository.save(user);
            return  user;
        } else {
            return  null;
        }
    }
}
