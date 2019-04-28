import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-third',
  templateUrl: './third.component.html',
  styleUrls: ['./third.component.css']
})
export class ThirdComponent implements OnInit {
  datafromsecond = 1;
  constructor(private routerA: ActivatedRoute) { }

  ngOnInit() {
    this.routerA.params.subscribe(
      (params: Params) => {
        this.datafromsecond = params.id;
      });
  }

}
