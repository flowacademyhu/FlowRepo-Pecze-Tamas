import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-kiddo',
  templateUrl: './kiddo.component.html',
  styleUrls: ['./kiddo.component.css']
})
export class KiddoComponent implements OnInit {
  @Input()
  cim = '';
  KiddoDoc = 'Hello, kidben vagyok!';
  @Output()
  childEvent = new EventEmitter();
  constructor() { }

  ngOnInit() {
  }
  onclick() {
    this.sendEvent();
  }
  sendEvent() {
    this.childEvent.emit(this.KiddoDoc);
  }

}
