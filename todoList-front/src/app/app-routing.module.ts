import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TasksComponent } from './components/tasks/tasks.component';
import { TaskDetailsComponent } from './components/tasks/taskdetails/task-details/task-details.component';
import { AddTaskComponent } from './components/tasks/add-task/add-task.component';

const routes: Routes = [
  { path: 'tasks', component: TasksComponent},
  { path: '', redirectTo: '/tasks', pathMatch: 'full' },
  {path: 'detail/:title', component: TaskDetailsComponent},
  {path:'newTask', component: AddTaskComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
