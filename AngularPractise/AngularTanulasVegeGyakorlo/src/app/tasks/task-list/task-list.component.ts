import { Component, OnInit } from '@angular/core';
import { TaskService } from '../task.service';
import { ITask } from '../task.model';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {

  tasks: ITask[] = [];
  filterValue = '';
  constructor(private taskService: TaskService) { }
  getFilteredTasks() {
    return this.tasks.filter(
    (item: ITask) => !item.message || item.message.toLowerCase().includes(this.filterValue) || 
    !item.name || item.name.toLowerCase().includes(this.filterValue)
    );
  }

  ngOnInit() {
    this.GetAll();
  }

  GetAll() {
    this.taskService.getAll().subscribe(
    (result: ITask[]) => {
      this.tasks = result; 
      console.log(this.tasks);
    },
    (error: any) => {
      alert('baj van!' + error.message);
    }
    );
  }
  handleDelete(task: ITask) {
    this.taskService.deleteById(task.id).subscribe((params: any) => {
      console.log(params);
    },(error: any) => {
      alert(error);
      console.log(error);
    });
    this.GetAll();
  }
  
}
