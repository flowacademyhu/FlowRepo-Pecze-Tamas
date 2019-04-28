import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { InfoService } from '../info.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-second',
  templateUrl: './second.component.html',
  styleUrls: ['./second.component.css']
})
export class SecondComponent implements OnInit {
  @Output()
  e = new EventEmitter();
  data = '';
  randomData = [ {id: 1} ];
  constructor(private info: InfoService, private router: Router) { }
  routingData = [
    {id: 1, name: 'Tibi'},
    {id: 2, name: 'Tamas'}
  ];
  ngOnInit() {
    this.e.emit('Hey!!!');
    this.data = this.info.getInfo();
  }
  send(r) {
    this.router.navigate(['/third', r.id])
  }
}
