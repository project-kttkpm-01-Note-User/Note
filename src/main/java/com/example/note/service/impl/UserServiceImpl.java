package com.example.note.service.impl;

import com.example.note.authen.UserPrincipal;
import com.example.note.entity.User;
import com.example.note.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate template;


    @Override
    public User getById(Long idUser) {
        return template.getForObject("/"+idUser,User.class);
    }

    @Override
    public User getByUserName(String userName) {
        return template.getForObject("/username?userName="+userName,User.class);
    }

    @Override
    public User addUser(User user) {
        return template.postForEntity("",user,User.class).getBody();
    }

    @Override
    public UserPrincipal login(String userName) {
        User user = template.getForObject("/username?userName="+userName,User.class);
        UserPrincipal userPrincipal = new UserPrincipal();

        if (null != user) {
            userPrincipal.setUserId(user.getId());
            userPrincipal.setUsername(user.getUserName());
            userPrincipal.setPassword(user.getPassword());

        }

        return userPrincipal;
    }
}
