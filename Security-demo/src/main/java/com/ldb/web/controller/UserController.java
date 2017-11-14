package com.ldb.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.ldb.dto.User;
import com.ldb.exception.UserNotExistException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bobbi
 * @date 2017/10/30
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult errors){
        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error-> System.out.println(error));
        }
        System.out.println(user.getUsername());
        System.out.println(user.getBirthday());
        user.setId(1);
        return user;
    }
    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors){
        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error-> System.out.println(error));
        }
        user.setId(1);
        return user;
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(){
        List<User> users=new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/{id:\\d+}")//正则
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable Integer id){
//        throw new RuntimeException("user not exist");
        System.out.println("进入getinfo服务");
        User user=new User();
        user.setUsername("tom");
        return user;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        System.out.println(id);

    }

}
