package com.vicent.chatergo.Repository;

import com.vicent.chatergo.Models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<UserModel, String> {
    List<UserModel> findAllByStatus(String status);
}
