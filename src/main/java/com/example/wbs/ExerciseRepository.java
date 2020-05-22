package com.example.wbs;

import org.springframework.data.repository.CrudRepository;
import com.example.wbs.ExerciseModel;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ExerciseRepository extends CrudRepository<ExerciseModel, Integer> {

}