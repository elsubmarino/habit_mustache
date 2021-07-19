package com.habit.controller;

import com.habit.domain.Login;
import com.habit.repository.LoginRepository;
import com.habit.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Resource(name="loginService")
    private LoginService loginService;

    @PostMapping("/login")
        public ResponseEntity<Login> login(Login login, HttpServletRequest request){
        Login returned = loginService.getLoginInformation(login);
        if(returned != null) {
            returned.setPassword(null);
            request.setAttribute("login", returned);
        }
        return new ResponseEntity<Login>(returned, HttpStatus.OK);
    }
}
