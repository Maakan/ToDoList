import { Component } from '@angular/core';
import { Task } from '../../models/Task';
import { TaskService } from '../../services/task.service';
import { catchError, map } from 'rxjs';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrl: './tasks.component.css'
})
export class TasksComponent {
  public tasks: Task[] = [];
  public doneTasks: Task[] = [];
  selectedTask?: Task;
  constructor(private taskService: TaskService, private router: Router){
    
  }
  ngOnInit() {
    this.getTasks();
    this.tasks.sort((a, b) => b.index - a.index);
  }

  public getTasks(){
    this.taskService.getTasks().pipe(
      map((response: Task[]) => {
        this.tasks = response;
      }),
      catchError((error:HttpErrorResponse) => {
        alert(error.message);
        throw error;
      })
    ).subscribe();
  } 
  onSelect(task: Task): void{
    this.selectedTask = task;
  }

  public changeStatus(task: Task){
    task.toDo = !task.toDo;
    console.log(task.title + " toDo est:"+ task.toDo);
    if(task.toDo == false){
      this.setDoneTasks(task);
    }else{
      this.doneTasks = this.doneTasks.filter(
        t => t.toDo == false
      );
      this.tasks.push(task);
    }
  }

  public setDoneTasks(task: Task){
    this.doneTasks.push(task);
    this.tasks = this.tasks.filter(
      t => t.toDo == true
    );
  }

  public updateTaskStatus(){
    this.doneTasks.forEach(task => {
      task.toDo = !task.toDo;
    })
    this.taskService.updateTaskStatus(this.doneTasks).pipe(
      map((response: Task[]) => {
        this.tasks = response;
        this.doneTasks = [];
      }),
      catchError((error:HttpErrorResponse) => {
        alert(error.message);
        throw error;
      })
    ).subscribe();
    this.router.navigate(['/']);
  }
  
}
