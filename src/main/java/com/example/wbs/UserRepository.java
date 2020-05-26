package com.example.wbs;
import java.util.*;
import org.springframework.data.repository.CrudRepository;
import com.example.wbs.UserModel;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<UserModel, Integer> {
    List<UserModel> findByUsername(String username);
}