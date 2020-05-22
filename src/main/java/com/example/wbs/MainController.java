package com.example.wbs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

@Controller // This means that this class is a Controller
@RequestMapping(path="/workouts") // This means URL's start with /demo (after Application path)
public class MainController {
  @Autowired // This means to get the bean called ExerciseRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private ExerciseRepository exerciseRepository;

  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewExercise (@RequestBody ExerciseModel newExercise) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    // ExerciseModel n = new ExerciseModel();
    // n.setName(name);
    // n.setWorkoutName(workoutName);
    // n.setLength(length);
    // n.setRest(rest);
    exerciseRepository.save(newExercise);
    return "Saved";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<ExerciseModel> getAllExercises() {
    // This returns a JSON or XML with the Exercises
    return exerciseRepository.findAll();
  }
}