import { Component } from '@angular/core';
import { TaskService } from './services/task.service';
import { Task } from './models/Task';
import { HttpErrorResponse } from '@angular/common/http';
import { catchError, map } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'todoList-front';
  

  constructor(){
  }

}
