import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-second',
  templateUrl: './second.component.html',
  styleUrls: ['./second.component.css']
})
export class SecondComponent implements OnInit {
  constructor() { }
  temporary = '';
  @Input()
  array;
  @Input()
  krumplisZsak;
  @Output() Antenna = new EventEmitter<string>();
  ngOnInit() {
    
  }
  SendingDataToParent() {
    this.Antenna.next(this.temporary);
  }
}
