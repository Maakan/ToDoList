package com.project.todoList.servicesTest;

import com.project.todoList.models.Task;
import com.project.todoList.services.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskServiceTest {
  TaskService taskService;

  @BeforeEach
  void setTaskService(){
    taskService = new TaskService();
  }
  @Test
  void getTaskTest(){
    List<Task> tasks = taskService.getTasks();

    assertEquals(2, tasks.size());
    Task task = tasks.get(1);
    assertEquals("Study", task.getTitle());
    assertEquals("Study for my exams", task.getDescription());
  }

  @Test
  void addTasksTest(){

    List<Task> taskToAdd = new ArrayList<>();
    taskToAdd.add(new Task("Do something meaningful", "Do something that would help you or somebody else"));
    taskToAdd.add(new Task("Sport", "Go to the gym"));

    taskService.addTasks(taskToAdd);

    List<Task> tasks = taskService.getTasks();
    int lastindex = tasks.size()-1;
    int beforeLast = tasks.size() -2;
    Task lastAdded = tasks.get(lastindex);
    Task beforeLastAdded = tasks.get(beforeLast);
    assertEquals("Sport",lastAdded.getTitle());
    assertEquals("Do something meaningful", beforeLastAdded.getTitle());
  }
  @Test
  void updateTasks(){
    int index = 0;
    Task task = new Task("Do YOGA", "15min of yoga is good");
    taskService.updateTask(index, task);
    List<Task> tasks = taskService.getTasks();

    assertEquals("Do YOGA", tasks.get(index).getTitle());
    assertEquals("15min of yoga is good", tasks.get(index).getDescription());
  }
  @Test
  void deleteTask(){
    int index = 0;
    taskService.deleteTask(index);
    assertEquals(1, taskService.getTasks().size());
  }
}
