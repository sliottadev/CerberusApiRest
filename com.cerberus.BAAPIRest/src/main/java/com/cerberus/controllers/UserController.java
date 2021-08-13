package com.cerberus.controllers;

import com.cerberus.enums.LoggerType;
import com.cerberus.helpers.GenericMapper;
import com.cerberus.helpers.Logger;
import com.cerberus.models.Rol;
import com.cerberus.models.User;
import com.cerberus.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UserController	Path: "../users/"
 * Controla : User, Login
 * Entidades relacionadas: Rol, User, Permission
 */
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    IUserService userService;

    @Autowired
    Logger log;

    @GetMapping
    public Iterable<User> GetUsers() {
        return userService.GetUsers();
    }

    @GetMapping("/{id}")
    public User GetUserById(@PathVariable Integer id) {
        return userService.GetUserById(id);
    }

    @PostMapping
    public User CreateUser(@RequestBody User user) {
        return userService.CreateUser(user);
    }

    @PutMapping("/{id}")
    public User UpdateUser(@RequestBody User user, @PathVariable Integer id) {
        return userService.UpdateUser(user, id);
    }

    @DeleteMapping("/{id}")
    public void DeleteUser(@PathVariable Integer id) {
        userService.DeleteUser(id);
    }

    @GetMapping("/roles")
    public String GetRoles() {
        List<Rol> Result = (List<Rol>) userService.GetRoles();
        if (Result != null) {
            String json = GenericMapper.serialize(Result);
            log.Write(LoggerType.LOG_AUDIT, json);
            return json;
        }
        return "";
    }

    @GetMapping("/permissions")
    public String GetPermissions() {
        return userService.GetPermissions().toString();
    }

    @GetMapping("/permissions/{id}")
    public String GetPermissionById(@PathVariable Integer id) {
        return userService.GetPermissionById(id).toString();
    }
   
}
