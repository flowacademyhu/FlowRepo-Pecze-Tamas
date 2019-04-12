import { Component, OnInit, Input } from '@angular/core';
import { InforMATION } from 'src/app/inforMATION.module';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-fruits',
  templateUrl: './fruits.component.html',
  styleUrls: ['./fruits.component.css']
})
export class FruitsComponent implements OnInit  {
  info = new InforMATION('','',0,'');
  constructor( private Taskkk: TaskService) { }
  isClicked: boolean;
  value: boolean;
  ngOnInit() {

  }
  buttonClick() {
    /* this.Taskkk.save(this.info);
    console.log(this.info.name); */
    this.isClicked = true; 
  }
  Calori() {
    if(this.info.calories > 100) {
      this.value = true;
    } else {
      this.value = false;
    }
  }

}
