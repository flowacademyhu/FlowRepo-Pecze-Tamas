import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-thekid',
  templateUrl: './thekid.component.html',
  styleUrls: ['./thekid.component.css']
})
export class ThekidComponent implements OnInit {
  @Input()
  receive = '';
  @Output()
  e = new EventEmitter();
  constructor() { }

  ngOnInit() {
  }
  cl() {
    this.send();
  }
  send() {
    this.e.emit('I`m from the kiddo, this is an output emitted.');
  }
}
