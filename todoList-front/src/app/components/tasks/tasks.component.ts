import { Component } from '@angular/core';
import { Task } from '../../models/Task';
import { TaskService } from '../../services/task.service';
import { catchError, map } from 'rxjs';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrl: './tasks.component.css'
})
export class TasksComponent {
  public tasks: Task[] = [];
  selectedTask?: Task;
  constructor(private taskService: TaskService){
    
  }
  ngOnInit() {
    this.getTasks();
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

  
  
}
