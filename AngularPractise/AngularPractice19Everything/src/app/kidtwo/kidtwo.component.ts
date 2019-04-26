import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { InfoService } from '../info.service';

@Component({
  selector: 'app-kidtwo',
  templateUrl: './kidtwo.component.html',
  styleUrls: ['./kidtwo.component.css']
})
export class KidtwoComponent implements OnInit {
  public kidtwoID;
  text = 'waiting for info service...';
  constructor(private route: ActivatedRoute, private service: InfoService) { }

  ngOnInit() {
    this.text = this.service.info();
    this.route.params.subscribe(
      (params: Params) => {
        this.kidtwoID = params.id;
      }
    );
  }
}
