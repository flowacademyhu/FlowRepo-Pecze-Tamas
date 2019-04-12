import { Component, OnInit, Input, Output } from '@angular/core';
import { Task } from '../task.model';
import { EventEmitter } from '@angular/core';
import { LoggerService } from '../../shared/logger.service';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {
  @Input() task: Task;
  @Output() stateHundred : EventEmitter<Task> = new EventEmitter<Task>();

  constructor(private logService: LoggerService) {
  }

  ngOnInit() {
    this.logService.log(this.task.name);
  }

  onClicked() {
    this.task.state += 10;
    if (this.task.state >= 100) {
      this.stateHundred.emit(this.task);
    }
  }
}