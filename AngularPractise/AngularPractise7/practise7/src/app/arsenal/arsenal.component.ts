import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-ars',
  templateUrl: './arsenal.component.html',
  styleUrls: ['./arsenal.component.css']
})
export class ArsenalComponent implements OnInit {
  @Output() sending = new EventEmitter<object>();
  constructor() { }

  ngOnInit() {
  }
  myObj:any =
    [{ players:['Ozil', 'Ramsey','Leno'], stadion : 'Emirates', name : 'Arsenal', attendance : 60012
  }]

  sendingMethod() {
    this.sending.next(this.myObj);
  }
}