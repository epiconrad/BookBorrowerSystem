package com.conrad.bookborrower.controller;

import com.conrad.bookborrower.model.Book;
import com.conrad.bookborrower.model.User;
import com.conrad.bookborrower.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping("/users")
    public User addBook(@Valid @RequestBody User book)
    {
        return userService.save(book);
    }

    @CrossOrigin
    @GetMapping(value = {"/","/users"})
    public List<User> findAllUser()
    {
        return userService.findAll();
    }

    @CrossOrigin
    @GetMapping("/users/{id}")
    public ResponseEntity<User> findBookById(@PathVariable(value="id") Long bookId)
    {
        User user = userService.findById(bookId);

        if(user==null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }

    @CrossOrigin
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateBook(@PathVariable(value = "id") Long bookId, @Valid @RequestBody User userDetails)
    {
        User user = userService.findById(bookId);

        if(user==null)
        {
            return ResponseEntity.notFound().build();
        }
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setRole(userDetails.getRole());

        User updateUser = userService.save(user);
        return ResponseEntity.ok().body(updateUser);
    }

    @CrossOrigin
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable(value="id") String id)
    {   Long bookId = Long.valueOf(id);
        User user = userService.findById(bookId);

        if(user==null)
        {
            return ResponseEntity.notFound().build();
        }

        userService.delete(user);
        return ResponseEntity.ok().build();
    }
}