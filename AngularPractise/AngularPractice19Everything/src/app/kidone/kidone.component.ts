import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-kidone',
  templateUrl: './kidone.component.html',
  styleUrls: ['./kidone.component.css']
})
export class KidoneComponent implements OnInit {
  departments = [
    {id: 1, name: 'First'},
    {id: 2, name: 'Second'},
    {id: 3, name: 'Third'}
  ];
  constructor(private router: Router) { }

  ngOnInit() {
  }

  onSelect(department) {
    this.router.navigate(['/kidtwo', department.id]);
  }
}
