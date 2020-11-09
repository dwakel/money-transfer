package test.moneytransfer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.moneytransfer.model.User;
import test.moneytransfer.service.UserService;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/user")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){

        this.userService = userService;
    }

    @PostMapping
    public User AddUser(@RequestBody User user){
        return this.userService.AddUser(user);
    }

    @GetMapping(path = "{id}")
    public User GetUserById(@PathVariable("id") UUID id) {
        return this.userService.GetUser(id);
    }

    @PostMapping(path = "{id}")
    public User UpdateUser(@PathVariable("id")UUID id, @RequestBody User user){
        return this.userService.UpdateUser(id, user);
    }
}
