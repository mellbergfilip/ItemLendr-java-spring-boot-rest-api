package com.fmellberg.itemlendr.auth.service;

import com.fmellberg.itemlendr.auth.model.LoginResponse;

public interface AuthService {

    LoginResponse attemptLogin(String email, String password);
}
