import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {

  tasks: string[] = ['cook', 'learn Angular', 'practise JAVA', 'watch GoT', 'beat Feri in Codewars']

  constructor() { }

  checkboxMark: boolean;
  ngOnInit() {
  }
  handleTaskClicked(Task: String) {
    alert('Allj le ' + Task);
  }
  FI(Task:String) {
    alert('siraly' + Task);
  }
}
