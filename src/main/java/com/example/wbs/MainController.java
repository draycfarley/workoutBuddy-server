package com.example.wbs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.*;


@Controller // This means that this class is a Controller
@RequestMapping(path="/workouts") // This means URL's start with /demo (after Application path)
public class MainController {
  @Autowired // This means to get the bean called ExerciseRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private ExerciseRepository exerciseRepository;

  @CrossOrigin(origins = "https://workout-buddy-client2020.herokuapp.com/")
  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewExercise (@RequestBody ExerciseModel newExercise) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    // ExerciseModel n = new ExerciseModel();
    // n.setName(name);
    // n.setWorkoutName(workoutName);
    // n.setLength(length);
    // n.setRest(rest);
    Integer id=newExercise.getUserId();
    List<ExerciseModel> exercises= exerciseRepository.findByUserIdAndWorkoutName(id, newExercise.getWorkoutName());
    System.out.println(exercises.size());
    if(exercises.size()>0) return "reused workoutName";
    exerciseRepository.save(newExercise);
    return "Saved";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<ExerciseModel> getAllExercises() {
    // This returns a JSON or XML with the Exercises
    return exerciseRepository.findAll();
  }

  @PostMapping(path="/getByUserId")
  public @ResponseBody Iterable<ExerciseModel> getExerciseByUsername(@RequestBody ExerciseModel req) {
    // This returns a JSON or XML with the Exercises
    return exerciseRepository.findByUserId(req.getUserId());
  }

  @PostMapping(path="/getByWorkoutName")
  public @ResponseBody Iterable<ExerciseModel> getExerciseByWorkoutName(@RequestBody ExerciseModel req) {
    // This returns a JSON or XML with the Exercises
    List<ExerciseModel> exercises= exerciseRepository.findByUserId(req.getUserId());
    List<ExerciseModel> filtered = new ArrayList<>();

    for(int i=0; i<exercises.size(); i++) if(exercises.get(i).getWorkoutName().equals(req.getWorkoutName() )) filtered.add(exercises.get(i));

    return filtered;
  }
}