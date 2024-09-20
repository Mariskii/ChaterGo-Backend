package com.vicent.chatergo.Service;

import com.vicent.chatergo.Models.UserModel;

import java.util.List;

public interface UserService {
    void saveUser(UserModel userModel);
    void disconnect(UserModel user);
    public List<UserModel> findConnectedUsers();
}
