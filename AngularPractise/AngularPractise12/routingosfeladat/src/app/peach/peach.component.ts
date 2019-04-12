import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-peach',
  templateUrl: './peach.component.html',
  styleUrls: ['./peach.component.css']
})
export class PeachComponent implements OnInit {

  constructor(private route: ActivatedRoute) { }
  peachPrice:number;
  ngOnInit() {
        this.route.queryParams.subscribe(
        (params) => {
        this.peachPrice = params.order;
        console.log(params.order);
      }
    );
  }

}
