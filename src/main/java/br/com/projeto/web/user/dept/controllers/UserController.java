package br.com.projeto.web.user.dept.controllers;

import br.com.projeto.web.user.dept.UserRopsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.projeto.web.user.dept.entities.Users;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRopsitory repository;

    @GetMapping
    public List<Users> findAll(){
        List<Users> result = repository.findAll();

        return result;
    }

    @GetMapping(value = "/{id}")
    public Users findById(@PathVariable Long id){
        Users result = repository.findById(id).get();

        return result;
    }

    @PostMapping
    public Users insert(@RequestBody Users users){
        Users result = repository.save(users);

        return result;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Users> deleteById(@PathVariable Long id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
