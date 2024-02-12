// task-details.component.ts

import { Component, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { catchError, map } from 'rxjs';
import { TaskService } from '../../../../services/task.service';
import { Task } from '../../../../models/Task';
import { HttpErrorResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-task-details',
  templateUrl: './task-details.component.html',
  styleUrls: ['./task-details.component.css']
})
export class TaskDetailsComponent {
  task: Task | undefined;
  // taskForm: FormGroup;
  tasks: Task[] = [];
  updateTask: boolean = false;
  constructor(private taskService: TaskService, private route: ActivatedRoute, private router: Router){
  }

  ngOnInit(){
    this.getTask();
  }

  getTask(): void{
    const title: string | null = this.route.snapshot.paramMap.get('title');
    if(title !== null){
      this.taskService.getTaskByName(title).pipe(
        map((t:Task) => {
          this.task = t;
          console.log(t);
        }) ,
        catchError((error: HttpErrorResponse) => {
          alert(error.message);
          throw error;
        }
        )
      ).subscribe();
    }
  }

  update(task: Task): void{
    console.log(task);

    this.taskService.updateTask(task).pipe(
      map((t: Task[]) =>{
        this.tasks = t;
        this.router.navigate(['/']);
      } ),
      catchError((error: HttpErrorResponse) => {
        alert(error.message);
        throw error;
      })
    ).subscribe();
  }
}
