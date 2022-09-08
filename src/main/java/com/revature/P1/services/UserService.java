package com.revature.P1.services;

import com.revature.P1.daos.User_Daos;
import com.revature.P1.dtos.requests.NewUserRequest;
import com.revature.P1.models.Users.ERS_Users;

import java.util.UUID;
public class UserService {
    private User_Daos userDaos = null;

    public void UserService(User_Daos userDAO) {
        this.userDaos = userDaos;
    }

    public UserService(User_Daos userDaos) {
        this.userDaos = userDaos;
    }

    public ERS_Users register(NewUserRequest request) {
        ERS_Users user = null;

        if (isValidUsername(request.getUsername())) {
            if (!isDuplicateUsername(request.getUsername())) {
                if (isValidPassword(request.getPassword())) {
                    if (isSamePassword(request.getPassword())) {
                        user = new ERS_Users(UUID.randomUUID().toString(), request.getUsername(), request.getPassword());
                        userDaos.save(user);
                    }
                }
            }
        }

        return user;
    }

    private boolean isSamePassword(String password1) {
        return false;
    }

    private boolean isValidPassword(String password1) {
        return false;
    }

    private boolean isDuplicateUsername(String username) {
        return false;
    }

    private boolean isValidUsername(String username) {
        return false;
    }
}
