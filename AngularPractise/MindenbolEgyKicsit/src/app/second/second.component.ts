import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-second',
  templateUrl: './second.component.html',
  styleUrls: ['./second.component.css']
})
export class SecondComponent implements OnInit {
  @Input()
  isCollapsed = false;
  @Input()
  array;
  @Input()
  krumplisZsak;
  @Input()
  funfun;
  @Output() Antenna = new EventEmitter();
  constructor() { }
  temporary = '';
  funnyFromSecond = 'Secondbol jottem!';
  @Output() MokasAntenna = new EventEmitter<string>();
  SendingMoka() {
    this.MokasAntenna.next(this.funnyFromSecond);
    this.funnyFromSecond = '';
  }
  ngOnInit() {
  }
  SendingDataToParent() {
    this.Antenna.next(this.temporary);
    this.Antenna.next(this.isCollapsed);
  }
  REQUESTFUN() {
    this.funnyFromSecond = this.funfun;
  }
}
