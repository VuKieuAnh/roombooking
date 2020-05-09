package com.example.room.service.user;

import com.example.room.model.User;
import com.example.room.service.GeneralService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends GeneralService<User>, UserDetailsService {
    User findByUsername(String username);

    User getCurrentUser();

    boolean checkLogin(User user);

    boolean isRegister(User user);

    User findByEmail(String email);

}
