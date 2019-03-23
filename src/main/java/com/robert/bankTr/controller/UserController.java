package com.robert.bankTr.controller;

import com.robert.bankTr.miscellaneous.UserNotFoundException;
import com.robert.bankTr.model.User;
import com.robert.bankTr.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost")
public class UserController {
   private final UserRepository repository;

   public UserController(UserRepository repository)
   {
       this.repository=repository;
   }

   @GetMapping("/users")
    List<User> all(){
       return repository.findAll();
   }
   @PostMapping("/users")
    User newUser(@RequestBody User newUser){
       return repository.save(newUser);
   }
    @GetMapping("/user/{id}")
    User one(@PathVariable Long id){
       return repository.findById(id)
               .orElseThrow(()->new UserNotFoundException(id));
    }


}
