package com.project.todoList.handlers;

import com.project.todoList.models.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        break;
      }
    }
    return tasksToHandle;
  }

  public List<Task> updateTaskStatus(List<Task> updatedTasks) {
    List<Task> tasksToKeep = new ArrayList<>();

    for (Task task : tasksToHandle) {
      boolean updated = false;
      for (Task updatedTask : updatedTasks) {
        if (task.getIndex() == updatedTask.getIndex()) {
          task.setTodo(updatedTask.getToDo());
          updated = true;
          break;
        }
      }
      if (!updated) {
        tasksToKeep.add(task);
      }
    }
    tasksToHandle = tasksToKeep;
    return tasksToHandle;
  }


  public List<Task> deleteTask(int index){
     tasksToHandle.removeIf(task -> task.getIndex() == index);
     return tasksToHandle;
  }
}
