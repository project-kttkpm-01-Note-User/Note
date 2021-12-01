package com.example.note.service;

import com.example.note.authen.UserPrincipal;
import com.example.note.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    User getById(Long idUser);
    User getByUserName(String userName);
    User addUser(User user);
    UserPrincipal login(String userName);
}
