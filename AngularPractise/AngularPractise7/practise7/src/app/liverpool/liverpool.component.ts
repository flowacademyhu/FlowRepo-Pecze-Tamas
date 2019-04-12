import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pool',
  templateUrl: './liverpool.component.html',
  styleUrls: ['./liverpool.component.css']
})
export class LiverpoolComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  players = ['Salah', 'Mane', 'Firmino'];
  stadion = 'Anfield';
  name = 'Liverpool';
  attendance = 54033;
}
