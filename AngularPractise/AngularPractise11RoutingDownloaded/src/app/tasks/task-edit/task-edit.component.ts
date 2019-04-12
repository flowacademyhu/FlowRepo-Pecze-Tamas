import { Component, OnInit, Input } from '@angular/core';
import { TaskService } from '../task.service';
import { Router, Params, ActivatedRoute } from '@angular/router';
import { Route } from '@angular/compiler/src/core';
import { Task } from '../task.model'; 

@Component({
  selector: 'app-task-edit',
  templateUrl: './task-edit.component.html',
  styleUrls: ['./task-edit.component.css']
})
export class TaskEditComponent implements OnInit {
  model:Task = {} as Task;
  constructor( private router: Router, private taskService: TaskService, private route: ActivatedRoute) { }
  
  ngOnInit() {
    this.route.params.subscribe(
      (params: Params) => {
        console.log(params.id);
        this.model = this.taskService.get(params.id);
      }
    )
  }
  clicked() {
    this.router.navigate(['tasks']);
  }
  clicked2() {
    this.router.navigate(['']);
  }
  save() {
    this.taskService.save(this.model);
    this.router.navigate(['']);
  }
}
