import { Component, OnInit, Input, Output, Injectable } from '@angular/core';
import { DecimalPipe } from '@angular/common';
import { EventEmitter } from '@angular/core';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {
  @Output() Happening = new EventEmitter<String>();
// tslint:disable-next-line: no-input-rename
  @Output() HappeningSECOND = new EventEmitter<number>();
  @Input('firstname')
  name: string;
  @Input()
  lastname: string;
  @Input()
  el:string;
  @Input()
  checkboxValue: boolean;
  value = 0;
  value2 = 100;
  ngOnInit() {
  
  }
  increment() {
    this.value += 10;
    this.value2 += 10;
    if(this.value >= 100) {
    this.Happening.next(this.name);
    } else if (this.value >= 80 && this.value < 100) {
      alert('keves!');
    }
    if(this.value2 < 120) {
      this.HappeningSECOND.next(this.value);
    }
  }
}
