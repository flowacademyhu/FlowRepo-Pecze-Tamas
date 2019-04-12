import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-fruits',
  templateUrl: './fruits.component.html',
  styleUrls: ['./fruits.component.css']
})
export class FruitsComponent implements OnInit {
  constructor(private router: Router) { }
  applePrices = 3;
  pearPrices = 5;
  peachPrices = 10;
  ngOnInit() {

  }
  AppleClick() {
    this.router.navigate(['/apple'], {queryParams: {order: this.applePrices}});
  }
  PearClick() {
    this.router.navigate(['/pear'], {queryParams: {order: this.pearPrices}});
  }
  PeachClick() {
    this.router.navigate(['/peach'], {queryParams: {order: this.peachPrices}});
  }

}
