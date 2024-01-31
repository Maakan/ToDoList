package com.project.todoList.models;

public class Task {
  public TaskState taskState;
  public enum TaskState {
    TODO,
    DONE;

  }
  public String title;
  public String description;
  private int index;
  private static int taskCounter= 0;

  public Task(String title, String description){
    this.title = title;
    this.description = description;
    this.taskState = TaskState.TODO;
    this.index = getNextIndex();
  }

  public void setTitle(String title){
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setTaskState(TaskState taskState) {
    this.taskState = taskState;
  }

  public TaskState getTaskState() {
    return taskState;
  }
  public int getIndex() {
    return index;
  }
  public void setIndex(int index){
    this.index = index;
  }
  private static synchronized int getNextIndex() {
    return taskCounter++;
  }
}
