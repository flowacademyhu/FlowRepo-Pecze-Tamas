import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { NgClass } from '@angular/common';
import { InfoService } from '../info.service';
@Component({
  selector: 'app-kidone',
  templateUrl: './kidone.component.html',
  styleUrls: ['./kidone.component.css']
})
export class KidoneComponent implements OnInit {
  @Input()
  appcomptitle = '';
  @Output()
  e = new EventEmitter();
  valami = 'valami valtozo a kidbol emittelve.';
  departments = [
    {id: 1, name: 'First'},
    {id: 2, name: 'Second'},
    {id: 3, name: 'Third'}
  ];
  counter = 0;
  boo = false;
  constructor(private router: Router, private service: InfoService) { }
  boo2 = false;
  kapcsolo = 'Disable';
  ngOnInit() {
  }

  onSelect(department) {
    this.router.navigate(['/kidtwo', department.id]);
    this.e.emit(this.valami);
    this.counter++;
    if (this.counter === 3) {
      this.boo = true;
    } else {
      this.boo = false;
    }
  }
  disable() {
    if (this.boo2 === false) {
      this.boo2 = true;
      this.kapcsolo = 'Enable';
    } else {
      this.boo2 = false;
      this.kapcsolo = 'Disable';
    }
    this.service.log(this.kapcsolo);
  }
}
