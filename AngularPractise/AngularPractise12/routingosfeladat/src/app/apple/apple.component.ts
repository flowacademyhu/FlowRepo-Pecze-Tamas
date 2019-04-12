import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-apple',
  templateUrl: './apple.component.html',
  styleUrls: ['./apple.component.css']
})
export class AppleComponent implements OnInit {

  constructor(private route: ActivatedRoute) { }
  applePrices: number;
  ngOnInit() {
      this.route.queryParams.subscribe(
      (params) => {
        this.applePrices = params.order;
        console.log(params.order);
      }
    );
  } 

}
