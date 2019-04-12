import { Component, OnInit } from '@angular/core';
import { ITask } from '../task.model';
import { TaskService } from '../task.service';
import { ActivatedRoute, Params, Router } from '@angular/router';

@Component({
  selector: 'app-task-edit',
  templateUrl: './task-edit.component.html',
  styleUrls: ['./task-edit.component.css']
})
export class TaskEditComponent implements OnInit {

  task: ITask = {} as ITask;
  params: Params;

  constructor(private taskService: TaskService,private route: ActivatedRoute, private router: Router) { }

  save() {
    if (this.params.id !== '0'){
    this.taskService.save(this.task).subscribe(
      (saved: ITask) => {
        console.log(saved);
        this.router.navigate(['tasks'])
      }, (error: any) => {
        console.log(error);
        alert('Nem mentett!');
      }
    )
  } else {
    this.taskService.create(this.task).subscribe(
      (saved: ITask) => {
        console.log(saved);
        this.router.navigate(['tasks'])
      }, (error: any) => {
        console.log(error);
        alert('Nem mentett!');
      }
    );
  }
}
  ngOnInit() {
    this.route.params.subscribe(
      (params: Params) => {
        this.params = params;
        console.log(params);
        if (params.id !== '0') {
        this.taskService.getById(params.id).subscribe(
          (task: ITask) => {
            this.task = task;
          }
        ); }
      }
    );
  }

}
