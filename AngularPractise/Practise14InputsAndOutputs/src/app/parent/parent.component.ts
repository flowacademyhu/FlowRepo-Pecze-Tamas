import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent implements OnInit {
  testvlueFROMPARENT = 'HELLO';
  TheArray = ['Hello1', 'hello2', 'Hello3'];
  itemCount = 4;
  btnText = 'It`s a property binding';
  goalText = 'Two way data binding has occured.';
  constructor() { }

  ngOnInit() {
  }

}
