import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-kidtwo',
  templateUrl: './kidtwo.component.html',
  styleUrls: ['./kidtwo.component.css']
})
export class KidtwoComponent implements OnInit {
  public kidtwoID;
  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(
      (params: Params) => {
        this.kidtwoID = params.id;
      }
    )
  }

}
