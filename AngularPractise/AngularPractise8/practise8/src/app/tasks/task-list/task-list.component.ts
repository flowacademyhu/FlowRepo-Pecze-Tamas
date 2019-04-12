import { Component, OnInit, HostListener, ElementRef, Renderer2 } from '@angular/core';
import { TaskServiceService } from 'src/app/task-service.service';
@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {

  tasks: string[] = ['cook', 'learn Angular', 'practise JAVA', 'watch GoT', 'beat Feri in Codewars']

  constructor(private taskService: TaskServiceService, private el: ElementRef, private renderer: Renderer2) {

   }
  checkboxMark: boolean;
   num1 = 3;
  ngOnInit() {
    this.taskService.getAll().subscribe( //this.num1

      (result) => {
        console.log(result);
      }
    );
  }
  handleTaskClicked(Task: String) {
    alert('Allj le ' + Task);
  }
  FI(Task:String) {
    alert('siraly' + Task);
  }
  
}
