import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { DataService } from '../data.service';

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
  constructor(private local: DataService) { }
  empty = [];
  ngOnInit() {
    this.empty = this.local.getData();
  }
  cl() {
    this.emiTT();
  }
  emiTT() {
    this.Qemit.emit(this.salata);
  }
}
