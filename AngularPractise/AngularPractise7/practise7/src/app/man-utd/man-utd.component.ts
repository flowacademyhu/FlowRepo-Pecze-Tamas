import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-manchester',
  templateUrl: './man-utd.component.html',
  styleUrls: ['./man-utd.component.css']
})
export class ManUtdComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  players: string[] =['Martial', 'De Gea','Pogba'];
  stadion = 'Old Trafford';
  name = 'Manchester United';
  attendance = 76023;
}
