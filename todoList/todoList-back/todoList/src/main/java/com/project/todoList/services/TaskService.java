package com.project.todoList.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.todoList.handlers.TaskHandler;
import com.project.todoList.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
