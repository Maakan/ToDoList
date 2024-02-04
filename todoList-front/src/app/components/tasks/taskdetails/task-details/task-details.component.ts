// task-details.component.ts

import { Component, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { catchError, map } from 'rxjs';
import { TaskService } from '../../../../services/task.service';
import { Task } from '../../../../models/Task';
import { HttpErrorResponse } from '@angular/common/http';


@Component({
  selector: 'app-task-details',
  templateUrl: './task-details.component.html',
  styleUrls: ['./task-details.component.css']
})
export class TaskDetailsComponent {
  @Input() task?: Task;
  taskForm: FormGroup;
  tasks: Task[] = [];

  constructor(private formBuilder: FormBuilder, private taskService: TaskService) {
    this.taskForm = this.formBuilder.group({
      // Définissez les champs du formulaire selon votre modèle Task
      title: ['', Validators.required],
      description: ['', Validators.required],
      // Ajoutez d'autres champs si nécessaire
    });
  }

  ngOnInit(){
    
  }

  onSubmit() {
    if (this.taskForm.valid) {
      const newTask: Task = this.taskForm.value;
      
      // Utilisez le service pour ajouter la nouvelle tâche
      this.taskService.addTasks([newTask]).pipe(
        map((response: Task[]) => {
          this.tasks = response;
          console.log('Tâche ajoutée avec succès !', response);
          // Réinitialisez le formulaire après l'ajout
          this.taskForm.reset();
        }),
        catchError((error:HttpErrorResponse) => {
          alert(error.message);
          throw error;
        })
      ).subscribe();
    }
  }
}
