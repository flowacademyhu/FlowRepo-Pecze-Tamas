import { Component, OnInit } from '@angular/core';
import { Task } from '../task.model';
import { TaskService } from '../task.service';
import { LoggerService } from '../../shared/logger.service';
import { Router, Params, ActivatedRoute } from '@angular/router';
import 'rxjs/Rx';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {
  tasks: Task[] = [
    new Task(1, 'Konyhafelújítás', 0, 'A konyha felújítása'),
    new Task(2, 'Ajtók cseréje', 10, 'Ajtócserék, surprise!'),
    new Task(3, 'Betonozás', 20, 'Az udvar ne füves legyen, hanem betonnal borított!')
  ];
  constructor(private taskService: TaskService, private loggerService: LoggerService, 
    private router: Router) { }

  ngOnInit() {
    this.taskService.getAll()
    .map(this.mapTodo)
    .subscribe((data) => {
      this.loggerService.log(data);
    });
    
  }

  mapTodo(todos: Todo[]) : Task[] {
    return todos.map(t => new Task(5, t.title, t.completed ? 100 : 0, ''));
  }

  onStateHundred(task: Task) {
    alert(`${task.name} elérte a 100-at!`);
  }

  onTaskChanged(task: Task) {
    this.tasks[0] = task;
  }

}

class Todo {
  public userId: number;
  public id: number;
  public title: string;
  public completed: number;
}