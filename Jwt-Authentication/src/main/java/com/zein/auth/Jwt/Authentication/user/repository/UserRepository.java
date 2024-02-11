package com.zein.auth.Jwt.Authentication.user.repository;

import java.util.Optional;

import com.zein.auth.Jwt.Authentication.user.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,Long> {

	Optional<User> findByNumTel(String numTel);
}
