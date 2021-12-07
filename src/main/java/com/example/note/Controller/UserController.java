package com.example.note.Controller;

import com.example.note.authen.UserPrincipal;
import com.example.note.entity.User;
import com.example.note.service.impl.UserServiceImpl;
import com.example.note.util.JwtUtil;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        UserPrincipal userPrincipal=  service.login(user.getUserName());
        if(user== null || !(user.getPassword().equals(userPrincipal.getPassword()))){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Account or password is not valid!");
        }
       JSONObject jo= new JSONObject();
        jo.put("token" , jwtUtil.generateToken(userPrincipal) );
        jo.put("user" , service.getByUserName(user.getUserName()) );
        return ResponseEntity.ok(jo);
    }


    @GetMapping("/user/{id}")
    public User getById(@PathVariable Long id){
        User user= service.getById(id);
        user.setPassword("");
        return user;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){
        User u= service.addUser(user);

        JSONObject jo= new JSONObject();
        jo.put("token" , jwtUtil.generateToken(new UserPrincipal(u.getId(),u.getUserName(),u.getPassword())) );
        jo.put("user" , u);
        return ResponseEntity.ok(jo);
    }

    @GetMapping("/refreshToken")
    public ResponseEntity<?> getUserByToken(@RequestParam String token){
        UserPrincipal userPrincipal= jwtUtil.getUserFromToken(token.toString());
        System.out.println("userPrincipal"+userPrincipal);
        JSONObject jo= new JSONObject();
        jo.put("token" , jwtUtil.generateToken(userPrincipal));
        jo.put("user" , service.getByUserName(userPrincipal.getUsername()));
        return ResponseEntity.ok(jo);
    }

}
