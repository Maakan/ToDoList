import { Component } from '@angular/core';
import { Task } from '../../../models/Task';
import { TaskService } from '../../../services/task.service';
import { catchError, map } from 'rxjs';
import { HttpErrorResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrl: './add-task.component.css'
})
export class AddTaskComponent {
task: Task ={index: undefined, title: 'new', toDo: true, description: ''};
tasks: Task[] = [];

constructor(private taskService: TaskService, private router: Router){

}

addTask(){
  console.log(this.task);
  this.tasks.push(this.task);
  this.taskService.addTasks(this.tasks).pipe(
    map((t: Task[]) => {
      this.tasks = t;
      console.log(t);
      this.router.navigate(['/']);
    }),
    catchError((error: HttpErrorResponse) => {
      alert(error.message);
      throw error;
    })
  ).subscribe();
}
}
