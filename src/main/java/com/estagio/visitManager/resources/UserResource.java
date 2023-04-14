package com.estagio.visitManager.resources;

import com.estagio.visitManager.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L,"guilherme","123","guilherme@test","guilherme99",true,Boolean.TRUE);
        return ResponseEntity.ok().body(u);

    }








}
