package cn.feiyue.desensitization.controller;

import cn.feiyue.desensitization.pojo.User;
import cn.feiyue.desensitization.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Date 2020-08-27 15:34
 * @Created by zfy
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    private List<User> list() {
        return userService.list();
    }

    @PostMapping
    public String add(@RequestBody User user) {
        user.setCreateTime(new Date());
        userService.save(user);
        return "ok";
    }
}
