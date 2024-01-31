package com.project.todoList.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.todoList.models.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

  public List<Task> tasks;
  public TaskService(){
  initializeTasks();
  }

  private void initializeTasks(){
    tasks = new ArrayList<>();
    tasks.add(new Task("Clean", "Clean my bedroom"));
    tasks.add(new Task("Study", "Study for my exams"));

  }
  public List<Task> getTasks(){
    return tasks;
  }
  public void addTasks(List<Task> tasksToAdd){
      tasks.addAll(tasksToAdd);
  }

  public void updateTask(int index, Task updatedTask) {
    tasks.set(index, updatedTask);
  }

  public void deleteTask(int index) {
    tasks.remove(index);
  }
}
