package com.project.todoList.services;

import com.project.todoList.handlers.TaskHandler;
import com.project.todoList.models.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

  public List<Task> tasks;

  public TaskHandler taskHandler;
  public TaskService(){
    this.taskHandler = new TaskHandler();
  }

  public List<Task> getTasks(){
    tasks = taskHandler.getTasks();
    return tasks;
  }
  public Optional<Task> getTaskByTitle(String title){
    Optional<Task> taskByTitle;
    taskByTitle = taskHandler.getTasks().stream().filter( t -> t.getTitle().equalsIgnoreCase(title)).findAny();
    return taskByTitle;
  }
  public List<Task> addTasks(List<Task> tasksToAdd){
    tasks = taskHandler.addTasks(tasksToAdd);
    return tasks;
  }

  public List<Task> updateTask(Task updatedTask) {
    tasks = taskHandler.update(updatedTask);
    return tasks;
  }

  public List<Task> deleteTask(int index) {
    tasks = taskHandler.deleteTask(index);
    return tasks;
  }
  public List<Task> updateTaskStatus(List<Task> updatedTasks){
    System.out.println(updatedTasks);
    tasks = taskHandler.updateTaskStatus(updatedTasks);
    return tasks;
  }
}
