package com.project.todoList.controllers;

import com.project.todoList.models.Task;
import com.project.todoList.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tasks")
public class TaskController {

  private final TaskService taskService;
  @Autowired
  public TaskController(TaskService taskService){
    this.taskService = taskService;
  }
  @GetMapping("/all")
  public ResponseEntity<List<Task>> getTasks(){
    List<Task> tasks = taskService.getTasks();
    return new ResponseEntity<>(tasks, HttpStatus.OK);
  }
  @PostMapping("/add")
  public ResponseEntity<List<Task>> addTask(@RequestBody List<Task> newTasks){
     List<Task> tasks = taskService.addTasks(newTasks);
     return new ResponseEntity<>(tasks, HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<List<Task>> updateTask(@RequestBody Task task){
    List<Task> tasks = taskService.updateTask(task);
    return new ResponseEntity<>(tasks, HttpStatus.OK);
  }
  @DeleteMapping("/delete/{index}")
  public ResponseEntity<List<Task>> deleteTask(@PathVariable int index){
    List<Task> tasks = taskService.deleteTask(index);
    return new ResponseEntity<>(tasks, HttpStatus.OK);
  }
}
