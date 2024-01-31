import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Task } from '../models/Task';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private apiServerUrl = 'http://localhost:8080/tasks';
  constructor(private http: HttpClient) { }

  public getTasks(): Observable<Task[]>{
    return this.http.get<Task[]>(`${this.apiServerUrl}/all`);
  }
  
  public addTasks(tasks: Task[]): Observable<Task[]>{
    return this.http.post<Task[]>(`${this.apiServerUrl}/add`, tasks);
  }

  public updateTask(task: Task): Observable<Task[]>{
    return this.http.put<Task[]>(`${this.apiServerUrl}/update`, task);
  }

  public deleteTask(taskIndex: number): Observable<Task[]>{
    return this.http.delete<Task[]>(`${this.apiServerUrl}/delete/${taskIndex}`);
  }

}
