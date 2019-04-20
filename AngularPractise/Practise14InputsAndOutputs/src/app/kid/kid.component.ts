import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-kid',
  templateUrl: './kid.component.html',
  styleUrls: ['./kid.component.css']
})
export class KidComponent implements OnInit {
  @Input()
  testvlueFROMPARENTerkezik;
  constructor() { }

  ngOnInit() {
  }

}
