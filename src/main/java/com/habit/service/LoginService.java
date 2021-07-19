package com.habit.service;

import com.habit.domain.Login;
import com.habit.repository.LoginRepository;

import javax.annotation.Resource;

public interface LoginService {
    Login getLoginInformation(Login login);
}
