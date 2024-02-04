package com.project.todoList.models;

public class Task {
  public Boolean toDo;
  public String title;
  public String description;
  private int index;
  private static int taskCounter= 0;

  public Task(String title, String description){
    this.title = title;
    this.description = description;
    this.index = getNextIndex();
    this.toDo = true;
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

  public Boolean getToDo() {
    return toDo;
  }
  public void setTodo(Boolean todo){
    this.toDo = todo;
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
