import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-championship',
  templateUrl: './championship.component.html',
  styleUrls: ['./championship.component.css']
})
export class ChampionshipComponent implements OnInit {

  constructor() { }
  SELECTED = '';
  ngOnInit() {
  }
  handle(Task: object) {
    alert('das' + JSON.stringify(Task));
  }
}
