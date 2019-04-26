import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { parse } from 'url';

@Component({
  selector: 'app-showhide',
  templateUrl: './showhide.component.html',
  styleUrls: ['./showhide.component.css']
})
export class ShowhideComponent implements OnInit {
  randomData = [
    {id: 1, name: 'Tamas'},
    {id: 2, name: 'Gabor'},
    {id: 3, name: 'Eva'}
  ];
  constructor(private r: Router) { }

  ngOnInit() {
  }
  onSelect(randomm){
    this.r.navigate(['/kid', randomm.id]);
  }
}
