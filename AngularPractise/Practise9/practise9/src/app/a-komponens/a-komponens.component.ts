import { Component, OnInit } from '@angular/core';
import { ANagyTaskServiceService } from '../a-nagy-task-service.service';

@Component({
  selector: 'app-a-komponens',
  templateUrl: './a-komponens.component.html',
  styleUrls: ['./a-komponens.component.css']
})
export class AKomponensComponent implements OnInit {
  constructor( private tasky: ANagyTaskServiceService ) { }
array = [];
  ngOnInit() {
    this.getData();
  }
  public getData() {
    this.array = this.tasky.getAll();
  }
}
