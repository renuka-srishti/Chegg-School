package com.chegg.school.controller;

import com.chegg.school.model.Professor;
import com.chegg.school.model.Student;
import com.chegg.school.model.User;
import com.chegg.school.dto.UserDTO;
import com.chegg.school.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody UserDTO userDTO) {
        userService.adduser(userDTO.getName(), userDTO.getEmail(), userDTO.getIsProfessor());
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/deleteUser")
    public ResponseEntity deleteUser(@RequestBody UserDTO userDTO) {
        userService.deleteUser(userDTO);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/updateUser")
    public ResponseEntity updateUser(@RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/listAllUsers")
    public ResponseEntity listUsers() {
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/listAllProfessors")
    public ResponseEntity listAllProfessors() {
        return new ResponseEntity<List<Professor>>(userService.getAllProfessors(), HttpStatus.OK);
    }

    @GetMapping("/listAllStudents")
    public ResponseEntity listAllStudents() {
        return new ResponseEntity<List<Student>>(userService.getAllStudents(), HttpStatus.OK);
    }
}
