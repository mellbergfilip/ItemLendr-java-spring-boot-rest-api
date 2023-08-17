package com.fmellberg.itemlendr.service.interfaces;

import com.fmellberg.itemlendr.model.response.LoginResponse;

public interface AuthService {

    LoginResponse attemptLogin(String email, String password);
}
