package com.project.todoList.handlers;

import com.project.todoList.models.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskHandler {
  public List<Task> tasksToHandle;

  public  TaskHandler(){
    this.initializeTasks();
  }
  public void initializeTasks(){
    tasksToHandle = new ArrayList<>();
    tasksToHandle.add(new Task("Clean", "Clean my bedroom"));
    tasksToHandle.add(new Task("Study", "Study for my exams"));
  }
  public List<Task> getTasks(){
    return tasksToHandle;
  }

  public List<Task> addTasks(List<Task> tasksToAdd){
    tasksToHandle.addAll(tasksToAdd);
    return tasksToHandle;
  }

  public  List<Task> update(Task updatedTask) {
    for (int i = 0; i < tasksToHandle.size(); i++) {
      Task task = tasksToHandle.get(i);
      if (task.getIndex() == updatedTask.getIndex()) {
        tasksToHandle.set(i, updatedTask);
        break; // Ajout du break pour sortir de la boucle une fois la tâche mise à jour
      }
    }
    return tasksToHandle;
  }

  public List<Task> deleteTask(int index){
    tasksToHandle.remove(index);
    return tasksToHandle;
  }
}