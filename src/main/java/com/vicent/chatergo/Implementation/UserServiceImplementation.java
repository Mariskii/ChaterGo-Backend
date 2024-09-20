package com.vicent.chatergo.Implementation;

import com.vicent.chatergo.Models.UserModel;
import com.vicent.chatergo.Repository.UserRepository;
import com.vicent.chatergo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(UserModel userModel) {
        userModel.setStatus("ONLINE");
        userRepository.save(userModel);
    }

    @Override
    public void disconnect(UserModel user) {
        //TODO: Implement throw error if not found
        UserModel userModel = userRepository.findById(user.getUserName()).get();

        userModel.setStatus("OFFLINE");
    }

    @Override
    public List<UserModel> findConnectedUsers() {
        return userRepository.findAllByStatus("ONLINE");
    }
}
