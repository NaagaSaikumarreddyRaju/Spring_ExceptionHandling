package com.SpringExceptionHandling;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
    // /api/v1/saveUserDetails

    @Autowired
    UserService userService;

    @PostMapping("/saveUserDetails")
    public ResponseEntity<User> saveData(@RequestBody @Valid UserDto user){   // ResponseEntity<User>=User, To Follow current standards
        return new ResponseEntity<>(userService.saveUserData(user), HttpStatus.CREATED);
    }

    // /api/v1/getAllData
    @GetMapping("/getAllData")
    public ResponseEntity<List<User>> getAllData(){
        return new ResponseEntity<>(userService.getAllData(),HttpStatus.OK);
    }
}
