package com.example.demoPostGres.repository;

import com.example.demoPostGres.entity.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDetailsRepository extends MongoRepository<UserDetails, String> {
    UserDetails getById(String userId);
}
