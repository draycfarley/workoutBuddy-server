package com.example.wbs;

import javax.persistence.*;


@Entity // This tells Hibernate to make a table out of this class
public class ExerciseModel {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private Integer userId;

  private String name;

  private Integer length;

  private String workoutName;

  private Integer rest;

  private Integer visible;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getWorkoutName() {
    return workoutName;
  }

  public void setWorkoutName(String workoutName) {
    this.workoutName = workoutName;
  }

  public Integer getLength() {
    return length;
  }

  public void setLength(Integer length) {
    this.length = length;
  }

  public Integer getRest() {
    return rest;
  }

  public void setRest(Integer rest) {
      this.rest = rest;
  }

  public void setUserId(Integer userId){
    this.userId=userId;
  }

  public Integer getUserId(){
    return userId;
  }

  public void setVisible(Integer visible){
    this.visible=visible;
  }

  public Integer getVisible(){
    return visible;
  }

}