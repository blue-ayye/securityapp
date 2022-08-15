package com.blazingpotato.securityapp.service;

import com.blazingpotato.securityapp.domain.User;
import com.blazingpotato.securityapp.domain.Role;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToAppUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();
}
