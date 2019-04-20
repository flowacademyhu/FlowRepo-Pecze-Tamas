import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-kid',
  templateUrl: './kid.component.html',
  styleUrls: ['./kid.component.css']
})
export class KidComponent implements OnInit {
  @Input()
  randomnev = '';
  @Output()
  Qemit = new EventEmitter();
  salata = 'Salata';
  constructor() { }

  ngOnInit() {
  }
  cl() {
    this.emiTT();
  }
  emiTT() {
    this.Qemit.emit(this.salata);
  }
}
